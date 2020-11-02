package org.datastructure.tree;

import java.util.Arrays;

/**
 * @fileName: SegmentTree.java
 * @description: SegmentTree.java类说明
 * @author: by echo huang
 * @date: 2020/11/2 10:22 下午
 */
public class SegmentTree<E> {
    private E[] tree;
    private E[] data;
    private Merger<E> merger;

    public SegmentTree(E[] arr, Merger<E> merger) {
        this.data = (E[]) new Object[arr.length];
        this.merger = merger;
        for (int i = 0; i < arr.length; i++) {
            data[i] = arr[i];
        }
        tree = (E[]) new Object[4 * arr.length];
        buildSegmentTree(0, 0, data.length - 1);
    }

    /**
     * 在treeIndex的位置创建表示区间[l...r]的线段树
     *
     * @param treeIndex
     * @param l
     * @param r
     */
    private void buildSegmentTree(int treeIndex, int l, int r) {
        // 区间为1
        if (l == r) {
            tree[treeIndex] = data[l];
            return;
        }
        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);

        int mid = l + (r - l) / 2;
        buildSegmentTree(leftTreeIndex, l, mid);
        buildSegmentTree(rightTreeIndex, mid + 1, r);
        tree[treeIndex] = merger.merge(tree[leftTreeIndex], tree[rightTreeIndex]);
    }

    public int getSize() {
        return data.length;
    }

    public E get(int index) {
        if (index < 0 || index >= data.length) {
            throw new IllegalArgumentException();
        }
        return data[index];
    }

    /**
     * root index is zero
     *
     * @param index
     * @return
     */
    private int leftChild(int index) {
        return 2 * index + 1;
    }

    /**
     * @param index
     * @return
     */
    private int rightChild(int index) {
        return 2 * index + 2;
    }

    public E query(int queryL, int queryR) {
        if (queryL < 0 || queryL >= data.length || queryR < 0
                || queryR >= data.length || queryL > queryR) {
            throw new IllegalArgumentException();
        }
        return query(0, 0, data.length - 1, queryL, queryR);
    }

    /**
     * 在以treeID为根的线段树中[l...r]范围里，搜索区间[queryL...queryR]的值
     *
     * @param treeIndex
     * @param l
     * @param r
     * @param queryL
     * @param queryR
     * @return
     */
    private E query(int treeIndex, int l, int r, int queryL, int queryR) {
        if (l == queryL && r == queryR) {
            return tree[treeIndex];
        }
        int mid = l + (r - l) / 2;
        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);

        // 如果queryL在右子树
        if (queryL >= mid + 1) {
            // 从右子树中搜索
            return query(rightTreeIndex, mid + 1, r, queryL, queryR);
            // 如果queryR在左子树
        } else if (queryR <= mid) {
            // 从左子树中搜索
            return query(leftTreeIndex, l, mid, queryL, queryR);
        }
        // 查询区间同时落在左孩子和右孩子上
        E leftResult = query(leftTreeIndex, l, mid, queryL, mid);
        E rightResult = query(rightTreeIndex, mid + 1, r, mid + 1, queryR);
        return merger.merge(leftResult, rightResult);
    }

    public void update(int i, E val) {
        if (i < 0 || i >= data.length) {
            throw new IllegalArgumentException();
        }
        data[i] = val;
        update(0, 0, data.length - 1, i, val);
    }

    private void update(int treeIndex, int l, int r, int index, E e) {
        if (l == r) {
            tree[treeIndex] = e;
            return;
        }
        int mid = l + (r - l) / 2;
        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);
        // 去右子树寻找
        if (index >= mid + 1) {
            update(rightTreeIndex, mid + 1, r, index, e);
        }
        //去左子树寻找
        else {
            update(leftTreeIndex, l, mid, index, e);
        }
        tree[treeIndex] = merger.merge(tree[leftTreeIndex], tree[rightTreeIndex]);
    }


    @Override
    public String toString() {
        return "SegmentTree{" +
                "tree=" + Arrays.toString(tree) +
                ", data=" + Arrays.toString(data) +
                ", merger=" + merger +
                '}';
    }

    public static void main(String[] args) {
        Integer[] num = {-2, 0, 3, -5, 2, -1};
        SegmentTree<Integer> segmentTree = new SegmentTree<>(num, new Merger<Integer>() {
            @Override
            public Integer merge(Integer a, Integer b) {
                return a + b;
            }
        });

        System.out.println(segmentTree);

        System.out.println(segmentTree.query(0, 4));
    }
}
