package org.algorithm.dp;

/**
 * @fileName: LeetCode673.java
 * @description: 最长递增子序列的个数
 * @author: by echo huang
 * @date: 2020/10/27 5:42 下午
 */
public class LeetCode673 {
    public static void main(String[] args) {
        int [] nums={1,3,5,4,7};
        LeetCode673 leetCode673 = new LeetCode673();
        System.out.println(leetCode673.findNumberOfLIS(nums));
    }
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        // base case
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    // dp[i] , dp[j]上一个小于dp[i]的值加1
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int max = 0;
        for (int i : dp) {
            max = Math.max(i, max);
        }
        int count=0;
        for (int i : dp) {
            if (max==i){
                count++;
            }
        }

        return count;
    }
}
