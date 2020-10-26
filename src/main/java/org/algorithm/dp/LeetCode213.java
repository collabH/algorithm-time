package org.algorithm.dp;

/**
 * @fileName: LeetCode213.java
 * @description: 打家劫舍2
 * @author: by echo huang
 * @date: 2020/10/26 11:54 上午
 */
public class LeetCode213 {
    // 环形数组,会存在俩种问题，不能选第一个同时选最后一个房子，那么
    // 有2种选择，选择第一个不选最后一个没，不选第一个选最后一个
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) return n;
        if (n == 1) return nums[0];
        return Math.max(robRange(nums, 0, n - 2)
                , robRange(nums, 1, n - 1));
    }

    int robRange(int[] nums, int start, int end) {
        int n = nums.length;
        // base case
        int[] dp = new int[n + 2];
        for (int i = end; i >= start; i--) {
            // 做选择， 不偷，偷
            dp[i] = Math.max(dp[i + 1], dp[i + 2] + nums[i]);
        }
        return dp[start];
    }

    public static void main(String[] args) {
        int []nums={1,2,3};
        System.out.println(new LeetCode213().rob(nums));
    }
}
