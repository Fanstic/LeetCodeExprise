package com.tusk;

/**
 * 题号344，字符串反转
 * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
 * 空间复杂度要求 O(1),可以假设数组中的字符都是可打印字符
 * @author tusk
 * @desc 字符串反转
 * @date 2020/12/7 13:17
 */
public class P344_ReverseString {

    public static void main(String[] args) {
        char[] s = {'h'};
        char[] s1 = {'h','o'};
        char[] s2 = {};
        char[] s4 = {'h','o','o','l'};

        reverseString(s4);

    }
    public static void reverseString(char[] s){
        for(int i = 0;i<s.length/2;i++){
            char tmp = s[i];
            s[i] = s[s.length - i -1];
            s[s.length - i - 1] = tmp;
        }

        System.out.println(new String(s));
    }
}
