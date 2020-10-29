package org.datastructure.set;

/**
 * @fileName: Set.java
 * @description: Set.java类说明
 * @author: by echo huang
 * @date: 2020/10/29 9:46 下午
 */
public interface Set<E> {
    void add(E e);

    void remove(E e);

    boolean contains(E e);

    int size();

    boolean isEmpty();
}
