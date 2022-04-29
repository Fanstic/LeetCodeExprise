package com.tusk.other;

import java.util.Arrays;

/**
 * 统计素数
 * 素数定义：一个数只能被1和其本身整除，则这个数称之为素数
 */
public class CountPrimes {

    public static void main(String[] args) {
        CountPrimes obj = new CountPrimes();
        int count = obj.countPrimesV2(100);
        System.out.println(count);
    }

    /**
     * 返回小于n的所有素数的个数
     *
     * @param n
     * @return
     */
    public int countPrimes(int n) {
        if (n <= 1) {
            return 0;
        }

        int count = 0;
        boolean isPrime = true;
        for (int i = 2; i <= n; i++) {

            //region 为什么为 j*j<=i,而不是j<=i
            //如果在[2,sqrt(n)]范围内没有发现整除因子，那么在（sqrt(n),n]范围内也不会有
            //因此，这里的j的上限无需设置为i
//            12 = 2 × 6
//            12 = 3 × 4
//            12 = sqrt(12) × sqrt(12)
//            12 = 4 × 3
//            12 = 6 × 2
            //endregion
            for (int j = 2; j * j <= i; j++) {
                if (i % j == 0) {
                    isPrime = false;
                }
            }

            if (isPrime) {
                count++;
            } else {
                isPrime = true;
            }
        }

        return count;
    }

    /**
     * 返回n范围之内的素数的个数
     * 另外一种更为高效的算法
     * <p>
     * 思路：
     * 1. 如果一个数为素数，那么它的任何倍数都不是素数
     * <p>
     * 可根据上面的结论来进行筛选
     *
     *  Sieve of Eratosthenes算法
     * @param n
     * @return
     */
    public int countPrimesV2(int n) {
        boolean[] isPrimes = new boolean[n];
        int count = 0;

        Arrays.fill(isPrimes, true);

        for (int i = 2; i*i < n; i++) {
            if (isPrimes[i]) {
                //这里的2*i,可以优化为i*i
                for (int j = 2*i; j < n; j+=i) {
                    isPrimes[j] = false;
                }
            }
        }

        for (int i = 2; i < n; i++) {
            if (isPrimes[i]) {
                count++;
            }
        }

        return count;
    }
}
