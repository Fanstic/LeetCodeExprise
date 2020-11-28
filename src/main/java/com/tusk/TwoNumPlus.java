package com.tusk;

import com.tusk.model.ListNode;

import java.math.BigInteger;
import java.util.LinkedList;

/** 题号:2 两数相加
 * @author tusk
 * @desc 给出两个非空的链表来表示两个非负的整数，其中，它们各自的位数是按照逆序的方式存储的，并且它们的每个节点只能存储一位
 * 数字，如果将两个数想加，则返回一个新的链表表示它们的和，除了数字0，两个数都不会以0开头
 * @date 2020/11/24 8:37
 */
public class TwoNumPlus {
    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        a.setNext(new ListNode(2));
        a.getNext().setNext(new ListNode(3));
        a.getNext().getNext().setNext(new ListNode(1));


        ListNode b = new ListNode(4);
        b.setNext(new ListNode(5));
        b.getNext().setNext(new ListNode(6));

        ListNode resultNode = calImproved(a, b);
        while (resultNode != null) {
            System.out.println(resultNode.getVal());
            resultNode = resultNode.getNext();
        }
    }

    /**
     * 考虑点：1,int类型范围  2,
     *
     * @param a 链表 a
     * @param b 链表 b
     * @return 结果链表
     */
    public static LinkedList<Integer> cal(LinkedList<Integer> a, LinkedList<Integer> b) {
        LinkedList<Integer> resultList = new LinkedList<>();


        BigInteger sum = sum(a).add(sum(b));
        String sumStr = sum.toString(10);
        for (String item : sumStr.split("")) {
            resultList.add(Integer.valueOf(item));
        }

        return resultList;
    }

    /**
     * 官方解法
     *
     * @param a 链表 a
     * @param b 链表 b
     * @return 结果节点
     */
    public static ListNode calImproved(ListNode a, ListNode b) {
        int carry = 0;
        ListNode head = null;
        ListNode tail = null;
        int aSize = a.getSize();
        int bSize = b.getSize();

        if (aSize != bSize) {

            int sizeDiff = Math.abs(aSize - bSize);

            ListNode tempHead = new ListNode(0);

            while (sizeDiff > 0) {
                tempHead.setNext(new ListNode(0));
                tempHead = tempHead.getNext();
                sizeDiff--;
            }

            //b高位补0
            if (aSize > bSize) {
                tempHead.setNext(b);
                b = tempHead;
            } else {
                tempHead.setNext(a);
                a = tempHead;
            }
        }
        while (a != null || b != null) {
            int v1 = a == null ? 0 : a.getVal();
            int v2 = b == null ? 0 : b.getVal();

            int sum = v1 + v2 + carry;
            if (head == null) {
                head = tail = new ListNode(sum % 10);
            } else {
                tail.setNext(new ListNode(sum % 10));
                tail = tail.getNext();
            }

            carry = sum / 10;
            if (a != null) {
                a = a.getNext();
            }

            if (b != null) {
                b = b.getNext();
            }
        }

        if (carry > 0) {
            tail.setNext(new ListNode(carry));
        }

        return head;
    }

    /**
     * 列表求和
     *
     * @param iList 整数列表
     * @return 列表中元素的和
     */
    private static BigInteger sum(LinkedList<Integer> iList) {
        if (iList == null || iList.isEmpty() || iList.getFirst() <= 0) {
            return BigInteger.ZERO;
        }


        BigInteger sum = new BigInteger("0");
        int counter = 1;
        while (counter <= iList.size()) {
            double pow = Math.pow(10, iList.size() - counter);
            BigInteger currentVal = new BigInteger(iList.get(counter - 1).toString())
                    .multiply(new BigInteger(String.valueOf((int) pow)));
            sum = sum.add(currentVal);
            counter++;
        }

        return sum;
    }
}

