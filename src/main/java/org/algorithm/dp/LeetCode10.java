package org.algorithm.dp;

/**
 * @fileName: LeetCode10.java
 * @description: 正则表达式匹配
 * @author: by echo huang
 * @date: 2020/10/27 11:40 上午
 */
public class LeetCode10 {
    public boolean isMatch(String s, String p) {
        int i = 0, j = 0;
        char[] sc = s.toCharArray();
        char[] pc = p.toCharArray();
        while (i < sc.length && j < pc.length) {
            if (sc[i] == pc[j] && pc[j] == '.') {
                // pc[i+1]=="*"
                if (j < pc.length - 1 && pc[j + 1] == '*') {

                } else {
                    i++;
                    j++;
                }
            } else {
                // p[i]不匹配，看后续字符是否匹配
                if (j < pc.length - 1 && pc[j + 1] == '*') {

                }
            }
        }
        return false;
    }


    // 不考虑"*"的匹配
    public boolean isMatch1(String s, String p) {
        int i = 0, j = 0;
        char[] sc = s.toCharArray();
        char[] pc = p.toCharArray();
        while (i < sc.length && j < pc.length) {
            if (sc[i] == pc[j] || pc[j] == '.') {
                // 匹配，接着匹配 s[i+1..] 和 p[j+1..]
                i++;
                j++;
            } else {
                // 不匹配
                return false;
            }
        }
        return i == j;
    }
}
