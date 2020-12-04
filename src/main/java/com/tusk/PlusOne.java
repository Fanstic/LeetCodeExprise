package com.tusk;

/**
 * 题号66
 * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 * @author tusk
 * @desc 加一
 * @date 2020/12/4 8:59
 */
public class PlusOne {

    public static void main(String[] args) {
        int[] arr = {9};
        arr = plusOne(arr);
        for (int a : arr) {
            System.out.println(a);
        }
    }

    /**
     * 自己写的，有点啰哩巴嗦的
     *
     * @param digits 整形数组
     * @return 运算结果数组
     */
    public static int[] plusOne(int[] digits) {
        boolean carry;
        int tmpSum = digits[digits.length - 1] + 1;
        if (tmpSum < 10) {
            digits[digits.length - 1] += 1;
            return digits;
        } else {
            if (digits.length == 1 && digits[0] == 9) {
                return new int[]{1, 0};
            }
            digits[digits.length - 1] = tmpSum % 10;
            carry = true;
        }

        for (int i = digits.length - 2; i >= 0; i--) {
            tmpSum = digits[i] + 1;
            if (carry) {
                if (tmpSum >= 10) {
                    digits[i] = tmpSum % 10;
                    carry = true;

                    if (i == 0) {
                        int[] resultArr = new int[digits.length + 1];
                        resultArr[0] = 1;
                        System.arraycopy(digits, 0, resultArr, 1, digits.length);

                        return resultArr;
                    }
                } else {
                    digits[i] += 1;
                    return digits;
                }
            } else {
                return digits;
            }
        }
        return digits;
    }

    /**
     * 他人很简洁巧妙的解法
     * @param digits 整形数组
     * @return 运算结果数组
     */
    public static int[] plusOneImprove(int[] digits) {
        for (int i = 0; i < digits.length; i++){
            if(digits[i] == 9){
                digits[i] = 0;
            }else{
                digits[i] +=1;
                return digits;
            }
        }

        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
}
