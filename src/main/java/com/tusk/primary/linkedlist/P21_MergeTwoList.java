package com.tusk.primary.linkedlist;

import com.tusk.model.ListNode;

/**
 * @author tusk
 * @desc 合并两个有序单链表
 * @date 2021/5/8 11:132
 */
public class P21_MergeTwoList {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1, new ListNode(4,new ListNode(9)));

        ListNode l2 = new ListNode(2, new ListNode(6));

        ListNode l3 = mergeTwoLists(l1, l2);

        System.out.println(l3);
    }

    /**
     * 迭代法
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }

        if(l1 == null&&l2!=null){
            return l2;
        }

        if(l1!=null&&l2 == null){
            return l1;
        }

        ListNode l3 = new ListNode(-1);
        ListNode head = l3;
        while (l1 != null && l2 != null) {
            if (l1.getVal() <= l2.getVal()) {
                l3.setNext(new ListNode(l1.getVal()));
                l1 = l1.getNext();
            } else {
                l3.setNext(new ListNode(l2.getVal()));
                l2 = l2.getNext();
            }
            l3 = l3.getNext();
        }

        if (l1 == null && l2 != null) {
            l3.setNext(l2);
        } else if (l2 == null && l1 != null) {
            l3.setNext(l1);
        }


        return head.getNext();
    }

    /**
     * 递归法
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeTwoList1(ListNode l1,ListNode l2){
        if(l1 == null){
            return l2;
        }else if(l2 == null){
            return l1;
        }else if(l1.getVal()<=l2.getVal()){
            return mergeTwoList1(l1.getNext(),l2);
        }else{
            return mergeTwoList1(l2.getNext(),l1);
        }
    }
}
