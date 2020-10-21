package org.algorithm.dp;

/**
 * @fileName: LeetCode123.java
 * @description: 买卖股票的最佳时机 IV
 * @author: by echo huang
 * @date: 2020/10/20 5:23 下午
 */
public class LeetCode188 {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][][] dpTable = new int[n][k + 1][2];
        for (int i = 0; i < n; i++) {
            for (int j = k; j >= 1; j--) {
                if (i == 0) {
                    dpTable[i][j][0] = 0;
                    dpTable[i][j][1] = -prices[i];
                    continue;
                }
                dpTable[i][j][0] = Math.max(dpTable[i - 1][j][0], dpTable[i - 1][j][1] + prices[i]);
                dpTable[i][j][1] = Math.max(dpTable[i - 1][j][1], dpTable[i - 1][j - 1][0] - prices[i]);
            }
        }
        return dpTable[n - 1][k][0];
    }
}
