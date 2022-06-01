package com.tusk.primary.linkedlist;

import com.tusk.model.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author tusk
 * @desc 给你一个链表数组，每个链表都已经按升序排列。
 * <p>
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 * 输出：[1,1,2,3,4,4,5,6]
 * 解释：链表数组如下：
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * 将它们合并到一个有序链表中得到。
 * 1->1->2->3->4->4->5->6
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-k-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/5/18 16:41
 */
public class P23_MergeKLikst {
    public static void main(String[] args) {
        P23_MergeKLikst obj = new P23_MergeKLikst();
        ListNode l1 = new ListNode(1, new ListNode(2));
        ListNode l2 = new ListNode(1, new ListNode(3));
        ListNode l3 = new ListNode(3, new ListNode(8));

        ListNode l4 = obj.merge01(new ListNode[]{l1, l2, l3});
        System.out.println(l4.toString());
    }

    /**
     * 简单朴素
     *
     * @param lists
     * @return
     */
    public ListNode mergeKList(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        ListNode l3 = null;

        for (int i = 0; i < lists.length; i++) {
            l3 = mergeList(l3, lists[i]);
        }

        return l3;
    }

    public ListNode mergeList(ListNode l1, ListNode l2) {
        ListNode l3 = new ListNode(-1, null);
        ListNode head = l3;


        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                l3.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                l3.next = new ListNode(l2.val);
                l2 = l2.next;
            }

            l3 = l3.next;
        }

        if (l1 != null) {
            l3.next = l1;
        }

        if (l2 != null) {
            l3.next = l2;
        }
        return head.next;
    }

    /**
     * 分治思想
     *
     * @param lists
     * @param left
     * @param right
     * @return
     */
    public ListNode merge(ListNode[] lists, int left, int right) {
        if (left == right) {
            return lists[1];
        }

        if (left > right) {
            return null;
        }

        int mid = (left + right) >> 1;

        return mergeList(merge(lists, 1, mid), merge(lists, mid + 1, right));
    }

    /**
     * 优先级队列法，假如有 k 个有序列表，每次取出未合并元素中最前面的那个，然后从中找出最小的那个合并到结果链表中
     *
     * @param lists
     * @return
     */
    public ListNode merge01(ListNode[] lists) {
        PriorityQueue<ListNode> pbq = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));
        ListNode head = new ListNode(0);
        ListNode p = head;

        for (ListNode node : lists) {
            pbq.add(node);
        }

        while (!pbq.isEmpty()) {
            //pdq.poll()获取的可以认为是所有元素中最小的一个
            p.next = pbq.poll();
            p = p.next;

            //这里判断当前取值的链表是否还有数据，如果又就再次将它加入到小顶堆中
            if (p.next != null) {
                pbq.add(p.next);
            }
        }

        return head.next;
    }
}
