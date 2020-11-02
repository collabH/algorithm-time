package org.algorithm.datastructure.tree;

import org.algorithm.base.TreeNode;

/**
 * @fileName: Leet.java
 * @description: 最大二叉树
 * @author: by echo huang
 * @date: 2020/10/30 11:36 上午
 */
public class LeetCode654 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }


    private TreeNode build(int[] nums, int lt, int ri) {
        // base case
        if (lt > ri) {
            return null;
        }
        int index = -1, max = Integer.MIN_VALUE;
        for (int i = lt; i <= ri; i++) {
            if (max < nums[i]) {
                index = i;
                max = nums[i];
            }
        }
        TreeNode root = new TreeNode(max);
        // 构建左子树
        root.left = build(nums, lt, index - 1);
        // 构建右子树
        root.right = build(nums, index + 1, ri);
        return root;
    }
}
