package com.tusk;

/**
 * 题号58，
 * 给定一个仅包含大小写字母和空格 ' ' 的字符串 s，返回其最后一个单词的长度。
 * 如果字符串从左向右滚动显示，那么最后一个单词就是最后出现的单词。
 * 如果不存在最后一个单词，请返回 0 。
 *
 * @author tusk
 * @desc 最后一个单词的长度
 * @date 2020/12/3 10:56
 */
public class P58_LengthOfLastWord {

    public static void main(String[] args) {
        String s = " ";
        System.out.println(lengthOfLastWord(s));
    }

    /**
     * 这里声明了两个变量,内存占用大
     * @param s 字符串s
     * @return 最后一个单词长度
     */
    public static int lengthOfLastWord(String s) {
        if (s == null || "".equals(s)) {
            return 0;
        }

        int counter = s.length() - 1;
        int start = -1;
        int end = -1;
        while (counter >= 0) {
            char c = s.charAt(counter);
            if (!Character.isSpaceChar(c)) {
                if (start == -1) {
                    start = counter;
                }
            } else {
                if (start != -1) {
                    end = counter;
                    break;
                }
            }
            counter--;
        }

        //此时 start == end = -1
        if (start == end) {
            return 0;
        } else {
            return start - end;
        }
    }

    /**
     * 参考他人算法
     * @param s 字符串
     * @return 最后一个单词长度
     */
    public static int lengthOfLastWordImproved(String s){
        if(s == null || "".equals(s)){
            return 0;
        }

        int end = s.length() - 1;
        while(end >= 0 && s.charAt(end) == ' ') end--;
        if(end < 0) return 0;
        int start = end;
        while(start >= 0 && s.charAt(start) != ' ') start--;
        return end - start;

    }
}
