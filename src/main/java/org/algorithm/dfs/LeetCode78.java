package org.algorithm.dfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @fileName: LeetCode78.java
 * @description: LeetCode78.java类说明
 * @author: by echo huang
 * @date: 2020/11/13 3:57 下午
 */
public class LeetCode78 {
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        // 路径
        LinkedList<Integer> track = new LinkedList<>();
        dfs(track, 0, nums);
        return res;
    }

    void dfs(LinkedList<Integer> track, int start, int[] nums) {
        res.add(new LinkedList<>(track));
        for (int i = start; i < nums.length; i++) {
            // 筛选
            if (track.contains(nums[i])) continue;

            // 做选择
            track.add(nums[i]);
            dfs(track, i + 1, nums);
            track.removeLast();
        }
    }

    public static void main(String[] args) {
        LeetCode78 leetCode78 = new LeetCode78();
        int[] nums = {1, 2, 3};
        System.out.println(leetCode78.subsets(nums));
    }
}
