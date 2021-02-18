package com.tusk;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 题号217，是否存在重复元素
 *
 * @author tusk
 * @desc
 * @date 2020/12/9 10:29
 */
public class P217_ContainDuplicate {
    public static void main(String[] args) {
        int[] arr0 = {1, 3, 3};
        System.out.println(containDuplicateV1(arr0));
    }

    /**
     * hash 判断
     *
     * @param nums
     * @return
     */
    public static boolean containDuplicate(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return false;
        }

        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            if (set.contains(i)) {
                return true;
            } else {
                set.add(i);
            }
        }
        return false;
    }

    /**
     * 排序 + 快慢指针
     *
     * @param nums
     * @return
     */
    public static boolean containDuplicateV1(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return false;
        }

        Arrays.sort(nums);

        int j = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[j] == nums[i]) {
                return true;
            } else {
                j++;
            }
        }

        return false;
    }

    /**
     * 他人解法
     *
     * @param nums
     * @return
     */
    public static boolean containDuplicateV2(int[] nums) {
        if (nums.length == 0) return false;
        int max = nums[0];
        int min = nums[0];

        //找到最大值和最小值
        for (int num : nums) {
            if (num > max)
                max = num;
            if (num < min)
                min = num;
        }

        boolean[] bool = new boolean[max - min + 1];
        for (int num : nums) {
            /*
            默认为 false,第一次执行变为 true,如果有重复，第二次执行会变为false,下面取反为真返回 true
             */
            bool[num - min] = !bool[num - min];
            if (!bool[num - min])
                return true;
        }
        return false;
    }

    /**
     * 他人解法
     * @param nums
     * @return
     */
    public static boolean containDuplicateV3(int[] nums) {
        if (nums.length == 0 || nums.length == 1) {
            return false;
        } else {
            int temp;
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] == nums[i - 1]) {
                    return true;
                } else if (nums[i] < nums[i - 1]) {
                    for (int j = i - 2; j >= 0; j--) {
                        if (nums[i] == nums[j]) {
                            return true;
                        }
                    }
                    temp = nums[i];
                    nums[i] = nums[i - 1];
                    nums[i - 1] = temp;
                }
            }
            return false;
        }
    }
}
