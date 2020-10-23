package org.algorithm.dp;

import java.util.Arrays;

/**
 * @fileName: DpCoin.java
 * @description: 硬币问题，存在k枚硬币，面值a，b，c，得到amount需要最少多少枚硬币
 * @author: by echo huang
 * @date: 2020/10/16 11:24 上午
 */
public class DpCoin {
    public static void main(String[] args) {
        int[] coins = new int[]{1, 2, 5};
        System.out.println(coinChange(coins, 12));
    }

    /**
     * 暴力递归法
     *
     * @param amount
     * @return
     */
    static int coinChange(int[] coins, int amount) {
        return coinChange(0, coins, amount);
    }

    /**
     * 暴力递归方式
     * fixme 还不太懂
     *
     * @param coinIdx
     * @param coins
     * @param amount
     * @return
     */
    static int coinChange(int coinIdx, int[] coins, int amount) {
        if (amount == 0) {
            return amount;
        }
        // 边界条件
        if (coinIdx < coins.length && amount > 0) {
            int maxVal = amount / coins[coinIdx];
            int minCost = Integer.MAX_VALUE;
            for (int x = 0; x <= maxVal; x++) {
                if (amount >= x * coins[coinIdx]) {
                    int res = coinChange(coinIdx + 1, coins, amount - x * coins[coinIdx]);
                    if (res != -1) {
                        minCost = Math.min(minCost, res + x);
                    }
                }
            }
            return (minCost == Integer.MAX_VALUE) ? -1 : minCost;
        }
        return -1;
    }

    public int coinChange1(int[] coins, int amount) {
        // 自底向上的动态规划
        if (coins.length == 0) {
            return -1;
        }
        // memo[n]的值： 表示的凑成总金额为n所需的最少的硬币个数
        int[] memo = new int[amount + 1];
        // 给memo赋初值，最多的硬币数就是全部使用面值1的硬币进行换
        // amount + 1 是不可能达到的换取数量，于是使用其进行填充
        Arrays.fill(memo, amount + 1);
        memo[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] >= 0) {
                    // memo[i]有两种实现的方式，
                    // 一种是包含当前的coins[i],那么剩余钱就是 i-coins[i],这种操作要兑换的硬币数是 memo[i-coins[j]] + 1
                    // 另一种就是不包含，要兑换的硬币数是memo[i]
                    memo[i] = Math.min(memo[i], memo[i - coins[j]] + 1);
                }
            }
        }
        return memo[amount] == (amount + 1) ? -1 : memo[amount];
    }


}
