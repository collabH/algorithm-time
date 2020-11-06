package org.algorithm.mianshi;

import org.algorithm.base.ListNode;
import org.algorithm.base.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @fileName: ListOfDepth0403.java
 * @description: ListOfDepth0403.java类说明
 * @author: by echo huang
 * @date: 2020/11/6 2:45 下午
 */
public class ListOfDepth0403 {
    public ListNode[] listOfDepth(TreeNode tree) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(tree);

        List<ListNode> res = new ArrayList<>();
        ListNode dummy = new ListNode(0);
        while (!queue.isEmpty()) {
            int size = queue.size();
            ListNode curr = dummy;
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = queue.poll();
                curr.next = new ListNode(treeNode.val);
                if (treeNode.left != null) {
                    queue.offer(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.offer(treeNode.right);
                }
                curr = curr.next;
            }
            res.add(dummy.next);
            dummy.next = null;
        }
        ListNode[] listNodes = new ListNode[res.size()];
        for (int i = 0; i < res.size(); i++) {
            listNodes[i] = res.get(i);
        }
        return listNodes;
    }
}
