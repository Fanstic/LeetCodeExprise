package com.tusk.thought.backtracking;

import java.util.*;

/**
 * @author tusk
 * @desc 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * <p>
 * candidates 中的数字可以无限制重复被选取。
 * <p>
 * 说明：
 * <p>
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1：
 * <p>
 * 输入：candidates = [2,3,6,7], target = 7,
 * 所求解集为：
 * [
 * [7],
 * [2,2,3]
 * ]
 * 示例 2：
 * <p>
 * 输入：candidates = [2,3,5], target = 8,
 * 所求解集为：
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= candidates.length <= 30
 * 1 <= candidates[i] <= 200
 * candidate 中的每个元素都是独一无二的。
 * 1 <= target <= 500
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/6/9 13:50
 */
public class P39_CombinationSum {
    List<List<Integer>> result = new ArrayList<>();
//    HashSet<String> dic = new HashSet<>();

    public static void main(String[] args) {
        P39_CombinationSum obj = new P39_CombinationSum();
        int[] candidates = new int[]{2, 3,5};
        int target = 8;
        System.out.println(obj.combinationSum(candidates, target));
    }

    /**
     * 组合总和
     *
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        backTracking(candidates, target, new ArrayList<>(), 0,0);
        return result;
    }

    /**
     *
     * @param candidates
     * @param target
     * @param l
     * @param sum
     * @param begin 这里的 begin用于除去重复，用begin记录当前搜索开始的位置
     */
    public void backTracking(int[] candidates, int target, ArrayList<Integer> l, int sum,int begin) {
        if (sum >= target) {
            if (sum == target) {
                //这里使用了hash去重，比较耗时,如何可以做到在搜索过程中去重？
//                ArrayList<Integer> cl = new ArrayList<>(l);
//                Collections.sort(cl);
//                String hash = cl.toString();
//                if(!dic.contains(hash)){
//                    result.add(new ArrayList<>(l));
//                }
//                dic.add(hash);

                result.add(new ArrayList<>(l));
            }
        } else {
            for (int i = begin; i < candidates.length; i++) {
                l.add(candidates[i]);
                sum += candidates[i];
                backTracking(candidates, target, l, sum,i);
                l.remove(l.size() - 1);
                sum -= candidates[i];
            }
        }
    }
}
