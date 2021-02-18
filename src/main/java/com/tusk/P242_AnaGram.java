package com.tusk;

import java.util.Arrays;

/**
 * 题号 242，有效的字母异位词
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * @author tusk
 * @desc 有效的字母异位词
 * @date 2020/12/8 12:42
 */
public class P242_AnaGram {
    public static void main(String[] args) {
        int[] a = {1};
        int[] b = {1};
        System.out.println(Arrays.equals(a, b));
    }

    /**
     * 排序方式
     * @param s 字符串s
     * @param t 字符串t
     * @return 是否为异位词
     */
    public boolean isAnagram(String s, String t) {
        if (s == null || t == null) {
            return false;
        }

        if (s.length() != t.length()) {
            return false;
        }

        char[] scharArray = s.toCharArray();
        char[] tcharArray = t.toCharArray();

        Arrays.sort(scharArray);
        Arrays.sort(tcharArray);

        return Arrays.equals(scharArray, tcharArray);
    }

    /**
     * hash 实现
     * @param s 字符串s
     * @param t 字符串t
     * @return 是否为异位词
     */
    public boolean isAnagramOther(String s, String t) {
        if (s == null || t == null) {
            return false;
        }

        if (s.length() != t.length()) {
            return false;
        }

        int[] arr = new int[26];

        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            int idx = arr[s.charAt(i)];
            arr[idx]--;
            if (arr[idx] < 0) {
                return false;
            }
        }
        return true;

    }
}
