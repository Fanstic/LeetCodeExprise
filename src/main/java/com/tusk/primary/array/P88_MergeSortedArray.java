package com.tusk.primary.array;

import java.util.Arrays;

/**
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 * 说明：
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 * <p>
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnumcr/
 *
 * @author tusk
 * @desc 合并两个有序数组
 * @date 2020/12/21 17:21
 */
public class P88_MergeSortedArray {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};

        P88_MergeSortedArray obj = new P88_MergeSortedArray();
        obj.merge2(nums1, 3, nums2, nums2.length);
        System.out.println("O");
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //先将 nums2的数据合并到 nums1,然后执行排序
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
    }

    /**
     * 双指针解法
     * 时间复杂度O(m+n)
     * 空间复杂度O(m+n)
     * 思考：如何将空间复杂度变为 O(1)
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int[] sorted = new int[m + n];
        int p1 = 0;
        int p2 = 0;
        int cur;

        while (p1 < m || p2 < n) {
            if (p1 == m) {//利用数组有序的性质，如果nums1数取完了，直接从nums2取
                cur = nums2[p2++];
            } else if (p2 == n) {
                cur = nums1[p1++];
            } else if (nums1[p1] < nums2[p2]) {
                cur = nums1[p1++];
            } else {
                cur = nums2[p2++];
            }

            //p1 + p2 - 1表示当前元素的下标
            sorted[p1 + p2 - 1] = cur;
        }

        //将 sorted 中的元素移动到nums1中
        for (int i = 0; i != m + n; ++i) {
            nums1[i] = sorted[i];
        }
    }
}



