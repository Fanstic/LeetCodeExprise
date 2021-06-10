package com.tusk.thought.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author tusk
 * @desc 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * <p>
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * 示例 2：
 * <p>
 * 输入：nums = [0]
 * 输出：[[],[0]]
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 * nums 中的所有元素 互不相同
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subsets
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/6/10 13:57
 */
public class P78_SubSets {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> solution = new LinkedList<>();

    public static void main(String[] args) {
        P78_SubSets obj = new P78_SubSets();
        int[] nums = new int[]{1, 2, 3};
        System.out.println(obj.suSets01(nums));

    }

    /**
     * 数组子集
     * 官方解法1
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> subSets(int[] nums) {
        int n = nums.length;
        for (int mask = 0; mask < (1 << n); mask++) {
            solution.clear();
            for (int i = 0; i < n; i++) {
                //这里取数很巧妙，不等0说明当前元素存在于子集中，例如nums=[1,2,3],则101(二进制)表示
                //1和3存在于当前子集中，所有的子集即按照 0~2^n-1的二进制位进行取值，n为len(nums)
                if ((mask & (1 << i)) != 0) {
                    solution.add(nums[i]);
                }
            }
            result.add(new ArrayList<>(solution));
        }

        return result;
    }


    /**
     * 回溯法求解
     * 子集和排列组合可以看做是回溯算法求解的两种不同的类型，子集的解空间是子集树,后者的解空间是排列树
     * 参考：https://www.cnblogs.com/waring/p/4551218.html#:~:text=%E5%9B%9E%E6%BA%AF%E6%B3%95%E7%9A%84%E8%A7%A3%E7%A9%BA%E9%97%B4%E8%A1%A8%E7%A4%BA%E6%96%B9%E6%B3%95.%20%E5%9B%9E%E6%BA%AF%E6%B3%95%E8%A7%A3%E9%A2%98%E6%97%B6%E9%80%9A%E5%B8%B8%E5%8C%85%E5%90%AB3%E4%B8%AA%E6%AD%A5%E9%AA%A4%EF%BC%9A.%201.%20%E9%92%88%E5%AF%B9%E6%89%80%E7%BB%99%E9%97%AE%E9%A2%98%EF%BC%8C%E5%AE%9A%E4%B9%89%E9%97%AE%E9%A2%98%E7%9A%84%E8%A7%A3%E7%A9%BA%E9%97%B4%EF%BC%9B.,2.%20%E7%A1%AE%E5%AE%9A%E6%98%93%E4%BA%8E%E6%90%9C%E7%B4%A2%E7%9A%84%E8%A7%A3%E7%A9%BA%E9%97%B4%E7%BB%93%E6%9E%84%EF%BC%9B.%203.%20%E4%BB%A5%E6%B7%B1%E5%BA%A6%E4%BC%98%E5%85%88%E6%96%B9%E5%BC%8F%E6%90%9C%E7%B4%A2%E8%A7%A3%E7%A9%BA%E9%97%B4%EF%BC%8C%E5%B9%B6%E5%9C%A8%E6%90%9C%E7%B4%A2%E8%BF%87%E7%A8%8B%E4%B8%AD%E7%94%A8%E5%89%AA%E6%9E%9D%E5%87%BD%E6%95%B0%E9%81%BF%E5%85%8D%E6%97%A0%E6%95%88%E6%90%9C%E7%B4%A2%E3%80%82.%20%E5%AF%B9%E4%BA%8E%E9%97%AE%E9%A2%98%E7%9A%84%E8%A7%A3%E7%A9%BA%E9%97%B4%E7%BB%93%E6%9E%84%E9%80%9A%E5%B8%B8%E4%BB%A5%E6%A0%91%E6%88%96%E5%9B%BE%E7%9A%84%E5%BD%A2%E5%BC%8F%E8%A1%A8%E7%A4%BA%EF%BC%8C%E5%B8%B8%E7%94%A8%E7%9A%84%E4%B8%A4%E7%B1%BB%E5%85%B8%E5%9E%8B%E7%9A%84%E8%A7%A3%E7%A9%BA%E9%97%B4%E6%A0%91%E6%98%AF%E5%AD%90%E9%9B%86%E6%A0%91%E5%92%8C%E6%8E%92%E5%88%97%E6%A0%91%E3%80%82.
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> suSets01(int[] nums) {
        backTrack(nums, 0,nums.length);
        return result;
    }

    public void backTrack(int[] nums,int begin,int n) {
       result.add(new ArrayList<>(solution));
        System.out.println(solution);
       for(int i=begin;i<n;i++){
           solution.offerLast(nums[i]);
           backTrack(nums,i + 1,n);
           solution.pollLast();
       }
    }

}

