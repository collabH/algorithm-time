package org.datastructure.set;

import org.datastructure.linkedlist.LinkedList;
import org.datastructure.linkedlist.LinkedListStack;

import java.util.HashMap;
import java.util.Map;

/**
 * @fileName: LinkedListSet.java
 * @description: LinkedListSet.java类说明
 * @author: by echo huang
 * @date: 2020/10/29 10:02 下午
 */
public class LinkedListSet<E> implements Set<E> {
    private LinkedList<E> data;
    private Map<E, Integer> offset;

    public LinkedListSet() {
        this.data = new LinkedList<>();
        offset = new HashMap<>();
    }

    @Override
    public void add(E e) {
        if (!contains(e)) {
            int size = size();
            offset.put(e, size);
            data.add(size, e);
        }
    }

    @Override
    public void remove(E e) {
        Integer index = offset.get(e);
        data.remove(index);
    }

    @Override
    public boolean contains(E e) {
        return data.contains(e);
    }

    @Override
    public int size() {
        return data.getSize();
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    @Override
    public String toString() {
        return data.toString();
    }

    public static void main(String[] args) {
        LinkedListSet<Integer> set = new LinkedListSet<>();
        set.add(1);
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(3);
        System.out.println(set);
        set.remove(3);
        System.out.println(set);
        System.out.println(set.contains(2));
        System.out.println(set.size());
        System.out.println(set.isEmpty());
    }
}
