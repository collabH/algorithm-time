package org.algorithm.datastructure.fastslow;

import org.datastructure.linkedlist.LeetCode203;

/**
 * @fileName: LeetCode83.java
 * @description: 删除排序链表中的重复元素
 * @author: by echo huang
 * @date: 2020/10/29 4:56 下午
 */
public class LeetCode83 {
    public LeetCode203.ListNode deleteDuplicates(LeetCode203.ListNode head) {
        if (head == null) {
            return null;
        }
        LeetCode203.ListNode slow = head, fast = head;
        while (fast != null) {
            if (fast.val != slow.val) {
                slow.next = fast;
                slow = slow.next;
            }
            fast = fast.next;
        }
        slow.next = null;
        return head;
    }

    public static void main(String[] args) {
        LeetCode203.ListNode listNode = new LeetCode203.ListNode(1);
        listNode.next = new LeetCode203.ListNode(1);
        listNode.next.next = new LeetCode203.ListNode(2);

        LeetCode83 leetCode83 = new LeetCode83();
        System.out.println(leetCode83.deleteDuplicates(listNode));
    }
}
