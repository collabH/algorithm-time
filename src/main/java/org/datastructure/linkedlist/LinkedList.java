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

    private int size;
    // 使用虚拟节点作为头节点
    private Node dummyHead;

    public LinkedList() {
        this.size = 0;
        this.dummyHead = new Node();
    }

    public int getSize() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public void add(int index, E e) {
        indexValid(index);
        Node pred = this.dummyHead;
        for (int i = 0; i < index; i++) {
            pred = pred.next;
        }
        pred.next = new Node(e, pred.next);
        size++;

    }

    public void addFirst(E e) {
        add(0, e);
    }

    public void addLast(E e) {
        add(size, e);
    }

    public E get(int index) {
        indexValid(index);
        Node cur = dummyHead.next;
        int i = 0;
        while (cur != null) {
            if (i == index) {
                return cur.data;
            }
            cur = cur.next;
            i++;
        }
        return null;
    }

    public E getFirst() {
        return get(0);
    }

    public E getLast() {
        return get(size - 1);
    }

    public void set(int index, E e) {
        indexValid(index);
        Node cur = this.dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.data = e;
    }

    public boolean contains(E e) {
        Node cur = dummyHead.next;
        while (cur != null) {
            if (e == cur.data) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    public void remove(int index) {
        indexValid(index);
        Node prev = this.dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        Node deleteNode = prev.next;
        prev.next = deleteNode.next;
        // 移除删除节点引用
        deleteNode.next = null;
        size--;
    }

    private void indexValid(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("add failed.Illegal index.");
        }
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();

        Node cur = dummyHead.next;
        while (cur != null) {
            res.append(cur).append("->");
            cur = cur.next;
        }
        res.append("NULL");
        return res.toString();
    }

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            list.addLast(i);
        }
        System.out.println(list.contains(4));
        System.out.println(list.get(0));
        System.out.println(list.getLast());
        System.out.println(list.getFirst());
        list.addFirst(-1);
        System.out.println(list.getFirst());
        list.add(5, 100);

        list.remove(0);
        list.remove(8);
        System.out.println(list);

    }
}
