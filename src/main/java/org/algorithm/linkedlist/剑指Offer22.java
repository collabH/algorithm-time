package org.algorithm.linkedlist;

import org.algorithm.base.ListNode;

/**
 * @fileName: 剑指Offer22.java
 * @description: 链表中倒数第k个节点
 * @author: by echo huang
 * @date: 2020/10/26 4:49 下午
 */
public class 剑指Offer22 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode fast = head;
        ListNode slow = head;
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
