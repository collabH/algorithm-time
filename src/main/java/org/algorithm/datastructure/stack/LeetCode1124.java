package org.algorithm.datastructure.stack;

import java.util.HashMap;
import java.util.Map;

/**
 * @fileName: LeetCode1124.java
 * @description: LeetCode1124.java类说明
 * @author: by echo huang
 * @date: 2020/11/4 11:33 上午
 */
public class LeetCode1124 {
    public int longestWPI(int[] hours) {
        int sum = 0;
        int res = 0;
        Map<Integer, Integer> sumToIndex = new HashMap<>();
        for (int i = 0; i < hours.length; i++) {
            int temp = hours[i] > 8 ? 1 : -1;
            sum += temp;
            if (sum > 0)
                res = i + 1;
            else {
                if (!sumToIndex.containsKey(sum))
                    sumToIndex.put(sum, i);
                if (sumToIndex.containsKey(sum - 1))
                    res = Math.max(res, i - sumToIndex.get(sum - 1));
            }
        }
        return res;

    }
}
