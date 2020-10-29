package org.algorithm.tree;

/**
 * @fileName: LeetCode701.java
 * @description: 二叉搜索树中的插入操作
 * @author: by echo huang
 * @date: 2020/10/27 4:22 下午
 */
public class LeetCode701 {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        // 向左子树插入数据
        if (root.val > val) {
            if (root.left == null) {
                root.left = new TreeNode(val);
                return root;
            }
            insertIntoBST(root.left, val);
        } else {
            if (root.right == null) {
                root.right = new TreeNode(val);
                return root;
            }
            // 右子树插入数据
            insertIntoBST(root.right, val);
        }
        return root;
    }



    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
