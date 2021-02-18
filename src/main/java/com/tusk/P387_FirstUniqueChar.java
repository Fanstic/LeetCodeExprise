package com.tusk;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 题号387，字符串中的第一个唯一字符
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 *
 * @author tusk
 * @desc 字符串中的第一个唯一字符
 * @date 2020/12/7 13:29
 */
public class P387_FirstUniqueChar {
    public static void main(String[] args) {
        String s = "leetcode";
        String s1 = "loveleetcode";
        String s3 = "dddccdbba";
//        System.out.println(firstUniqChar(s));
        System.out.println(firstUniqChar(s));
    }

    /**
     * @param s 只包含小写字母的字符串
     * @return 第一个只出现一次的字母下标
     */
    public static int firstUniqChar(String s) {
        if (s == null || "".equals(s)) {
            return -1;
        }

        Map<Character, Integer> map = new LinkedHashMap<>();
        char[] arr = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            char key = arr[i];
            if (map.containsKey(key)) {
                map.put(key, map.get(key) + 1);
            } else {
                map.put(key, 1);
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if (map.get(arr[i]) == 1) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 优化版本
     *
     * @param s 只包含小写字母的字符串
     * @return 第一个只出现一次的字母下标
     */
    public static int firstUniquCharImproved(String s) {
        if (s == null || "".equals(s)) {
            return -1;
        }

        //题目前提条件字符串只包含小写字母
        int[] arr = new int[26];

        //char的ascll编码相对字符a的位移作为数组索引
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            if (arr[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}
