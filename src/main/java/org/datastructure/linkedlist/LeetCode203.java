package org.datastructure.linkedlist;

/**
 * @fileName: LeetCode203.java
 * @description: 移除链表元素
 * @author: by echo huang
 * @date: 2020/10/25 4:09 下午
 */
public class LeetCode203 {
    public ListNode removeElements(ListNode head, int val) {
        // 虚拟头节点
        ListNode pred = new ListNode(-1);
        pred.next = head;
        ListNode pre = pred, curr = head;
        while (curr != null) {
            if (curr.val == val) {
                pre.next = curr.next;
            } else {
                pre = curr;
            }
            curr = curr.next;
        }
        return pred.next;
    }

    public static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int x) {
            val = x;
        }
    }
}

