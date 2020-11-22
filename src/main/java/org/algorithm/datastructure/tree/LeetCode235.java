package org.algorithm.datastructure.tree;

import org.algorithm.base.TreeNode;

/**
 * @fileName: LeetCode235.java
 * @description: LeetCode235.java类说明
 * @author: by echo huang
 * @date: 2020/11/22 3:27 下午
 */
public class LeetCode235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode ancestor = root;
        while (true) {
            // 都在左边，都在右边
            if (p.val < ancestor.val && q.val < ancestor.val) {
                ancestor = ancestor.left;
            } else if (p.val > ancestor.val && q.val > ancestor.val) {
                ancestor = ancestor.right;
                // 相同
            } else {
                break;
            }
        }
        return ancestor;
    }
}
