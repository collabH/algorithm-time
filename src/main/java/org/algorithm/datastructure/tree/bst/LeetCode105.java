package org.algorithm.datastructure.tree.bst;

import org.algorithm.base.TreeNode;

/**
 * @fileName: LeetCode105.java
 * @description: 从前序与中序遍历序列构造二叉树
 * @author: by echo huang
 * @date: 2020/10/30 11:44 上午
 */
public class LeetCode105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // base case
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        return build(preorder, 0, preorder.length - 1,
                inorder, 0, inorder.length - 1);
    }

    TreeNode build(int[] preorder, int preStart, int preEnd,
                   int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd) {
            return null;
        }
        int rootVal = preorder[preStart];
        int index = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == rootVal) {
                index = i;
                break;
            }
        }
        TreeNode root = new TreeNode(rootVal);

        // leftSize
        int leftSize = index - inStart;

        root.left = build(preorder, preStart + 1, preStart + leftSize,
                inorder, inStart, index - 1);
        root.right = build(preorder, preStart + leftSize+1, preEnd,
                inorder, index + 1, inEnd);

        return root;
    }
}
