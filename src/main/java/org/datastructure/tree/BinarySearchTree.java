package org.datastructure.tree;

/**
 * @fileName: BinarySearchTree.java
 * @description: 二分搜索树
 * @author: by echo huang
 * @date: 2020/10/27 1:24 下午
 */
public class BinarySearchTree<E extends Comparable<E>> {
    public static void main(String[] args) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();

        int[] nums = {5, 3, 6, 8, 4, 1};
        for (int num : nums) {
            bst.add(num);
        }

        bst.preOrder();
        System.out.println();
        System.out.println(bst);
    }

    private Node<E> root;
    private int size;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(E e) {
        root = add(root, e);
    }

    /**
     * 返回插入新节点的二叉树的根
     *
     * @param node
     * @param e
     * @return
     */
    private Node<E> add(Node<E> node, E e) {
        if (node == null) {
            size++;
            return new Node<>(e);
        }
        // 插入右子树
        if (node.e.compareTo(e) > 0) {
            node.right = add(node.right, e);
        } else if (node.e.compareTo(e) < 0) {
            node.left = add(node.left, e);
        }
        return node;
    }

    /**
     * 查询元素是否包含
     *
     * @param e
     * @return
     */
    public boolean contains(E e) {
        return contains(root, e);
    }

    /**
     * 查询原属递归函数
     *
     * @param node
     * @param e
     * @return
     */
    private boolean contains(Node<E> node, E e) {
        if (root == null) {
            return false;
        }
        if (root.e.compareTo(e) == 0) {
            return true;
        } else if (root.e.compareTo(e) > 0) {
            return contains(root.right, e);
        } else {
            return contains(root.left, e);
        }
    }

    /**
     * 前序遍历
     * 根 左 右
     */
    public void preOrder() {
        preOrder(root);
    }

    public void preOrder(Node<E> node) {
        if (node != null) {
            System.out.println(node.e);
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    /**
     * 后序遍历
     * 左 右 根
     */
    public void postOrder() {
        postOrder(root);
    }

    public void postOrder(Node<E> node) {
        if (node != null) {
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        generateBSTString(root, 0, sb);
        return sb.toString();

    }

    private void generateBSTString(Node<E> root, int i, StringBuilder sb) {
        if (root == null) {
            sb.append(generateDepthString(i)).append("null\n");
            return;
        }
        sb.append(generateDepthString(i)).append(root.e).append("\n");
        generateBSTString(root.left, i + 1, sb);
        generateBSTString(root.right, i + 1, sb);
    }

    private String generateDepthString(int i) {
        StringBuilder res = new StringBuilder();
        for (int i1 = 0; i1 < i; i1++) {
            res.append("--");
        }
        return res.toString();
    }
}
