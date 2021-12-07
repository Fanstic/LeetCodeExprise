package com.tusk.primary.array;

/**
 * @author tusk
 * @desc leetcode-560:和为k的子数组
 * https://leetcode-cn.com/problems/subarray-sum-equals-k/
 * @date 2021/12/7 15:52
 */
public class P560_SubArraySum {
    public static void main(String[] args) {
        int[] nums = new int[]{-1,-1,1};

        P560_SubArraySum obj = new P560_SubArraySum();
        System.out.println(obj.subarraySum(nums, 0));
    }

    /**
     * 这里需要注意一下，一个元素本身也算是一个子数组
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum(int[] nums, int k) {

        if(nums.length == 1){
        if(nums[0] == k){
            return 1;
        }else{
            return 0;
        }
        }

        //前缀和数组
        int[] preSums = new int[nums.length + 1];
        int count = 0;

        for (int i = 1; i < preSums.length; i++) {
            preSums[i] = preSums[i - 1] + nums[i - 1];
        }

        //穷举所有的子数组和
        for(int i=0;i<nums.length;i++){
            for(int j= i;j<nums.length;j++){
                //i~j
                int subSum = preSums[j + 1] - preSums[i];
                if(subSum == k ){
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * TODO:优化复杂度为O(N)
     * @param nums
     * @param k
     * @return
     */
    public int subarraySumImproved(int[] nums,int k){
        return  -1;
    }
}