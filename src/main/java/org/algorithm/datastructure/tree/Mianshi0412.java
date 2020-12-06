package org.algorithm.datastructure.tree;

import org.algorithm.base.TreeNode;

/**
 * @fileName: Mianshi0412.java
 * @description: 面试题 04.12. 求和路径
 * @author: by echo huang
 * @date: 2020/12/6 6:47 下午
 */
public class Mianshi0412 {
    private int res = 0;

    public int pathSum(TreeNode root, int sum) {
        if(root == null) return res;

        // 根节点
        helper(root, sum);

        // 非根节点
        pathSum(root.left, sum);
        pathSum(root.right, sum);
        return res;
    }

    private void helper(TreeNode node, int sum){
        if(node == null) return;
        // 做选择
        sum -= node.val;
        if(sum == 0)
            res ++;
        helper(node.left, sum);
        helper(node.right, sum);
        // 撤销选择
        sum += node.val;
    }
}
