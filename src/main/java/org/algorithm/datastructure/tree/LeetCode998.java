package org.algorithm.datastructure.tree;

import org.algorithm.base.TreeNode;

/**
 * @fileName: LeetCode998.java
 * @description: 最大二叉树
 * @author: by echo huang
 * @date: 2020/11/9 2:31 下午
 */
public class LeetCode998 {
    public static TreeNode insertIntoMaxTree(TreeNode root, int val) {
        if (root == null || root.val < val) {
            return new TreeNode(val, root, null);
        }
        root.right = insertIntoMaxTree(root.right, val);
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4, new TreeNode(1), new TreeNode(3, new TreeNode(2), null));
        insertIntoMaxTree(root, 5);
    }
}
