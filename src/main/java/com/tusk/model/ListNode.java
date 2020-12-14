package com.tusk.model;

/**
 * 链表节点
 */
public class ListNode {
    private int val;
    private ListNode next;

    public ListNode(int v) {
        val = v;
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
