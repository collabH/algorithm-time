package org.algorithm.datastructure.tree.bst;

import org.algorithm.base.TreeNode;

/**
 * @fileName: LeetCode226.java
 * @description: 翻转二叉树
 * @author: by echo huang
 * @date: 2020/10/30 9:57 上午
 */
public class LeetCode226 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode temp = invertTree(root.right);
        root.right = invertTree(root.left);
        root.left = temp;
        return root;
    }
}
