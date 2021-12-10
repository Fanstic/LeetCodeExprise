package com.tusk.primary.string;

import com.sun.org.apache.xpath.internal.operations.NotEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author tusk
 * @desc leetcode-438:找到字符串中的所有的字母异位词
 * 解题思路:滑动窗口
 * https://leetcode-cn.com/problems/find-all-anagrams-in-a-string/
 * <p>
 * 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 * <p>
 * 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "cbaebabacd", p = "abc"
 * 输出: [0,6]
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
 *  示例 2:
 * <p>
 * 输入: s = "abab", p = "ab"
 * 输出: [0,1,2]
 * 解释:
 * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
 * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
 * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
 *  
 * <p>
 * 提示:
 * <p>
 * 1 <= s.length, p.length <= 3 * 104
 * s 和 p 仅包含小写字母
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-all-anagrams-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/12/9 15:14
 */
public class P438_FindAnagrams {
    public static void main(String[] args) {
        P438_FindAnagrams obj = new P438_FindAnagrams();

        String s = "abab";
        String p = "ab";

        System.out.println(obj.findAnagrams(s, p));
    }


    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();

        int left = 0;
        int right = 0;
        int valid = 0;
        int start = left;

        Map<Character, Integer> neeq = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        for (Character c : p.toCharArray()) {
            neeq.put(c, neeq.getOrDefault(c, 0) + 1);
        }

        while (right < s.length()) {
            Character c = s.charAt(right);
            right++;

            if (neeq.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (neeq.get(c).equals(window.get(c))) {
                    valid++;
                }
            }

            while (right - left >= p.length()) {
                Character cur = s.charAt(left);
                start = left;
                left++;

                if (neeq.size() == valid) {
                    result.add(start);
                }

                if (neeq.containsKey(cur)) {
                    if (window.get(cur).equals(neeq.get(cur))) {
                        valid--;
                    }

                    window.put(cur, window.get(cur) - 1);
                }
            }
        }

        return result;
    }
}
