package org.datastructure.union;

/**
 * @fileName: UF.java
 * @description: UF.java类说明
 * @author: by echo huang
 * @date: 2020/11/3 4:08 下午
 */
public class UF {
    // 记录连通分量
    private int count;
    // 节点x的节点是parent[x]
    private int[] parent;

    // 记录树的"重量"
    private int[] size;

    public UF(int n) {
        // 一开始互不连通
        this.count = n;
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            // 节点i指向自己
            parent[i] = i;
            // 出事状态只包含自己一个节点
            size[i] = 1;
        }
    }

    /**
     * 连通p和q
     *
     * @param p
     * @param q
     */
    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) {
            return;
        }
        // 小树接到大树下，较平衡
        if (size[rootP] > size[rootQ]) {
            parent[rootQ] = rootP;
            size[rootP] += size[rootQ];
        } else {
            parent[rootP] = rootQ;
            size[rootQ] += size[rootP];
        }
        count--;
    }

    /**
     * 判断p和q是否连通
     *
     * @param p
     * @param q
     * @return
     */
    public boolean connected(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        return rootP == rootQ;
    }

    /**
     * 返回某个节点x的根节点
     *
     * @param x
     * @return
     */
    private int find(int x) {
        while (parent[x] != x) {
            // 路径压缩
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }

    public int count() {
        return count;
    }
}
