package com.tusk.thought.dp;

/**
 * @author tusk
 * @desc 乘积最大子数组
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 * 示例 2:
 * <p>
 * 输入: [-2,0,-1]
 * 输出: 0
 * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-product-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/6/29 13:50
 */
public class P152_MaxProduct {
    public static void main(String[] args) {
        P152_MaxProduct obj = new P152_MaxProduct();
        int[] nums = {-3, 1, -1};
//        nums = new int[]{-2,3,-4};
        nums = new int[]{2, 3, -2, 4};
        System.out.println(obj.maxProduct(nums));
    }

    public int maxProduct(int[] nums) {
        if (nums.length <= 1) {
            return nums[0];
        }

        int max = Integer.MIN_VALUE;
        int imax = 1;
        int imin = 1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                int tmp = imax;
                imax = imin;
                imin = tmp;
            }

            imax = Math.max(imax, imax * nums[i]);
            imin = Math.min(imin, imin * nums[i]);

            max = Math.max(max, imax);
        }

        return max;
    }
}
