package org.datastructure.union;

/**
 * @fileName: TreeUnionFind.java
 * @description: TreeUnionFind.java类说明
 * @author: by echo huang
 * @date: 2020/11/4 10:37 下午
 */
public class TreeUnionFind1 implements UnionFind {

    private int[] parent;
    private int count;
    private int[] rank;

    public TreeUnionFind1(int count) {
        this.count = count;
        rank = new int[count];
        parent = new int[count];
        // 节点指向自己
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    @Override
    public int getSize() {
        return count;
    }

    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    public void unionElements(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) {
            return;
        }
        // 防止数据倾斜将小树接到大树下, size优化
        if (rank[rootP] > rank[rootQ]) {
            parent[rootQ] = rootP;
        } else if (rank[rootP] < rank[rootQ]) {
            parent[rootP] = rootQ;
        } else {
            parent[rootP] = rootQ;
            rank[rootQ] += 1;
        }
        count--;
    }

    private int find(int p) {
        if (p < 0 || p >= parent.length) {
            throw new IllegalArgumentException();
        }
        while (parent[p] != p) {
            // 路径压缩，减少遍历数据深度
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }
}
