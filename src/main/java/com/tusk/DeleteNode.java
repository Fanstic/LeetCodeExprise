package com.tusk;

import com.tusk.model.ListNode;

import javax.sound.midi.Soundbank;

/**
 * 题号237，删除单链表中的节点
 * 请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点。传入函数的唯一参数为 要被删除的节点 。
 * 提示：
 * <p>
 * 链表至少包含两个节点。
 * 链表中所有节点的值都是唯一的。
 * 给定的节点为非末尾节点并且一定是链表中的一个有效节点。
 * 不要从你的函数中返回任何结果。
 *
 * @author tusk
 * @desc
 * @date 2020/12/14 8:57
 */
public class DeleteNode {
    public static void main(String[] args) {
        DeleteNode deleteNode = new DeleteNode();
        deleteNode.deleteNode(new ListNode(1));

        ListNode node = deleteNode.getHead();
        while (node!=null){
            System.out.println(node.getVal());
            node = node.getNext();
        }
    }

    public ListNode getHead() {
        return head;
    }

    public ListNode head;


    public DeleteNode() {
        head = new ListNode(1);
        ListNode secondNode = new ListNode(2);
        head.setNext(secondNode);
        ListNode thirdNode = new ListNode(3);
        secondNode.setNext(thirdNode);
    }

    /**
     * 是我没看懂还是你妹说明白。。
     * @param node
     */
    public void deleteNode(ListNode node) {
        ListNode next = head;

        while (next != null) {
            if (next.getVal() == node.getVal()) {
                head = next.getNext();
                next = null;
                return;
            } else {
                if (next.getNext().getVal() == node.getVal()) {
                    next.setNext(next.getNext().getNext());
                    return;
                }

                next = next.getNext();
            }
        }
    }

    public void deleteNodeOffice(ListNode node){
        node.setVal(node.getNext().getVal());
        node.setNext(node.getNext().getNext());
    }
}
