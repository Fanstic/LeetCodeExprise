package com.tusk;

import com.tusk.primary.linkedlist.P19_RemoveNthFromEnd;

import java.util.LinkedList;
import java.util.List;

/**
 * 判断一个链表是否为回文链表
 *
 * @author tusk
 * @desc
 * @date 2020/12/17 10:08
 */
public class P234_IsPalindromeLIst {
    public static void main(String[] args) {
        P19_RemoveNthFromEnd.ListNode head = new P19_RemoveNthFromEnd.ListNode(-129, null);
        head.next = new P19_RemoveNthFromEnd.ListNode(-129, null);
//        head.next.next = new RemoveNthFromEnd.ListNode(2, null);
//        head.next.next.next = new RemoveNthFromEnd.ListNode(1, null);

        System.out.println(isPalindrome(head));
    }

    /**
     * 思路1:将链表数据复制到一个数组中，然后通过头尾两个指针遍历进行比较，空间复杂度和时间复杂度都是O(n)
     *
     * @param head
     * @return
     */
    public static boolean isPalindrome(P19_RemoveNthFromEnd.ListNode head) {
        List<Integer> list = new LinkedList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }

        int h = 0;
        int t = list.size() - 1;

        while (h < t) {
            if (list.get(h).intValue() != list.get(t).intValue()) {
                return false;
            }

            h = h + 1;
            t = t - 1;
        }

        return true;
    }

    /**
     * 思路2：将链表半部翻转然后进行比对，此种方式会修改原链表的数据结构
     *
     * @param head
     * @return
     */
    public static boolean isPalindrome01(P19_RemoveNthFromEnd.ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        P19_RemoveNthFromEnd.ListNode slow = head, fast = head;
        P19_RemoveNthFromEnd.ListNode pre = head, prepre = null;

        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;

            //链表反转
            pre.next = prepre;
            prepre = pre;
        }

        //当跳出上述循环时，慢指针所处位置为链表的中间节点位置.且链表的前半部分进行了反转
        //链表节点个数为偶数时循环后 fast = null,节点个数为奇数是 fast!=null
        //在节点个数为奇数时比对可忽略中间节点
        if (fast != null) {
            slow = slow.next;
        }


        //将反转后的前半部分与后半部分进行比对
        while (pre != null && slow != null) {
            if (pre.val != slow.val) {
                return false;
            }
            pre = pre.next;
            slow = slow.next;
        }
        return true;

//        作者：nuan
//        链接：https://leetcode-cn.com/problems/palindrome-linked-list/solution/wo-de-kuai-man-zhi-zhen-du-cong-tou-kai-shi-gan-ju/
//        来源：力扣（LeetCode）
//        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    }
}