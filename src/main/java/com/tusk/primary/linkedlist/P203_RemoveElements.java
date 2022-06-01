package com.tusk.primary.linkedlist;

import com.tusk.model.ListNode;

/**
 * @author tusk
 * @desc 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
 * 输入：head = [1,2,6,3,4,5,6], val = 6
 * 输出：[1,2,3,4,5]
 * @date 2021/6/5 23:28
 */
public class P203_RemoveElements {
    public static void main(String[] args) {
        P203_RemoveElements obj = new P203_RemoveElements();
        ListNode node = new ListNode(7, new ListNode(7, new ListNode(7, new ListNode(7, new ListNode(7, new ListNode(7))))));

        ListNode result = obj.removeElements(node, 7);

        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }


    }

    /**
     * 移除指定链表中所有等于 val 的节点
     *空间复杂度:O(1)
     * 时间复杂度：O(n)
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }

        ListNode pre = null;

        //找到第一个不等于指定值的节点
        while (head!=null&&head.val == val) {
            head = head.next;
        }

        ListNode newHead = new ListNode(-1, head);

        while (head != null) {

            if (head.val == val) {
                if (pre == null) {
                    pre = head;
                }
                pre.next = head.next;
            }else{
                pre = head;
            }
            head = head.next;

        }

        return newHead.next;
    }

    /**
     * 空间复杂度:O(n)
     * 时间复杂度:O(n)
     *
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements01(ListNode head, int val) {
        if (head == null) {
            return null;
        }

        ListNode p = new ListNode(-1, null);
        ListNode newHead = p;
        ListNode cur = head;

        while (cur != null) {
            if (cur.val != val) {
                p.next = new ListNode(cur.val);
                p = p.next;
            }
            cur = cur.next;
        }

        return newHead.next;
    }
}
