package org.datastructure.set;

import org.datastructure.tree.BinarySearchTree;

/**
 * @fileName: BSTSet.java
 * @description: BSTSet.java类说明
 * @author: by echo huang
 * @date: 2020/10/29 9:47 下午
 */
public class BSTSet<E extends Comparable<E>> implements Set<E> {
    private BinarySearchTree<E> data;

    public BSTSet() {
        data = new BinarySearchTree<>();
    }

    @Override
    public void add(E e) {
        data.add(e);
    }

    @Override
    public void remove(E e) {
        data.remove(e);
    }

    @Override
    public boolean contains(E e) {
        return data.contains(e);
    }

    @Override
    public int size() {
        return data.size();
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
        Set<Integer> set = new BSTSet<>();
        set.add(1);
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(3);

        System.out.println(set);
    }
}
