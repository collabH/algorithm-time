package org.algorithm.dp;

/**
 * @fileName: LeetCode72.java
 * @description: 72. 编辑距离
 * @author: by echo huang
 * @date: 2020/10/23 10:59 上午
 */
public class LeetCode72 {
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        // base case dp[i][0]=i, dp[0][j]=j;
        for (int i = 1; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int j = 1; j <= n; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1]; // 跳过
                } else {
                    dp[i][j] = Math.min(Math.min(
                            dp[i - 1][j] + 1, // 删除
                            dp[i][j - 1] + 1), // 插入
                            dp[i - 1][j - 1] + 1); //替换
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        LeetCode72 leetCode72 = new LeetCode72();
        System.out.println(leetCode72.minDistance("horse", "ros"));
        System.out.println(leetCode72.minDistance1("horse", "ros"));
    }

    public int minDistance1(String word1, String word2) {
        int n = word1.length(), m = word2.length();
        return dp(n - 1, m - 1, word1, word2);
    }

    /**
     * 超出时间限制
     * @param i
     * @param j
     * @param word1
     * @param word2
     * @return
     */
    int dp(int i, int j, String word1, String word2) {
        // base case
        if (i == -1) return j + 1;
        if (j == -1) return i + 1;
        char[] word1Arr = word1.toCharArray();
        char[] word2Arr = word2.toCharArray();
        // skip
        if (word1Arr[i] == word2Arr[j]) {
            return dp(i - 1, j - 1, word1, word2);
        } else {
            return Math.min(Math.min(dp(i - 1, j, word1, word2) + 1, dp(i, j - 1, word1, word2) + 1)
                    , dp(i - 1, j - 1, word1, word2) + 1);
        }
    }
}
