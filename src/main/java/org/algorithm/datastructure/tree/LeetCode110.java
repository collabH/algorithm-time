package org.algorithm.datastructure.tree;

import org.algorithm.base.TreeNode;

/**
 * @fileName: LeetCode110.java
 * @description: 平衡二叉树
 * @author: by echo huang
 * @date: 2020/11/6 11:25 上午
 */
public class LeetCode110 {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        } else {
            return Math.abs(getHeight(root.left) - getHeight(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
        }
    }

    public int getHeight(TreeNode root) {
        if (root==null){
            return 0;
        }
        return Math.max(getHeight(root.left),getHeight(root.right))+1;
    }
}
