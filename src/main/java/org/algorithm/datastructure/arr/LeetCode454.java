package org.algorithm.datastructure.arr;


import java.util.HashMap;
import java.util.Map;

/**
 * @fileName: LeetCode454.java
 * @description: LeetCode454.java类说明
 * @author: by echo huang
 * @date: 2020/11/15 3:49 下午
 */
public class LeetCode454 {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> record = new HashMap<>();
        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < D.length; j++) {
                record.put(C[i] + D[j], record.getOrDefault(C[i] + D[j], 0) + 1);
            }
        }
        int res = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                if (record.containsKey(-A[i] - B[j])) {
                 res+=record.get(-A[i] - B[j]);
                }
            }
        }
        return res;
    }
}
