package com.tusk.primary.stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author tusk
 * @desc 比较含退格的字符串
 * 给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。 # 代表退格字符。
 *
 * 注意：如果对空文本输入退格字符，文本继续为空。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：S = "ab#c", T = "ad#c"
 * 输出：true
 * 解释：S 和 T 都会变成 “ac”。
 * 示例 2：
 *
 * 输入：S = "ab##", T = "c#d#"
 * 输出：true
 * 解释：S 和 T 都会变成 “”。
 * 示例 3：
 *
 * 输入：S = "a##c", T = "#a#c"
 * 输出：true
 * 解释：S 和 T 都会变成 “c”。
 * 示例 4：
 *
 * 输入：S = "a#c", T = "b"
 * 输出：false
 * 解释：S 会变成 “c”，但 T 仍然是 “b”。
 *  
 *
 * 提示：
 *
 * 1 <= S.length <= 200
 * 1 <= T.length <= 200
 * S 和 T 只含有小写字母以及字符 '#'。
 *  
 *
 * 进阶：
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/backspace-string-compare
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/5/9 20:05
 */
public class P844_BackSpaceCompare {
    public static void main(String[] args) {
        String s1 = "bxj##tw";
        String s2 =         "bxj###tw";
        System.out.println(backSpaceCompare(s1,s2));
    }
    public static boolean backSpaceCompare(String s1,String s2){
        String rs1 = deal(s1);
        String rs2 = deal(s2);
        return rs1.equals(rs2);
    }

    public static String deal(String s){
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        int spaceCount = 0;
        for(int i = n - 1;i>=0;i--){
            char c = s.charAt(i);
            if(c == '#'){
                spaceCount++;
            }else{
                if(spaceCount==0){
                    sb.append(c);
                }else{
                    if(spaceCount>0)
                    spaceCount--;
                }
            }
        }
return sb.toString();
    }
}
