package com.tusk;

import java.util.LinkedList;

/**
 * 题号19，删除链表的倒数第 n 个节点
 * 示例：
 * <p>
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * <p>
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 *
 * @author tusk
 * @desc
 * @date 2020/12/15 15:46
 */
public class P19_RemoveNthFromEnd {
    /**
     * 1. 遍历链表计算长度
     * 2. 计算删除元素位置 target = size - 1 - n
     * 3. node = target.next;
     * target.next = node.next;
     * node = null
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dumy = new ListNode(0, head);

        int size = 0;
        ListNode node = dumy;
        while (node != null) {
            node = node.next;
            size++;
        }

        int target = size - n - 1;
        int counter = 0;

        node = dumy;
        while (counter < target) {
            node = node.next;
            counter++;

        }

        ListNode cnode = node.next;

        node.next = cnode.next;
        cnode = null;


        return dumy.next;
    }

    /**
     * 使用栈来实现，先入栈所有节点，出栈的第n个节点就是要删除的节点
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEndV1(ListNode head, int n) {
        ListNode dumy = new ListNode(0, head);
        ListNode node = dumy;
        LinkedList<ListNode> stack = new LinkedList<>();
        while (node != null) {
            stack.push(node);
            node = node.next;
        }

        int count = 0;
        while (count < n) {
            stack.pop();
            count++;
        }

        //此时栈顶的元素的就是要删除的元素的前一个元素
        ListNode peek = stack.peek();
        peek.next = peek.next.next;
        return dumy.next;
    }

    /**
     * 快慢指针法
     * 同时使用快慢两个指针对链表进行遍历，快指针比慢指针快n个节点，当快指针到达链表末尾时，
     * 满指针所在即为要删除的元素
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthfromEndV2(ListNode head, int n) {
        ListNode dumy = new ListNode(0, head);
        ListNode first = new ListNode(0, dumy);
        ListNode second = new ListNode(0, dumy);
        int count = 0;
        while (count < n) {
            first = first.next;
            count++;
        }

        while (first.next != null) {
            first = first.next;
            second = second.next;
        }

        second.next = second.next.next;
        return dumy.next;
    }

    static class ListNode {
        public ListNode next;
        public int val;

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
