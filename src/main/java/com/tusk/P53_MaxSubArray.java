package com.tusk;

/**
 * 题号 53，
 * 给定一个整数数组 nums，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 示例:
 * 输入: [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释:连续子数组[4,-1,2,1] 的和最大，为6。
 *另有时间复杂度为 O(logn)的分治方法，没看懂，以后再说
 * @author tusk
 * @desc 最大子序和
 * @date 2020/12/3 16:18
 */
public class P53_MaxSubArray {

    public static void main(String[] args) {
        int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(arr));
    }
    /**
     * 最大子序列和
     * 没有思路，直接参考答案。。
     * 解法1，动态规划
     * 时间复杂度：O(n)
     * @param nums 整形数组
     * @return 最大子序列和
     */
    public static int maxSubArray(int[] nums) {

        if (nums.length == 1) {
            return nums[0];
        }

        int pre = 0;
        int maxSum = nums[0];

        for(int n : nums){
            pre = Math.max(pre + n,n);
            maxSum = Math.max(maxSum,pre);
        }

        return maxSum;
    }
}