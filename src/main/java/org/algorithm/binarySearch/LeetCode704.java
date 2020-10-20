package org.algorithm.binarySearch;

/**
 * @fileName: LeetCode704.java
 * @description: 二分查找
 * @author: by echo huang
 * @date: 2020/10/20 11:36 上午
 */
public class LeetCode704 {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            // 这里left + (right - left) / 2等价于(right+left)/2，这样做为了防止int数据溢出
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        return -1;
    }

    /**
     * 寻找左边界的二分搜索
     *
     * @param nums
     * @param target
     * @return
     */
    public int leftBoundSearch(int[] nums, int target) {
        int length = nums.length;
        if (length == 0) {
            return -1;
        }
        int left = 0, right = length - 1;
        while (left <= right) {
            // 这
            int mid = left + (right - left) / 2;
            // 左边搜索
            if (nums[mid] == target) {
                right = mid - 1;
            }
            if (nums[mid] > target) {
                right = mid - 1;
            }
            if (nums[mid] < target) {
                left = mid + 1;
            }
        }
        // 防止数据越界
        if (left >= nums.length || nums[left] != target) {
            return -1;
        }
        return left;
    }


    /**
     * 寻找右边界的二分搜索
     *
     * @param nums
     * @param target
     * @return
     */
    public int rightBoundSearch(int[] nums, int target) {
        int length = nums.length;
        if (length == 0) {
            return -1;
        }
        int left = 0, right = length - 1;
        while (left <= right) {
            // 这
            int mid = left + (right - left) / 2;
            // 左边搜索
            if (nums[mid] == target) {
                left = mid + 1;
            }
            if (nums[mid] > target) {
                right = mid - 1;
            }
            if (nums[mid] < target) {
                left = mid + 1;
            }
        }
        // 防止数据越界
        if (right < 0 || nums[right] != target) {
            return -1;
        }
        return right;
    }
}
