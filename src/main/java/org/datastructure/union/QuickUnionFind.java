package org.datastructure.union;

/**
 * @fileName: QuickUnionFind.java
 * @description: QuickUnionFind.java类说明
 * @author: by echo huang
 * @date: 2020/11/4 10:29 下午
 */
public class QuickUnionFind implements UnionFind {
    // 每个数据对应的集合的编号
    private int[] id;

    private int[] size;

    public QuickUnionFind(int size) {
        //初始化元素
        id = new int[size];
        // 将集合编号指向自己
        for (int i = 0; i < id.length; i++) {
            id[i] = i;
        }
    }

    @Override
    public int getSize() {
        return id.length;
    }

    @Override
    public boolean isConnected(int p, int q) {
        // p和q所存储的集合编号是否相等
        return find(p) == find(q);
    }


    /**
     * O n
     *
     * @param p
     * @param q
     */
    @Override
    public void unionElements(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) {
            return;
        }
        for (int i = 0; i < id.length; i++) {
            // 联通p q，使id[p]=q
            if (id[i] == rootP) {
                id[i] = rootQ;
            }
        }
    }

    /**
     * 查找元素p对应的编号
     *
     * @param p
     * @return
     */
    private int find(int p) {
        if (p < 0 || p >= id.length) {
            throw new IllegalArgumentException();
        }
        return id[p];
    }
}
