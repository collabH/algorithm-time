package org.algorithm.sort;

import java.util.Arrays;

/**
 * @fileName: InsertSort.java
 * @description: 插入排序
 * @author: by echo huang
 * @date: 2020/11/9 9:41 上午
 */
public class InsertSort {


    /**
     * 插入排序
     * 基本思想是在遍历数组的过程中，假设在序号 i （i>=1）之前的元素即 [0..i-1] 都已经排好序，
     * 本趟需要找到 i 对应的元素 x 的正确位置 k ，并且在寻找这个位置 k 的过程中逐个将比较过的元素往后移一位，
     * 为元素 x “腾位置”，最后将 k 对应的元素值赋为 x
     */
    public static void sort(int[] nums) {
        int n = nums.length;
        int i, j, temp;
        for (i = 1; i < n; i++) {
            //只有当前位置i元素小于已经有序的[0,i-1]中的最大元素nums[i-1]时，才需要进行插入
            if (nums[i - 1] > nums[i]) {
                temp = nums[i];//存当前位置i的元素，其中[0,i-1]已经有序
                for (j = i; j > 0 && nums[j - 1] > temp; j--) {
                    if (nums[j] < temp) {
                        break;
                    }
                    // 将j大于temp的数据全部向后移动
                    nums[j] = nums[j - 1];//从i-1开始遍历到0，比temp大的数后移一位
                }
                nums[j] = temp;//插入到合适的位置
            }
        }
    }

    public static void sort2(int[] nums) {
        int n = nums.length, i, j, temp;
        for (i = 1; i < n; i++) {
            if (nums[i] < nums[i - 1]) {
                temp = nums[i];
                for (j = i; j > 0 && nums[j - 1] > temp; j--) {
                    nums[j] = nums[j - 1];
                }
                nums[j] = temp;
            }

        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 6, 2, 3, 4, 10, 9, 7};
        sort2(nums);
        System.out.println(Arrays.toString(nums));
    }


}
