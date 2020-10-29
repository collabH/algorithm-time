package org.algorithm.datastructure;

import java.util.Stack;

/**
 * @fileName: LeetCode1081.java
 * @description: LeetCode1081.java类说明
 * @author: by echo huang
 * @date: 2020/10/29 4:27 下午
 */
public class LeetCode1081 {
    public String smallestSubsequence(String s) {
        Stack<Character> stack = new Stack<>();
        int length = s.length();
        if (length == 0) {
            return "";
        }
        boolean[] isExist = new boolean[256];
        int[] count = new int[256];
        for (int i = 0; i < length; i++) {
            count[s.charAt(i)]++;
        }

        for (char c : s.toCharArray()) {
            // 出现的次数减1
            count[c]--;
            // 去重复，找最小子序列
            if (isExist[c]) {
                continue;
            }
            // 为了字典顺序排列,前词小于当前词
            while (!stack.isEmpty() && stack.peek() > c) {
                // 如果前词后续还有，就从stack弹出，否则不做操作
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
