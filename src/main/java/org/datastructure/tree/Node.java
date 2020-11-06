package org.datastructure.tree;

/**
 * @fileName: Node.java
 * @description: Tree Node
 * @author: by echo huang
 * @date: 2020/10/25 11:22 下午
 */
public class Node<E> {
    public E e;
    public Node<E> left, right;
    public int height;

    public Node(E e) {
        this.e = e;
        height = 1;
        left = null;
        right = null;
    }
}
