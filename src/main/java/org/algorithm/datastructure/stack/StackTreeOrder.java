package org.algorithm.datastructure.stack;

import org.algorithm.base.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @fileName: StackTreeOrder.java
 * @description: StackTreeOrder.java类说明
 * @author: by echo huang
 * @date: 2020/11/16 10:53 下午
 */
public class StackTreeOrder {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            list.add(cur.val);
            if (cur.right!=null){
                stack.push(cur.right);
            }
            if (cur.left!=null){
                stack.push(cur.left);
            }
        }

        return list;
    }
}
