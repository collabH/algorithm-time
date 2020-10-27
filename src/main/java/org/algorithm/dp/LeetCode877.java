package org.algorithm.dp;

/**
 * @fileName: LeetCode877.java
 * @description: 博弈问题
 * @author: by echo huang
 * @date: 2020/10/27 10:51 上午
 */
public class LeetCode877 {
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        int[][] dp = new int[n][n];
        // base case
        for (int i = 0; i < n; i++) {
            dp[i][i] = piles[i];
        }
        // 状态转移方程: dp[i][i]-dp[i-1][i-1]
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                dp[i][j] = Math.max(piles[i] - dp[i + 1][j], piles[j] - dp[i][j - 1]);
            }
        }
        return dp[0][n - 1] > 0;
    }
}
