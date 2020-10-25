package org.datastructure.linkedlist;

/**
 * @fileName: Sum.java
 * @description: 递归算法
 * @author: by echo huang
 * @date: 2020/10/25 10:20 下午
 */
public class Sum {
    public static int sum(int[] arr) {
        return sum(arr, 0);
    }

    /**
     * 递归函数
     * @param arr
     * @param l
     * @return
     */
    public static int sum(int[] arr, int l) {
        if (l == arr.length - 1) {
            return 0;
        }
        return arr[l] + sum(arr, l + 1);
    }
}
