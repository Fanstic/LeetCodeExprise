package com.tusk;

import java.util.LinkedList;
import java.util.List;

/**
 * 判断一个链表是否为回文链表
 *
 * @author tusk
 * @desc
 * @date 2020/12/17 10:08
 */
public class P234_IsPalindromeLIst {
    public static void main(String[] args) {
        P19_RemoveNthFromEnd.ListNode head = new P19_RemoveNthFromEnd.ListNode(-129, null);
        head.next = new P19_RemoveNthFromEnd.ListNode(-129, null);
//        head.next.next = new RemoveNthFromEnd.ListNode(2, null);
//        head.next.next.next = new RemoveNthFromEnd.ListNode(1, null);

        System.out.println(isPalindrome(head));
    }

    public static boolean isPalindrome(P19_RemoveNthFromEnd.ListNode head) {
        List<Integer> list = new LinkedList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }

        int h = 0;
        int t = list.size() - 1;

        while (h < t) {
            if (list.get(h).intValue()!=list.get(t).intValue()) {
                return false;
            }

            h = h + 1;
            t = t - 1;
        }

        return true;
    }
}