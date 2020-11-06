package org.algorithm.base;

public class ListNode {
    public int val;
    public ListNode next;


    public ListNode(int x) {
        val = x;
    }
    public ListNode(int x,ListNode cur) {
        val = x;
        next=cur;
    }
}