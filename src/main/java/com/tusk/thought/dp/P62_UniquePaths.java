package com.tusk.thought.dp;

import java.util.Arrays;

/**
 * @author tusk
 * @desc 不同的路径
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 * <p>
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 * <p>
 * 问总共有多少条不同的路径？
 * <p>
 * 输入：m = 3, n = 7
 * 输出：28
 * 示例 2：
 * <p>
 * 输入：m = 3, n = 2
 * 输出：3
 * 解释：
 * 从左上角开始，总共有 3 条路径可以到达右下角。
 * 1. 向右 -> 向下 -> 向下
 * 2. 向下 -> 向下 -> 向右
 * 3. 向下 -> 向右 -> 向下
 * 示例 3：
 * <p>
 * 输入：m = 7, n = 3
 * 输出：28
 * 示例 4：
 * <p>
 * 输入：m = 3, n = 3
 * 输出：6
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= m, n <= 100
 * 题目数据保证答案小于等于 2 * 109
 * 通过次数263,809提交次数403,629
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/unique-paths
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/6/18 23:00
 */
public class P62_UniquePaths {
    public static void main(String[] args) {
        P62_UniquePaths obj = new P62_UniquePaths();
        System.out.println(obj.uniquePaths01(3, 7));
    }

    public int uniquePaths(int m, int n) {
        //dp[i][j] 表示从左上角到 i,j的不同线路数
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }

        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                //到当前位置的线路数=到左侧的线路数 + 到上面的线路数
                //这里可优化，只记录其左侧的线路数和上册的线路数，而不需要声明一个数组
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    /**
     * 优化上面的解决方案
     * 上面的解法空间复杂度为 O(mn)，可以使用滑动数组进行优化
     *
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths01(int m, int n) {
        int[][] dp = new int[2][n];

        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }

        dp[1][0] = 1;

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i % 2][j] = dp[(i - 1) % 2][j] + dp[i % 2][j - 1];
            }
        }

        return m%2 == 0?dp[1][n-1]:dp[0][n - 1];
    }

    /**
     * mod 优化
     * @param x
     * @param y
     * @return
     */
    public int mod(int x,int y){
        return x - x*(x/y);
    }
}