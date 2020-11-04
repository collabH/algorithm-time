package org.datastructure.union;

/**
 * @fileName: UnionFind.java
 * @description: 并查集
 * @author: by echo huang
 * @date: 2020/11/4 10:24 下午
 */
public interface UnionFind {
    int getSize();

    boolean isConnected(int p, int q);

    void unionElements(int p, int q);
}
