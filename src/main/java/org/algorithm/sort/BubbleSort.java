package org.algorithm.sort;

import java.util.Arrays;

/**
 * @fileName: BubbleSort.java
 * @description: 冒泡排序
 * @author: by echo huang
 * @date: 2020/11/9 9:18 上午
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] nums = {1, 5, 2, 7, 3, 10};
        sort2(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void sort1(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    swap(nums, i, j);
                }
            }
        }
    }

    public static void sort2(int[] nums) {
        boolean flag = true;
        for (int i = 0; i < nums.length && flag; i++) {
            flag = false;
            for (int j = nums.length - 1; j > i; j--) {
                if (nums[j - 1] > nums[j]) {
                    flag = true;
                    swap(nums, j - 1, j);
                }
            }
        }
    }


    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
