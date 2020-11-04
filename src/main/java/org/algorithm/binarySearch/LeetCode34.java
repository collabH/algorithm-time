package org.algorithm.binarySearch;

import java.util.Arrays;

/**
 * @fileName: LeetCode34.java
 * @description: 在排序数组中查找元素的第一个和最后一个位置
 * @author: by echo huang
 * @date: 2020/11/4 3:27 下午
 */
public class LeetCode34 {
    public int[] searchRange(int[] nums, int target) {
        int leftBound = left_bound(nums, target);
        int rightBound = right_bound(nums, target);
        return new int[]{leftBound, rightBound};
    }

    int left_bound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] == target) {
                // 别返回，锁定左侧边界
                right = mid - 1;
            }
        }
        // 最后要检查 left 越界的情况
        if (left >= nums.length || nums[left] != target)
            return -1;
        return left;
    }


    int right_bound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] == target) {
                // 别返回，锁定右侧边界
                left = mid + 1;
            }
        }
        // 最后要检查 right 越界的情况
        if (right < 0 || nums[right] != target)
            return -1;
        return right;
    }

    public static void main(String[] args) {
        LeetCode34 leetCode34 = new LeetCode34();
        int[] nums = new int[]{5, 7, 7, 8, 8, 10};
        System.out.println(Arrays.toString(leetCode34.searchRange(nums, 8)));
    }
}
