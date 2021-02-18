package com.tusk;

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
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //先将 nums2的数据合并到 nums1,然后执行排序
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
    }
}



