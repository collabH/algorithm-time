package org.algorithm.datastructure.tree;

import org.algorithm.base.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @fileName: LeetCode145.java
 * @description: LeetCode145.java类说明
 * @author: by echo huang
 * @date: 2020/11/4 11:22 上午
 */
public class LeetCode145 {
    List<Integer> list = new ArrayList<>();

    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) {
            return list;
        }
        postOrder(root);
        return list;
    }

    private void postOrder(TreeNode root) {
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            list.add(root.val);
        }
    }

}
