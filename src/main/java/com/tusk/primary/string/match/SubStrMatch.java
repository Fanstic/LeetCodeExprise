package com.tusk.primary.string.match;

/**
 * @author tusk
 * @desc 字符串匹配BF 算法，又称为朴素匹配算法
 * @date 2021/6/3 9:54
 */
public class SubStrMatch {
    public static void main(String[] args) {
        SubStrMatch obj = new SubStrMatch();
        int idx = obj.bf("hello", "lp");

    }

    /**
     * BF 字符串匹配，主串m中存在 n- m + 1个长度为m的子串
     *时间复杂度:Log(n*m),n和m分别为主串和模式串的长度
     * @param s       主串
     * @param pattern 模式串
     * @return 存在时返回开始位置索引，不存在返回 -1
     */
    public int bf(String s, String pattern) {
        if (s == null || pattern == null) {
            return -1;
        }

        int sl = s.length();
        int pl = pattern.length();

        if (pl > sl) {
            return -1;
        }

        if (pattern.equals(s)) {
            return 0;
        }

        for (int i = 0; i <= sl - pl; i++) {
            int cur = i;
            boolean match = true;

            if (s.charAt(i) == pattern.charAt(0)) {
                for (int j = 1; j < pl; j++) {
                    if (pattern.charAt(j) != s.charAt(++cur)) {
                        match = false;
                        break;
                    }
                }

                if (match) {
                    return i;
                }
            }
        }
        return -1;
    }

    //TODO:字符串匹配rk算法实现
    /**
     * 字符串匹配，rk算法
     * @param s
     * @param pattern
     * @return
     */
    public int rk(String s,String pattern){
        return -1;
    }
}
