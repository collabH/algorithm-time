package org.algorithm.datastructure.fastslow;

/**
 * @fileName: LeetCode283.java
 * @description: 移动零
 * @author: by echo huang
 * @date: 2020/10/29 5:28 下午
 */
public class LeetCode283 {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        if (n == 0) return;

        int fast = 0, slow = 0;
        while (fast < n) {
            if (nums[fast] != 0) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        for (int i=slow;i<n;i++){
            nums[i]=0;
        }
    }
}
