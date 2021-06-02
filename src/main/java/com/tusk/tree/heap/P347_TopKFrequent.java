package com.tusk.tree.heap;

import java.util.*;

/**
 * @author tusk
 * @desc 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * 示例 2:
 * <p>
 * 输入: nums = [1], k = 1
 * 输出: [1]
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * k 的取值范围是 [1, 数组中不相同的元素的个数]
 * 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的
 * @date 2021/6/2 10:28
 */
public class P347_TopKFrequent {
    public static void main(String[] args) {
        P347_TopKFrequent obj = new P347_TopKFrequent();
        int[] nums = new int[]{1, 1, 1, 2, 2, 3};
        int k = 2;
        int[] result = obj.topkfrequent01(nums, k);

        System.out.println(Arrays.toString(result));
    }

    /**
     * 使用优先级队列处理
     *时间复杂度：O(NLogN)
     * @param nums
     * @param k
     * @return
     */
    public int[] topkfrequent(int[] nums, int k) {
        if (nums.length <= 1) {
            return nums;
        }

        int[] result = new int[k];
        int remainder = 0;

        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        remainder = map.size() - k;

        //优先级按照出现次数排序
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>(Comparator
                .comparingInt(kv -> kv.getValue()));

        queue.addAll(map.entrySet());

        //由于队列中的count是按照升序排列的，因此要跳过前 size -k个
        while (remainder > 0) {
            queue.poll();
            remainder--;
        }

        while (!queue.isEmpty()) {
            result[--k] = queue.poll().getKey();
        }

        return result;
    }

    /**
     * 使用小顶堆实现
     *时间复杂度：O(NLogN)
     * @param nums
     * @param k
     * @return
     */
    public int[] topkfrequent01(int[] nums, int k) {
        if (nums.length <= 1) {
            return nums;
        }

        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]);

        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int num = entry.getKey();
            int count = entry.getValue();

            //维护一个大小为k 的小顶堆
            if (queue.size() == k) {
                //如果堆顶元素小于当前count,将堆顶元素移除，当前元素入堆
                if (queue.peek()[1] < count) {
                    queue.poll();
                    queue.offer(new int[]{num, count});
                }
            } else {
                queue.offer(new int[]{num, count});
            }
        }

        int[] result = new int[k];
        for(int i=0;i<result.length;i++){
            result[i] = queue.poll()[0];
        }

        return result;
    }
}
