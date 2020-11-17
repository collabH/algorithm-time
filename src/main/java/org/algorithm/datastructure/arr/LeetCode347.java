package org.algorithm.datastructure.arr;


import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;

/**
 * @fileName: LeetCode347.java
 * @description: 前K个高频元素
 * @author: by echo huang
 * @date: 2020/11/1 10:17 下午
 */
public class LeetCode347 {

    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> occurrences = new HashMap<>(nums.length);
        for (int num : nums) {
            occurrences.put(num, occurrences.getOrDefault(num, 0) + 1);
        }

        // int[] 的第一个元素代表数组的值，第二个元素代表了该值出现的次数
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>(new Comparator<int[]>() {
            @Override
            public int compare(int[] m, int[] n) {
                return m[1] - n[1];
            }
        });
        for (Map.Entry<Integer, Integer> entry : occurrences.entrySet()) {
            int num = entry.getKey(), count = entry.getValue();
            // 如果等于k
            if (queue.size() == k) {
                assert queue.peek() != null;
                // 最小堆堆顶小于count，替换位置
                if (queue.peek()[1] < count) {
                    queue.poll();
                    queue.offer(new int[]{num, count});
                }
            } else {
                queue.offer(new int[]{num, count});
            }
        }
        int[] ret = new int[k];
        for (int i = 0; i < k; ++i) {
            ret[i] = Objects.requireNonNull(queue.poll())[0];
        }
        return ret;
    }

    public static void main(String[] args) {

        System.out.println(Arrays.toString(topKFrequent(new int[]{1, 1, 2, 2, 2, 3, 4}, 2)));
    }
}
