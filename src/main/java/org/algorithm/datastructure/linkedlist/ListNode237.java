package org.algorithm.datastructure.linkedlist;

import org.algorithm.base.ListNode;

/**
 * @fileName: ListNode237.java
 * @description: ListNode237.java类说明
 * @author: by echo huang
 * @date: 2020/11/15 10:00 下午
 */
public class ListNode237 {
    public void deleteNode(ListNode node) {
         node.val= node.next.val;
        ListNode delNode = node.next;
        node.next=delNode.next;
        delNode=null;
    }
}
