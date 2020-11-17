package org.algorithm.datastructure.queue;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @fileName: LeetCode279.java
 * @description: LeetCode279.java类说明
 * @author: by echo huang
 * @date: 2020/11/17 9:48 下午
 */
public class LeetCode279 {
    public static int numSquares(int n) {
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];
        // 存入当前数和要走的步数
        queue.add(new Pair<>(n, 0));
        while (!queue.isEmpty()) {
            // 获取步数
            Pair<Integer, Integer> cur = queue.poll();
            // 获取数字
            Integer num = cur.getKey();
            // 步数
            Integer step = cur.getValue();
            // 遍历使得i从1开始，找到最大的平方数
            for (int i = 1; ; i++) {
                int a = num - i * i;
                if (a < 0) break;
                if (a == 0) return step + 1;
                if (!visited[a]) {
                    queue.add(new Pair<>(a, step + 1));
                    visited[a] = true;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(numSquares(12));
    }
}
