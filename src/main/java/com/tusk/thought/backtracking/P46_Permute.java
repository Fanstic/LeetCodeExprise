package com.tusk.thought.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author tusk
 * @desc 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * 示例 2：
 * <p>
 * 输入：nums = [0,1]
 * 输出：[[0,1],[1,0]]
 * 示例 3：
 * <p>
 * 输入：nums = [1]
 * 输出：[[1]]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/6/8 16:44
 */
public class P46_Permute {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};


        P46_Permute obj = new P46_Permute();
        List<List<Integer>> result = obj.permute(nums);
        System.out.println(result);
    }

    //TODO:回溯算法求全排列，不理解
    /**
     * 回溯算法
     * @param nums
     * @param used
     * @param solation
     * @param result
     */
    public void backtrack(int[] nums, int[] used, LinkedList<Integer> solation, List<List<Integer>> result) {
        if (solation.size() == nums.length) {
            result.add(new LinkedList<>(solation));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (used[i] == 0) {
                    used[i] = 1;
                    solation.offerFirst(nums[i]);
                    backtrack(nums, used, solation, result);
                    solation.pollFirst();
                    used[i] = 0;
                }
            }
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> solation = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        int[] used = new int[nums.length];
        backtrack(nums, used, solation, result);
        return result;
    }
}
