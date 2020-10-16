package org.algorithm.dp;

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

}
