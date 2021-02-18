package com.tusk;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 题号349，两个数组的交集
 * 输出结果中的每个元素一定是唯一的。
 * 不考虑输出顺序
 *
 * @author tusk
 * @desc 两个数组的交集
 * @date 2020/12/4 15:14
 */
public class P349_Intersection {
    public static void main(String[] args) {
        int[] arr1 = {1, 2};
        int[] arr2 = {1};

        int[] intersectionResult = intersectionOffice(arr1, arr2);
        for (int i : intersectionResult) {
            System.out.println(" " + i);
        }

    }

    /**
     * @param nums1 数组1
     * @param nums2 数组2
     * @return 交集数组
     */
    public static int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return new int[0];
        }

        if (nums1.length <= 0 || nums2.length <= 0) {
            return new int[0];
        }

        List<Integer> list = new ArrayList<>();

        if (nums1.length > nums2.length) {
            return intersectionOffice(nums2, nums1);
        }

        for (int j : nums1) {
            if (!list.contains(j)) {
                for (int k : nums2) {
                    if (k == j) {
                        list.add(j);
                        break;
                    }
                }
            }
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    /**
     * 官方双指针解法
     *
     * @param nums1 数组1
     * @param nums2 数组2
     * @return
     */
    public static int[] intersectionOffice(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return new int[0];
        }

        if (nums1.length <= 0 || nums2.length <= 0) {
            return new int[0];
        }

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int idx = 0;
        int idx1 = 0;
        int idx2 = 0;
        int l1 = nums1.length;
        int l2 = nums2.length;

        int[] intersection = new int[Math.min(l1, l2)];

        while (idx1 < l1 && idx2 < l2) {
            if (nums1[idx1] == nums2[idx2]) {
                if (idx == 0 || nums1[idx1] != intersection[idx--]) {
                    intersection[idx++] = nums1[idx1];
                }
                idx1++;
                idx2++;

            } else if (nums1[idx1] < nums2[idx2]) {
                idx1++;
            } else {
                idx2++;
            }
        }

        return Arrays.copyOf(intersection, idx);
    }
}
