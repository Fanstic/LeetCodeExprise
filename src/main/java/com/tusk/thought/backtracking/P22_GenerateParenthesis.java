package com.tusk.thought.backtracking;

import java.util.*;

/**
 * @author tusk
 * @desc 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 * 示例 2：
 * <p>
 * 输入：n = 1
 * 输出：["()"]
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 8
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/generate-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/6/10 9:50
 */
public class P22_GenerateParenthesis {
    public static void main(String[] args) {
        P22_GenerateParenthesis obj = new P22_GenerateParenthesis();
        System.out.println(new Solution().generateParenthesis(3));

    }

    public List<String> generateParenthesis(int n) {
        String s = "()";
        List<String> result = new ArrayList<>();
        backTrack(result, new StringBuilder(), s, n * 2);
        ListIterator<String> iterator = result.listIterator();
        return result;
    }


    /**
     * 彩笔的解法
     * @param result
     * @param sb
     * @param s
     * @param n
     */
    public void backTrack(List<String> result, StringBuilder sb, String s, int n) {
        String str = sb.toString();
        if (sb.length() == n) {
            if (isValid(str)) {
                result.add(str);
            }
        } else {
            for (int i = 0; i < s.length(); i++) {
                sb.append(s.charAt(i));
                backTrack(result, sb, s, n);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

    public boolean isValid(String s) {
        Deque<Character> q = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == ')') {
                if (q.isEmpty() || q.peek() != '(') {
                    return false;
                }
                q.pop();
            } else {
                q.push(c);
            }
        }

        return q.isEmpty();
    }
}

/**
 * 大佬的解法
 */
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backTrack(result, new StringBuilder(), n, 0, 0);
        return result;
    }

    public void backTrack(List<String> result, StringBuilder sb, int max, int open, int close) {
        if (sb.length() == max * 2) {
            result.add(sb.toString());
        }

        if (open < max) {
            sb.append("(");
            backTrack(result, sb, max, open + 1, close);
            sb.deleteCharAt(sb.length() - 1);
        }

        if (close < open) {
            sb.append(")");
            backTrack(result, sb, max, open, close + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
