package org.datastructure.map;

/**
 * @fileName: LinkedListHashMap.java
 * @description: LinkedListHashMap.java类说明
 * @author: by echo huang
 * @date: 2020/10/29 10:58 下午
 */
public class LinkedListHashMap<K, V> implements Map<K, V> {
    private class Node {
        public K k;
        public V v;
        public Node next;

        public Node(K k, V v, Node next) {
            this.k = k;
            this.v = v;
            this.next = next;
        }

        public Node(K k) {
            this(k, null, null);
        }

        public Node() {
        }

        @Override
        public String toString() {
            return "Node{" +
                    "k=" + k.toString() +
                    ", v=" + v.toString() +
                    ", next=" + next +
                    '}';
        }
    }

    private Node dummyHead;
    private int size;

    public LinkedListHashMap() {
        dummyHead = new Node(null, null, null);
    }

    @Override
    public void add(K k, V v) {
        Node node = getNode(k);
        if (node != null) {
            node.v = v;
            return;
        }
        dummyHead.next = new Node(k, v, dummyHead.next);
        size++;
    }

    @Override
    public V remove(K k) {
        Node node = getNode(k);
        if (node == null) {
            throw new IllegalArgumentException();
        }
        Node cur = this.dummyHead.next;
        Node prev = this.dummyHead;
        while (cur != null) {
            if (cur.k == k) {
                break;
            }
            prev = cur;
            cur = cur.next;
        }
        if (cur != null) {
            prev.next = cur.next;
            cur.next = null;
            size--;
            return cur.v;
        }
        return null;
    }

    @Override
    public boolean contains(K k) {
        return getNode(k) != null;
    }

    @Override
    public V get(K k) {
        Node node = getNode(k);
        return node == null ? null : node.v;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void set(K k, V v) {
        Node node = getNode(k);
        if (node != null) {
            node.v = v;
        }
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        return "LinkedListHashMap{" +
                "dummyHead=" + dummyHead.next +
                ", size=" + size +
                '}';
    }

    private Node getNode(K k) {
        Node cur = dummyHead.next;
        while (cur != null) {
            if (cur.k == k) {
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }

    public static void main(String[] args) {
        Map<Integer, Integer> map = new LinkedListHashMap<>();
        map.add(1, 1);
        map.add(1, 2);
        map.add(2, 2);
        map.add(3, 2);
        System.out.println(map);
        System.out.println(map.remove(3));
        System.out.println(map);
        System.out.println(map.contains(1));
        System.out.println(map.get(2));
        System.out.println(map.isEmpty());
        map.set(1, 5);
        System.out.println(map);
    }
}
