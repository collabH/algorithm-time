package org.algorithm.datastructure.linkedlist;

import java.util.LinkedHashMap;

/**
 * @fileName: LeetCode146.java
 * @description: LRU
 * @author: by echo huang
 * @date: 2020/10/30 4:36 下午
 */
public class LRU {
    private LinkedHashMap<Integer, Integer> cache;
    private int cap;

    public LRU(int cap) {
        this.cache = new LinkedHashMap<>(cap);
        this.cap = cap;
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        makeRecently(key);
        return cache.get(key);
    }

    public void put(int key, int value) {
        if (!cache.containsKey(key)) {
            cache.put(key, value);
            makeRecently(key);
            return;
        }
        while (cache.size() >= cap) {
            Integer oldestKey = cache.keySet().iterator().next();
            cache.remove(oldestKey);
        }
        cache.put(key, value);
    }


    // 重新将其移动到链表尾部
    private void makeRecently(int key) {
        Integer value = cache.get(key);
        cache.remove(key);
        cache.put(key, value);
    }
}
