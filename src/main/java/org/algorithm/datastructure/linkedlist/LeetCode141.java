package org.algorithm.datastructure.linkedlist;

import org.algorithm.base.ListNode;

/**
 * @fileName: LeetCode141.java
 * @description: 环形链表
 * @author: by echo huang
 * @date: 2020/11/10 9:17 上午
 */
public class LeetCode141 {
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) return true;
        }
        return false;
    }
}
