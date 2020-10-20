package org.algorithm.dp;

/**
 * @fileName: LeetCode122.java
 * @description: 买卖股票的最佳时机 II,可以无限次交易
 * @author: by echo huang
 * @date: 2020/10/20 4:55 下午
 */
public class LeetCode122 {
    public int maxProfit(int[] prices) {
        // base case dp_-1_k_0=dp_i_0_0=0 dp_-1_k_1=dp_i_0_1=负无穷
        int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE;
        int n = prices.length;
        if (n == 0) {
            return n;
        }
        for (int i = 0; i < n; i++) {
            int temp = dp_i_0;
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            dp_i_1 = Math.max(dp_i_1, temp - prices[i]);
        }
        return dp_i_0;
    }


    public int maxProfitArr(int[] prices) {
        int n = prices.length;
        if (n == 0) {
            return n;
        }
        int[][] dp = new int[n][2];
        for (int i = 0; i < n; i++) {
            // base case dp_-1_k_0=dp_i_0_0=0 dp_-1_k_1=dp_i_0_1=负无穷
            if (i == 0) {
                dp[i][0] = 0;
                dp[i][1] = -prices[i];
                continue;
            }
            dp[i][0] = Math.max(dp[i][0], dp[i-1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i][1], dp[i-1][0] - prices[i]);
        }
        return dp[n - 1][0];
    }

}
