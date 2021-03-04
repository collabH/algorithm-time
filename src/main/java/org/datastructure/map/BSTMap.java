package org.datastructure.map;

/**
 * @fileName: BSTMap.java
 * @description: BSTMap.java类说明
 * @author: by echo huang
 * @date: 2020/10/29 11:34 下午
 */
public class BSTMap<K extends Comparable<K>, V> implements Map<K, V> {
    private class Node {
        public K k;
        public V v;
        // 左右子树
        public Node left, right;

        public Node(K k, V v) {
            this.k = k;
            this.v = v;
            this.left = null;
            this.right = null;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "k=" + k +
                    ", v=" + v +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

    // root节点
    private Node root;
    private int size;

    public BSTMap() {

    }

    @Override
    public void add(K k, V v) {
        root = add(root, k, v);
    }

    private Node add(Node node, K k, V v) {
        if (node == null) {
            size++;
            return new Node(k, v);
        }
        // 判断如果插入key在左子树
        if (node.k.compareTo(k) > 0) {
            node.left = add(node.left, k, v);
            // 如果插入key在右子树
        } else if (node.k.compareTo(k) < 0) {
            node.right = add(node.right, k, v);
        } else {
            // 替换value值
            node.v = v;
        }
        return node;
    }

    private Node getNode(Node node, K k) {
        if (node == null) {
            return null;
        }
        if (node.k.compareTo(k) == 0) {
            return node;
        } else if (node.k.compareTo(k) > 0) {
            return getNode(node.left, k);
        } else {
            return getNode(node.right, k);
        }
    }

    @Override
    public V remove(K k) {
        if (getNode(root, k) == null) {
            throw new IllegalArgumentException();
        }
        Node remove = remove(root, k);
        return remove == null ? null : remove.v;
    }

    private Node remove(Node node, K k) {
        if (node == null) {
            return null;
        }
        if (k.compareTo(node.k) < 0) {
            node.left = remove(node.left, k);
            return node;
        } else if (k.compareTo(node.k) > 0) {
            node.right = remove(node.right, k);
            return node;
        } else {
            if (node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                size--;
                // 右子树为根节点
                return rightNode;
            } else if (node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                size--;
                // 左子树为根节点
                return leftNode;
            }
            // 画图更合适
            // 如果存在左右孩子节点，找到node的后继，右节点的左节点
            // 找到左子数的最大节点
            Node successor = maxNode(node.left);
            // 移除最大节点，左子树的最大节点的左孩子等于左子树的左孩子
            successor.left = removeMax(node.left);
            // 左子树的最大节点的右孩子等于节点的右孩子
            successor.right = node.right;
            return successor;
        }
    }

    private Node removeMax(Node node) {
        // 如果右子树为null，则移除node节点，新的树为左子树
        if (node.right == null) {
            return node.left;
        }
        // 否则递归
        node.right = removeMax(node.right);
        return node;
    }

    private Node maxNode(Node node) {
        if (node.right == null) {
            return node;
        }
        return maxNode(node.right);
    }

    @Override
    public boolean contains(K k) {
        return getNode(root, k) != null;
    }

    @Override
    public V get(K k) {
        return getNode(root, k) == null ? null : getNode(root, k).v;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void set(K k, V v) {
        Node node = getNode(root, k);
        if (node != null) {
            node.v = v;
        }
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        return "BSTMap{" +
                "root=" + root +
                '}';
    }

    public static void main(String[] args) {
        Map<Integer, Integer> map = new BSTMap<>();
        map.add(1, 1);
        map.add(1, 2);
        map.add(2, 3);
        map.add(3, 3);
        map.add(3, 4);
        System.out.println(map);
        System.out.println(map.contains(2));
        map.set(3, 5);
        System.out.println(map);
        map.remove(3);
        System.out.println(map);
        System.out.println(map.isEmpty());
        System.out.println(map.get(1));
        System.out.println(map.size());
    }
}
