package org.algorithm.dp;

/**
 * @fileName: KMP.java
 * @description: kmp算法
 * @author: by echo huang
 * @date: 2020/10/28 5:48 下午
 */
public class KMP {
    // dp[j][c]=next j代表当前状态，next代表下一个状态，c代表遇到的字符的(ASCII码)
    private int[][] dp;
    // 匹配的子串
    private String pat;

    public KMP(String pat) {
        this.pat = pat;
        int M = pat.length();
        // dp[状态][字符] = 下个状态
        dp = new int[M][256];
        // base case
        dp[0][pat.charAt(0)] = 1;
        // 影子状态 X 初始为 0
        int X = 0;
        // 当前状态 j 从 1 开始
        for (int j = 1; j < M; j++) {
            for (int c = 0; c < 256; c++) {
                if (pat.charAt(j) == c) {
                    dp[j][c] = j + 1;
                } else {
                    dp[j][c] = dp[X][c];
                }
            }
            // 更新影子状态
            X = dp[X][pat.charAt(j)];
        }
    }

    public int search(String txt) {
        int M = pat.length();
        int N = txt.length();

        // 初始化pat的状态
        int j = 0;
        for (int i = 0; i < N; i++) {
            // next=dp[j][char]
            j = dp[j][txt.charAt(i)];
            // 终止条件
            if (j == M) {
                // 如果达到终止态，返回匹配开头的索引
                return i - M + 1;
            }
        }
        return -1;
    }
}
