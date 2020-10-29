package org.algorithm.datastructure.tree.bst;

import java.util.ArrayList;
import java.util.List;

/**
 * @fileName: LeetCode589.java
 * @description: LeetCode589.java类说明
 * @author: by echo huang
 * @date: 2020/10/29 12:01 上午
 */
public class LeetCode589 {
    public List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        List<Node> children = root.children;

        if (children == null || children.size() == 0) {
            result.add(root.val);
            return result;
        }
        preOrder(root, result);
        return result;
    }

    private void preOrder(Node node, List<Integer> res) {
        if (node != null) {
            res.add(node.val);
            for (Node child : node.children) {
                preOrder(child, res);
            }
        }
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    ;
}
