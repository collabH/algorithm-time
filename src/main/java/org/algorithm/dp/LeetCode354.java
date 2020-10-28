package org.algorithm.dp;

import java.util.Arrays;

/**
 * @fileName: LeetCode354.java
 * @description: LeetCode354.java类说明
 * @author: by echo huang
 * @date: 2020/10/28 11:17 上午
 */
public class LeetCode354 {
    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        if (n == 0) {
            return 0;
        }
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (envelopes[i][0] < envelopes[j][0]) {
                    int temp1 = envelopes[i][0];
                    int temp2 = envelopes[i][1];
                    envelopes[i][0] = envelopes[j][0];
                    envelopes[i][1] = envelopes[j][1];
                    envelopes[j][0] = temp1;
                    envelopes[j][1] = temp2;
                }
            }
        }
        System.out.println(Arrays.deepToString(envelopes));
        int max = 0;
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                // 递增子序列
                if (envelopes[i][0] > envelopes[j][0]
                        && envelopes[i][1] > envelopes[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(dp[i], max);
        }
        return max;
    }

    public static void main(String[] args) {
        int [][] envelopes={{1,2},{5,3},{2,1}};
        LeetCode354 leetCode354 = new LeetCode354();
        System.out.println(leetCode354.maxEnvelopes(envelopes));
    }
}
