package org.algorithm.datastructure.tree;

import org.algorithm.base.TreeNode;

/**
 * @fileName: LeetCodeM1712.java
 * @description: BINode
 * @author: by echo huang
 * @date: 2020/10/30 3:32 下午
 */
public class LeetCodeM1712 {
    private TreeNode dummyHead = new TreeNode(-1);
    private TreeNode prev;

    public TreeNode convertBiNode(TreeNode root) {
        helper(root);
        return dummyHead.right;
    }

    // 辅助函数，因为二叉搜索树的中序遍历是有序的
    void helper(TreeNode root) {
        if (root == null) {
            return;
        }
        helper(root.left);
        if (prev == null) {
            dummyHead.right = root;
            prev = root;
        } else {
            prev.right = root;
            prev = root;
        }
        root.left = null;
        helper(root.right);
    }

}
