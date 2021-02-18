package com.tusk;


import java.util.Deque;
import java.util.LinkedList;

/**
 * 反转一个链表
 *
 * @author tusk
 * @desc
 * @date 2020/12/16 10:04
 */
public class ReverseList {

    public static void main(String[] args) {
        P19_RemoveNthFromEnd.ListNode head = new P19_RemoveNthFromEnd.ListNode(1, null);
        head.next = new P19_RemoveNthFromEnd.ListNode(2, null);
        head.next.next = new P19_RemoveNthFromEnd.ListNode(3,null);
        P19_RemoveNthFromEnd.ListNode result = new ReverseList().reverseListV2(head);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

    /**
     * 使用栈，现将所有元素入栈，然后出栈组成一个新的链表，返回链表头
     *
     * @param head
     * @return
     */
    public P19_RemoveNthFromEnd.ListNode reverseList(P19_RemoveNthFromEnd.ListNode head) {

        Deque<P19_RemoveNthFromEnd.ListNode> stack = new LinkedList<>();

        while (head != null) {
            stack.push(head);
            head = head.next;
        }


        P19_RemoveNthFromEnd.ListNode dumy = new P19_RemoveNthFromEnd.ListNode(0, null);
        P19_RemoveNthFromEnd.ListNode c = dumy;
        while (!stack.isEmpty()) {
            P19_RemoveNthFromEnd.ListNode node = stack.pop();
            node.next = null;//需要将当前栈顶节点next置空，否则会死循环
            c.next = node;
            c = c.next;
        }

        return dumy.next;
    }

    /**
     * 迭代法
     * 时间复杂度:O(n),n为链表的长度
     * 空间复杂度:O(1)
     * https://leetcode-cn.com/problems/reverse-linked-list/solution/fan-zhuan-lian-biao-by-leetcode/
     * @param head
     * @return
     */
    public P19_RemoveNthFromEnd.ListNode reverseListV1(P19_RemoveNthFromEnd.ListNode head) {

        P19_RemoveNthFromEnd.ListNode cur = head;
        //前驱
        P19_RemoveNthFromEnd.ListNode pre = null;

        while (cur != null) {
            P19_RemoveNthFromEnd.ListNode tempNode = cur.next;
            cur.next = pre;
            pre = cur;

            cur = tempNode;
        }

        return pre;
    }

    /**
     * 递归法,没看懂
     * 时间复杂度:O(n)
     * 空间复杂度:O(n)
     * https://leetcode-cn.com/problems/reverse-linked-list/solution/fan-zhuan-lian-biao-by-leetcode/
     * @param head
     * @return
     */
    public P19_RemoveNthFromEnd.ListNode reverseListV2(P19_RemoveNthFromEnd.ListNode head){
        if (head == null || head.next == null) {
            return head;
        }
        //p当前端的最后一个节点,p 为head的前一个节点
        P19_RemoveNthFromEnd.ListNode p = reverseListV2(head.next);
        head.next.next = head;
        head.next = null;
        return p;


    }
}
