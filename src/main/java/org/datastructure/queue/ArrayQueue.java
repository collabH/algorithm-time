package org.datastructure.queue;

import org.datastructure.array.Arr;

/**
 * @fileName: ArrayQueue.java
 * @description: ArrayQueue.java类说明
 * @author: by echo huang
 * @date: 2020/10/20 10:14 下午
 */
public class ArrayQueue<E> implements Queue<E> {
    private Arr<E> data;

    public ArrayQueue(int cap) {
        this.data = new Arr<>(cap);
    }

    public ArrayQueue() {
        this(10);
    }


    @Override
    public void enqueue(E e) {
        // 向数组尾部插入数据
        this.data.addLast(e);
    }

    @Override
    public E dequeue() {
        // 移除头部数据，最早的数据越靠近头部
        return this.data.remove(0);
    }

    @Override
    public E getFront() {
        return this.data.get(0);
    }

    @Override
    public int getSize() {
        return this.data.size();
    }

    @Override
    public boolean isEmpty() {
        return this.data.isEmpty();
    }

    @Override
    public String toString() {
        return "ArrayQueue{" +
                "data=" + data +
                '}';
    }

    public static void main(String[] args) {
        ArrayQueue<Integer> queue= new ArrayQueue<>();
        for (int i = 0; i < 5; i++) {
            queue.enqueue(i);
        }
        System.out.println(queue);
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue);
        System.out.println(queue.getFront());
        System.out.println(queue);
    }
}
