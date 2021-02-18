package com.tusk;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 数组交集2
 * 给定两个数组，编写一个函数来计算它们的交集。
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2,2]
 * 示例 2:
 * <p>
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[4,9]
 * <p>
 * 说明：
 * <p>
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现次数的最小值一致。
 * 我们可以不考虑输出结果的顺序。
 * 进阶：
 * <p>
 * 如果给定的数组已经排好序呢？你将如何优化你的算法？
 * 如果nums1的大小比nums2小很多，哪种方法更优？
 * 如果nums2的元素存储在磁盘上，内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2y0c2/
 *
 * @author tusk
 * @desc
 * @date 2020/12/12 17:59
 */
public class P350_Intersection2 {
    public static void main(String[] args) {
        int[] arr = {4, 9, 5};
        int[] arr1 = {9, 4, 9, 8, 4};

        int[] arr2 = {1};
        int[] arr3 = {1};

        int[] arr4 = {3, 1, 2};
        int[] arr5 = {1, 1};

        int[] arr6 = {1, 2, 2, 1};
        int[] arr7 = {2, 2};

        int[] resultArr = intersect(arr2, arr3);
        for (int n : resultArr) {
            System.out.println(n);
        }

    }

    public static int[] intersect(int[] nums1, int[] nums2) {

        if (nums1 == null || nums2 == null) {
            return new int[0];
        }

        if (nums1.length <= 0 || nums2.length <= 0) {
            return new int[0];
        }
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }

        Map<Integer, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            int lastIdx = findValueInMap(map, nums1[i]);
            int start = 0;
            if (lastIdx >= 0) {
                start = lastIdx + 1;
            }

            int targetIndex = indexOf(nums2, nums1[i], start);
            if (targetIndex >= 0) {
                map.put(targetIndex, nums1[i]);
            }
        }

        return Arrays.stream(map.values().toArray(new Integer[0]))
                .mapToInt(Integer::valueOf).toArray();
    }

    /**
     * 官方 hash解法
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] intersectV2(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return intersectV2(nums2, nums1);
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            map.put(nums1[i], map.getOrDefault(nums1[i], 0) + 1);
        }

        int[] intersectionArr = new int[nums1.length];
        int index = 0;
        for (int i = 0; i < nums2.length; i++) {
            int count = map.getOrDefault(nums2[i], 0);
            if (count > 0) {
                intersectionArr[index++] = nums2[i];
                count--;

                //这里求交集相同的元素要计算多次，因此需要把count重新赋回去
                if (count > 0) {
                    map.put(nums2[i], count);
                } else {
                    map.remove(nums2[i]);
                }
            }
        }

        return Arrays.copyOfRange(intersectionArr, 0, index);
    }

    /**
     * 官方 排序 + 双指针解法
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] intersectV3(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return intersectV3(nums2, nums1);
        }

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int index = 0;
        int index1 = 0;
        int index2 = 0;
        int[] intersectionArr = new int[nums1.length];
        while (index1 < nums1.length && index2 < nums2.length) {
            if (nums1[index1] < nums2[index2]) {
                index1++;
            } else if (nums1[index1] > nums2[index2]) {
                index2++;
            } else {
                intersectionArr[index++] = nums1[index1];
                index1++;
                index2++;
            }
        }

        return Arrays.copyOfRange(intersectionArr, 0, index);
    }


    public static int indexOf(int[] nums, int key, int start) {
        List<Integer> resultList = new LinkedList<>();
        for (int i = start; i < nums.length; i++) {
            if (nums[i] == key) {
                return i;
            }
        }
        return -1;
    }


    public static int findValueInMap(Map<Integer, Integer> map, int value) {
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        Stream<Map.Entry<Integer, Integer>> resultSet = entries.stream().filter(e -> {
            return e.getValue() == value;
        }).sorted((a, b) -> b.getKey() - a.getKey());

        try {
            List<Map.Entry<Integer, Integer>> first = resultSet.collect(Collectors.toList());
            return first.get(0).getKey();
        } catch (Exception e) {
            return -1;
        }
    }
}
