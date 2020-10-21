package org.algorithm.dp;

/**
 * @fileName: KnapsackProblem01.java
 * @description: 0-1背包问题，
 * 给你一个可装载重量为`W`的背包和`N`个物品，每个物品有重量和价值两个属性。其中第`i`个物品的重量为`wt[i]`，价值为`val[i]`，现在让你用这个背包装物品，最多能装的价值是多少？
 * @author: by echo huang
 * @date: 2020/10/21 2:58 下午
 */
public class KnapsackProblem01 {
    int knapsack(int W, int N, int[] wt, int[] val) {
        int n = wt.length;
        if (n == 0) {
            return 0;
        }
        // 记录状态：选择的物品和可承载的重量
        int[][] dp = new int[N][W];
        // base case
        dp[0][W] = 0;
        dp[N][0] = 0;
        for (int i = 1; i <= n; i++) {
            if (W - wt[i - 1] < 0) {
                // 当前背包容量装不下，只能选择不装入背包
                dp[i][W] = dp[i - 1][W];
            } else {
                // 装入或者不装入背包，择优
                dp[i][W] = Math.max(dp[i - 1][W - wt[i - 1]] + val[i - 1],
                        dp[i - 1][W]);
            }
        }
        return dp[N][W];
    }
}
