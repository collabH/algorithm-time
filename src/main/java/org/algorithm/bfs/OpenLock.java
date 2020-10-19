package org.algorithm.bfs;


import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @fileName: OpenLock.java
 * @description: 打开转盘锁 752
 * @author: by echo huang
 * @date: 2020/10/19 10:49 上午
 */
public class OpenLock {
    public static void main(String[] args) {
        OpenLock openLock = new OpenLock();

        String[] deadends = {"8887", "8889", "8878", "8898", "8788", "8988", "7888", "9888"};
        System.out.println(openLock.openLock(deadends, "8888"));
    }

    public int openLock(String[] deadends, String target) {
        Set<String> deadend = new HashSet<>(Arrays.asList(deadends));

        Queue<String> queue = new LinkedList<>();
        if (deadend.contains("0000")) {
            return -1;
        }
        int depth = 0;
        // 记录密码锁
        queue.offer("0000");
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                if (cur == null) {
                    return depth;
                }
                // 跳过这次
                if (deadend.contains(cur)) {
                    continue;
                }
                if (cur.equals(target)) {
                    return depth;
                }
                // 每次翻转共8次机会
                for (int j = 0; j < 4; j++) {
                    String up = plusOne(cur, j);
                    String down = minusOne(cur, j);

                    queue.offer(up);
                    queue.offer(down);
                }
            }
            depth++;
        }
        return depth;
    }

    /**
     * s[j] 向上翻一次
     *
     * @param s
     * @param j
     * @return
     */
    private String plusOne(String s, int j) {
        char[] chars = s.toCharArray();
        if (chars[j] == '9') {
            chars[j] = '0';
        } else {
            chars[j] += 1;
        }
        return new String(chars);
    }

    /**
     * s[j]向下翻一次
     *
     * @param s
     * @param j
     * @return
     */
    private String minusOne(String s, int j) {
        char[] chars = s.toCharArray();
        if (chars[j] == '0') {
            chars[j] = '9';
        } else {
            chars[j] -= 1;
        }
        return new String(chars);
    }
}
