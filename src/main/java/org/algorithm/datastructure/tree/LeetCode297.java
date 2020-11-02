package org.algorithm.datastructure.tree;

import org.algorithm.base.TreeNode;

/**
 * @fileName: LeetCode297.java
 * @description: 二叉树的序列化与反序列化
 * @author: by echo huang
 * @date: 2020/11/2 2:10 下午
 */
public class LeetCode297 {
    private static final String NULL = "#";
    private static final String SEP = ",";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        traverse(root, sb);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] arr = data.split(",");
        return null;
    }

    void traverse(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append(NULL).append(SEP);
            return;
        }
        sb.append(root.val).append(SEP);
        traverse(root.left, sb);
        traverse(root.right, sb);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(20), new TreeNode(2, new TreeNode(3), new TreeNode(4)));
        LeetCode297 leetCode297 = new LeetCode297();
        System.out.println(leetCode297.serialize(root));
    }
}
