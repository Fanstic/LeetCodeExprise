package com.tusk.thought.dp;

/**
 * @author tusk
 * @desc 70. 爬楼梯
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * <p>
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * <p>
 * 注意：给定 n 是一个正整数。
 * <p>
 * 示例 1：
 * <p>
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * 示例 2：
 * <p>
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/climbing-stairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/6/15 13:57
 */
public class P70_ClaimStairs {
    public static void main(String[] args) {
        P70_ClaimStairs obj = new P70_ClaimStairs();
        System.out.println(obj.claimStairs(4));
    }

    /**
     * 动态规划解法
     * 1. 最优子结构
     * 2.状态转移方程
     * 3.重叠子结构(可通过dp数组或备忘录进行优化)
     * 参考：https://mp.weixin.qq.com/s?__biz=MzAxODQxMDM0Mw==&mid=2247484731&idx=1&sn=f1db6dee2c8e70c42240aead9fd224e6&chksm=9bd7fb33aca07225bee0b23a911c30295e0b90f393af75eca377caa4598ffb203549e1768336&scene=21#wechat_redirect
     * @param n
     * @return
     */
    public int claimStairs(int n) {
        if (n <= 2) {
            return n;
        }

        int prev = 1;
        int curr = 2;

        for(int i=3;i<=n;i++){
            int sum = prev + curr;
            prev = curr;
            curr = sum;
        }

        return curr;
    }
}
