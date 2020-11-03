package org.algorithm.binarySearch;

/**
 * @fileName: LeetCodeOffer53.java
 * @description: 0～n-1中缺失的数字
 * @author: by echo huang
 * @date: 2020/11/3 5:51 下午
 */
public class LeetCodeOffer53 {
    public int missingNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (nums[mid] == mid) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        return i;
    }
}
