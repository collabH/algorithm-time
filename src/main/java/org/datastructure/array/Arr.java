package org.datastructure.array;

import java.util.Arrays;

/**
 * @fileName: Arr.java
 * @description: 数组, 参考ArrayList
 * @author: by echo huang
 * @date: 2020/10/18 1:03 下午
 */
public class Arr<E> {
    public static void main(String[] args) {
        Arr<Integer> arr = new Arr<Integer>();
        arr.addLast(1);
        arr.addLast(2);
        arr.addLast(3);
        System.out.println(arr);
        System.out.println(arr.remove(1));
        System.out.println(arr);
    }

    private final E[] data;

    private int size;

    public Arr() {
        this(10);
    }

    /**
     * 初始化数组
     *
     * @param cap
     */
    public Arr(int cap) {
        data = (E[]) new Object[cap];
        this.size = 0;
    }

    public int size() {
        return this.size;
    }

    public int cap() {
        return data.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addLast(E element) {
        add(size, element);
    }

    public void add(int index, E element) {
        valid();
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("超出容量");
        }
        System.arraycopy(data, index, data, index + 1, size - index);
        data[index] = element;
        size++;
    }

    private void valid() {
        // fixme 需要判断是否超过容量
        if (size == cap()) {
            throw new IllegalArgumentException("超出容量");
        }
    }

    public E get(int index) {
        return data[index];
    }

    public E remove(int index) {
        E[] data = this.data;
        valid();
        E removeData = data[index];
        System.arraycopy(data, index + 1, data, index, size - index);
        // help gc
        data[size] = null;
        size--;
        return removeData;
    }

    @Override
    public String toString() {
        return "Arr{" +
                "data=" + Arrays.toString(data) +
                ", size=" + size +
                '}';
    }
}
