package org.datastructure.union;

/**
 * @fileName: UnionFind.java
 * @description: 并查集
 * @author: by echo huang
 * @date: 2020/11/4 10:24 下午
 */
public interface UnionFind {
    int getSize();

    // 判断俩个节点是否连接
    boolean isConnected(int p, int q);

    // 连接p和q
    void unionElements(int p, int q);
}
