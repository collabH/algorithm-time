package org.datastructure.map;

/**
 * @fileName: Map.java
 * @description: Map.java类说明
 * @author: by echo huang
 * @date: 2020/10/29 10:54 下午
 */
public interface Map<K, V> {
    void add(K k, V v);

    V remove(K k);

    boolean contains(K k);

    V get(K k);

    int size();

    void set(K k, V v);

    boolean isEmpty();
}
