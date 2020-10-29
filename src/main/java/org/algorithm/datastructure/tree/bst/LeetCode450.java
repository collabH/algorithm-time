package org.algorithm.datastructure.tree.bst;

import org.algorithm.base.TreeNode;

/**
 * @fileName: LeetCode450.java
 * @description: 删除BST中的节点
 * @author: by echo huang
 * @date: 2020/10/29 5:50 下午
 */
public class LeetCode450 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val > key) {
            root.left = deleteNode(root.left, key);
            return root;
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
            return root;
        } else {
            if (root.left == null) {
                TreeNode deleteNode = root.right;
                root.right = null;
                return deleteNode;
            } else if (root.right == null) {
                TreeNode deleteNode = root.left;
                root.left = null;
                return deleteNode;
                // 存在左右子树，将删除节点的前驱节点替换到删除节点的位置
            } else {
                TreeNode sucessor = maxNode(root.left);
                sucessor.left = removeMax(root.left);
                sucessor.right = root.right;
                return sucessor;
            }
        }
    }


    private TreeNode removeMax(TreeNode node) {
        if (node.right == null) {
            TreeNode left = node.left;
            node.left = null;
            return left;
        }
        node.right = removeMax(node.right);
        return node;
    }

    private TreeNode maxNode(TreeNode node) {
        if (node.right == null) {
            return node;
        }
        return maxNode(node.right);
    }

}
