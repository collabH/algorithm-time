package org.algorithm.window;

import java.util.TreeSet;

/**
 * @fileName: LeetCode220.java
 * @description: LeetCode220.java类说明
 * @author: by echo huang
 * @date: 2020/11/15 5:26 下午
 */
public class LeetCode220 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < nums.length; ++i) {
            // Find the successor of current element
            Integer s = set.ceiling(nums[i]);
            if (s != null && s - nums[i] <= t) return true;

            // Find the predecessor of current element
            Integer g = set.floor(nums[i]);
            if (g != null && nums[i] - g <= t) return true;

            set.add(nums[i]);
            if (set.size() > k) {
                set.remove(nums[i - k]);
            }
        }
        return false;

    }
}
