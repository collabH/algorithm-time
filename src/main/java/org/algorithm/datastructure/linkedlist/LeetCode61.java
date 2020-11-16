package org.algorithm.datastructure.linkedlist;

import org.algorithm.base.ListNode;

/**
 * @fileName: LeetCode61.java
 * @description: 旋转链表
 * @author: by echo huang
 * @date: 2020/11/15 10:19 下午
 */
public class LeetCode61 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null;
        if (head.next == null || k == 0) return head;

        // 计算链表总长度
        int len = 0;
        ListNode temp = head;
        while (temp != null) {
            temp = temp.next;
            len++;
        }

        // 重新计算k
        k = k % len;
        if (k == 0) return head;
        ListNode p = head, fast = head, slow = head;
        while (k-- > 0) {
            fast = fast.next;
        }

        // 移动slow
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        // 新的头
        ListNode newHead = slow.next;
        slow.next = null;
        fast.next = head;
        return newHead;
    }


    public static void main(String[] args) {
        LeetCode61 leetCode61 = new LeetCode61();
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4,
                new ListNode(5)))));
        ListNode listNode = leetCode61.rotateRight(head, 2);
    }
}
