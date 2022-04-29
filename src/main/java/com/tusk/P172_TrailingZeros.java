package com.tusk;

/**
 * 给定一个整数 n ，返回 n! 结果中尾随零的数量。
 * <p>
 * 提示 n! = n * (n - 1) * (n - 2) * ... * 3 * 2 * 1
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 3
 * 输出：0
 * 解释：3! = 6 ，不含尾随 0
 * 示例 2：
 * <p>
 * 输入：n = 5
 * 输出：1
 * 解释：5! = 120 ，有一个尾随 0
 * 示例 3：
 * <p>
 * 输入：n = 0
 * 输出：0
 *  
 * <p>
 * 提示：
 * <p>
 * 0 <= n <= 104
 *  
 * <p>
 * 进阶：你可以设计并实现对数时间复杂度的算法来解决此问题吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/factorial-trailing-zeroes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class P172_TrailingZeros {
    public static void main(String[] args) {
        P172_TrailingZeros obj = new P172_TrailingZeros();

        int n = 125;
        System.out.println(obj.trailingZeros(n));
    }

    /**
     * 首先理解结果中的零是如何来的：十进制下，每包含一对(5*2)结果中便会出现一个0
     * 每一个偶数都可以拆解出来2，因此这个问题就转换为了结果中可以拆解出来多少个的5
     * 5，15 本身提供一个5
     * 25本身可以提供两个5
     * 125 本身可以提供3个5
     *
     * @param n
     * @return
     */
    public int trailingZeros(int n) {
        long divisor = 5L;
        int count = 0;

        while (divisor <= n) {
            count += n / divisor;
            divisor *= 5;
        }

        return count;
    }
}
