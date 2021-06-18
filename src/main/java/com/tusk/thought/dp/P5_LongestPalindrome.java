package com.tusk.thought.dp;

/**
 * @author tusk
 * @desc 最长回文串
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * 示例 2：
 * <p>
 * 输入：s = "cbbd"
 * 输出："bb"
 * 示例 3：
 * <p>
 * 输入：s = "a"
 * 输出："a"
 * 示例 4：
 * <p>
 * 输入：s = "ac"
 * 输出："a"
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 1000
 * s 仅由数字和英文字母（大写和/或小写）组成
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/6/17 14:50
 */
public class P5_LongestPalindrome {
    public static void main(String[] args) {
        P5_LongestPalindrome obj = new P5_LongestPalindrome();
        System.out.println(obj.longestPalindrome("cbbd"));
    }

    /**
     * 字符串s 的最长回文串
     *
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }
        char[] charArr = s.toCharArray();
        boolean[][] dp = new boolean[len][len];

        int maxLen = 1;
        int begin = 0;
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        //遍历回文串的长度
        for (int L = 2; L <= len; L++) {
            for (int i = 0; i < len; i++) {
                int j = i + L - 1;

                if(j>=len){
                    break;
                }
                //首尾字符不同一定不是回文串
                if (charArr[i] != charArr[j]) {
                    dp[i][j] = false;
                } else {
                    //长度小于3,首尾字符相同一定是回文串
                    if (L < 3) {
                        dp[i][j] = true;
                    } else {
                        //首尾字符相同，如果去除首尾字符仍然为回文则为回文，否则不是回文
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                //如果 i~j问回文字符串且当前子串长度大于最大回文子串长度
                if (dp[i][j] && L > maxLen) {
                    begin = i;
                    maxLen = L;
                }
            }
        }

        return s.substring(begin, begin + maxLen);
    }
}
