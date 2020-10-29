package org.algorithm.datastructure;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;

/**
 * @fileName: LeetCode710.java
 * @description: 黑名单中的随机数
 * @author: by echo huang
 * @date: 2020/10/29 3:00 下午
 */
public class LeetCode710 {

    class Solution {
        Map<Integer, Integer> m;
        Random r;
        int wlen;

        public Solution(int n, int[] b) {
            m = new HashMap<>();
            r = new Random();
            wlen = n - b.length;
            Set<Integer> w = new HashSet<>();
            for (int i = wlen; i < n; i++) w.add(i);
            for (int x : b) w.remove(x);
            Iterator<Integer> wi = w.iterator();
            for (int x : b)
                if (x < wlen)
                    m.put(x, wi.next());
        }

        public int pick() {
            int k = r.nextInt(wlen);
            return m.getOrDefault(k, k);
        }

    }
}
