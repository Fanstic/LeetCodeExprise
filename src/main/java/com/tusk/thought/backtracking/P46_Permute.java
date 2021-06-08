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
     * https://www.bilibili.com/video/BV1P5411N7Xc?t=840
     *
     * @param nums
     * @param used
     * @param solution
     * @param result
     */
    public void backtrack(int[] nums, int[] used, LinkedList<Integer> solution, List<List<Integer>> result) {
        //到达叶子节点，将路径装入全排列列表
        if (solution.size() == nums.length) {
            result.add(new LinkedList<>(solution));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (used[i] == 1) {
                    continue;
                } else {
                    //做选择
                    used[i] = 1;
                    solution.offerFirst(nums[i]);
                    //进入下一次决策树
                    backtrack(nums, used, solution, result);

                    //撤销选择
                    solution.pollFirst();
                    used[i] = 0;
                }
            }
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        //存储单次全排列
        LinkedList<Integer> solatiou = new LinkedList<>();
        //存储所有全排列
        List<List<Integer>> result = new ArrayList<>();
        //记录节点是否已访问
        int[] used = new int[nums.length];
        backtrack(nums, used, solatiou, result);
        return result;
    }
}
