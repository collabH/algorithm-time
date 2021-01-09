package org.datastructure.stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @fileName: QueueStack.java
 * @description: QueueStack.java类说明
 * @author: by echo huang
 * @date: 2020/11/4 3:06 下午
 */
public class QueueStack {
    private Queue<Integer> queue;

    /**
     * Initialize your data structure here.
     */
    public QueueStack() {
        queue = new LinkedList<>();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        // a
        int n = queue.size();
        queue.offer(x);
        // n=1
        // 将x之前的元素重新入队, a->x
        // n=2
        // x->a->b ==> a->b->x
        // 这里每次将除了新加的元素拿出来重新放入队列，这样就可以保证先进来的元素变成后进的元素，后进的元素放入队列的头部，然后满足了栈的特性
        for (int i = 0; i < n; i++) {
            queue.offer(queue.poll());
        }
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        return queue.poll();
    }

    /**
     * Get the top element.
     */
    public int top() {
        return queue.peek();
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return queue.isEmpty();
    }

    public static void main(String[] args) {
        QueueStack queueStack = new QueueStack();
        queueStack.push(1);
        queueStack.push(2);
        queueStack.push(3);
        System.out.println(queueStack.pop());
        System.out.println(queueStack.pop());
        System.out.println(queueStack.pop());
    }
}
