package com.tusk.thought.dp;

/**
 * @author tusk
 * @desc P198 打家劫舍
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * <p>
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：[1,2,3,1]
 * 输出：4
 * 解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 * 示例 2：
 * <p>
 * 输入：[2,7,9,3,1]
 * 输出：12
 * 解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
 *      偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/house-robber
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/6/16 8:50
 */
public class P198_Rob {
    public static void main(String[] args) {
        P198_Rob obj = new P198_Rob();
        int[] nums = {1, 2, 3, 1};
        nums = new int[]{2, 7, 9, 3, 1};
        System.out.println(obj.rob(nums));

    }

    public int rob(int[] nums) {
        int len = nums.length;

        //dp[i]表示前n家能偷到的最大价值
        int[] dp = new int[len];
        dp[0] = nums[0];

        //如果只有一家则只能偷这一家
        if (nums.length <= 1) {
            return nums[0];
        }

        //前两家则偷其中价值大的一家
        dp[1] = Math.max(nums[0], nums[1]);

        for (int k = 2; k < len; k++) {
            //如果偷第k家，则不能偷k-1家，则dp[k] = dp[k-1] + nums[k]
            int robK = dp[k - 2] + nums[k];

            //不偷第k家,则等于dp[k-1]
            int unRobK = dp[k - 1];

            //取两种方案中的价值最大者
            dp[k] = Math.max(robK, unRobK);
        }

        return dp[len - 1];
    }


}
