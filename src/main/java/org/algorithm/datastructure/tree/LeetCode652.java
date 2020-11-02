package org.algorithm.datastructure.tree;

import org.algorithm.base.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @fileName: LeetCode.java
 * @description: 寻找重复的子树
 * @author: by echo huang
 * @date: 2020/10/30 2:56 下午
 */
public class LeetCode652 {
    List<TreeNode> res = new ArrayList<>();

    HashMap<String, Integer> memo = new HashMap<>();

    List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        traverse(root);
        return res;
    }

    public static void main(String[] args) {
        LeetCode652 leetCode652 = new LeetCode652();
        TreeNode treeNode = new TreeNode(2, new TreeNode(1, new TreeNode(2,
                new TreeNode(3), new TreeNode(3)), new TreeNode(3)), new TreeNode(3));
        System.out.println(leetCode652.findDuplicateSubtrees(treeNode));
    }


    String traverse(TreeNode root) {
        if (root == null) {
            return "#";
        }
        String left = traverse(root.left);
        String right = traverse(root.right);

        String subTree = left + "," + right + "," + root.val;

        int freq = memo.getOrDefault(subTree, 0);

        if (freq == 1) {
            res.add(root);
        }
        memo.put(subTree, freq + 1);
        return subTree;
    }
}
