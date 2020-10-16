package org.algorithm.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * @fileName: DpFibonacci.java
 * @description: 斐波那契数组
 * @author: by echo huang
 * @date: 2020/10/16 10:27 上午
 */
public class DpFibonacci {

    public static void main(String[] args) {
        System.out.println(compressState(34));
    }

    /**
     * 暴力解法递归法
     *
     * @param n
     * @return
     */
    static int recursion(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        return recursion(n - 2) + recursion(n - 1);
    }

    // 备忘录
    static Map<Integer, Integer> memo = new HashMap<>();

    /**
     * 备忘录方式
     *
     * @param n
     * @return
     */
    static int memo(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        // 如果备忘录中存在
        if (memo.containsKey(n)) {
            return memo.get(n);
        }
        memo.put(n, memo(n - 2) + memo(n - 1));
        return memo.get(n);
    }

    /**
     * dp表方式
     *
     * @param n
     * @return
     */
    static int dpTable(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        Map<Integer, Integer> dpTable = new HashMap<>(n);
        dpTable.put(1, 1);
        dpTable.put(2, 1);
        for (int i = 3; i <= n; i++) {
            dpTable.put(i, dpTable.get(i - 2) + dpTable.get(i - 1));
        }
        return dpTable.get(n);
    }

    /**
     * 状态压缩
     *
     * @param n
     * @return
     */
    static int compressState(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        int first = 1;
        int second = 1;
        int res = 1;
        for (int i = 3; i <= n; i++) {
            res = first + second;
            first = second;
            second = res;
        }
        return res;
    }
}
