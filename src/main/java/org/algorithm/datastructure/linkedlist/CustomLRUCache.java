package org.algorithm.datastructure.linkedlist;

import java.util.HashMap;

/**
 * @fileName: CustomLRUCache.java
 * @description: 基于自定义双链表实现的LRU算法
 * @author: by echo huang
 * @date: 2020/10/30 5:05 下午
 */
public class CustomLRUCache {
    private HashMap<Integer, DoubleList.Node> map;
    private DoubleList cache;
    private int cap;

    public CustomLRUCache(int cap) {
        this.cap = cap;
        this.map = new HashMap<>();
        this.cache = new DoubleList();
    }

    // 将k提升为最近使用的k
    private void makeRecently(int key) {
        DoubleList.Node node = map.get(key);
        cache.remove(node);
        cache.addLast(node);
    }

    private void addRecently(int key, int val) {
        DoubleList.Node node = new DoubleList.Node(key, val);
        cache.addLast(node);
        map.put(key, node);
    }

    private void deleteKey(int key) {
        DoubleList.Node node = map.remove(key);
        cache.remove(node);
    }

    private void removeLeastRecently() {
        DoubleList.Node removeFirstNode = cache.removeFirst();
        map.remove(removeFirstNode.key);
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        makeRecently(key);
        return map.get(key).value;
    }

    public void put(int key, int value) {

        if (map.containsKey(key)) {
            deleteKey(key);
            addRecently(key, value);
            return;
        }
        if (cap == cache.size()) {
            removeLeastRecently();
        }
        addRecently(key, value);
    }
}
