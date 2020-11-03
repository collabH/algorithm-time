package org.algorithm.datastructure.custom;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @fileName: LeetCode295.java
 * @description: 数据流的中位数
 * @author: by echo huang
 * @date: 2020/11/3 4:48 下午
 */
public class LeetCode295 {
    private PriorityQueue<Integer> large;
    private PriorityQueue<Integer> small;

    /**
     * initialize your data structure here.
     */
    public LeetCode295() {
        large = new PriorityQueue<>();
        small = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
    }

    /**
     * 需要维持small和large元素最大相差1
     *
     * @param num
     */
    public void addNum(int num) {
        // 如果small元素大于large元素
        if (small.size() >= large.size()) {
            // 新增数据插入small中，然后将samll中最大元素让入large中
            small.offer(num);
            large.offer(small.poll());
            // 否则新增元素放入large中，将最小元素放入small中
        } else {
            large.offer(num);
            small.offer(large.poll());
        }
    }

    public double findMedian() {
        if (large.isEmpty() && small.isEmpty()) {
            return 0.0;
        }
        if (large.size() < small.size()) {
            return small.peek();
        } else if (large.size() > small.size()) {
            return large.peek();
        }
        return (large.peek() + small.peek()) / 2.0;
    }

}
