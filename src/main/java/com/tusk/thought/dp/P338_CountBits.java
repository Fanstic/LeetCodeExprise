package com.tusk.thought.dp;

import java.util.Arrays;

/**
 * @author tusk
 * @desc 比特位计数
 * 给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 2
 * 输出: [0,1,1]
 * 示例 2:
 * <p>
 * 输入: 5
 * 输出: [0,1,1,2,1,2]
 * 进阶:
 * <p>
 * 给出时间复杂度为O(n*sizeof(integer))的解答非常容易。但你可以在线性时间O(n)内用一趟扫描做到吗？
 * 要求算法的空间复杂度为O(n)。
 * 你能进一步完善解法吗？要求在C++或任何其他语言中不使用任何内置函数（如 C++ 中的 __builtin_popcount）来执行此操作。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/counting-bits
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/6/15 14:38
 */
public class P338_CountBits {
    public static void main(String[] args) {
        P338_CountBits obj = new P338_CountBits();
        System.out.println(Arrays.toString(obj.countbits(1)));
    }

    /**
     * 动态规划法-最低有效位
     *
     * @param n
     * @return
     */
    public int[] countbits(int n) {
        int[] results = new int[n + 1];

//如果n为偶数，n的二进制中1的个数与n/2相同，如果为奇数则与 n/2 + 1相同
        for (int i = 1; i <= n; i++) {
//            int r = i >> 1;
//            int mod = i - 2 * (i / 2);//优化 x%y = x - x*(x/y)
//            results[i] = mod == 0 ? results[r] : results[r] + 1;
            results[i] = results[i >> 1] + (i & 1);//优化：奇数最低位为1,i&1=1,偶数最低位为0，i&1=0
        }

        return results;
    }
}

/**
 * 利用 Brian Kernighan 算法求解
 */
class Solution01 {
    /**
     * 利用 Brian Kernighan 算法求解十进制 n二进制表示时1的个数
     * 等同于 Integer.bitCount(n)
     *
     * @param n
     * @return
     */
    public int countOnes(int n) {
        int count = 0;
        while (n > 0) {
            n = n & (n - 1);
            count++;
        }

        return count;
    }

    public int[] countbits(int n) {
        int[] results = new int[n + 1];

        for (int i = 1; i < results.length; i++) {
            results[i] = countOnes(i);
        }

        return results;
    }
}

/**
 * 动态规划-最高有效位
 */
class Solution02 {
    public int[] countbits(int n) {
        int[] results = new int[n + 1];
        int highBit = 0;

        for (int i = 1; i < results.length; i++) {
            //当且仅当i为 2的整数幂
            if ((i & (i - 1)) == 0) {
                highBit = i;
            }
//highBit 取值1,2,4,8...，results[2] = results[2 - 2] + 1;
//            results[3] = results[3 - 2] + 1;
            results[i] = results[i - highBit] + 1;
        }

        return results;

    }

}
