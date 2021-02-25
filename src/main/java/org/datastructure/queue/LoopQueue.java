package org.datastructure.queue;

import java.util.Arrays;

/**
 * @fileName: LoopQueue.java
 * @description: 循环队列
 * @author: by echo huang
 * @date: 2020/10/20 10:44 下午
 */
public class LoopQueue<E> implements Queue<E> {

    // 循环队列存储数据数组
    private E[] data;
    // 队首索引
    private int front;
    // 队尾索引
    private int tail;

    private int size;

    public LoopQueue(int cap) {
        /**
         * 会浪费一个位置，front==tail为null front==tail+1 队列满
         */
        this.data = (E[]) new Object[cap + 1];
    }

    public LoopQueue() {
        this(10);
    }

    public int getCap() {
        return data.length - 1;
    }

    private boolean isValid() {
        // 防止数据越界
        return (this.tail + 1) % data.length == front;
    }

    private void resize(int cap) {
        //扩容，重新创建队列
        E[] resizeQueue = (E[]) new Object[cap + 1];
        // 遍历历史队列，将数组放入新队列位置
        for (int i = 0; i < size; i++) {
            // 防止数组越界
            resizeQueue[i] = data[(i + front) % data.length];
        }
        data = resizeQueue;
        front = 0;
        tail = size;
    }

    @Override
    public void enqueue(E e) {
        // 扩容
        if (isValid()) {
            resize(getCap() * 2);
        }
        this.data[this.tail] = e;
        tail = (tail + 1) % data.length;
        size++;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new NullPointerException("循环队列为空");
        }
        E ret = data[front];
        // help gc
        data[front] = null;
        front = (front + 1) % data.length;
        size--;
        // lazy 缩容
        if (this.size == getCap() / 4 && getCap() / 2 != 0) {
            resize(getCap() / 2);
        }
        return ret;
    }

    @Override
    public E getFront() {
        if (isEmpty()) {
            throw new NullPointerException("循环队列为空");
        }
        return data[front];
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return this.front == this.tail;
    }

    @Override
    public String toString() {
        return "LoopQueue{" +
                "data=" + Arrays.toString(data) +
                ", front=" + front +
                ", tail=" + tail +
                ", size=" + size +
                '}';
    }

    public static void main(String[] args) {
        LoopQueue<Integer> loopQueue = new LoopQueue<>();
        for (int i = 0; i < 4; i++) {
            loopQueue.enqueue(i);
        }
        System.out.println(loopQueue.getCap());
        System.out.println(loopQueue.dequeue());
        System.out.println(loopQueue.getFront());
        System.out.println(loopQueue);
    }
}
