package org.algorithm.datastructure.tree;

import org.algorithm.base.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @fileName: LeetCode113.java
 * @description: 路径总和 II
 * @author: by echo huang
 * @date: 2020/11/21 7:28 下午
 */
public class LeetCode113 {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> list = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        dfs(root, 0, sum);
        return res;
    }

    public void dfs(TreeNode root, int num, int sum) {
        // 总之条件
        if (root == null) return;
        // 添加数据
        num += root.val;
        // 添加路径
        list.add(root.val);
        // 满足条件加入res
        if (num == sum && root.left == null && root.right == null) res.add(new ArrayList(list));
        // 遍历左边
        dfs(root.left, num, sum);
        // 遍历右边
        dfs(root.right, num, sum);
        // 撤销选择
        list.removeLast();
    }
}
