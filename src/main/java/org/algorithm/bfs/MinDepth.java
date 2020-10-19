package org.algorithm.bfs;

import org.algorithm.base.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @fileName: MinDepth.java
 * @description: 给定一个二叉树，找出其最小深度。
 * @author: by echo huang
 * @date: 2020/10/19 9:59 上午
 */
public class MinDepth {
    public static void main(String[] args) {

    }

    public int minDepth(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        // 设置start
        queue.offer(root);
        // 默认深度为1
        int depth = 1;
        while (!queue.isEmpty()) {
            // 获取当前queue的个数
            int size = queue.size();
            // 为了处理队列中全部的元素，这里应该记录下被处理过后的node
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                // target条件
                if (cur.left == null && cur.right == null) {
                    return depth;
                }
                // 左边还有treeNode
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                // 右边还有treeNode
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            // depth每增加一次，队列中的所有节点向前一步
            depth++;
        }
        return depth;
    }
}

