package org.algorithm.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @fileName: leetcode20.java
 * @description: leetcode
 * @author: by echo huang
 * @date: 2020/10/19 10:29 下午
 */
public class LeetCode20 {
    public static void main(String[] args) {
        LeetCode20 leetCode20 = new LeetCode20();
        System.out.println(leetCode20.isValid("(){}}{"));
    }

    public boolean isValid(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }
        Map<Character, Character> store = new HashMap<>();
        store.put('(', ')');
        store.put('[', ']');
        store.put('{', '}');
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();

        for (char c : chars) {
            if (store.containsKey(c)) {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                if (!store.get(stack.pop()).equals(c)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
