package com.tusk;

import java.util.Arrays;

/**
 * #189 旋转数组
 *
 * @author tusk
 * @desc 旋转数组
 * @date 2020/12/10 17:38
 * 给定一个数组，将数组中的元素向右移动k个位置，其中k是非负数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3,4,5,6,7] 和 k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 * <p>
 * 说明:
 * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
 * 要求使用空间复杂度为 O(1) 的 原地 算法。
 */
public class RotateArray {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        rotateV1(arr, 3);
        for (int n : arr) {
            System.out.print(n + " ");
        }
    }

    /**
     * 不满足空间复杂度O(1)
     *
     * @param nums
     * @param k
     * @return
     */
    public static void rotate(int[] nums, int k) {

        if (nums.length >= 2) {
            k = k % nums.length;
            int[] tmpNums = Arrays.copyOf(nums, nums.length);
            System.arraycopy(tmpNums, nums.length - k, nums, 0, k);
            System.arraycopy(tmpNums, 0, nums, k, nums.length - k);
        }
    }

    /**
     * 每次旋转一个元素
     * @param nums
     * @param k
     */
    public static void rotateV1(int[] nums, int k) {
        if (nums.length > 1) {
            k = k % nums.length;

            while (k > 0) {
                int pre = nums[nums.length - 1];
                for (int i = 0; i < nums.length; i++) {
                    int tmp = nums[i];
                    nums[i] = pre;
                    pre = tmp;
                }
                k--;
            }

        }
    }

    /**
     * 环形替换
     * @param nums
     * @param k
     */
    public static void rotaveV2(int[] nums,int k){
        k = k % nums.length;
        int count = 0;
        for (int start = 0; count < nums.length; start++) {
            int current = start;
            int prev = nums[start];
            do {
                int next = (current + k) % nums.length;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
                count++;
            } while (start != current);
        }
    }
}
