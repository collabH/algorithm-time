package org.algorithm.datastructure.linkedlist;

import org.algorithm.base.ListNode;

/**
 * @fileName: LeetCode25.java
 * @description: K个一组翻装链表
 * @author: by echo huang
 * @date: 2020/11/2 10:32 上午
 */
public class LeetCode25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return head;
        ListNode b = head;
        for (int i = 0; i < k; i++) {
            if (b == null) return head;
            b = b.next;
        }
        // 递归[a,b)范围的链表
        ListNode newHead = reverse(head, b);
        // 将b，和k在放入递归中
        head.next = reverseKGroup(b, k);
        return newHead;
    }

    /**
     * 翻转a，b链表
     *
     * @param a
     * @param b
     * @return
     */
    ListNode reverse(ListNode a, ListNode b) {
        ListNode pre, cur, nxt;
        pre = null;
        cur = a;
        nxt = a;
        // while 终止的条件改一下就行了
        while (cur != b) {
            nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        // 返回反转后的头结点
        return pre;
    }

    /**
     * 迭代版本反转链表
     *
     * @param head
     * @return
     */
    public ListNode reverse(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode prev = null, cur = head, nxt = head;
        while (cur != null) {
            nxt = cur.next;
            cur.next = prev;
            prev = cur;
            cur = nxt;
        }
        return prev;
    }
}
