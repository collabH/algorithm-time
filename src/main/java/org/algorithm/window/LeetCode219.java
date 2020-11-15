package org.algorithm.window;

import java.util.HashSet;
import java.util.Set;

/**
 * @fileName: LeetCode219.java
 * @description: LeetCode219.java类说明
 * @author: by echo huang
 * @date: 2020/11/15 4:51 下午
 */
public class LeetCode219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> window = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (window.contains(nums[i])) {
                return true;
            }
            window.add(nums[i]);
            if (window.size() == k + 1) {
                window.remove(nums[i - k]);
            }
        }
        return false;
    }
}
