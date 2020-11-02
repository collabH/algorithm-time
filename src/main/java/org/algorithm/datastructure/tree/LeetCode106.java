package org.algorithm.datastructure.tree;

import org.algorithm.base.TreeNode;

/**
 * @fileName: LeetCode106.java
 * @description: 从中序与后序遍历序列构造二叉树
 * @author: by echo huang
 * @date: 2020/10/30 2:31 下午
 */
public class LeetCode106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0 || postorder.length == 0) {
            return null;
        }
        return build(inorder, 0, inorder.length - 1,
                postorder, 0, postorder.length - 1);
    }

    private TreeNode build(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
        // base case
        if (inStart > inEnd) {
            return null;
        }
        // 获取root val
        int rootVal = postorder[postEnd];
        int index = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == rootVal) {
                index = i;
                break;
            }
        }

        TreeNode root = new TreeNode(rootVal);
        int rightSize = inEnd - index;
        root.left = build(inorder, inStart, index - 1,
                postorder, postStart, postEnd - rightSize - 1);

        root.right = build(inorder, index + 1, inEnd,
                postorder, postEnd - rightSize, postEnd - 1);

        return root;
    }

}
