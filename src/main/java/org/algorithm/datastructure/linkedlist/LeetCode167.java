package org.algorithm.datastructure.linkedlist;

/**
 * @fileName: LeetCode167.java
 * @description: 两数之和 II - 输入有序数组
 * @author: by echo huang
 * @date: 2020/11/11 10:18 上午
 */
public class LeetCode167 {
    public int[] twoSum(int[] numbers, int target) {
        int low = 0, high = numbers.length - 1;
        while (low < high) {
            int sum = numbers[low] + numbers[high];
            if (sum == target) {
                return new int[]{low + 1, high + 1};
            } else if (sum < target) {
                ++low;
            } else {
                --high;
            }
        }
        return new int[]{-1, -1};
    }
}
