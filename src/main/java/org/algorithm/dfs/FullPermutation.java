package org.algorithm.dfs;

import java.util.LinkedList;
import java.util.List;

/**
 * @fileName: FullPermutation.java
 * @description: 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 * @author: by echo huang
 * @date: 2020/10/16 4:21 下午
 */
public class FullPermutation {
    static List<List<Integer>> res = new LinkedList<>();

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        System.out.println(permute(nums));
    }

    public static List<List<Integer>> permute(int[] nums) {
        // 记录路径
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(track, nums);
        return res;
    }

    /**
     * @param track 路径
     * @param nums  选择列表
     */
    static void backtrack(LinkedList<Integer> track, int[] nums) {
        // todo 结束条件为路径包含全部选择列表
        if (track.size() == nums.length) {
            res.add(new LinkedList<>(track));
            return;
        }

        // 做选择, 从1-》【1，2，3】 2-》【1，2，3】 3-》【1，2，3】
        for (int num : nums) {
            // 移除已经选择的列表
            if (track.contains(num)) {
                continue;
            }
            // 做选择
            track.add(num);
            // 继续下一轮决策选择
            backtrack(track, nums);
            // 撤销选择
            track.removeLast();
        }
    }
}
