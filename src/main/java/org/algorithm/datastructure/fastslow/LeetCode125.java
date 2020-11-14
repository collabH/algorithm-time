package org.algorithm.datastructure.fastslow;

import java.util.Stack;

/**
 * @fileName: LeetCode125.java
 * @description: LeetCode125.java类说明
 * @author: by echo huang
 * @date: 2020/11/14 11:24 下午
 */
public class LeetCode125 {
    public boolean isPalindrome(String s) {
        int n = s.length();
        int left = 0, right = n - 1;
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                ++left;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                --right;
            }
            if (left < right) {
                if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                    return false;
                }
                ++left;
                --right;
            }
        }
        return true;
    }
}
