package org.algorithm.datastructure.linkedlist;

import org.algorithm.base.ListNode;

/**
 * @fileName: LeetCode24.java
 * @description: LeetCode24.java类说明
 * @author: by echo huang
 * @date: 2020/11/15 9:44 下午
 */
public class LeetCode24 {
    public ListNode swapPairs(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode p = dummyHead;
        while (p.next != null && p.next.next != null) {
            ListNode node1 = p.next;
            ListNode node2 = p.next.next;
            ListNode next = node2.next;

            node2.next = node1;
            node1.next = next;
            p.next = node2;


            p = node1;
        }

        return dummyHead.next;
    }
}
