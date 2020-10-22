package org.algorithm.dp;

/**
 * @fileName: LeetCode416.java
 * @description: 416. 分割等和子集
 * @author: by echo huang
 * @date: 2020/10/21 3:26 下午
 */
public class LeetCode416 {
    /**
     * 能够得到一种背包问题的变体条件
     * sum(nums)/2=
     *
     * @param nums
     * @return
     */
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return false;
        }
        int sum = 0, maxNum = 0;
        for (int num : nums) {
            sum += num;
            maxNum = Math.max(maxNum, num);
        }
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        if (maxNum > target) {
            return false;
        }
        boolean[][] dp = new boolean[n][target + 1];
        // base case dp[i][0]=true dp[0][j]=false
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }
        dp[0][nums[0]] = false;
        // 做选择
        for (int i = 1; i < n; i++) {
            int num = nums[i];
            // 做选择
            for (int j = 1; j <= target; j++) {
                // 如果重量大于该num
                if (j >= num) {
                    // 要么不放入背包，要么放入背包
                    dp[i][j] = dp[i - 1][j] | dp[i - 1][j - num];
                } else {
                    // 重量小于num，不放入背包
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n - 1][target];
    }

    public static void main(String[] args) {
        LeetCode416 leetCode416 = new LeetCode416();
        int[] nums = {2, 2, 3, 5};
        System.out.println(leetCode416.canPartition1(nums));
        System.out.println(leetCode416.canPartition(nums));
    }

    // 压缩状态
    public boolean canPartition1(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return false;
        }
        int sum = 0, maxNum = 0;
        for (int num : nums) {
            sum += num;
            maxNum = Math.max(maxNum, num);
        }
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        if (maxNum > target) {
            return false;
        }
        boolean[] dp = new boolean[target + 1];
        // base case
        dp[0] = true;
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            for (int j = target; j>=num; j--) {
                dp[j] = dp[j] | dp[j - num];
            }
        }
        return dp[target];
    }
}
