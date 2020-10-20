package org.datastructure.queue;

/**
 * @fileName: Queue.java
 * @description: 队列
 * @author: by echo huang
 * @date: 2020/10/20 10:14 下午
 */
public interface Queue<E> {
    void enqueue(E e);

    E dequeue();

    E getFront();

    int getSize();

    boolean isEmpty();
}
