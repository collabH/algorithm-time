package org.algorithm.dp;

/**
 * @fileName: LeetCode28.java
 * @description: 实现strStr()
 * @author: by echo huang
 * @date: 2020/10/29 10:28 上午
 */
public class LeetCode28 {
    public static void main(String[] args) {
        LeetCode28 leetCode28 = new LeetCode28();
        leetCode28.strStr("hello","ll");
    }
    public int strStr(String haystack, String needle) {

        int N = haystack.length();
        int M = needle.length();
        if (M == 0) return M;
        int[][] dp = new int[M][256];
        // base case
        dp[0][needle.charAt(0)] = 1;
        // 和dp[i][j]具有相同前缀的状态
        int x = 0;
        for (int i = 1; i < M; i++) {
            for (int j = 0; j < 256; j++) {
                // 匹配上
                if (needle.charAt(i) == j) {
                    dp[i][j] = i + 1;
                    // 没有匹配，重新激活
                } else {
                    dp[i][j] = dp[x][j];
                }
            }
            // 这里会找到
            x = dp[x][needle.charAt(i)];
        }
        // pat初始化状态
        int j = 0;
        for (int i = 0; i < N; i++) {
            j = dp[j][haystack.charAt(i)];
            if (j == M) {
                return i - M + 1;
            }
        }
        return -1;
    }
}
