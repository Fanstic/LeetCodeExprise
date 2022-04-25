package com.tusk.primary.string;

import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author tusk
 * @desc leetcode-567:字符串的排列
 * 解题思路：滑动窗口
 * 由于排列不会改变字符串中每个字符的个数，所以只有当两个字符串每个字符的个数均相等时，一个字符串才是另一个字符串的排列。
 * 滑动窗口每向右滑动一次，就多统计一次进入窗口的字符，少统计一次离开窗口的字符。
 * @date 2021/12/9 11:02
 */
public class P567_CheckInclusion {
    public static void main(String[] args) {
        String s1 = "ad";
        String s2 = "eidboaoo";
        String s3 = "dcda";

        P567_CheckInclusion obj = new P567_CheckInclusion();
        System.out.println(obj.checkInclusion(s1, s3));
    }

    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() <= 0) {
            return true;
        }

        //记录目标串需要匹配的元素和次数
        Map<Character, Integer> need = new HashMap<>();

        //当前窗口中的匹配的目标元素和出现的次数
        Map<Character, Integer> window = new HashMap<>();

        int left = 0;
        int right = 0;
        int valid = 0;

        for (Character c : s1.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        while (right < s2.length()) {
            Character c = s2.charAt(right);
            right++;
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);

                if (need.get(c).equals(window.get(c))) {
                    valid++;
                }
            }

            //窗口大小等于目标串长度
            while (right - left>=s1.length()){

                //对应元素个数相同
                if(need.size() == valid){
                    return true;
                }else{
                    Character cur = s2.charAt(left);
                    left++;

                    //向右滑动窗口，处理窗口内数据
                    if(window.containsKey(cur)){
                        if(need.get(cur).equals(window.get(cur))){
                            valid--;
                        }

                        window.put(cur,window.get(cur) - 1);
                    }
                }
            }
        }

        return false;
    }

    /**
     * 官方滑动窗口
     * @param s1
     * @param s2
     * @return
     */
    public boolean checkInclusionOffical(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        if (n > m) {
            return false;
        }
        int[] cnt1 = new int[26];
        int[] cnt2 = new int[26];
        for (int i = 0; i < n; ++i) {
            ++cnt1[s1.charAt(i) - 'a'];
            ++cnt2[s2.charAt(i) - 'a'];
        }
        if (Arrays.equals(cnt1, cnt2)) {
            return true;
        }
        for (int i = n; i < m; ++i) {
            ++cnt2[s2.charAt(i) - 'a'];
            --cnt2[s2.charAt(i - n) - 'a'];
            if (Arrays.equals(cnt1, cnt2)) {
                return true;
            }
        }
        return false;
    }
}
