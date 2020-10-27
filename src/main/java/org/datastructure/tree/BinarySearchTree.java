package org.datastructure.tree;

/**
 * @fileName: BinarySearchTree.java
 * @description: 二分搜索树
 * @author: by echo huang
 * @date: 2020/10/27 1:24 下午
 */
public class BinarySearchTree<E extends Comparable<E>> {
    private Node<E> root;
    private int size;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(E e) {
        if (root == null) {
            root = new Node<>(e);
            return;
        }
        if (root.e.compareTo(e) > 0) {

        } else {

        }
    }
}
