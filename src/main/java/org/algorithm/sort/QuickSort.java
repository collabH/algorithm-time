package org.algorithm.sort;

import java.util.Arrays;

/**
 * @fileName: QuickSort.java
 * @description: 快排
 * @author: by echo huang
 * @date: 2020/11/9 10:51 上午
 */
public class QuickSort {

    public void sort(int[] nums, int n) {
        sort(nums, 0, n - 1);
    }

    public void sort(int[] nums, int low, int high) {
        int pivot;
        if (low < high) {
            pivot = partition(nums, low, high);/*将L->r[low..high]一分为二，*/
            /*算出枢轴值pivot */
            sort(nums, low, pivot - 1);
            sort(nums, pivot + 1, high);
        }
    }

    public int partition(int[] nums, int low, int high) {
        int pivotkey = nums[low];
        while (low < high) {
            // 大于pivotkey的值放右边
            while (low < high && nums[high] >= pivotkey) {
                high--;
            }
            // 小于pivotkey放左边
            BubbleSort.swap(nums, low, high);
            while (low < high && nums[low] <= pivotkey) {
                low++;
            }
            //大于pivotkey的值放右边
            BubbleSort.swap(nums, low, high);
        }
        return low;
    }

    public static void main(String[] args) {
        int[] nums = {1, 7, 2, 4, 5, 19};
        QuickSort quickSort = new QuickSort();
        quickSort.sort(nums, nums.length);
        System.out.println(Arrays.toString(nums));
    }
}
