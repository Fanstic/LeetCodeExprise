package com.tusk.thought.dp;

import java.util.Arrays;

/**
 * @author tusk
 * @desc 零钱兑换
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 * <p>
 * 你可以认为每种硬币的数量是无限的。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：coins = [1, 2, 5], amount = 11
 * 输出：3
 * 解释：11 = 5 + 5 + 1
 * 示例 2：
 * <p>
 * 输入：coins = [2], amount = 3
 * 输出：-1
 * 示例 3：
 * <p>
 * 输入：coins = [1], amount = 0
 * 输出：0
 * 示例 4：
 * <p>
 * 输入：coins = [1], amount = 1
 * 输出：1
 * 示例 5：
 * <p>
 * 输入：coins = [1], amount = 2
 * 输出：2
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= coins.length <= 12
 * 1 <= coins[i] <= 231 - 1
 * 0 <= amount <= 104
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/coin-change
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/6/29 9:08
 */
public class P322_CoinChange {
    public static void main(String[] args) {
        P322_CoinChange obj = new P322_CoinChange();
        int[] coins = {2};
        int amount = 3;
        System.out.println(obj.coinChange(coins, amount));
    }

    /**
     * 零钱兑换
     *
     * @param coins  硬币数组
     * @param amount 总金额
     * @return 所需最少硬币数
     */
    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        //dp[i]表示总金额为i时所需的最小硬币数
        int[] dp = new int[max];

        Arrays.fill(dp, max);
        dp[0] = 0;

        for (int i = 1; i <=amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i >= coins[j]) {
                    //dp[i]就等于总金额为 i - coins[j]时的最小硬币数加1(当前面值的硬币)
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }

        //因为coins[i]>=1，因此 dp[amount]一定是小于等于 amount的
        //因为dp使用max=amount +１进行填充，因此，当不存在可组成总金额的组合时，dp[i]的取值一定是max
        //因此，可以以此为条件，判断不满足的情况
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
