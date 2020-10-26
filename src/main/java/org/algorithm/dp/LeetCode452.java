package org.algorithm.dp;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @fileName: LeetCode452.java
 * @description: 用最少数量的箭引爆气球
 * @author: by echo huang
 * @date: 2020/10/26 4:30 下午
 */
public class LeetCode452 {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) return 0;
        return scheduleInterval(points);
    }

    int scheduleInterval(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[1]));
        int count = 1;
        // 定义x
        int x_end = intervals[0][1];
        for (int[] intv : intervals) {
            int start = intv[0];
            // 不相交
            if (start > x_end) {
                count++;
                x_end = intv[1];
            }
        }
        return count;
    }
}
