package com.tusk;

/**
 * 题号 69，x 的平方根
 * 实现int sqrt(int x) 函数。
 * <p>
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 * <p>
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 *
 * @author tusk
 * @desc x 的平方根
 * @date 2020/12/4 10:08
 */
public class MySqrt {
    public static void main(String[] args) {
        System.out.println(mySqrt(2134567891));
    }

    /**
     * 二分查找法
     *
     * @param x
     * @return 平方根
     */
    public static int mySqrt(int x) {
        if (x <= 1) {
            return x;
        }

        int l = 0;
        int r = x;
        int ans = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            //不转long会有问题
            if ((long) mid * mid <= x) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }
}
