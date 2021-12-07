package com.tusk.primary.array;

/**
 * @author tusk
 * @desc leetcode-303:区域和检索，数组不可变
 * 给定一个整数数组  nums，求出数组从索引 i 到 j（i ≤ j）范围内元素的总和，包含 i、j 两点。
 * https://leetcode-cn.com/problems/range-sum-query-immutable/
 * @date 2021/12/7 13:54
 */
public class P303_NumArray {
    public static void main(String[] args) {
        int[] arr = new int[]{-2, 0, 3, -5, 2, -1};

        P303_NumArray obj = new P303_NumArray(arr);

        System.out.println(obj.sumRange(0,2));
        System.out.println(obj.sumRange(2,5));
        System.out.println(obj.sumRange(0,5));
    }
    private int[] preSums;

    /**
     * 使用前缀和
     * @param arr
     */
    public P303_NumArray(int[] arr) {
        //构造一个arr的前缀和数组,preSums[0] = 0,便于计算
        preSums = new int[arr.length + 1];


        for (int i = 1; i < preSums.length; i++) {
            preSums[i] = preSums[i - 1] + arr[i - 1];
        }
    }

    public int sumRange(int left, int right) {
        if(left<0 || right>preSums.length){
            return -1;
        }
        return preSums[right + 1] - preSums[left];
    }
}
