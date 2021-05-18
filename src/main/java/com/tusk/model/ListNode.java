package com.tusk.model;

import java.lang.reflect.WildcardType;

/**
 * 链表节点
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int v) {
        val = v;
    }

    public ListNode(int v,ListNode next){
        this.val = v;
        this.next = next;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int v){
        this.val = v;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    public int getSize() {
        int count = 1;
        ListNode node = this;
        while (node.getNext() != null) {
            node = node.getNext();
            count++;
        }

        return count;
    }


}
