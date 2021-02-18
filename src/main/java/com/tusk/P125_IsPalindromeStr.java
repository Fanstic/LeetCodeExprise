package com.tusk;

/**
 * 题号125，验证字符串是否为回文字符串，给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * 空串定义为有效回文字符串
 *
 * @author tusk
 * @desc
 * @date 2020/12/9 9:18
 */
public class P125_IsPalindromeStr {
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        String s1 = "race a car";
        System.out.println(isPalindrome(s));


    }

    /**
     * 验证字符串是否为回文字符串
     *
     * @param s 字符串s
     * @return 是否为回文字符串
     */
    public static boolean isPalindrome(String s) {
        if (s == null) {
            return false;
        }

        if ("".equals(s)) {
            return true;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                sb.append(Character.toLowerCase(c));
            }
        }

        //这里也可以通过栈来比较，或者翻转字符串
        for (int i = 0; i < sb.length() / 2; i++) {
            if (sb.charAt(i) != sb.charAt(sb.length() - i - 1)) {
                return false;
            }
        }

        return true;

    }

    /**
     * 官方双指针解法，感觉差不多
     *
     * @param s 字符串s
     * @return 是否为回文字符串
     */
    public boolean isPalindromeOffice(String s) {
        StringBuffer sgood = new StringBuffer();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char ch = s.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                sgood.append(Character.toLowerCase(ch));
            }
        }
        int n = sgood.length();
        int left = 0, right = n - 1;
        while (left < right) {
            if (Character.toLowerCase(sgood.charAt(left)) != Character.toLowerCase(sgood.charAt(right))) {
                return false;
            }
            ++left;
            --right;
        }
        return true;
    }
}
