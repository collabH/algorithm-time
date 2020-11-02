package org.datastructure.queue;

/**
 * @fileName: PriorityQueue.java
 * @description: PriorityQueue.java类说明
 * @author: by echo huang
 * @date: 2020/11/1 10:08 下午
 */
public class PriorityQueue<E extends Comparable<E>> implements Queue<E> {

    private MaxHeap<E> maxHeap;

    public PriorityQueue() {
        maxHeap = new MaxHeap<>();
    }

    @Override
    public void enqueue(E e) {
        maxHeap.add(e);
    }

    @Override
    public E dequeue() {
        return maxHeap.extractMax();
    }

    @Override
    public E getFront() {
        return maxHeap.findMax();
    }

    @Override
    public int getSize() {
        return maxHeap.size();
    }

    @Override
    public boolean isEmpty() {
        return maxHeap.isEmpty();
    }

    @Override
    public String toString() {
        return "PriorityQueue{" +
                "maxHeap=" + maxHeap +
                '}';
    }

    public static void main(String[] args) {
        Queue<Integer> queue=new PriorityQueue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(5);
        queue.enqueue(10);
        System.out.println(queue);
        System.out.println(queue.dequeue());
        System.out.println(queue);
        System.out.println(queue.getFront());
        System.out.println(queue);
    }
}
