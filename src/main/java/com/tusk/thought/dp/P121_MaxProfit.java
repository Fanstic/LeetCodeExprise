package com.tusk.thought.dp;

/**
 * @author tusk
 * @desc 买卖股票的最佳时机
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 * <p>
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 * <p>
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：[7,1,5,3,6,4]
 * 输出：5
 * 解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 * 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
 * 示例 2：
 * <p>
 * 输入：prices = [7,6,4,3,1]
 * 输出：0
 * 解释：在这种情况下, 没有交易完成, 所以最大利润为 0。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= prices.length <= 105
 * 0 <= prices[i] <= 104
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/6/24 8:47
 */
public class P121_MaxProfit {
    public static void main(String[] args) {
        P121_MaxProfit obj = new P121_MaxProfit();
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(obj.maxProfit02(prices));
    }

    /**
     * 买卖股票的最佳时机
     * 这么写会超出时间限制。
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int len = prices.length;

        if (len <= 1) {
            return 0;
        }
        int maxProfit = 0;

        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (prices[j] > prices[i]) {
                    int profit = prices[j] - prices[i];
                    maxProfit = profit > maxProfit ? profit : maxProfit;
                }
            }
        }
        return maxProfit;
    }

    /**
     * 遍历过程中记录最高和最低价格
     *
     * @param prices
     * @return
     */
    public int maxProfit01(int[] prices) {
        int len = prices.length;

        if (len <= 1) {
            return 0;
        }

        int maxPrice = 0;
        int minPrice = 0;
        int maxProfit = 0;

        for (int i = 1; i < len; i++) {
            if (prices[i] > prices[maxPrice]) {
                maxPrice = i;
            }

            if (prices[i] < prices[minPrice]) {
                minPrice = i;
                maxPrice = i;//你不能在买入前卖出股票。在找到最低价格时，之前的最高价格就无效了
            }

            int curProfit = prices[maxPrice] - prices[minPrice];
            if (maxPrice > minPrice && curProfit > maxProfit) {
                maxProfit = curProfit;
            }
        }

        return maxProfit;
    }

    /**
     * 动态规划 前i天的最大收益 = max{前i-1天的最大收益，第i天的价格-前i-1天中的最小价格}
     *
     * @param prices
     * @return
     */
    public int maxProfit02(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }

        int minPrice = prices[0];
        int max = 0;

        for (int i = 1; i < prices.length; i++) {
            max = Math.max(max, prices[i] - minPrice);
            minPrice = Math.min(minPrice, prices[i]);
        }

        return max;
    }

}
