package com.tusk.primary.string;

import java.util.HashMap;
import java.util.Map;

/**
 * @author tusk
 * @desc leetcode-3:无重复字符的最长子串
 *
 * 解题思路：滑动窗口
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * 示例 4:
 * <p>
 * 输入: s = ""
 * 输出: 0
 *  
 * <p>
 * 提示：
 * <p>
 * 0 <= s.length <= 5 * 104
 * s 由英文字母、数字、符号和空格组成
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/12/10 8:40
 */
public class P3_LengthOfLongestSubstring {
    public static void main(String[] args) {
        P3_LengthOfLongestSubstring obj = new P3_LengthOfLongestSubstring();
        String s1 = "abcabcbb";
        String s2 = "bbbb";
        String s3 = "pwwkew";
        String s4 = "";
        String s5 = "aab";

        System.out.println(obj.lengthOfLongestSubstring(s1) == 3);
        System.out.println(obj.lengthOfLongestSubstring(s2) == 1);
        System.out.println(obj.lengthOfLongestSubstring(s3) == 3);
        System.out.println(obj.lengthOfLongestSubstring(s4) == 0);
        System.out.println(obj.lengthOfLongestSubstring(s5) == 2);
    }

    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> window = new HashMap<>();

        int left = 0;
        int right = 0;
        int maxLen = 0;

        while (right < s.length()) {
            Character c = s.charAt(right);
            right++;

            window.put(c, window.getOrDefault(c, 0) + 1);

            //当出现重复字符时，右边界收缩直到窗口中不存在重复字符
            while (window.get(c) > 1) {
                Character cur = s.charAt(left);
                left++;
                window.put(cur, window.get(cur) - 1);
            }

            //更新最长子串长度
            maxLen = Math.max(maxLen, right - left);
        }

        return maxLen;
    }
}
