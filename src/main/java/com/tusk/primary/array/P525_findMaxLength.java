package com.tusk.primary.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author tusk
 * @desc 给定一个二进制数组 nums , 找到含有相同数量的 0 和 1 的最长连续子数组，并返回该子数组的长度。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [0,1]
 * 输出: 2
 * 说明: [0, 1] 是具有相同数量0和1的最长连续子数组。
 * 示例 2:
 * <p>
 * 输入: nums = [0,1,0]
 * 输出: 2
 * 说明: [0, 1] (或 [1, 0]) 是具有相同数量0和1的最长连续子数组。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/contiguous-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/6/3 16:58
 */
public class P525_findMaxLength {
    public static void main(String[] args) {
        P525_findMaxLength obj = new P525_findMaxLength();
        int[] nums = new int[]{0, 0, 1, 0, 0, 0, 1, 1};
        System.out.println(obj.findMaxLength(nums));
    }

    public int findMaxLength(int[] nums) {
        int len = nums.length;

        int[] preFixSus = new int[len];

        for (int i = 0; i < len; i++) {
            if (nums[i] == 0) {
                nums[i] = -1;
            }
        }

        //初始化前缀和
        for (int i = 0; i < len; i++) {
            int sum = 0;
            if (i == 0) {
                preFixSus[i] = nums[0];
            } else {
                preFixSus[i] = preFixSus[i - 1] + nums[i];
            }
        }

        int maxLen = len % 2 == 0 ? len : len - 1;
        for (int i = maxLen; i >= 2; i -= 2) {
            int max = len - i;

            while (max >= 0) {
                //i~k的和sum = preFixSus[k] - preFixSus[i-1]

                int j = max - 1;
                int k = max + i - 1;

                int sum = 0;

                if (j < 0) {
                    sum = preFixSus[k];
                } else {
                    sum = preFixSus[k] - preFixSus[j];
                }

                if (sum == 0) {
                    return i;
                }

                max--;
            }
        }
        return 0;
    }

    public int findMaxLengthOffice(int[] nums) {
        int len = nums.length;
        int maxLength = 0;
        int counter = 0;

        //map用来记录前缀和及第一次出现的下标
        Map<Integer, Integer> map = new HashMap<>();

        //空的前缀前缀和为0
        map.put(counter, -1);

        for (int i = 0; i < len; i++) {
            if (nums[i] == 1) {
                counter++;
            } else {
                counter--;
            }

            if(map.containsKey(counter)){
                int prevIndex = map.get(counter);
                maxLength = Math.max(prevIndex, i);
            }else{
                map.put(counter,i);
            }
        }

        return maxLength;
    }
}
