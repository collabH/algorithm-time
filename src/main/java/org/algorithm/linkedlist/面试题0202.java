package org.algorithm.linkedlist;

import org.algorithm.base.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @fileName: 面试题0202.java
 * @description: 返回倒数第 k 个节点
 * @author: by echo huang
 * @date: 2020/10/26 4:42 下午
 */
public class 面试题0202 {
    public int kthToLast(ListNode head, int k) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        return list.get(list.size() - k);
    }

}
