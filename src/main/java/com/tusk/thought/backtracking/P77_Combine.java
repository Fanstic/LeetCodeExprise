package com.tusk.thought.backtracking;

import java.sql.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: leetCodeExprise
 * @description: 组合
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 * <p>
 * 示例:
 * <p>
 * 输入: n = 4, k = 2
 * 输出:
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combinations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: asus
 * @create: 2021-06-12 19:40
 **/
public class P77_Combine {
    List<Integer> solution = new LinkedList<>();
    List<List<Integer>> result = new ArrayList<>();

    public static void main(String[] args) {
        P77_Combine obj = new P77_Combine();
        int n = 4;
        int k = 2;
        System.out.println(new Solution_01().combine(n, k));
    }


    /**
     * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
     *
     * @param n
     * @param k
     * @return
     */
    public List<List<Integer>> combine(int n, int k) {
        int[] used = new int[n];
        backTrack(n, k, 1, used);
        return result;
    }

    public void backTrack(int n, int k, int begin, int[] used) {
        if (solution.size() == k) {
            result.add(new ArrayList<>(solution));
        }

        for (int i = begin; i <= n; i++) {
            if (used[i - 1] == 1) {
                continue;
            }
            solution.add(i);
            used[i - 1] = 1;
            backTrack(n, k, i, used);
            used[i - 1] = 0;
            solution.remove(solution.size() - 1);
        }
    }
}

class Solution_01 {
    List<Integer> solution = new LinkedList<>();
    List<List<Integer>> result = new ArrayList<>();

    /**
     * 字典法
     *
     * @param n
     * @param k
     * @return
     */
    public List<List<Integer>> combine(int n, int k) {
        backTrack(n, k, 1);
        return result;
    }

    public void backTrack(int n, int k, int cur) {
        if (solution.size() == k) {
            result.add(new ArrayList<>(solution));
        }

        for (int i = cur; i <= n; i++) {
            solution.add(i);
            backTrack(n, k, i + 1);
            solution.remove(solution.size() - 1);
        }
    }
}