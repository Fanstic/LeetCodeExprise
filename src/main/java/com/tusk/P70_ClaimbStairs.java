package com.tusk;

/**
 * 题号 70，爬楼梯
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 注意：给定 n 是一个正整数。
 * 1.
 *
 * @author tusk
 * @desc 爬楼梯
 * @date 2020/12/6 7:46
 */
public class P70_ClaimbStairs {

    public static void main(String[] args) {
        int n = 45;
        System.out.println(claimbStairs(n));
    }

    /**
     * 对计算结果进行缓存可以极大程度降低运行时间
     * 记忆搜索法
     *
     * @param n 楼梯阶数
     * @return 方案数
     */
    public static int claimbStairs(int n) {
        if (n <= 2) {
            return n;
        }

        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    /**
     * 斐波那契数列通项公式法
     * 时间复杂度：O(LogN)
     * 空间复杂度：O(1)
     *
     * @param n 楼梯阶数
     * @return 方案数
     */
    public static int claimbStairs0(int n) {
        double sqrt5 = Math.sqrt(5);
        double fibn = Math.pow((1 + sqrt5) / 2, n + 1) - Math.pow((1 - sqrt5) / 2, n + 1);
        return (int) (fibn / sqrt5);
    }

    /**
     * 滑动数组法
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     *
     * @param n 楼梯阶数
     * @return 方案数
     */
    public static int claimbStairs1(int n) {
        int p = 0;
        int q = 0;
        int r = 1;
        for (int i = 1; i <= n; ++i) {
            p = q;
            q = r;
            r = p + q;
        }
        return r;

    }
}

