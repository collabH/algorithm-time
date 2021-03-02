package org.datastructure.trie;

import java.util.TreeMap;

/**
 * @fileName: Trie.java
 * @description: Trie.java类说明
 * @author: by echo huang
 * @date: 2020/11/3 10:52 下午
 */
public class Trie {
    private static class Node {
        //是否是一个单词
        public boolean isWord;
        // 存储下一个单词节点
        public TreeMap<Character, Node> next;

        public Node(boolean isWord) {
            this.isWord = isWord;
            next = new TreeMap<>();
        }

        public Node() {
            this(false);
        }
    }

    private Node root;
    private int size;

    public Trie() {
        root = new Node();
        size = 0;
    }

    public int size() {
        return size;
    }

    public void add(String word) {
        Node cur = this.root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            // 如果不包含则添加至next中
            if (!cur.next.containsKey(c)) {
                cur.next.put(c, new Node());
            }
            // 获取c字符的next
            cur = cur.next.get(c);
        }
        // 走完一个单词后，如果该单词字符不是一个单词则设置为单词标示
        if (!cur.isWord) {
            cur.isWord = true;
        }
        size++;
    }

    public boolean contains(String word) {
        Node cur = this.root;
        // 遍历word，判断是否在字典树中
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!cur.next.containsKey(c)) {
                return false;
            }
            cur = cur.next.get(c);
        }
        return cur.isWord;
    }

    public boolean isPrefix(String prefix) {
        Node cur = this.root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (!cur.next.containsKey(c)) {
                return false;
            }
            cur = cur.next.get(c);
        }
        return true;
    }


    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.add("1261109615");
        trie.add("9999999999");
        trie.add("15093231212");
        trie.add("23412353512");
        System.out.println(trie.contains("1261109615"));
    }
}
