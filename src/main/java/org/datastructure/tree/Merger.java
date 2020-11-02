package org.datastructure.tree;

/**
 * @fileName: Merger.java
 * @description: 线段树的融合器
 * @author: by echo huang
 * @date: 2020/11/2 10:40 下午
 */
public interface Merger<E> {
    E merge(E a, E b);
}
