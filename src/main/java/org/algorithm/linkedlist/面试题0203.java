package org.algorithm.linkedlist;

import org.algorithm.base.ListNode;

/**
 * @fileName: 面试题0202.java
 * @description: 返回倒数第 k 个节点
 * @author: by echo huang
 * @date: 2020/10/26 4:42 下午
 */
public class 面试题0203 {
    public void deleteNode(ListNode node) {
        // 替换值
        node.val = node.next.val;
        // 替换next
        node.next = node.next.next;
    }


    // 反转链表
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }
}
