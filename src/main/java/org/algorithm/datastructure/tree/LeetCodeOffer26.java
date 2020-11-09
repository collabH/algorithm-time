package org.algorithm.datastructure.tree;

import org.algorithm.base.TreeNode;

/**
 * @fileName: LeetCodeOffer26.java
 * @description: 树的子结构
 * @author: by echo huang
 * @date: 2020/11/9 4:23 下午
 */
public class LeetCodeOffer26 {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        return (A != null && B != null) && (preOrder(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
    }

    boolean preOrder(TreeNode A, TreeNode B) {
        if (B == null) return true;
        if (A == null || A.val != B.val) return false;
        return preOrder(A.left, B.left) && preOrder(A.right, B.right);
    }
}
