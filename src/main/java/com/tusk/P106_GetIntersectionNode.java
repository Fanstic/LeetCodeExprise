package com.tusk;

import com.tusk.model.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author tusk
 * @desc 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表没有交点，返回 null 。
 * <p>
 * 图示两个链表在节点 c1 开始相交：
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/intersection-of-two-linked-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/6/4 8:48
 */
public class P106_GetIntersectionNode {
    public static void main(String[] args) {
        P106_GetIntersectionNode obj = new P106_GetIntersectionNode();
        ListNode headA = new ListNode(1, new ListNode(2));

        ListNode node = new ListNode(3, new ListNode(4));
        headA.next.next = node;

        ListNode headB = new ListNode(0, node);

        System.out.println(obj.getIntersectionNode_Hash(headA, headB).getVal());

    }

    /**
     * 粗暴遍历法
     * 长链表长度 ll,短链表长度 ls,让两者从同一起跑线遍历，有过有相同节点则相交
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode dummyA = new ListNode(-1, headA);
        ListNode dummyB = new ListNode(-1, headB);

        int lenA = 0;
        int lenB = 0;

        while (dummyA.next != null) {
            ++lenA;
            dummyA = dummyA.next;
        }

        while (dummyB.next != null) {
            ++lenB;
            dummyB = dummyB.next;
        }

        int diff = Math.abs(lenA - lenB);

        dummyA = new ListNode(-1, headA);
        dummyB = new ListNode(-1, headB);

        ListNode longger = lenA > lenB ? dummyA : dummyB;
        ListNode shorter = longger == dummyA ? dummyB : dummyA;

        while (diff > 0) {
            longger = longger.next;
            diff--;
        }

        while (longger != null && shorter != null) {
            if (longger == shorter) {
                return longger;
            }

            longger = longger.next;
            shorter = shorter.next;
        }

        return null;
    }

    /**
     * 哈希法
     *空间复杂度：O(m)
     * 时间复杂度：O(m + n)
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode_Hash(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        Set<ListNode> setA = new HashSet<>();


        ListNode a = headA;
        ListNode b = headB;

        while (a != null) {
            setA.add(a);
            a = a.next;
        }

        while (b != null) {
            if (setA.contains(b)) {
                return b;
            }

            b = b.next;
        }

        return null;
    }

    /**
     * 官方双指针解法
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode_dl(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }
}
