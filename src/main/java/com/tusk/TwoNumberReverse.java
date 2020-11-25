package com.tusk;

import java.util.Arrays;

/** 整数反转
 * @author tusk
 * @desc 给出一个 32 位整数，将这个整数的所有位上的数字反转，反转后溢出则返回0
 * @date 2020/11/25 8:38
 */
public class TwoNumberReverse {
    public static void main(String[] args) {
        int result = reverse(1234567890);
        System.out.println(result);
    }

    public static int reverse(int n){
        int arg = Math.abs(n);

        String[] arr = String.valueOf(arg).split("");
        if("0".equals(arr[arr.length - 1])){
            return 0;
        }

        for(int i=0;i<arr.length/2;i++){
            String tmp = arr[i];
            arr[i] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = tmp;
        }


            String reverResult = String.join("",arr);
            long longResult = Long.parseLong(reverResult);
            if(longResult > Integer.MAX_VALUE || longResult< Integer.MIN_VALUE){
                return 0;
            }else{
                return (int)longResult;
            }

    }
}
