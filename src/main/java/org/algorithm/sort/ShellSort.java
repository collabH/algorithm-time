package org.algorithm.sort;

/**
 * @fileName: ShellSort.java
 * @description: 希尔排序
 * @author: by echo huang
 * @date: 2020/11/9 9:56 上午
 */
public class ShellSort {
    public static void sort(int[] nums) {
        int n = nums.length;
        int i, j, temp;
        int h = 1; /* 关于步长，取值没有统一标准，必须小于size，最后一次步长要为1 */
        for (h = 1; h < n / 3; h = 3 * h + 1) ;//计算首次步长
        for (; h > 0; h = h / 3) {
            for (i = h; i < n; i++) {
                //只有当前位置i元素小于已经有序的[0,i-1]中的最大元素nums[i-h]时，才需要进行插入
                if (nums[i] < nums[i - h]) {
                    temp = nums[i];//存当前位置i的元素，其中[0,i-1]已经有序
                    for (j = i; j > h - 1 && nums[j - h] > temp; j = j - h) {
                        nums[j] = nums[j - h];//从i-h开始遍历到h-1，比temp大的数后移h位
                    }
                    nums[j] = temp;//插入到合适的位置
                }
            }
        }

    }
}
