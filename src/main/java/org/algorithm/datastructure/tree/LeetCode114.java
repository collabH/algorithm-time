package org.algorithm.datastructure.tree;

import org.algorithm.base.TreeNode;

/**
 * @fileName: LeetCode114.java
 * @description: 二叉树展开成链表
 * @author: by echo huang
 * @date: 2020/10/30 10:57 上午
 */
public class LeetCode114 {
    public void flatten(TreeNode root) {
        // base case
        if (root == null) {
            return;
        }
        // 后续遍历 左右子树已经拉平成链表了
        flatten(root.left);
        flatten(root.right);

        TreeNode right = root.right;
        TreeNode left = root.left;

        root.left = null;
        root.right = left;

        TreeNode p = root;
        //将原先的右子树接到当前右子树的末端
        while (p.right != null) {
            p = p.right;
        }
        p.right = right;
    }


    // 寻找前驱节点，然后将当前节点右子树变成前驱节点的右子树
    public void flatten1(TreeNode root) {
        // base case
        if (root == null) {
            return;
        }
        TreeNode curr = root;
        while (curr != null) {
            if (curr.left != null) {
                TreeNode next = curr.left;
                TreeNode predecessor = next;
                // cur的前驱
                while (predecessor.right != null) {
                    predecessor = predecessor.right;
                }
                // 将cur的right指向给cur的前驱节点
                predecessor.right = curr.right;
                // cur的左子树设置为null
                curr.left = null;
                next.right=predecessor;
                // cur的右子树设置为next
                curr.right = next;
            }
            curr = curr.right;
        }
    }

}
