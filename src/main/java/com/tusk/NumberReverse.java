package com.tusk;

/**
 *  题号：7 整数反转
 *
 * @author tusk
 * @desc 给出一个 32 位整数，将这个整数的所有位上的数字反转，反转后溢出则返回0
 * @date 2020/11/25 8:38
 */
public class NumberReverse {
    public static void main(String[] args) {

    }

    public static int reverse(int n) {
        int arg = Math.abs(n);

        String[] arr = String.valueOf(arg).split("");
        if ("0".equals(arr[arr.length - 1])) {
            return 0;
        }

        for (int i = 0; i < arr.length / 2; i++) {
            String tmp = arr[i];
            arr[i] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = tmp;
        }


        String reverResult = String.join("", arr);
        long longResult = Long.parseLong(reverResult);
        if (longResult > Integer.MAX_VALUE || longResult < Integer.MIN_VALUE) {
            return 0;
        } else {
            return (int) longResult;
        }

    }

    /**
     * 官方解法
     *
     * @param n 整数n
     * @return 反转后的整数
     */
    public static int reverseImproved(int n) {
        int rev = 0;
        while (n != 0) {
            int pop = n % 10;
            n = n / 10;

            /*
            判断溢出上限条件
            如果 rev = rev * 10 + pop > Integer.MAX_VALUE,则有 rev*10 > Integer.MAX_VALUE,当 rev = Integer.MAX_VALUE 时，
            可得,此时 pop = 7,
             */
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) {
                return 0;
            }

            /*
            判断溢出下限条件,
            同上限条件，可得 下限 pop = -8
             */
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) {
                return 0;
            }
            rev = rev * 10 + pop;
        }
        return rev;
    }
}
