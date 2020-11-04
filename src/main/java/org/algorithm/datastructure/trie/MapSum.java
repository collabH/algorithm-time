package org.algorithm.datastructure.trie;


/**
 * @fileName: MapSum.java
 * @description: LeetCode677
 * @author: by echo huang
 * @date: 2020/11/3 11:57 下午
 */
public class MapSum {

    private Node root;

    /**
     * Initialize your data structure here.
     */
    public MapSum() {
        root = new Node();
    }

    public void insert(String key, int val) {
        Node node = root;
        char[] charArray = key.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            int idx = charArray[i] - 'a';
            if (node.children[idx] == null) {
                node.children[idx] = new Node();
            }
            node = node.children[idx];
        }
        // 遍历结束
        node.value = val;
    }

    public int sum(String prefix) {
        if (prefix == null) return 0;
        Node node = root;
        char[] charArray = prefix.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            int idx = charArray[i] - 'a';
            if (node.children[idx] == null) return 0;
            node = node.children[idx];
        }
        return dfs(node);
    }

    private int dfs(Node node) {
        if (node == null) return 0;
        int res = node.value;
        for (Node child : node.children) {
            res += dfs(child);
        }
        return res;
    }

    class Node {
        Node[] children;
        int value;

        public Node() {
            children = new Node[26];
        }
    }


    public static void main(String[] args) {
        MapSum mapSum = new MapSum();
        mapSum.insert("apple", 3);
        System.out.println(mapSum.sum("ap"));
        mapSum.insert("app", 2);
        System.out.println(mapSum.sum("ap"));


    }
}
