package org.algorithm.dp;

import java.util.Arrays;

/**
 * @fileName: LeetCode198.java
 * @description: 打家劫舍
 * @author: by echo huang
 * @date: 2020/10/26 11:27 上午
 */
public class LeetCode198 {
    private int[] memo;

    public int rob(int[] nums) {
        // 初始化备忘录
        memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return dp(nums, 0);
    }

    // 递归函数
    int dp(int[] nums, int start) {
        if (start >= nums.length) {
            return 0;
        }
        if (memo[start] != -1) {
            return memo[start];
        }
        int res = Math.max(dp(nums, start + 1), nums[start] + dp(nums, start + 2));
        memo[start] = res;
        return memo[start];
    }

    // dp表
    public int rob1(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return n;
        }
        // base case
        int[] dp = new int[n + 2];
        for (int i = n - 1; i >= 0; i--) {
            // 做选择， 不偷，偷
            dp[i] = Math.max(dp[i + 1], dp[i + 2] + nums[i]);
        }
        // 递归到第一个元素
        return dp[0];
    }

    // 压缩状态
    int rob2(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return n;
        }
        // base case
        int dp_i_1 = 0, dp_i_2 = 0;
        int dp_i = 0;
        for (int i = n - 1; i >= 0; i--) {
            // 做选择， 不偷，偷
            dp_i = Math.max(dp_i_1, dp_i_2 + nums[i]);
            dp_i_2 = dp_i_1;
            dp_i_1 = dp_i;
        }
        // 递归到第一个元素
        return dp_i;
    }
}
