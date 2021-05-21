package com.tusk.primary.string;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author tusk
 * @desc 给定一个字符串，逐个翻转字符串中的每个单词。
 * <p>
 * 说明：
 * <p>
 * 无空格字符构成一个 单词 。
 * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入："the sky is blue"
 * 输出："blue is sky the"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-words-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/5/21 15:24
 */
public class P151_ReverseWords {
    public static void main(String[] args) {
        P151_ReverseWords obj = new P151_ReverseWords();
        String s = "a good   example";
        System.out.println(obj.reverseWords1(s));
    }

    /**
     * 空间复杂度：O(n)
     * 时间复杂度：O(n)
     *
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        if (s == null || s.length() <= 0)
            return null;

        String[] arr = s.split(" ");
        int len = arr.length;

        StringBuilder sb = new StringBuilder();
        for (int i = len - 1; i >= 0; i--) {

            String res = arr[i].trim();
            if (res.length() > 0) {
                sb.append(res + " ");
            }

        }

        return sb.substring(0, sb.length() - 1);
    }

    /**
     * 使用双端队列处理
     * 时间复杂度：O(n)
     * 空间复杂度:O(n)
     *
     * @param s
     * @return
     */
    public String reverseWords1(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left <= right && s.charAt(left) == ' ') {
            left++;
        }

        while (left <= right && s.charAt(right) == ' ') {
            right--;
        }

        Deque<String> q = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        while (left <= right) {
            Character c = s.charAt(left);
            if (sb.length() > 0 && c == ' ') {
                q.offerFirst(sb.toString());
                sb.setLength(0);
            } else if(c!= ' '){
                sb.append(c);
            }
            left++;
        }

        q.offerFirst(sb.toString());
        return String.join(" ", q);
    }
}
