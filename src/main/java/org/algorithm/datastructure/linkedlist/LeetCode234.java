package org.algorithm.datastructure.linkedlist;

import org.algorithm.base.ListNode;

/**
 * @fileName: LeetCode234.java
 * @description: 回文链表
 * @author: by echo huang
 * @date: 2020/11/2 11:04 上午
 */
public class LeetCode234 {

    /**
     * 快慢指针写法
     *
     * @param head
     * @return
     */
    public boolean isPalindrome1(ListNode head) {
        if (head == null) return true;
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

        }
        // 如果node个数为奇数，slow指针需要前进一次
        if (fast != null) {
            slow = slow.next;
        }
        ListNode left = head;
        ListNode right = reverse(slow);
        while (right != null) {
            if (left.val != right.val) return false;
            right = right.next;
            left = left.next;
        }
        return true;
    }

    private ListNode reverse(ListNode node) {
        ListNode nxt, cur = node, prev = null;
        while (cur != null) {
            nxt = cur.next;
            cur.next = prev;
            prev = cur;
            cur = nxt;
        }
        return prev;
    }


    public boolean isPalindrome(ListNode head) {
        left = head;
        return traverse(head);
    }

    ListNode left;

    private boolean traverse(ListNode right) {
        if (right == null) {
            return true;
        }
        boolean res = traverse(right.next);
        res = res && left.val == right.val;
        left = left.next;
        return res;
    }


}
