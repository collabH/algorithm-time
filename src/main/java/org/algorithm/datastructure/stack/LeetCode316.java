package org.algorithm.datastructure.stack;

import java.util.Stack;

/**
 * @fileName: LeetCode316.java
 * @description: 去除重复字母
 * @author: by echo huang
 * @date: 2020/10/29 3:26 下午
 */
public class LeetCode316 {
    public String removeDuplicateLetters(String s) {
        Stack<Character> stack = new Stack<>();
        boolean[] isExist = new boolean[256];
        int[] count = new int[256];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i)]++;
        }
        for (char c : s.toCharArray()) {
            count[c]--;
            if (isExist[c]) {
                continue;
            }
            // 前一个元素大于当前元素的后，将其弹出设置为不存在
            while (!stack.isEmpty() && stack.peek() > c) {
                if (count[stack.peek()] < 1) {
                    break;
                }
                isExist[stack.pop()] = false;
            }
            stack.push(c);
            isExist[c] = true;
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
