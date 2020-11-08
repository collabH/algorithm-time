package org.algorithm.datastructure.hashtable;


import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @fileName: LeetCode387.java
 * @description: 字符串中的第一个唯一字符
 * @author: by echo huang
 * @date: 2020/11/7 11:23 下午
 */
public class LeetCode387 {
    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return s.indexOf(entry.getKey());
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        LeetCode387 leetCode387 = new LeetCode387();
        System.out.println(leetCode387.firstUniqChar("leetcode"));
    }
}
