package org.algorithm.datastructure;

/**
 * @fileName: Leet.java
 * @description: 移除元素
 * @author: by echo huang
 * @date: 2020/10/29 5:15 下午
 */
public class LeetCode27 {
    public int removeElement(int[] nums, int val) {
        int n = nums.length;
        if (n == 0) return 0;
        int fast = 0, slow = 0;
        while (fast < n) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }
}
