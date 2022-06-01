package com.tusk.primary.string;

/**
 * 剑指Offer05,替换字符串中的空格
 * <p>
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 *  
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/ti-huan-kong-ge-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ReplaceSpace {
    public static void main(String[] args) {
        ReplaceSpace obj = new ReplaceSpace();
        String s = "hello";


    }

    public String replaceSpace(String s) {
        if (s == null || s.length() <= 0) {
            return s;
        }
        StringBuilder sb = new StringBuilder();

        int len = s.length();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);

            if (c == ' ') {
                sb.append("%20");
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }


}
