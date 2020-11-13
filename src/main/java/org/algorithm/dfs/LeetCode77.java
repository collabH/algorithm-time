package org.algorithm.dfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @fileName: LeetCode77.java
 * @description: 组合
 * @author: by echo huang
 * @date: 2020/11/13 4:41 下午
 */
public class LeetCode77 {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        LinkedList<Integer> track = new LinkedList<>();
        dfs(n, k, 1, track);
        return res;
    }

    void dfs(int n, int k, int start, LinkedList<Integer> track) {
        if (k == track.size()) {
            res.add(new LinkedList<>(track));
            return;
        }
        for (int i = start; i <= n; i++) {
            if (track.contains(i)){
                continue;
            }
            track.add(i);
            dfs(n,k,i+1,track);
            track.removeLast();
        }
    }
}
