package org.datastructure.queue;


import java.util.Stack;

/**
 * @fileName: LeetCode232.java
 * @description: 用栈实现队列
 * @author: by echo huang
 * @date: 2020/11/4 2:52 下午
 */
public class StackQueue {

    private Stack<Integer> left;
    private Stack<Integer> right;

    /**
     * Initialize your data structure here.
     */
    public StackQueue() {
        left = new Stack<>();
        right = new Stack<>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        left.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        if (right.isEmpty()){
            transform();
        }
        return right.pop();
    }

    private void transform() {
        while (!left.isEmpty()) {
            right.push(left.pop());
        }
    }

    /**
     * Get the front element.
     */
    public int peek() {
        if (right.isEmpty()){
            transform();
        }
        return right.peek();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return right.isEmpty() && left.isEmpty();
    }

    public static void main(String[] args) {
        StackQueue stackQueue = new StackQueue();
        stackQueue.push(1);
        stackQueue.push(2);
        stackQueue.push(3);
        stackQueue.push(4);
        stackQueue.push(-10);

        System.out.println(stackQueue.pop());
        System.out.println(stackQueue.pop());
        System.out.println(stackQueue.pop());
        System.out.println(stackQueue.pop());
        stackQueue.push(5);
        System.out.println(stackQueue.pop());
        System.out.println(stackQueue.pop());
    }
}
