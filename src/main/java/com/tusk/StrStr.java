package com.tusk;

/**
 * 题号 28，实现 strStr 函数
 *
 * @author tusk
 * @desc 给定一个haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。
 * 如果不存在，则返回 -1。
 * 思考：如果给定字符串为空串，应该返回什么
 * @date 2020/12/2 8:45
 */
public class StrStr {

    public static void main(String[] args) {
        String haystack = "hello";
        String needle = "o";

        System.out.println(strStr(haystack, needle));
    }

    //最简单的是使用 滑动窗口 + subString 去实现

    /**
     * 滑动窗口
     * @param haystack 目标查找串
     * @param needle 查找串
     * @return 索引位置
     */
    public static int strStr(String haystack, String needle) {
        if (haystack == null || needle == null || needle.length() > haystack.length()) {
            return -1;
        }

        if ("".equals(needle)) {
            return 0;
        }

        //如果 needle 是 haystack 的一个子串，则 len(haystack)>=len(needle)
        int hayStackArrLen = haystack.length();
        int needleArrLen = needle.length();

        if (hayStackArrLen == needleArrLen) {
            for (int i = 0; i < hayStackArrLen; i++) {
                if (haystack.charAt(i) != needle.charAt(i)) {
                    return -1;
                }
            }
            return 0;
        } else {
            int sum = 0;
            int index;
            for (int i = 0; i < hayStackArrLen; i++) {

                //只可能包含 needle 的部分子串
                if (needle.charAt(0) == haystack.charAt(i)) {
                    if (i + needleArrLen > hayStackArrLen) {
                        return -1;
                    }

                    index = i;
                    for (int j = 1; j < needleArrLen; j++) {
                        if (needle.charAt(j) == haystack.charAt(j + i)) {
                            sum += 1;
                        } else {
                            sum = 0;
                            break;
                        }
                    }

                    if (sum == needleArrLen - 1) {
                        return index;
                    }
                    sum = 0;
                }
            }
        }
        return -1;
    }

    /**
     * leetcode 官方双指针解法
     * 空间复杂度：O(1)
     * 其中 N 为 haystack 字符串的长度，L 为 needle 字符串的长度。内循环中比较字符串的复杂度为 L，总共需要比较 (N - L) 次。
     * @param haystack 目标查找串
     * @param needle 查找串
     * @return 索引位置
     */
    public static int strStrOffice(String haystack, String needle) {
        int l  = needle.length(), n = haystack.length();
        if (l == 0) return 0;

        int pn = 0;
        while (pn < n - l + 1) {
            // find the position of the first needle character
            // in the haystack string
            while (pn < n - l + 1 && haystack.charAt(pn) != needle.charAt(0)) ++pn;

            // compute the max match string
            int currLen = 0, pL = 0;
            while (pL < l && pn < n && haystack.charAt(pn) == needle.charAt(pL)) {
                ++pn;
                ++pL;
                ++currLen;
            }

            // if the whole needle string is found,
            // return its start position
            if (currLen == l) return pn - l;

            // otherwise, backtrack
            pn = pn - currLen + 1;
        }
        return -1;
    }
}

