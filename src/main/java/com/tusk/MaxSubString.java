package com.tusk;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 题号14，最长公共前缀
 *
 * @author tusk
 * @desc 编写一个函数来查询字符串数组中的最长公共前缀
 * @date 2020/11/30 9:53
 */
public class MaxSubString {

    public static void main(String[] args) {
        String[] data = {"flow","fly","flower"};
        String maxPrefix = longestCommonPrefix(data);
        System.out.println(maxPrefix);
    }

    /**
     *
     * @param strs 参数数组
     * @return 最长公共前缀
     */
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length < 1 || strs[0].equals("")) {
            return "";
        }

        if (strs.length == 1) {
            return strs[0];
        }

        //首先对字符串按照长度排序,最长公共前缀最长不超过最短字符串的长度
        Arrays.sort(strs, Comparator.comparingInt(String::length));

        String commonPrefixStr = strs[0];
        int counter = commonPrefixStr.length() + 1;

        while (counter > 0) {
            for (String s : strs) {
                if (!s.startsWith(commonPrefixStr)) {
                    commonPrefixStr = commonPrefixStr.substring(0, commonPrefixStr.length() - 1);
                }
            }
            counter--;
        }

        return commonPrefixStr;
    }

    /**
     * leetcode 他人解法
     * @param strs 参数数组
     * @return 最长公共前缀
     */
    public static String longestCommonPrefixImprove(String[] strs){
        if(strs == null || strs.length == 0){
            return "";
        }

        String prefix = strs[0];
        int count = strs.length;

        for(int i = 1;i<count;i++){
            prefix = longestCommonPrefix(prefix,strs[i]);
            if(prefix.length() == 0){
                break;
            }
        }
        return prefix;
    }

    public static String longestCommonPrefix(String str1, String str2) {
        int length = Math.min(str1.length(), str2.length());
        int index = 0;
        while (index < length && str1.charAt(index) == str2.charAt(index)) {
            index++;
        }
        return str1.substring(0, index);
    }
}
