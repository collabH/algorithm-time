package org.algorithm.dfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @fileName: Leet.java
 * @description: 括号生成
 * @author: by echo huang
 * @date: 2020/11/13 5:36 下午
 */
public class LeetCode22 {
    public static void main(String[] args) {
        LeetCode22 leetCode22 = new LeetCode22();
        System.out.println(leetCode22.generateParenthesis(3));
    }
    List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        LinkedList<String> track = new LinkedList<>();
        if (n == 0) return track;
        dfs(n, n, track);
        return res;
    }



    void dfs(int left, int right, LinkedList<String> track) {
        if (left > right) return;
        if (left < 0 || right < 0) return;
        if (left == 0 && right == 0) {
            res.add(parse(track));
            return;
        }
        track.add("(");
        dfs(left - 1, right, track);
        track.removeLast();


        track.add(")");
        dfs(left, right - 1, track);
        track.removeLast();
    }

    String parse(LinkedList<String> track) {
        StringBuilder sb = new StringBuilder();
        for (String t : track) {
            sb.append(t);
        }
        return sb.toString();
    }
}
