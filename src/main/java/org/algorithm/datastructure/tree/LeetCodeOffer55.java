package org.algorithm.datastructure.tree;

import org.algorithm.base.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @fileName: LeetCodeOffer55.java
 * @description: 计算二叉树的深度 层序遍历
 * @author: by echo huang
 * @date: 2020/10/30 2:57 下午
 */
public class LeetCodeOffer55 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int dept = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        Queue<TreeNode> temp;
        while (!queue.isEmpty()) {
            temp = new LinkedList<>();
            for (TreeNode treeNode : queue) {
                if (treeNode.right != null) {
                    temp.add(treeNode.right);
                }
                if (treeNode.left != null) {
                    temp.add(treeNode.left);
                }
            }
            queue = temp;
            dept++;
        }
        return dept;
    }
}
