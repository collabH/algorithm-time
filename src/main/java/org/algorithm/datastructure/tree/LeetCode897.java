package org.algorithm.datastructure.tree;

import org.algorithm.base.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @fileName: LeetCode897.java
 * @description: 递增顺序查找树
 * @author: by echo huang
 * @date: 2020/11/9 2:51 下午
 */
public class LeetCode897 {
    TreeNode cur;

    public TreeNode increasingBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode temp = new TreeNode(0);
        cur = temp;
        inOrder(root);
        return temp.right;
    }

    private void inOrder(TreeNode root) {
        if (root == null) return;

        inOrder(root.left);
        root.left = null;
        cur.right = root;
        cur = root;
        inOrder(root.right);
    }


    private List<Integer> nums = new ArrayList<>();

    private int count = 0, res = 0;

    public int kthLargest(TreeNode root, int k) {
        count = k;
        inOrder2(root);
    return res;
    }

    private void inOrder1(TreeNode node) {
        if (node == null) return;
        inOrder1(node.left);
        nums.add(node.val);
        inOrder1(node.right);
    }


    private void inOrder2(TreeNode node) {
        if (node == null || count == 0) return;
        inOrder1(node.right);
        if (--count == 0) {
            res = node.val;
            return;
        }
        inOrder1(node.left);
    }

}
