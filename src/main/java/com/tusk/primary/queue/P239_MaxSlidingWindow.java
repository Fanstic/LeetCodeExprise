package com.tusk.primary.queue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author tusk
 * @desc leetcode-239:滑动窗口的最大值
 * 解题思路：单调队列
 * <p>
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * <p>
 * 返回滑动窗口中的最大值。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
 * 输出：[3,3,5,5,6,7]
 * 解释：
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * 1 [3  -1  -3] 5  3  6  7       3
 * 1  3 [-1  -3  5] 3  6  7       5
 * 1  3  -1 [-3  5  3] 6  7       5
 * 1  3  -1  -3 [5  3  6] 7       6
 * 1  3  -1  -3  5 [3  6  7]      7
 * 示例 2：
 * <p>
 * 输入：nums = [1], k = 1
 * 输出：[1]
 * 示例 3：
 * <p>
 * 输入：nums = [1,-1], k = 1
 * 输出：[1,-1]
 * 示例 4：
 * <p>
 * 输入：nums = [9,11], k = 2
 * 输出：[11]
 * 示例 5：
 * <p>
 * 输入：nums = [4,-2], k = 2
 * 输出：[4]
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104
 * 1 <= k <= nums.length
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sliding-window-maximum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/12/15 14:09
 */
public class P239_MaxSlidingWindow {
    public static void main(String[] args) {
        P239_MaxSlidingWindow obj = new P239_MaxSlidingWindow();
        int[] nums = new int[]{1,3,-1,-3,5,3,6,7};
        int k = 3;

        System.out.println(Arrays.toString(obj.maxSlidingWindow(nums,k)));

    }

    /**
     * 每次窗口滑动都会从窗口中移除一个元素，新加入一个元素，可以看做是队列的出队与入队操作
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> arr = new ArrayList<>();
        MonotonicQueue window = new MonotonicQueue();

        for (int i = 0; i < nums.length; i++) {
            if (i + 1 < k) {
                window.push(nums[i]);
            } else {
                //窗口加入新的元素
                window.push(nums[i]);
                arr.add(window.max());

                //窗口移除元素
                window.pop(nums[i-k+1]);
            }
        }

        int[] result = new int[arr.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = arr.get(i);
        }

        return result;
    }


}

/**
 * 一个单调递增的队列
 */
class MonotonicQueue {
    LinkedList<Integer> list = new LinkedList<>();

    /**
     * push操作与普通队列不同的时需要移除队列中比当前元素小的元素
     *
     * @param t
     */
    public void push(Integer t) {
        while (!list.isEmpty() && list.getLast() < t) {
            list.pollLast();
        }

        list.addLast(t);
    }


    /**
     * 如果队头是t，则将其出队
     *
     * @param t
     * @return
     */
    public void pop(Integer t) {
        if (list.getFirst().equals(t)) {
            list.pollFirst();
        }
    }

    /**
     * 返回队列中的最大值
     *
     * @return
     */
    public Integer max() {
        return list.getFirst();
    }
}
