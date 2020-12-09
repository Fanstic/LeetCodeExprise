package com.tusk;

import java.util.HashMap;
import java.util.Map;

/**
 * 题号8，
 * 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。接下来的转化规则如下：
 * <p>
 * 如果第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字字符组合起来，形成一个有符号整数。
 * 假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成一个整数。
 * 该字符串在有效的整数部分之后也可能会存在多余的字符，那么这些字符可以被忽略，它们对函数不应该造成影响。
 * 注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换，即无法进行有效转换。
 * <p>
 * 在任何情况下，若函数不能进行有效的转换时，请返回 0 。
 * <p>
 * 提示：
 * <p>
 * 本题中的空白字符只包括空格字符 ' ' 。
 * 假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为[−231, 231− 1]。如果数值超过这个范围，请返回 INT_MAX (231− 1) 或INT_MIN (−231) 。
 * <p>
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnoilh/
 *
 * @author tusk
 * @desc 请你来实现一个 atoi 函数，使其能将字符串转换成整数。
 * @date 2020/12/8 14:18
 */
public class MyAtoi {

    public static void main(String[] args) {
        String s = " -123a";
        String s1 = " a1234b";
        String s2 = "-a123";
        String s3 = "- 123";
        String s4 = " -42";
        String s5 = "-12345678999";
        String s6 = "-000000000000001";
        String s7 = "  0000000000012345678";
//        System.out.println(myAtoi(s3));
        System.out.println(myAtoiOffice(s7));
        //System.out.println(checkInteger(s7));
    }

    public static int myAtoi(String s) {
        if (s == null || "".equals(s)) {
            return 0;
        }

        s = s.trim();
        char firstChar = s.charAt(0);
        if (firstChar != '+' && firstChar != '-' && !Character.isDigit(firstChar)) {
            return 0;
        }

        if (firstChar == '-' || firstChar == '+') {
            s = s.substring(1);
        }
        //存放合理字符
        StringBuilder sb = new StringBuilder();
        //标识正负数
        int symbol = firstChar == '-' ? -1 : 1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    sb.append(s.charAt(i));
                    i++;
                }
                break;
            }
        }

        s = sb.toString();
        if ("".equals(s)) {
            return 0;
        }

        if (symbol == -1) {
            s = "-" + s;
        }
        return checkInteger(s);
    }

    /**
     * 判断给定数字字符串是否溢出
     *
     * @param s 数字字符串
     * @return 溢出返回边界，否则返回s转换后的int
     */
    public static int checkInteger(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int sum = 0;
        int index = 0;
        boolean negative = s.charAt(0) == '-';

        int start = negative ? 1 : 0;
        for (int i = start; i < s.length(); i++) {
            if (s.charAt(i) != '0') {
                start = i;
                break;
            }
        }

        s = s.substring(start);

        while (index < s.length()) {
            int digit = s.charAt(index) - '0';
            if (sum > Integer.MAX_VALUE / 10 || (Integer.MAX_VALUE / 10 == sum && Integer.MAX_VALUE % 10 < digit)) {
                if (negative) {
                    return Integer.MIN_VALUE;
                }
                return Integer.MAX_VALUE;
            }


            sum = sum * 10 + digit;
            index++;

        }
        return Integer.parseInt(s) * (negative ? -1 : 1);
    }

    /**
     * 官方自动机(有限状态机器)解法
     *
     * @param s 字符串s
     * @return int 转换结果
     */
    public static int myAtoiOffice(String s) {
        Automaton automaton = new Automaton();
        int length = s.length();
        for (int i = 0; i < length; ++i) {
            automaton.get(s.charAt(i));
        }
        return (int) (automaton.sign * automaton.ans);
    }
}

class Automaton {
    private final Map<String, String[]> table = new HashMap<String, String[]>() {{
        put("start", new String[]{"start", "signed", "in_number", "end"});
        put("signed", new String[]{"end", "end", "in_number", "end"});
        put("in_number", new String[]{"end", "end", "in_number", "end"});
        put("end", new String[]{"end", "end", "end", "end"});
    }};
    public int sign = 1;
    public long ans = 0;
    private String state = "start";

    public void get(char c) {
        state = table.get(state)[get_col(c)];
        if ("in_number".equals(state)) {
            ans = ans * 10 + c - '0';
            ans = sign == 1 ? Math.min(ans, Integer.MAX_VALUE) : Math.min(ans, -(long) Integer.MIN_VALUE);
        } else if ("signed".equals(state)) {
            sign = c == '+' ? 1 : -1;
        }
    }

    private int get_col(char c) {
        if (c == ' ') {
            return 0;
        }
        if (c == '+' || c == '-') {
            return 1;
        }
        if (Character.isDigit(c)) {
            return 2;
        }
        return 3;
    }
}