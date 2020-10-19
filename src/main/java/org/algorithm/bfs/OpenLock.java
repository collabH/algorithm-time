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

    /**
     * 双BFS
     * @param deadends
     * @param target
     * @return
     */
    int openLock2(String[] deadends, String target) {
        Set<String> deads = new HashSet<>(Arrays.asList(deadends));
        // 用集合不用队列，可以快速判断元素是否存在
        Set<String> q1 = new HashSet<>();
        Set<String> q2 = new HashSet<>();
        Set<String> visited = new HashSet<>();

        int step = 0;
        q1.add("0000");
        q2.add(target);

        while (!q1.isEmpty() && !q2.isEmpty()) {
            // 哈希集合在遍历的过程中不能修改，用 temp 存储扩散结果
            Set<String> temp = new HashSet<>();

            /* 将 q1 中的所有节点向周围扩散 */
            for (String cur : q1) {
                /* 判断是否到达终点 */
                if (deads.contains(cur))
                    continue;
                if (q2.contains(cur))
                    return step;
                visited.add(cur);

                /* 将一个节点的未遍历相邻节点加入集合 */
                for (int j = 0; j < 4; j++) {
                    String up = plusOne(cur, j);
                    if (!visited.contains(up))
                        temp.add(up);
                    String down = minusOne(cur, j);
                    if (!visited.contains(down))
                        temp.add(down);
                }
            }
            /* 在这里增加步数 */
            step++;
            // temp 相当于 q1
            // 这里交换 q1 q2，下一轮 while 就是扩散 q2
            q1 = q2;
            q2 = temp;
        }
        return -1;
    }

    public int openLock(String[] deadends, String target) {
        Set<String> deadend = new HashSet<>(Arrays.asList(deadends));
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        if (deadend.contains("0000")) {
            return -1;
        }
        int depth = 0;
        // 记录密码锁
        queue.offer("0000");
        visited.add("0000");
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
                    if (!visited.contains(up)){
                        queue.offer(up);
                        visited.add(up);
                    }
                    if (!visited.contains(down)){
                        queue.offer(down);
                        visited.add(down);
                    }
                }
            }
            depth++;
        }
        return -1;
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
