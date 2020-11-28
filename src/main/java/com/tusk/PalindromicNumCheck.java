package com.tusk;

/**
 * 题号9，回文数，即从前往后与从后往前读结果一致
 *
 * @author tusk
 * @desc 判断一个整数是否为回文数
 * @date 2020/11/28 10:26
 */
public class PalindromicNumCheck {
    public static void main(String[] args) {

    }

    /**
     * 普通思路转字符串
     *
     * @param num 整形数
     * @return 是否为回文数
     */
    public static boolean check(int num) {
        //临界条件,1.负数肯定不是回文数;2.个位为 0 的肯定不是回文数
        if (num < 0 || (num !=0 && num % 10 == 0)) {
            return false;
        }

        String s = String.valueOf(num);

        for (int i = 0; i < s.length() / 2; i++) {
            char p = s.charAt(i);
            char q = s.charAt(s.length() - i - 1);

            if (p != q)
                return false;
        }

        return true;
    }

    /**
     * 官方解法,数字反转，全部反转可能会溢出，因此，考虑半数反转
     * 1. 如何反转
     * 2. 如何判断是否中位
     * @param num 整形数
     * @return 是否为回文数
     */
    public static boolean checkImporve(int num){
        if(num < 0 || (num !=0 &&num % 10 == 0)){
            return false;
        }

        int reverseNum = 0;

        //位数一半的判断
        while (reverseNum < num){
            reverseNum = reverseNum*10 + num % 10;
            num = num / 10;
        }

        //当输入数字长度为奇数时，reverseNum / 10,去除中位数，因此，此时中位数不影响是否
        //为回文数
        return num == reverseNum || num == reverseNum / 10;
    }
}
