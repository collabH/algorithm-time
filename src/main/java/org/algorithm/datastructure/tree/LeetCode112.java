package org.algorithm.datastructure.tree;

import org.algorithm.base.TreeNode;

/**
 * @fileName: LeetCode112.java
 * @description: LeetCode112.java类说明
 * @author: by echo huang
 * @date: 2020/11/18 10:36 下午
 */
public class LeetCode112 {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root ==null){
            return false;
        }
        if (root.left == null&&root.right==null) return root.val==sum;
        return hasPathSum(root.left,sum - root.val)||hasPathSum(root.right,sum - root.val);
    }
}
