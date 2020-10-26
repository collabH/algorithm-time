package org.algorithm.dp;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @fileName: LeetCode.java
 * @description: 贪心算法
 * @author: by echo huang
 * @date: 2020/10/26 3:38 下午
 */
public class LeetCode5 {

    /**
     * 调度区间算法
     *
     * @param intvs
     * @return
     */
    public int intervalSchedule(int[][] intvs) {
        if (intvs.length == 0) return 0;
        // 根据end从小到大排序
        Arrays.sort(intvs, Comparator.comparingInt(o -> o[1]));
        // 至少有一个区间不相交
        int count = 1;
        // end最小的区间，从最小end开始计算不相交，如果不相交count+1，并且更新x的end值为当前这个区间的end，继续上述过程
        int x_end = intvs[0][1];
        for (int[] intv : intvs) {
            // start
            int start = intv[0];
            // 不想交的区间
            if (start >= x_end) {
                count++;
                // 更新x
                x_end = intv[1];
            }
        }
        return count;
    }

    /**
     * 第 435 题
     * @param intervals
     * @return
     */
    public int eraseOverlapIntervals(int[][] intervals) {
        return intervals.length - intervalSchedule(intervals);
    }
}
