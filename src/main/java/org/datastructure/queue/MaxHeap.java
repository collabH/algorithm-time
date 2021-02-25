package org.datastructure.queue;

import org.datastructure.array.Arr;

import java.rmi.MarshalledObject;

/**
 * @fileName: PriorityQueue.java
 * @description: 自定义优先级队列
 * @author: by echo huang
 * @date: 2020/11/1 2:06 下午
 */
public class MaxHeap<E extends Comparable<E>> {
    // 底层使用数组实现
    private Arr<E> data;

    public MaxHeap(int cap) {
        data = new Arr<>(cap);
    }

    public MaxHeap() {
        data = new Arr<>();
    }

    public int size() {
        return data.size();
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    // 返回完全二叉树的数组表示中，一个索引所表示的元素的父亲节点的索引
    private int parent(int index) {
        if (index == 0) {
            throw new IllegalArgumentException();
        }
        return (index - 1) / 2;
    }

    private int leftChild(int index) {
        return index * 2 + 1;
    }

    private int rightChild(int index) {
        return index * 2 + 2;
    }

    public void add(E e) {
        data.addLast(e);
        // 上浮
        siftUp(data.size() - 1);
    }

    public E findMax() {
        if (data.size() == 0) {
            throw new NullPointerException();
        }
        return data.get(0);
    }

    public E extractMax() {
        E max = findMax();
        data.swap(0, data.size() - 1);
        data.remove(data.size() - 1);
        // 下层0
        siftDown(0);
        return max;
    }

    /**
     * 满足最大堆特性
     * 上升
     *
     * @param index
     */
    private void siftUp(int index) {
        // 如果index的parent小于index，则切换parent和index的位置，并且index赋值为parent
        while (index > 0 && data.get(parent(index)).compareTo(data.get(index)) < 0) {
            data.swap(parent(index), index);
            index = parent(index);
        }
    }

    /**
     * 下沉
     *
     * @param index
     */
    private void siftDown(int index) {
        while (leftChild(index) < data.size()) {
            // 找到index的左孩子
            int j = leftChild(index);
            // 左index+1小于数据大小并且获取左index+1大于左
            if (j + 1 < data.size() && data.get(j + 1).compareTo(data.get(j)) > 0) {
                j = rightChild(index);
            }
            if (data.get(index).compareTo(data.get(j)) >= 0) {
                break;
            }
            data.swap(index, j);
            index = j;
        }
    }

    /**
     * 将最大的max替换为新加的e
     *
     * @param e
     * @return
     */
    public E replace(E e) {
        E max = findMax();
        data.add(0, e);
        siftDown(0);
        return max;
    }


    @Override
    public String toString() {
        return "MaxHeap{" +
                "data=" + data +
                '}';
    }

    public static void main(String[] args) {
        MaxHeap<Integer> map = new MaxHeap<>();
        map.add(1);
        map.add(3);
        map.add(5);
        map.add(100);
        System.out.println(map.findMax());

        System.out.println(map);

        System.out.println(map.extractMax());
        System.out.println(map);

        map.replace(7);
        System.out.println(map);
    }
}
