package com.tusk.primary.linkedlist;

import com.tusk.model.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 题号：141，判断链表中是否有环
 *
 * @author tusk
 * @desc
 * @date 2020/11/26 16:01
 */
public class P141_CheckCircularInLinkList {

    /**
     * 判断给定链表中是否有环,要考虑各种环的情况，找出各种成环时的临界条件
     *
     * @param root 链表
     * @return true，有环，false，无环
     */
    public static boolean check(ListNode root) {
        if (root == null || root.getNext() == null) {
            return false;
        }

        /*
         * 1.单节点链表环, p.next = p
         * 2.相邻节点成环  r.next.next = r
         * 3. 尾节点成环  tail = r.next tail.next = tail
         */
        ListNode slow = root;
        ListNode fast = root;

        /*
         * 快慢指针法，如果链表中有环，则快慢指针一定会在环上相遇，且相遇时快指针尚未走完环的一周
         * 快指针一次两步，慢指针一次一步
         */

        //这里快指针肯定比慢指针先到达null，因此，可以略去慢指针是否为 null 的判断
        while (fast != null && fast.next != null) {

            slow = slow.getNext();
            fast = fast.getNext().getNext();

            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    /**
     * 集合法
     *
     * @param head
     * @return
     */
    public static boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (!set.add(head)) {
                return true;
            }

            head = head.getNext();
        }

        return false;
    }

    /**
     * 如果链表中有环，找出环的起始位置
     *
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        ListNode fast, slow;
        fast = slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                break;
            }
        }

        //说明链表中没有环
        if (fast == null || fast.next == null) {
            return null;
        }


        /**
         * 假设第一次两者相遇时，slow走了k步，fast走了2k步，k一定是环长度的整数倍
         *两者相遇时记相遇点到环的起始位置的距离为m,则head到环的起始位置的距离便是k-m
         * 同样的，快指针从相遇点到环的起始位置也是k-m
         * 因此，让快慢指针任意一个重新指向头指针，以同样的速度前进，再次相遇的位置就是环的入口位置
         * https://labuladong.gitee.io/algo/2/21/55/
         */

        //
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }
}


