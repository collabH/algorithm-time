package org.algorithm.recall;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @fileName: NQueue.java
 * @description: n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * @author: by echo huang
 * @date: 2020/10/16 5:00 下午
 */
public class NQueue {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> solutions = new ArrayList<List<String>>();
        int[] queens = new int[n];
        Arrays.fill(queens, -1);
        Set<Integer> columns = new HashSet<Integer>();
        Set<Integer> diagonals1 = new HashSet<Integer>();
        Set<Integer> diagonals2 = new HashSet<Integer>();
        backtrack(solutions, queens, n, 0, columns, diagonals1, diagonals2);
        return solutions;
    }

    /**
     * @param solutions  怕列结果
     * @param queens     皇后数组
     * @param n          皇后数量
     * @param row        当前行数
     * @param columns    列存储
     * @param diagonals1 斜线1
     * @param diagonals2 斜线2
     */
    public void backtrack(List<List<String>> solutions, int[] queens, int n, int row, Set<Integer> columns, Set<Integer> diagonals1, Set<Integer> diagonals2) {
        // 如果行数和皇后数相同表示结束条件
        if (row == n) {
            List<String> board = generateBoard(queens, n);
            solutions.add(board);
            return;
        }
        // 遍历行
        for (int i = 0; i < n; i++) {
            // 做选择，如果该列已经存在数据则不能在放置queue
            if (columns.contains(i)) {
                continue;
            }
            // 从左到右的斜行，在同一斜行上能得出 行1-列1=行2-列2
            int diagonal1 = row - i;
            if (diagonals1.contains(diagonal1)) {
                continue;
            }
            // 从右到左的斜行，在同一斜行上能得出 行1+列1=行2+列2
            int diagonal2 = row + i;
            if (diagonals2.contains(diagonal2)) {
                continue;
            }
            // row queue放置的位置
            queens[row] = i;
            // 该列加入columns中
            columns.add(i);
            diagonals1.add(diagonal1);
            diagonals2.add(diagonal2);
            backtrack(solutions, queens, n, row + 1, columns, diagonals1, diagonals2);
            // 走不通进行回溯
            queens[row] = -1;
            columns.remove(i);
            diagonals1.remove(diagonal1);
            diagonals2.remove(diagonal2);
        }
    }

    /**
     * 替换字符串
     *
     * @param queens
     * @param n
     * @return
     */
    public List<String> generateBoard(int[] queens, int n) {
        List<String> board = new ArrayList<String>();
        for (int i = 0; i < n; i++) {
            char[] row = new char[n];
            Arrays.fill(row, '.');
            row[queens[i]] = 'Q';
            board.add(new String(row));
        }
        return board;
    }

}
