package com.tusk;

/**
 * 题号 67，二进制求和
 * 给你两个二进制字符串，返回它们的和（用二进制表示）。
 * 输入为 非空 字符串且只包含数字 1 和 0。
 * 如果字符串不是0，则不包含前导0
 *
 * @author tusk
 * @desc 二进制求和
 * @date 2020/12/5 12:31
 */
public class P67_AddBinary {
    public static void main(String[] args) {
        String s1 = "1010";
        String s2 = "1011";

        String result = addBinary(s1, s2);
        System.out.println(result);
        System.out.println(Integer.valueOf(result, 2));
//        System.out.println(Integer.parseInt(String.valueOf('1')));
    }

    public static String addBinary(String a, String b) {
        if (a == null || "".equals(a) || b == null || "".equals(b)) {
            return "";
        }

        int l1 = a.length();
        int l2 = b.length();

        if (l1 > l2) {
            return addBinary(b, a);
        }

        int padding = l2 - l1;
        //高位补零
        if (padding > 0) {
            while (padding > 0) {
                a = "0" + a;
                padding--;
            }
        }
        int carry = 0;
        char[] chrs = new char[l2 + 1];
        for (int i = l2 - 1; i >= 0; i--) {
            int cb = Integer.parseInt(String.valueOf(b.charAt(i)));

            int ca = Integer.parseInt(String.valueOf(a.charAt(i)));

            int sum = ca + cb + carry;
            if (sum > 1) {
                carry = 1;
                //chrs[i+1] = sum/2;
                if(sum>2){
                    chrs[i + 1] = '1';
                }else{
                    chrs[i + 1] = '0';
                }

            } else {
                carry = 0;
                if (sum == 1) {
                    chrs[i + 1] = '1';
                } else {
                    {
                        chrs[i + 1] = '0';
                    }
                }
            }
        }
        if (carry > 0) {
            chrs[0] = '1';
            return new String(chrs);
        } else {
            return new String(chrs).substring(1);
        }

    }

    /**
     * 官方解法，思路基本一致，但更简洁
     * 减少了长度判断和char[]转string
     * @param a
     * @param b
     * @return
     */
    public static String addBinaryOffice(String a,String b){
        StringBuffer ans = new StringBuffer();

        int n = Math.max(a.length(), b.length()), carry = 0;
        for (int i = 0; i < n; ++i) {
            carry += i < a.length() ? (a.charAt(a.length() - 1 - i) - '0') : 0;
            carry += i < b.length() ? (b.charAt(b.length() - 1 - i) - '0') : 0;
            ans.append((char) (carry % 2 + '0'));
            carry /= 2;
        }

        if (carry > 0) {
            ans.append('1');
        }
        ans.reverse();

        return ans.toString();
    }
}
