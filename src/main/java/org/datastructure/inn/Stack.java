package org.datastructure.inn;

/**
 * @fileName: Stack.java
 * @description: Stack.java类说明
 * @author: by echo huang
 * @date: 2020/10/19 7:45 下午
 */
public interface Stack<E> {
    int getSize();

    boolean isEmpty();

    void push(E e);

    E pop();

    E peek();
}
