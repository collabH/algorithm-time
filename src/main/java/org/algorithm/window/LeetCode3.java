package org.algorithm.window;

import java.util.HashMap;

/**
 * @fileName: LeetCode3.java
 * @description: 无重复字符的最长子串
 * @author: by echo huang
 * @date: 2020/11/5 2:26 下午
 */
public class LeetCode3 {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;
        int left = 0;
        // abcabcbd
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                // 1
                // 2
                // 3
                // 4
                // 5
                left = Math.max(left, map.get(s.charAt(i)) + 1);
            }
            // a,0
            // b,1
            // c,2
            // a,3
            // b,4
            // c,5
            // b,6
            // d,7
            map.put(s.charAt(i), i);
            // 1
            // 2
            // 3
            // 3
            // 3
            // 3
            // 3
            //
            max = Math.max(max, i - left + 1);
        }
        return max;

    }

    public static void main(String[] args) {
        LeetCode3 leetCode3 = new LeetCode3();
        System.out.println(leetCode3.lengthOfLongestSubstring("abcabcbd"));
    }
}
