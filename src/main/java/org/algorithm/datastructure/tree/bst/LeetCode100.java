package org.algorithm.datastructure.tree.bst;

import org.algorithm.base.TreeNode;

/**
 * @fileName: LeetCode100.java
 * @description: 相同的树
 * @author: by echo huang
 * @date: 2020/10/29 5:40 下午
 */
public class LeetCode100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
