package org.algorithm.dp;

/**
 * @fileName: LeetCode518.java
 * @description: 零钱兑换 II
 * @author: by echo huang
 * @date: 2020/10/22 11:11 上午
 */
public class LeetCode518 {
    public static void main(String[] args) {
        LeetCode518 leetCode518 = new LeetCode518();
        int[] coins = {1, 2, 5};
        System.out.println(leetCode518.change1(5, coins));
    }

    int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];
        // base case
        for (int i = 0; i <= n; i++)
            dp[i][0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= amount; j++)
                if (j - coins[i - 1] >= 0)
                    dp[i][j] = dp[i - 1][j]
                            + dp[i][j - coins[i - 1]];
                else
                    dp[i][j] = dp[i - 1][j];
        }
        return dp[n][amount];
    }


    int change1(int amount, int[] coins) {
        int n = coins.length;
        int[] dp = new int[amount + 1];
        // base case
        dp[0] = 1;
        for (int i = 0; i < n; i++) {
            int coin = coins[i];
            for (int j = 1; j <= amount; j++) {
                if (j-coin>=0)
                    dp[j] = dp[j] + dp[j - coin];
            }
        }
        return dp[amount];
    }
}
