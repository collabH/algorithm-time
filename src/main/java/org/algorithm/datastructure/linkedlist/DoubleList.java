package org.algorithm.datastructure.linkedlist;

/**
 * @fileName: DoubleList.java
 * @description: DoubleList.java类说明
 * @author: by echo huang
 * @date: 2020/10/30 4:52 下午
 */
public class DoubleList {
    public static class Node {
        public int key, value;
        public Node next, prve;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private Node head, tail;
    private int size;

    public DoubleList() {
        head = new Node(0, 0);
        tail = new Node(0, 0);
        size = 0;
        head.next = tail;
        tail.prve = head;
    }

    public void addLast(Node node) {
        if (node == null) {
            return;
        }
        node.prve = tail.prve;
        node.next = tail;
        tail.prve.next = node;
        tail.prve = node;
        size++;
    }

    public void remove(Node x) {
        x.prve.next = x.next;
        x.next.prve = x.prve;
        size--;
    }

    public Node removeFirst() {
        if (head.next == null) {
            return null;
        }
        Node first = head.next;
        remove(first);
        return first;
    }

    public int size() {
        return size;
    }
}
