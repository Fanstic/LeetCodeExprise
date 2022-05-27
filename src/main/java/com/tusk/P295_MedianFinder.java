package com.tusk;

import java.util.PriorityQueue;

/**
 * @author tusk
 * @desc leetcode-295:数据流的中位数
 * 中位数是有序列表中间的数。如果列表长度是偶数，中位数则是中间两个数的平均值。
 * <p>
 * 解题思路：大小堆(优先级队列)
 * 例如，
 * <p>
 * [2,3,4] 的中位数是 3
 * <p>
 * [2,3] 的中位数是 (2 + 3) / 2 = 2.5
 * <p>
 * 设计一个支持以下两种操作的数据结构：
 * <p>
 * void addNum(int num) - 从数据流中添加一个整数到数据结构中。
 * double findMedian() - 返回目前所有元素的中位数。
 * 示例：
 * <p>
 * addNum(1)
 * addNum(2)
 * findMedian() -> 1.5
 * addNum(3)
 * findMedian() -> 2
 * 进阶:
 * <p>
 * 如果数据流中所有整数都在 0 到 100 范围内，你将如何优化你的算法？
 * 1.使用一个长度为101的桶用于记录每个数字出现的次数，当计算中位数时先根据插入元素的总个数计算出中位数的位置
 *然后遍历桶，比如说一次插入 1,1,2,3,2,4,3,5，
 * 此时，桶中记录为 1:2,2:2,3:2,4:1,5:1,共计8个元素，中位数为第4个和第5个数的平均数，
 * 遍历桶可知，第4个数为2，第五个数为3，因此，中位数为 (2+3)/2
 *
 * ==========================================================================================================
 * 如果数据流中 99% 的整数都在 0 到 100 范围内，你将如何优化你的算法？
 * 思路类似上面的一个进阶，加一个桶记录范围之外的数即可
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-median-from-data-stream
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/12/21 14:28
 */
public class P295_MedianFinder {

    //大顶堆，存放小于等于当前中位数的数
    PriorityQueue<Integer> minQue = new PriorityQueue<>((a, b) -> b - a);

    //小顶堆，存放大于当前中位数的数
    PriorityQueue<Integer> maxQue = new PriorityQueue<>((a, b) -> a - b);

    public void addNum(int num) {
        //当插入元素数为0时插入 minQue
        //当nums小于当前中位数时，插入 minQue
        if (minQue.isEmpty() || num < minQue.peek()) {
            minQue.offer(num);

            //保证minQue和maxQue的size不超过1,当插入总元素数为偶数时，
            //差值为0，为奇数时，minQue.size - maxQue.size = 1
            if (maxQue.size() + 1 < minQue.size()) {
                //将minQue中的最大值插入到maxQue中，这是中位数在minQue中
                maxQue.offer(minQue.poll());
            }
        } else {
            maxQue.offer(num);
            //如果大顶堆元素个数大于小顶堆，则将大顶堆堆顶元素移到小顶堆
            if (maxQue.size() > minQue.size()) {
                minQue.offer(maxQue.poll());
            }
        }
    }

    public double findMedian() {
        //插入元素个数为奇数，minQue堆顶元素就是中位数
        if (minQue.size() > maxQue.size()) {
            return minQue.peek();
        } else {
            //插入元素个数为偶数，中位数为minQue和maxQue堆顶元素的平均数
            return (minQue.peek() + maxQue.peek()) / 2d;
        }
    }
}
