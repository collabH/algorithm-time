package org.algorithm.datastructure;

/**
 * @fileName: LeetCode26.java
 * @description: 删除排序数组中的重复项
 * @author: by echo huang
 * @date: 2020/10/29 4:44 下午
 */
public class LeetCode26 {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n == 0) return n;
        int fast = 0, slow = 0;
        while (fast < n) {
            if (nums[fast] != nums[slow]) {
                slow++;
                // 维护 nums[0..slow] 无重复
                nums[slow] = nums[fast];
            }
            fast++;
        }
        return slow + 1;
    }
}
