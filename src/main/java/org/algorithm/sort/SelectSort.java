package org.algorithm.sort;

import java.util.Arrays;

/**
 * @fileName: SelectSort.java
 * @description: 选择排序
 * @author: by echo huang
 * @date: 2020/11/9 9:31 上午
 */
public class SelectSort {
    /**
     * 选择排序:寻找序列中的最小值，用当前位置的值交换最小值
     *
     * @param nums
     */
    public static void sort(int[] nums) {
        int n = nums.length, min;
        for (int i = 0; i < n - 1; i++) {
            min = i;
            for (int j = i + 1; j < n; j++) {
                if (nums[min] > nums[j]) {
                    min = j;
                }
            }
            if (i != min) {
                BubbleSort.swap(nums, i, min);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 23, 2, 6, 5, 3, 10, 8};
        sort(nums);

        System.out.println(Arrays.toString(nums));
    }
}
