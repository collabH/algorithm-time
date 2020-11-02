package org.algorithm.datastructure.tree;

import org.algorithm.base.TreeNode;

/**
 * @fileName: LeetCode222.java
 * @description: 完全二叉树的节点个数
 * @author: by echo huang
 * @date: 2020/11/2 3:16 下午
 */
public class LeetCode222 {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 计算left和right的层数
        int left = countLevel(root.left);
        int right = countLevel(root.right);
        // 如果left==right，左子树一定是满二叉树，所以左子树的节点的个数为2*leftLevel+右子树递归
        if (left == right) {
            return countNodes(root.right) + (1 << left);
        } else {
            // 否则右子树是满二叉树，右子树的节点个数为2*rightLevel+左子树递归
            return countNodes(root.left) + (1 << right);
        }
    }

    /**
     * 计算二叉树的层数
     *
     * @param root
     * @return
     */
    private int countLevel(TreeNode root) {
        int level = 0;
        while (root != null) {
            level++;
            root = root.left;
        }
        return level;
    }

}
