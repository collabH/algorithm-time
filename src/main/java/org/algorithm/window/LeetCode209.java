package org.algorithm.window;

/**
 * @fileName: LeetCode209.java
 * @description: 长度最小的子数组
 * @author: by echo huang
 * @date: 2020/11/15 2:47 下午
 */
public class LeetCode209 {
    public int minSubArrayLen(int s, int[] nums) {

        int l = 0, r = -1, sum = 0;
        int res = nums.length + 1;
        while (l < nums.length) {
            if (r + 1 < nums.length && sum < s) {
                sum += nums[++r];
            } else {
                sum -= nums[l++];
            }
            if (sum >= s) {
                res = Math.min(res, r - l + 1);
            }
        }
        if (res == nums.length + 1) {
            return 0;
        }
        return res;
    }
}
