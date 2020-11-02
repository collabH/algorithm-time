package org.algorithm.datastructure.linkedlist;

import java.util.HashMap;
import java.util.LinkedHashSet;

/**
 * LFUCache
 */
class LFUCache {
    // key 到 val 的映射，我们后文称为 KV 表
    HashMap<Integer, Integer> keyToVal;
    // key 到 freq 的映射，我们后文称为 KF 表
    HashMap<Integer, Integer> keyToFreq;
    // freq 到 key 列表的映射，我们后文称为 FK 表
    HashMap<Integer, LinkedHashSet<Integer>> freqToKeys;
    // 记录最小的频次
    int minFreq;
    // 记录 LFU 缓存的最大容量
    int cap;

    public LFUCache(int capacity) {
        keyToVal = new HashMap<>();
        keyToFreq = new HashMap<>();
        freqToKeys = new HashMap<>();
        this.cap = capacity;
        this.minFreq = 0;
    }


    public int get(int key) {
        if (!keyToVal.containsKey(key)) {
            return -1;
        }
        increaseFreq(key);
        return keyToVal.get(key);
    }

    /**
     * 增加key的freq
     *
     * @param key 增加freq的key
     */
    private void increaseFreq(int key) {
        Integer oldFreq = keyToFreq.getOrDefault(key, 0);
        Integer newFreq = oldFreq + 1;
        // 操作kf
        keyToFreq.put(key, newFreq);
        LinkedHashSet<Integer> oldKeyList = freqToKeys.get(oldFreq);
        // 将其移除
        oldKeyList.remove(key);
        if (oldKeyList.isEmpty()) {
            freqToKeys.remove(oldFreq);
            if (oldFreq == this.minFreq) {
                this.minFreq++;
            }
        }
        freqToKeys.putIfAbsent(newFreq, new LinkedHashSet<>());
        freqToKeys.get(newFreq).add(key);
    }

    public void put(int key, int value) {
        if (this.cap <= 0) {
            return;
        }
        if (keyToVal.containsKey(key)) {
            keyToVal.put(key, value);
            increaseFreq(key);
            return;
        }
        while (this.cap <= keyToVal.size()) {
            removeMinFreqKey();
        }
        keyToVal.put(key, value);
        keyToFreq.put(key, 1);
        freqToKeys.putIfAbsent(1, new LinkedHashSet<>());
        freqToKeys.get(1).add(key);
        this.minFreq = 1;
    }

    /**
     * 移除最小的freq的key
     */
    private void removeMinFreqKey() {
        // 找到最小freq的keyList
        LinkedHashSet<Integer> keyList = freqToKeys.get(this.minFreq);
        if (keyList == null) {
            return;
        }
        // 第一个元素，最先被插入的key
        Integer deletedKey = keyList.iterator().next();
        keyList.remove(deletedKey);
        // 如果keyList为空，移除该最小freq
        if (keyList.isEmpty()) {
            freqToKeys.remove(this.minFreq);
        }
        keyToFreq.remove(deletedKey);
        keyToVal.remove(deletedKey);
    }
}
