package com.tusk;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * 题号1:两数求和
 * @desc 给定一个整数数组 nums 和一个目标值 target,在该数组中找出和为目标值的两个整数
 * 并返回它们的下标
 * 假设：每种输入只对应一个答案，但数组中的同一元素不能使用两次
 * @author tusk
 * @date 2020/11/23 13:03
 */
public class TwoNumSum {
    public static void main(String[] args) {

        final int MAX_SIZE = 100000;
        int[] dataArr1 = new int[MAX_SIZE];

        for(int i=0;i<MAX_SIZE;i++){
            dataArr1[i] = new Random().nextInt(1000);
        }

        long currMs = System.currentTimeMillis();
        int[] resultArr = calImproved(dataArr1, 10000);
        System.out.println("total elpased: " + (System.currentTimeMillis() - currMs));

        if (resultArr != null) {
            for (int item : resultArr) {
                System.out.println(item);
            }
        }

    }

    /**
     * 两数之和
     * 时间复杂度: O(N^2)
     * 空间复杂度：O(1)
     * @param nums   整数数组
     * @param target 目标值
     * @return 下标
     */
    public static int[] cal(int[] nums, int target) {
        int[] resultArr = new int[2];

        if (nums != null && nums.length > 1) {
            for (int i = 0; i < nums.length; i++) {
                int diffValue = target - nums[i];
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] == diffValue) {
                        resultArr[0] = i;
                        resultArr[1] = j;
                        return resultArr;
                    }
                }
            }
        }
        return null;
    }

    /**
     * 改进算法
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     * @param nums 整数数组
     * @param target 目标值
     * @return 下标数组
     */
    public static int[] calImproved(int[] nums,int target){
        if(nums == null || nums.length<1){
            return new int[0];
        }

        Map<Integer,Integer> mp = new HashMap<>(nums.length);

        for(int i=0;i<nums.length;i++){
            int diffVal = target - nums[i];
            if(mp.containsKey(diffVal)){
                return new int[]{mp.get(diffVal),i};
            }

            mp.put(nums[i],i);
        }

        return new int[0];
    }
}
