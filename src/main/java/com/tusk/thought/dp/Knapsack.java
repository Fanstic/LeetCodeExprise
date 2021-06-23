package com.tusk.thought.dp;

/**
 * @author tusk
 * @desc o-1背包问题
 * 给你一个可装载重量为W的背包和N个物品，每个物品有重量和价值两个属性。其中第i个物品的重量为wt[i]，价值为val[i]，现在让你用这个背包装物品，最多能装的价值是多少？
 * <p>
 * 举个简单的例子，输入如下：
 * <p>
 * N = 3, W = 4
 * wt = [2, 1, 3]
 * val = [4, 2, 3]
 * 算法返回 6，选择前两件物品装进背包，总重量 3 小于W，可以获得最大价值 6。
 * https://mp.weixin.qq.com/s?__biz=MzAxODQxMDM0Mw==&mid=2247485064&idx=1&sn=550705eb67f5e71487c8b218382919d6&chksm=9bd7f880aca071962a5a17d0f85d979d6f0c5a5ce32c84b8fee88e36d451f9ccb3bb47b88f78&scene=21#wechat_redirect
 * @date 2021/6/22 13:57
 */
public class Knapsack {
    public static void main(String[] args) {

        //物品个数
        int N = 3;
        //背包最大容量
        int W = 4;

        //物品重量
        int[] wt = {2, 1, 3};
        //物品价值
        int[] val = {4, 2, 3};

        System.out.println(new Knapsack().knapsack(N, W, wt, val));
    }

    /**
     * 0-1背包问题
     * 1.状态  背包容量和是否放入物品
     * 2.做选择 装进背包或不装进背包
     * 3.明确 dp数组的含义
     * @param n 物品个数
     * @param w 背包容量
     * @param wt 重量数组
     * @param val 价值数组
     * @return
     */
    public int knapsack(int n, int w, int[] wt, int[] val) {
        //dp[i][j]表示前i个物品放在容量为j的背包中的最大价值
        int[][] dp = new int[n + 1][w + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= w; j++) {
                //表示背包当前可以放下当前的物品
                if (j - wt[i - 1] >= 0) {
                    //当前物品装入背包,当前背包价值就等于背包容量为 j - wt[i-1]时放 i - 1件物品时背包的最大价值加上当前物品的价值
                    int v1 = dp[i - 1][j - wt[i - 1]] + val[i - 1];

                    //当前物品不装入背包,最大价值就等于 i-1 件物品的最大价值
                    int v2 = dp[i - 1][j];
                    dp[i][j] = Math.max(v1, v2);

                } else {
                    dp[i][j] = dp[i - 1][w];
                }
            }
        }

        return dp[n][w];
    }
}
