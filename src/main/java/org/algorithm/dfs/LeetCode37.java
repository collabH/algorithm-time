package org.algorithm.dfs;

/**
 * @fileName: LeetCode37.java
 * @description: 解数独
 * @author: by echo huang
 * @date: 2020/11/13 4:51 下午
 */
public class LeetCode37 {
    public void solveSudoku(char[][] board) {
        dfs(board, 0, 0);
    }

    /**
     * @param board
     * @param lines
     * @param columns
     * @return
     */
    boolean dfs(char[][] board, int lines, int columns) {
        int m = 9, n = 9;
        if (columns == n) {
            // 穷举到最后一列的话就换到下一行重新开始。
            return dfs(board, lines + 1, 0);
        }
        if (lines == m) {
            // 找到一个可行解，触发 base case
            return true;
        }

        if (board[lines][columns] != '.') {
            // 如果有预设数字，不用我们穷举
            return dfs(board, lines, columns + 1);
        }

        for (char ch = '1'; ch <= '9'; ch++) {
            // 如果遇到不合法的数字，就跳过
            if (!isValid(board, lines, columns, ch))
                continue;

            board[lines][columns] = ch;
            // 如果找到一个可行解，立即结束
            if (dfs(board, lines, columns + 1)) {
                return true;
            }
            // 撤销选择
            board[lines][columns] = '.';
        }
        // 穷举完 1~9，依然没有找到可行解，此路不通
        return false;
    }

    // 判断 board[i][j] 是否可以填入 n
    boolean isValid(char[][] board, int lines, int columns, char ch) {
        for (int i = 0; i < 9; i++) {
            // 判断行是否存在重复
            if (board[lines][i] == ch) return false;
            // 判断列是否存在重复
            if (board[i][columns] == ch) return false;
            // 判断 3 x 3 方框是否存在重复
            if (board[(lines / 3) * 3 + i / 3][(columns / 3) * 3 + i % 3] == ch)
                return false;
        }
        return true;
    }
}
