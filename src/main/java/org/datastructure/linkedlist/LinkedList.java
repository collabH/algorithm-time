package org.datastructure.linkedlist;

/**
 * @fileName: LinkedList.java
 * @description: LinkedList.java类说明
 * @author: by echo huang
 * @date: 2020/10/20 11:31 下午
 */
public class LinkedList<E> {
    private class Node {
        E data;
        Node next;

        public Node(E data, Node next) {
            this.data = data;
            this.next = next;
        }

        public Node(E data) {
            this.data = data;
            this.next = null;
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return data.toString();
        }
    }
}
