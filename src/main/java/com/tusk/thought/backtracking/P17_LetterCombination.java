package com.tusk.thought.backtracking;

import java.util.*;

/**
 * @author tusk
 * @desc 17. 电话号码的字母组合
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * <p>
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/6/9 10:25
 */
public class P17_LetterCombination {
    static Map<String, List<String>> map = new HashMap<>();

    static {
        map.put("2", Arrays.asList("a", "b", "c"));
        map.put("3", Arrays.asList("d", "e", "f"));
        map.put("4", Arrays.asList("g", "h", "i"));
        map.put("5", Arrays.asList("j", "k", "l"));
        map.put("6", Arrays.asList("m", "n", "o"));
        map.put("7", Arrays.asList("p", "q", "r", "s"));
        map.put("8", Arrays.asList("t", "u", "v"));
        map.put("9", Arrays.asList("w", "x", "y", "z"));
    }

    public static void main(String[] args) {
        P17_LetterCombination obj = new P17_LetterCombination();
        String digits = "23";
        List<String> res = obj.letterCombinations(digits);

        System.out.println(res);

    }

    /**
     * 0 <= digits.length <= 4
     * digits[i] 是范围 ['2', '9'] 的一个数字
     *
     * @param digits
     * @return
     */
    public List<String> letterCombinations(String digits) {
        List<int[]> used = new ArrayList<>();
        List<String> l1 = new ArrayList<>();
        int k = 0;
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < digits.length(); i++) {
            String key = String.valueOf(digits.charAt(i));
            used.add(new int[map.get(key).size()]);
        }

        backTracking(digits, used, l1, sb, 0);
        return l1;
    }

    public void backTracking(String digits, List<int[]> used, List<String> l1, StringBuffer sb, int k) {
        if (sb.length() == digits.length()) {
            l1.add(sb.toString());
        } else {
            char c = digits.charAt(k);
            List<String> items = map.get(String.valueOf(c));

            for (int i = 0; i < items.size(); i++) {
                if (used.get(k)[i] == 1) {
                    continue;
                } else {
                    used.get(k)[i] = 1;
                    sb.append(items.get(i).charAt(0));
                    if (k < digits.length()) {
                        k++;
                    }
                    backTracking(digits, used, l1, sb, k);
                    k--;
                    sb.deleteCharAt(k);
                    used.get(k)[i] = 0;
                }
            }
        }
    }
}
