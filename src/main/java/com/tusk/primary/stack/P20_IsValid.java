package com.tusk.primary.stack;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author tusk
 * @desc 有效的括号
 * @date 2021/5/9 8:59
 */
public class P20_IsValid {
    public static void main(String[] args) {
        String s1 = "()[]{}";
        String s2 = "([])";
        System.out.println(isvalid(s2));
    }

    public static boolean isvalid(String s) {
        int n = -1;
        if (s == null ||(n=s.length()) <= 0 || n % 2 != 0) {
            return false;
        }

        Deque<Character> stack = new LinkedList<>();
        Map<Character, Character> pair = new HashMap<>();
        pair.put(')', '(');
        pair.put(']', '[');
        pair.put('}', '{');

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (pair.containsKey(c)) {
                if (stack.isEmpty() || !stack.peek().equals(pair.get(c))) {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();

    }


}
