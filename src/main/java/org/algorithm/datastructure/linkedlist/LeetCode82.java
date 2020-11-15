package org.algorithm.datastructure.linkedlist;

import org.algorithm.base.ListNode;

import java.util.HashSet;

/**
 * @fileName: LeetCode82.java
 * @description: LeetCode82.java类说明
 * @author: by echo huang
 * @date: 2020/11/15 9:33 下午
 */
public class LeetCode82 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        if (head.val == head.next.val) {
            while (head != null && head.next != null && head.val == head.next.val) {
                head = head.next;
            }
            return deleteDuplicates(head.next);
        } else {
            head.next = deleteDuplicates(head.next);
            return head;
        }
    }
}
