package org.datastructure.tree;

class NumArray1 {
    private int[] data;
    private int[] tree;

    public NumArray1(int[] nums) {
        if (nums.length > 0) {
            data = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                data[i] = nums[i];
            }
            tree = new int[4 * nums.length];
            bulidSegmentTree(0, 0, data.length - 1);
        }
    }

    private void bulidSegmentTree(int treeIndex, int l, int r) {
        if (l == r) {
            tree[treeIndex] = data[l];
            return;
        }
        int mid = l + (r - l) / 2;
        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);

        // 构建左子树
        bulidSegmentTree(leftTreeIndex, l, mid);
        // 构建右子树
        bulidSegmentTree(rightTreeIndex, mid + 1, r);
        tree[treeIndex] = tree[leftTreeIndex] + tree[rightTreeIndex];
    }


    private int leftChild(int index) {
        return 2 * index + 1;
    }

    private int rightChild(int index) {
        return 2 * index + 2;
    }

    public void update(int i, int val) {
        update(0, 0, data.length - 1, i, val);
    }

    private void update(int treeIndex, int l, int r, int index, int e) {
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
        tree[treeIndex] = tree[leftTreeIndex] + tree[rightTreeIndex];
    }

    public int sumRange(int i, int j) {
        return query(0, 0, data.length - 1, i, j);
    }

    private int query(int treeIndex, int l, int r, int queryL, int queryR) {
        if (queryL < 0 || queryL >= data.length || queryR < 0 || queryR >= data.length || queryL > queryR) {
            throw new IllegalArgumentException();
        }
        if (l == queryL && r == queryR) {
            return tree[treeIndex];
        }
        int mid = l + (r - l) / 2;
        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);
        // 判断区间在左子树还是在右子树
        if (queryR <= mid) {
            return query(leftTreeIndex, l, mid, queryL, queryR);
        } else if (queryL >= mid + 1) {
            return query(rightTreeIndex, mid + 1, r, queryL, queryR);
        }
        // 区间在左右子树上
        int leftResult = query(leftTreeIndex, l, mid, queryL, mid);

        int rightResult = query(rightTreeIndex, mid + 1, r, mid + 1, queryR);
        return leftResult + rightResult;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */