package org.algorithm.dp;

/**
 * @fileName: LeetCode674.java
 * @description: 最长连续递增序列
 * @author: by echo huang
 * @date: 2020/10/28 10:20 上午
 */
public class LeetCode674 {
    public int findLengthOfLCIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j] && i == j + 1) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
