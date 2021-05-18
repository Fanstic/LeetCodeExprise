package com.tusk.primary.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author tusk
 * @desc给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 * <p>
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/majority-element
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/5/18 13:52
 */
public class P169_MajorElement {
    public static void main(String[] args) {
        int[] data = {2, 2, 3, 3, 3, 3, 2};
        P169_MajorElement obj = new P169_MajorElement();
        System.out.println(obj.majorElement(data));
    }

    /**
     *  哈希法
     *  时间复杂度:O(n)
     *  空间复杂度:O(n)
     * @param nums
     * @return
     */
    public int majorElement(int[] nums) {
        int len = nums.length;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < len; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
            } else {
                map.computeIfPresent(nums[i], (k, v) -> {
                    return v + 1;
                });
            }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int k = entry.getKey();
            int v = entry.getValue();

            if (v > len / 2) {
                return k;
            }
        }

        return 0;
    }

    /**
     * 排序
     * 1. 当前数组中一定只存在一个众数
     * 2. 将数组排序后，中间位置的数一定是众数
     * 时间复杂度:O(nlogN)
     * 空间复杂度:O(logN)
     * @param nums
     * @return
     */
    public int majorElement01(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    /**
     * 摩尔投票法
     * 时间复杂度:O(n)
     * 空间复杂度:O(1)
     * @param nums
     * @return
     */
    public int mooreVote(int[] nums){
        int count = 0;
        Integer candidate = null;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }
}
