package org.algorithm.sort;

import java.util.Arrays;

/**
 * @fileName: MergeSort.java
 * @description: 归并排序
 * @author: by echo huang
 * @date: 2020/11/9 10:36 上午
 */
public class MergeSort {
    public static void sort(int[] nums, int n) {
        int[] temp = new int[n];//在排序前，先建好一个长度等于原数组长度的临时数组，避免递归中频繁开辟空间
        sort(nums, temp, 0, n - 1);
    }

    private static void sort(int[] nums, int[] temp, int left, int right) {
        int mid;
        if (left < right) {
            mid = left - (left - right) / 2;
            sort(nums, temp, left, mid);//左边归并排序，使得左子序列有序
            sort(nums, temp, mid + 1, right);//右边归并排序，使得右子序列有序
            merge(nums, temp, left, mid, right);//将两个有序子数组合并操作
        }
    }

    //right为序列最后一位元素下标
    private static void merge(int[] nums, int[] temp, int left, int mid, int right) {
        int i = left;  //左序列指针
        int j = mid + 1;  //右序列指针
        int k = 0;  //临时数组指针
        while (i <= mid && j <= right) {
            if (nums[i] < nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }
        while (i <= mid) { //将左边剩余元素填充进temp中
            temp[k++] = nums[i++];
        }
        while (j <= right) {  //将右序列剩余元素填充进temp中
            temp[k++] = nums[j++];
        }
        k = 0;
        while (left <= right) {  //将temp中的元素全部拷贝到原数组中
            nums[left++] = temp[k++];
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 6,2, 5, 4, 9, 7, 8, 10, 2};
        sort(nums, nums.length);
        System.out.println(Arrays.toString(nums));
    }
}
