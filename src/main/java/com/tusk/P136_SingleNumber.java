package com.tusk;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 题号136，只出现一次的数字
 *
 * @author tusk
 * @desc
 * @date 2020/12/10 16:45
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * <p>
 * 说明：
 * <p>
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 */

public class P136_SingleNumber {

    public static void main(String[] args) {
        int[] arr = {1, 1, 2};
        int[] arr1 = {1, 1, 2, 2, 3, 4, 4};
//        SingleNumberV1(arr);
        System.out.println(SingleNumberOffice(arr));
    }

    /**
     * 常规解法
     *
     * @param nums
     * @return
     */
    public static int singleNumber(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return -1;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }

        return 0;
    }

    /**
     * 空间复杂度O(1)
     *
     * @param nums
     * @return
     */
    public static int SingleNumberV1(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return -1;
        }

        if (nums.length == 1) {
            return nums[0];
        }

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                if (nums[i] < nums[i + 1]) {
                    return nums[i];
                }
            } else {
                if (i == nums.length - 1) {
                    if (nums[i] > nums[i - 1]) {
                        return nums[nums.length - 1];
                    }
                }

                if (nums[i] != nums[i - 1] && nums[i] != nums[i + 1]) {
                    return nums[i];
                }
            }
        }

        return -1;
    }

    /**
     * 官方解法，利用异或位运算
     * a^a=0
     * a^0=a
     *
     * @param nums
     * @return
     */
    public static int SingleNumberOffice(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return -1;
        }

        if (nums.length == 1) {
            return nums[0];
        }

        int m = 0;
        for (int n : nums) {
            m = m ^ n;
        }

        return m;
    }
}
