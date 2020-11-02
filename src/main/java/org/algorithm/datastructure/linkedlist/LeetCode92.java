package org.algorithm.datastructure.linkedlist;

import org.algorithm.base.ListNode;

/**
 * @fileName: LeetCode92.java
 * @description: 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 * @author: by echo huang
 * @date: 2020/11/2 9:43 上午
 */
public class LeetCode92 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) {
            return null;
        }
        if (m == 1) {
            return reverseN(head, n);
        }
        head.next = reverseBetween(head.next, m - 1, n - 1);
        return head;
    }

    public static void main(String[] args) {
        LeetCode92 leetCode92 = new LeetCode92();
        ListNode listNode = new ListNode(1,
                new ListNode(2, new ListNode(3, new ListNode(4))));
        leetCode92.reverseBetween(listNode, 2, 3);

    }

    // 反转链表
    public ListNode reverse(ListNode root) {
        if (root.next == null) return root;
        ListNode last = reverse(root.next);
        root.next.next = root;
        root.next = null;
        return last;
    }

    ListNode successor;

    public ListNode reverseN(ListNode root, int n) {
        // 翻转最后一个Node
        if (n == 1) {
            // 例如1-2-3-4-5 n=3，那么successor为4
            successor = root.next;
            return root;
        }
        ListNode last = reverseN(root, n - 1);
        // node反转
        root.next.next = root;
        // 将1的next关联上4
        root.next = successor;
        return last;
    }


}
