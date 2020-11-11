package org.algorithm.datastructure.linkedlist;

import org.algorithm.base.ListNode;

/**
 * @fileName: LeetCode142.java
 * @description: 环形链表II
 * @author: by echo huang
 * @date: 2020/11/10 9:28 上午
 */
public class LeetCode142 {
    public ListNode detectCycle(ListNode head) {
        ListNode fast, slow;
        fast = slow = head;
        // 找到相遇点，slow执政走了k步，fast走了n k
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) break;
        }
        // 上面的代码类似 hasCycle 函数
        if (fast == null || fast.next == null) {
            // fast 遇到空指针说明没有环
            return null;
        }

        // slow设置为head
        slow = head;

        while (slow != fast) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        LeetCode142 leetCode142 = new LeetCode142();

        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        a.next = b;
        b.next = a;

        ListNode listNode = leetCode142.detectCycle(a);
        System.out.println(listNode);


    }
}
