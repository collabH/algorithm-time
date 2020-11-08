package org.datastructure.hashtable;

import java.util.TreeMap;

/**
 * @fileName: HashTable.java
 * @description: HashTable.java类说明
 * @author: by echo huang
 * @date: 2020/11/8 6:35 下午
 */
public class HashTable<K, V> {

    private TreeMap<K, V>[] hashTable;

    private int size;
    private int M;

    public HashTable(int m) {
        M = m;
        size = 0;
        hashTable = new TreeMap[M];
        for (int i = 0; i < hashTable.length; i++) {
            hashTable[i] = new TreeMap<>();
        }
    }

    public HashTable() {
        this(97);
    }

    private int hash(K key) {
        // 消除key的hashCode的符号
        return (key.hashCode() & 0x7fffffff) % M;
    }

    public void add(K key, V value) {
        int hash = hash(key);
        if (hashTable[hash].containsKey(key)) {
            hashTable[hash].put(key, value);
        } else {
            hashTable[hash].put(key, value);
            size++;
        }
    }

    public V remove(K key) {
        int hash = hash(key);
        TreeMap<K, V> map = hashTable[hash];
        V ret = null;
        if (map.containsKey(key)) {
            ret = map.remove(key);
            size--;
        }
        return ret;
    }

    public void set(K key, V value) {
        TreeMap<K, V> map = hashTable[hash(key)];
        if (!map.containsKey(key)) {
            throw new IllegalArgumentException();
        }
        map.put(key, value);
    }

    public V get(K key) {
        return hashTable[hash(key)].get(key);
    }
}
