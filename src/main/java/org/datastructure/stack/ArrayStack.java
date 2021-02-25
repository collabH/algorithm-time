package org.datastructure.stack;

import org.datastructure.array.Arr;

/**
 * @fileName: ArrayStack.java
 * @description: ArrayStack.java类说明
 * @author: by echo huang
 * @date: 2020/10/19 7:45 下午
 */
public class ArrayStack<E> implements Stack<E> {
    public static void main(String[] args) {
        Stack<Integer> stack = new ArrayStack<>();
        for (int i = 0; i < 5; i++) {
            stack.push(i);
        }
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        System.out.println(stack);

    }
    // 底层数据存储为数组
    Arr<E> array;

    public ArrayStack(int cap) {
        this.array = new Arr<>(cap);
    }

    public ArrayStack() {
        this.array = new Arr<>();
    }

    @Override
    public int getSize() {
        return array.size();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    /**
     * 向数组尾部插入数据
     * @param e
     */
    @Override
    public void push(E e) {
        array.addLast(e);
    }

    /**
     * 从尾部获取数据
     * @return
     */
    @Override
    public E pop() {
        return array.remove(array.size() - 1);
    }

    @Override
    public E peek() {
        return array.get(array.size() - 1);
    }

    @Override
    public String toString() {
        return "ArrayStack{" +
                "array=" + array +
                '}';
    }
}
