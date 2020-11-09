package org.algorithm.datastructure.tree;

import org.algorithm.base.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @fileName: LeetCode103.java
 * @description: 二叉树的锯齿形层次遍历
 * @author: by echo huang
 * @date: 2020/11/9 3:55 下午
 */
public class LeetCode103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        int level = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            LinkedList<Integer> item = new LinkedList<>();
            for (int i = 0; i < size; ++i) {
                TreeNode node = queue.poll();
                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
                if ((level & 1) == 0)
                    item.addLast(node.val);
                else
                    item.addFirst(node.val);
            }
            res.add(item);
            ++level;
        }
        return res;
    }


    public static void main(String[] args) {
//        LeetCode103 leetCode103 = new LeetCode103();
//        TreeNode node = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
//        System.out.println(leetCode103.zigzagLevelOrder(node));
        System.out.println(3 & 1);

        //n % 2 == n & 1
        int n = 10;
    }

}
