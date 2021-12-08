package com.tusk.primary.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author tusk
 * @desc leetcode-560:和为k的子数组
 * 前缀和：适用于数组不变，频繁求取某个区间累加和的场景
 * 类似题目：303，0,304
 * https://leetcode-cn.com/problems/subarray-sum-equals-k/
 * @date 2021/12/7 15:52
 */
public class P560_SubArraySum {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1};

        P560_SubArraySum obj = new P560_SubArraySum();
        System.out.println(obj.subarraySumImproved(nums, 2));
    }

    /**
     * 这里需要注意一下，一个元素本身也算是一个子数组
     *
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum(int[] nums, int k) {

        if (nums.length == 1) {
            if (nums[0] == k) {
                return 1;
            } else {
                return 0;
            }
        }

        //前缀和数组
        int[] preSums = new int[nums.length + 1];
        int count = 0;

        for (int i = 1; i < preSums.length; i++) {
            preSums[i] = preSums[i - 1] + nums[i - 1];
        }

        //穷举所有的子数组和
        //嵌套双重for,时间复杂度O(N^2)
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                //i~j
                int subSum = preSums[j + 1] - preSums[i];
                if (subSum == k) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * TODO:优化复杂度为O(N)
     * 优化思路：去掉嵌套双重for循环的内存循环
     *
     * @param nums
     * @param k
     * @return
     */
    public int subarraySumImproved(int[] nums, int k) {
        int n = nums.length;

        //声明一个map记录前缀和以及其出现的次数
        Map<Integer, Integer> map = new HashMap<>();

        //前缀和为0的情况一定会出现一次
        map.put(0, 1);

        int sumi = 0;
        int count = 0;

        for (int i = 0; i < n; i++) {
            sumi += nums[i];

            //preSumi,由上面的 presumi - presumj = k,得出
            int sumj = sumi - k;
            if (map.containsKey(sumj)) {
                count += map.get(sumj);
            }

            map.put(sumi, map.getOrDefault(sumi, 0) + 1);
        }
        return count;
    }
}