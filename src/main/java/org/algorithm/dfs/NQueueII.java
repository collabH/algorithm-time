package org.algorithm.dfs;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @fileName: NQueueII.java
 * @description: 求N皇后解法的数量
 * @author: by echo huang
 * @date: 2020/10/16 5:46 下午
 */
public class NQueueII {
    int count = 0;

    public static void main(String[] args) {
        NQueueII nQueueII = new NQueueII();
        System.out.println(nQueueII.totalNQueens(8));
    }

    public int totalNQueens(int n) {
        Set<Integer> columns = new HashSet<>();
        // 斜线1
        Set<Integer> x1 = new HashSet<>();
        // 斜线2
        Set<Integer> x2 = new HashSet<>();

        int[] queens = new int[n];
        Arrays.fill(queens, -1);

        return backtrack(0, n, queens, columns, x1, x2);

    }

    int backtrack(int row, int n, int[] queens, Set<Integer> columns, Set<Integer> x1, Set<Integer> x2) {

        // 结束条件
        if (row == n) {
            count++;
        } else {
            for (int i = 0; i < n; i++) {
                if (columns.contains(i)) {
                    continue;
                }
                int x11 = row - i;
                if (x1.contains(x11)) {
                    continue;
                }
                int x22 = row + i;
                if (x2.contains(x22)) {
                    continue;
                }
                columns.add(i);
                x1.add(x11);
                x2.add(x22);
                queens[row] = i;
                backtrack(row + 1, n, queens, columns, x1, x2);
                queens[row] = -1;
                columns.remove(i);
                x1.remove(x11);
                x2.remove(x22);
            }
        }
        return count;
    }
}
