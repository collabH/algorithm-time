package org.algorithm.datastructure.linkedlist;

import org.algorithm.base.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @fileName: LeetCode143.java
 * @description: 重排链表
 * @author: by echo huang
 * @date: 2020/11/15 10:20 下午
 */
public class LeetCode143 {
    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        List<ListNode> list = new ArrayList<ListNode>();
        ListNode node = head;
        while (node != null) {
            list.add(node);
            node = node.next;
        }
        int i = 0, j = list.size() - 1;
        while (i < j) {
            list.get(i).next = list.get(j);
            i++;
            if (i == j) {
                break;
            }
            list.get(j).next = list.get(i);
            j--;
        }
        list.get(i).next = null;
    }
}
