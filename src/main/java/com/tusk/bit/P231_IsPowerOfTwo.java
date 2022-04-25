package com.tusk.bit;

/**
 * 给你一个整数 n，请你判断该整数是否是 2 的幂次方。如果是，返回 true ；否则，返回 false 。
 * <p>
 * 如果存在一个整数 x 使得 n == 2x ，则认为 n 是 2 的幂次方。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 1
 * 输出：true
 * 解释：20 = 1
 * 示例 2：
 * <p>
 * 输入：n = 16
 * 输出：true
 * 解释：24 = 16
 * 示例 3：
 * <p>
 * 输入：n = 3
 * 输出：false
 * 示例 4：
 * <p>
 * 输入：n = 4
 * 输出：true
 * 示例 5：
 * <p>
 * 输入：n = 5
 * 输出：false
 *  
 * <p>
 * 提示：
 * <p>
 * -231 <= n <= 231 - 1
 *  
 * <p>
 * 进阶：你能够不使用循环/递归解决此问题吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/power-of-two
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class P231_IsPowerOfTwo {

    public static void main(String[] args) {
        P231_IsPowerOfTwo obj = new P231_IsPowerOfTwo();

        int n = 16;
        System.out.println(obj.isPowerOfTwo(n));
    }

    public boolean isPowerOfTwo(int n) {
        if(n<=0){
            return false;
        }

        return (n & (n - 1)) == 0;
    }
}
