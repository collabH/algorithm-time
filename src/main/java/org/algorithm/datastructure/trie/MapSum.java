package org.algorithm.datastructure.trie;


import java.util.HashMap;
import java.util.Map;

/**
 * @fileName: MapSum.java
 * @description: LeetCode677
 * @author: by echo huang
 * @date: 2020/11/3 11:57 下午
 */
public class MapSum {

    private class Node {
        private int value;
        private Map<Character, Node> next;

        public Node(int value) {
            this.value = value;
            next = new HashMap<>();
        }

        public Node() {
            this(0);
        }
    }

    private Node root;

    public MapSum() {
        root = new Node();
    }

    public void insert(String key, int val) {
        Node cur = this.root;
        for (int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);
            if (!cur.next.containsKey(c)) {
                cur.next.put(c, new Node());
            }
            cur = cur.next.get(c);
        }
        cur.value = val;
    }

    public int sum(String prefix) {
        Node cur = this.root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (!cur.next.containsKey(c)) {
                return 0;
            }
            cur = cur.next.get(c);
        }
        return sum(cur);
    }

    private int sum(Node node) {
        if (node.next.size() == 0) {
            return node.value;
        }
        int result = node.value;
        for (Character c : node.next.keySet()) {
            result += sum(node.next.get(c));
        }
        return result;
    }


    public static void main(String[] args) {
        MapSum mapSum = new MapSum();
        mapSum.insert("apple", 3);
        System.out.println(mapSum.sum("ap"));
        mapSum.insert("app", 2);
        System.out.println(mapSum.sum("ap"));


    }
}
