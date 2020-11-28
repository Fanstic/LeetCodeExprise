package com.tusk;

import com.tusk.model.ListNode;

/**
 * 题号：141，判断链表中是否有环
 *
 * @author tusk
 * @desc
 * @date 2020/11/26 16:01
 */
public class CheckCircularInLinkList {

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
         * 两个指针第一次相遇的点即为环的入口
         */

        //这里快指针肯定比慢指针先到达null，因此，可以略去慢指针是否为 null 的判断
        while (fast != null){

            slow = slow.getNext();
            fast = fast.getNext().getNext();

            if(slow == fast){
                return true;
            }
        }
            return false;
    }
}


