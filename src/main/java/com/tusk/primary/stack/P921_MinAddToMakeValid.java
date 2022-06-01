package com.tusk.primary.stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author tusk
 * @desc leetcode-921:使括号有效的最少添加
 * 给定一个由 '('和')' 括号组成的字符串 S，我们需要添加最少的括号（ '(' 或是 ')'，可以在任何位置），以使得到的括号字符串有效。
 * <p>
 * 从形式上讲，只有满足下面几点之一，括号字符串才是有效的：
 * <p>
 * 它是一个空字符串，或者
 * 它可以被写成AB（A与B连接）, 其中A 和B都是有效字符串，或者
 * 它可以被写作 (A)，其中 A 是有效字符串。
 * 给定一个括号字符串，返回为使结果字符串有效而必须添加的最少括号数。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入："())"
 * 输出：1
 * 示例 2：
 * <p>
 * 输入："((("
 * 输出：3
 * 示例 3：
 * <p>
 * 输入："()"
 * 输出：0
 * 示例 4：
 * <p>
 * 输入："()))(("
 * 输出：4
 *  
 * <p>
 * 提示：
 * <p>
 * S.length <= 1000
 * S 只包含 '(' 和 ')' 字符。
 *  
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-add-to-make-parentheses-valid
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/12/14 16:14
 */
public class P921_MinAddToMakeValid {


    public static void main(String[] args) {
        P921_MinAddToMakeValid obj = new P921_MinAddToMakeValid();

        String s1 = "(((";
        String s2 = "";
        String s3 = "()))((";
        System.out.println(obj.minAddToMakeValid(s1));

        System.out.println(obj.minAddToMakeValid(s2));
        System.out.println(obj.minAddToMakeValid(s3));
    }

    public int minAddToMakeValid(String s) {
        if (s.length() == 0) {
            return 0;
        }

        Deque<Character> stack = new LinkedList<>();
        int left = 0;//记录需要匹配的左括号的数量

        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (c.equals(')')) {
                if(!stack.isEmpty()){
                    stack.pop();
                }else{//栈为空说明之前的字符是有效的括号，需要匹配的左括号++
                    left++;
                }
            } else {
                stack.push(c);
            }
        }

        //返回需要匹配的左括号和右括号的和
        return left + stack.size();
    }
}
