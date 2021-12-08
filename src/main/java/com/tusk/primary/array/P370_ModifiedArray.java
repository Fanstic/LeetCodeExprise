package com.tusk.primary.array;

import java.util.Arrays;

/**
 * @author tusk
 * @desc leetcode-370:区间加法
 * 假设有一个长度为n的数组，初始情况下所有的值均为0，给出k个更新的操作，每一个操作会被表示为
 * 一个三元组的形式，例如[start,end,inc],即表示对[start,end]闭合区间的数组元素增加inc,
 * 然后要求返回k次操作后的数组
 * 解题思路：差分数组，使用与对数组的某一区间进行频繁加减操作的场景
 * 解释一下差分数组：diff[i] = nums[i] - nums[i-1],
 * 根据差分数组可以推断出原来的数组：nums[i]=nums[i-1] + diff[i],
 * 如果要对原数组 [start,end]的元素执行inc的更新操作，相当于是在差分数组上执行如下的操作
 * diff[start]+=inc,
 * diff[end+1]-=inc(如果end+1>=length,则表示对数组中的所有元素执行操作，无效执行这一步
 * <p>
 * 通过此种方式，可以将此需求下常规操作的 O(N)的处理转换为O(1)的操作
 *
 * 类似的题目:leetcode-1109:航班预订统计
 * leetcode-1094:拼车
 * @date 2021/12/8 9:39
 */
public class P370_ModifiedArray {
    public static void main(String[] args) {
        P370_ModifiedArray obj = new P370_ModifiedArray();

        int[][] updates = new int[][]{
                new int[]{0,2,3},
                new int[]{2,4,-2}
        };

        int[] result = obj.getModifiedArray(6,updates);
        System.out.println(Arrays.toString(result));
    }

    public int[] getModifiedArray(int length, int[][] updates) {
        int[] nums = new int[length];//长度为length,初始值全为0 的数组

        int[] diff = new int[length];

        for (int[] arr : updates) {
            int start = arr[0];
            int end = arr[1];
            int inc = arr[2];

            diff[start] += inc;
            if(end+1<length)
            diff[end + 1] -= inc;
        }

        nums[0] = diff[0];
        for (int i = 1; i < length; i++) {
            nums[i] = nums[i - 1] + diff[i];
        }

        return nums;
    }
}
