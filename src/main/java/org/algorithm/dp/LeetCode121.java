package org.algorithm.dp;

/**
 * @fileName: LeetCode121.java
 * @description: 买卖股票的最佳时机
 * @author: by echo huang
 * @date: 2020/10/20 3:49 下午
 */
public class LeetCode121 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        // 构建dp表
        int[][] dp = new int[n][2];
        for (int i = 0; i < n; i++) {
            // base case,相当于dp[i][k][0]=dp[-1][k][0]=0
            // dp[i][k][1]=dp[-1][0][1]=负无穷
            if (i - 1 == -1) {
                dp[i][0] = 0;
                dp[i][1] = -prices[i];
                continue;
            }
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
        }
        return dp[n - 1][0];
    }

    int maxProfit_k_1(int[] prices) {
        int n = prices.length;
        // base case: dp[-1][0] = 0, dp[-1][1] = -infinity
        int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            // dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i])
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            // dp[i][1] = max(dp[i-1][1], -prices[i])
            dp_i_1 = Math.max(dp_i_1, -prices[i]);
        }
        return dp_i_0;
    }
}
