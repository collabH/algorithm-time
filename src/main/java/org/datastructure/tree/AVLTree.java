package org.datastructure.tree;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * @fileName: AVLTree.java
 * @description: AVL树
 * @author: by echo huang
 * @date: 2020/10/27 1:24 下午
 */
public class AVLTree<E extends Comparable<E>> {
    public static void main(String[] args) {
        AVLTree<Integer> bst = new AVLTree<>();

        int[] nums = {1, 2, 3, 4, 5, 6};
        for (int num : nums) {
            bst.add(num);
        }

        bst.add(10);
        bst.add(11);
        bst.add(14);
        bst.add(15);

        System.out.println(bst.isBalanced());
        System.out.println(bst.isBST());
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

    // 获得树的高度
    private int getHeight(Node<E> node) {
        if (node == null) {
            return 0;
        }
        return node.height;
    }

    private int getBalanceFactor(Node<E> node) {
        if (node == null) {
            return 0;
        }
        // 左子树的高度和右子树的高度差
        return getHeight(node.left) - getHeight(node.right);
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
        } else if (node.e.compareTo(e) < 0) {
            node.right = add(node.right, e);
        }
        // 平衡AVL树
        return maintainBalance(node);
    }

    /**
     * 右旋转过程
     *
     * @param y
     * @return
     */
    private Node<E> rightRotate(Node<E> y) {
        Node<E> x = y.left;
        Node<E> T3 = x.right;
        // 向右旋转
        x.right = y;
        y.left = T3;

        // 更新height
        y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
        x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;
        return x;
    }

    /**
     * y                                     x
     * / \                                   / \
     * T1  x                                 y   z
     * /\         ------->向左旋转       / \  / \
     * T2 z                            T1 T2 T3 T4
     * /\
     * T3 T4
     *
     * @param y
     * @return
     */
    private Node<E> leftRotate(Node<E> y) {
        Node<E> x = y.right;
        Node<E> T2 = x.left;
        // 向左旋转
        x.left = y;
        y.right = T2;

        // 更新height
        y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
        x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;
        return x;
    }

    public boolean isBST() {
        List<E> list = new ArrayList<>();
        // 中序便利出来的数据从小到大排列
        inOrder(root, list);
        for (int i = 1; i < list.size(); i++) {
            // 如果第一个大于第二个元素则不是BST
            if (list.get(i - 1).compareTo(list.get(i)) > 0) {
                return false;
            }
        }
        return true;
    }

    public boolean isBalanced() {
        return isBalanced(root);
    }

    private boolean isBalanced(Node<E> root) {
        if (root == null) {
            return true;
        }
        int balanceFactor = getBalanceFactor(root);
        if (Math.abs(balanceFactor) > 1) {
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
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
                Node<E> cur = stack.pop();
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
     *
     * @param node
     * @param list
     */
    public void inOrder(Node<E> node, List<E> list) {
        if (node != null) {
            inOrder(node.left, list);
            list.add(node.e);
            inOrder(node.right, list);
        }
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
            Node<E> rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }
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
        Node<E> retNode;
        if (e.compareTo(node.e) < 0) {
            node.left = remove(node.left, e);
            retNode = node;
        } else if (e.compareTo(node.e) > 0) {
            node.right = remove(node.right, e);
            retNode = node;
        } else {
            if (node.left == null) {
                Node<E> rightNode = node.right;
                node.right = null;
                size--;
                retNode = rightNode;
            } else if (node.right == null) {
                Node<E> leftNode = node.left;
                node.left = null;
                size--;
                retNode = leftNode;
            }   // 如果存在左右孩子节点，找到node的后继，右节点的左节点
            else {
                Node<E> successor = minimum(node.right);
                successor.right = remove(successor, successor.e);
                successor.left = node.left;
                retNode = successor;
            }
        }
        if (retNode == null) {
            return null;
        }
        return maintainBalance(retNode);
    }

    private Node<E> maintainBalance(Node<E> node) {
        // 更新height
        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));

        // 计算平衡因子
        int balanceFactor = getBalanceFactor(node);
        // 不满足平衡二叉树
        if (Math.abs(balanceFactor) > 1) {
            System.out.println("unblanced:" + balanceFactor);
        }
        // LL 平衡维护，右旋转，插入的元素在不平衡的节点的左侧的左侧，此时可以使用右旋转保证树的平衡
        if (balanceFactor > 1 && getBalanceFactor(node.left) >= 0) {
            return rightRotate(node);
        }
        // RR
        if (balanceFactor < -1 && getBalanceFactor(node.right) <= 0) {
            return leftRotate(node);
        }
        // LR左子树大于右子树，并且左子树的左子树小于左子树的右子树
        if (balanceFactor > 1 && getBalanceFactor(node.left) < 0) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        // RL 左子树小于右子树，并且左子树的左子树大于左子树的右子树
        if (balanceFactor < -1 && getBalanceFactor(node.right) > 0) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }
        return null;
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
