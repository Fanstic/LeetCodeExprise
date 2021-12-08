package com.tusk.primary.linkedlist;

import com.tusk.model.ListNode;

/**
 * @author tusk
 * @desc 单链表的中间节点
 * 解题思路：快慢指针的典型应用
 * @date 2021/5/9 8:49
 */
public class P876_MidleNode {
    public static void main(String[] args) {

    }

    public static ListNode midleNode(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }

        return slow;
    }
}
