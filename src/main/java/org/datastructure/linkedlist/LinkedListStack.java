package org.datastructure.linkedlist;

import org.datastructure.stack.Stack;

/**
 * @fileName: LinkedListStack.java
 * @description: LinkedListStack.java类说明
 * @author: by echo huang
 * @date: 2020/10/21 11:56 下午
 */
public class LinkedListStack<E> implements Stack<E> {
    private LinkedList<E> data;

    public LinkedListStack() {
        this.data = new LinkedList<>();
    }

    @Override
    public int getSize() {
        return data.getSize();
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    @Override
    public void push(E e) {
        data.addFirst(e);
    }

    @Override
    public E pop() {
        E first = data.getFirst();
        data.remove(0);
        return first;
    }

    @Override
    public E peek() {
        return data.getFirst();
    }

    @Override
    public String toString() {
        return "LinkedListStack{" +
                "data=" + data +
                '}';
    }

    public static void main(String[] args) {
        LinkedListStack<Integer> stack = new LinkedListStack<>();
        for (int i = 0; i < 4; i++) {
            stack.push(i);
        }
        System.out.println(stack.pop());
        System.out.println(stack);
        System.out.println(stack.peek());
        System.out.println(stack);
    }
}
