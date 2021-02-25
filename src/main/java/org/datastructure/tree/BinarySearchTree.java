package org.datastructure.tree;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @fileName: BinarySearchTree.java
 * @description: 二分搜索树
 * @author: by echo huang
 * @date: 2020/10/27 1:24 下午
 */
public class BinarySearchTree<E extends Comparable<E>> {
    public static void main(String[] args) {
        BinarySearchTree<Integer> bst = new org.datastructure.tree.BinarySearchTree<Integer>();

        int[] nums = {5, 3, 6, 8, 4, 1};
        for (int num : nums) {
            bst.add(num);
        }

//        bst.preOrder();
//        System.out.println("--");
//        bst.preOrderNR();
//        System.out.println("--");
//        bst.inOrder();
//        System.out.println("--");
//        bst.bfs();
//        System.out.println("--");
//        bst.postOrder();
//        System.out.println("--");
//        System.out.println(bst);
//
//
//        System.out.println("--");
//        System.out.println(bst.removeMax());
//        System.out.println(bst);
//        System.out.println(bst.removeMin());
//        System.out.println(bst);
        System.out.println("----");
        bst.inOrder();
    }

    // 树节点，包含left、right，和val
    private Node<E> root;
    // 节点个数
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
        // 插入左子树
        if (node.e.compareTo(e) > 0) {
            node.left = add(node.left, e);
            //插入右子树
        } else if (node.e.compareTo(e) < 0) {
            node.right = add(node.right, e);
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
            return contains(root.left, e);
        } else {
            return contains(root.right, e);
        }
    }

    /**
     * 前序遍历
     * 根 左 右
     */
    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node<E> node) {
        if (node != null) {
            System.out.println(node.e);
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    /**
     * 非递归前序遍历
     */
    private void preOrderNR() {
        Stack<Node<E>> stack = new Stack<>();
        if (root != null) {
            stack.push(root);
            while (!stack.isEmpty()) {
                // 弹出栈中元素
                Node<E> cur = stack.pop();
                // 根左右操作，栈是后进先出，所以入栈为右左，那么出栈就会为左右
                System.out.println(cur.e);

                if (cur.right != null) {
                    stack.push(cur.right);
                }
                if (cur.left != null) {
                    stack.push(cur.left);
                }
            }
        }
    }

    /**
     * 左根右
     */
    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node<E> node) {
        if (node != null) {
            inOrder(node.left);
            System.out.println(node.e);
            inOrder(node.right);
        }
    }

    /**
     * 后序遍历
     * 左 右 根
     */
    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(Node<E> node) {
        if (node != null) {
            preOrder(node.left);
            preOrder(node.right);
            System.out.println(node.e);
        }
    }

    /**
     * 层序遍历，广度有限遍历
     */
    public void bfs() {
        Queue<Node<E>> queue = new LinkedList<>();
        if (root != null) {
            queue.add(root);
            while (!queue.isEmpty()) {
                Node<E> cur = queue.remove();
                System.out.println(cur.e);
                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
            }
        }
    }

    public E minimum() {
        if (root == null) {
            throw new IllegalArgumentException();
        }
        return minimum(root).e;
    }

    /**
     * 最小值的节点
     *
     * @return
     */
    public Node<E> minimum(Node<E> node) {
        if (node.left == null) {
            return node;
        }
        return minimum(node.left);
    }

    public E maximum() {
        if (root == null) {
            throw new IllegalArgumentException();
        }
        return maximum(root).e;
    }

    /**
     * 最大值节点
     *
     * @param node
     * @return
     */
    public Node<E> maximum(Node<E> node) {
        if (node.right == null) {
            return node;
        }
        return maximum(node.right);
    }

    public E removeMin() {
        E ret = minimum();
        root = removeMin(root);
        return ret;
    }

    private Node<E> removeMin(Node<E> node) {
        if (node.left == null) {
            // 相当于移除根节点
            Node<E> rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }
        // 当前节点的左子树等于左子树节点的右子树
        // 返回的值为删除节点的右子树，此时他为当前node节点的左子树
        node.left = removeMin(node.left);
        return node;
    }

    public E removeMax() {
        E maximum = maximum();
        root = removeMax(root);
        return maximum;
    }

    public Node<E> removeMax(Node<E> node) {
        if (node.right == null) {
            Node<E> leftNode = node.left;
            node.left = null;
            size--;
            return leftNode;
        }
        node.right = removeMax(node.right);
        return node;
    }

    public void remove(E e) {
        root = remove(root, e);
    }

    private Node<E> remove(Node<E> node, E e) {
        if (node == null) {
            return null;
        }
        // 移除左子树
        if (e.compareTo(node.e) < 0) {
            node.left = remove(node.left, e);
            return node;
        } else if (e.compareTo(node.e) > 0) {
            node.right = remove(node.right, e);
            return node;
        } else {
            // 如果删除节点左子树为空
            if (node.left == null) {
                //  获取器right
                Node<E> rightNode = node.right;
                // 返回其右子树
                node.right = null;
                size--;
                return rightNode;
            } else if (node.right == null) {
                Node<E> leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            }   // 如果存在左右孩子节点，找到node的后继，右节点的左节点
            // 找到右子树最小的节点
            Node<E> successor = minimum(node.right);
            successor.right = removeMin(node.right);
            successor.left = node.left;
            return successor;
        }
    }

    /**
     * 使用删除节点的前驱来替代删除的节点
     *
     * @param node
     * @param e
     * @return
     */
    private Node<E> remove1(Node<E> node, E e) {
        if (node == null) {
            return null;
        }
        if (e.compareTo(node.e) < 0) {
            node.left = remove(node.left, e);
            return node;
        } else if (e.compareTo(node.e) > 0) {
            node.right = remove(node.right, e);
            return node;
        } else {
            if (node.left == null) {
                Node<E> rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            } else if (node.right == null) {
                Node<E> leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            }   // 如果存在左右孩子节点，找到node的前驱，右节点的左节点
            Node<E> successor = maximum(node.left);
            successor.left = removeMax(node.left);
            successor.right = node.right;
            return successor;
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
