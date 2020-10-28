package org.algorithm.dp;

/**
 * @fileName: LeetCode673.java
 * @description: 最长上升子序列
 * @author: by echo huang
 * @date: 2020/10/27 5:42 下午
 */
public class LeetCode300 {
    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        LeetCode300 leetCode300 = new LeetCode300();
        System.out.println(leetCode300.lengthOfLIS(nums));
    }

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int[] dp = new int[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            // base case
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
                max = Math.max(i, max);
            }
        }
        return max;
    }
}
