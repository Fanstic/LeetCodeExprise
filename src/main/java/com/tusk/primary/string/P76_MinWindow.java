package com.tusk.primary.string;

import java.util.HashMap;
import java.util.Map;

/**
 * @author tusk
 * @desc leetcode-76:最小覆盖子串
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 * <p>
 *  
 * <p>
 * 注意：
 * <p>
 * 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
 * 如果 s 中存在这样的子串，我们保证它是唯一的答案。
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "ADOBECODEBANC", t = "ABC"
 * 输出："BANC"
 * 示例 2：
 * <p>
 * 输入：s = "a", t = "a"
 * 输出："a"
 * 示例 3:
 * <p>
 * 输入: s = "a", t = "aa"
 * 输出: ""
 * 解释: t 中两个字符 'a' 均应包含在 s 的子串中，
 * 因此没有符合条件的子字符串，返回空字符串。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length, t.length <= 105
 * s 和 t 由英文字母组成
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-window-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * 解题思路：滑动窗口
 * @date 2021/12/8 16:09
 */
public class P76_MinWindow {
    public static void main(String[] args) {
        P76_MinWindow obj = new P76_MinWindow();

        String s = "AADOBECCCBODEBANC";
        String t = "ABC";

        System.out.println(obj.minWindow(s, t));
    }

    public String minWindow(String s, String t) {

        //需要匹配的字符以及出现的次数
        Map<Character, Integer> needs = new HashMap<>();

        //滑动窗口中匹配的字符及出现的次数
        Map<Character, Integer> window = new HashMap<>();

        //记录窗口的左右边界[left,right)
        int left = 0;
        int right = 0;

        //最小覆盖子串的长度
        int len = Integer.MAX_VALUE;

        //最小覆盖子串的起始索引值
        int start = 0;

        //记录窗口中满足条件的字符个数
        int valid = 0;

        for (Character c : t.toCharArray()) {
            needs.put(c, needs.getOrDefault(c, 0) + 1);
        }

        while (right < s.length()) {
            Character c = s.charAt(right);
            right++;
            if (needs.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);

                if (needs.get(c).equals(window.get(c))) {
                    valid++;
                }
            }

            //如果满足条件则增加左边界，缩小窗口
            while (valid == needs.size()) {

                //更新最小覆盖子串
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }

                //将要移出窗口的字符
                char cur = s.charAt(left);
                left++;

                if (needs.containsKey(cur)) {
                    //valid记录窗口中满足条件的个数，当前字符满足条件移出窗口后，valid减1
                    if (needs.get(cur).equals(window.get(cur))) {
                        valid--;
                    }

                    window.put(cur, window.get(cur) - 1);
                }
            }

        }


        return len == Integer.MAX_VALUE ? "" : s.substring(start, len);
    }
}
