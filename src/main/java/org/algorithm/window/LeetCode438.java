package org.algorithm.window;

import java.util.ArrayList;
import java.util.List;

/**
 * @fileName: LeetCode438.java
 * @description: 找到字符串中所有字母异位词
 * @author: by echo huang
 * @date: 2020/11/5 2:13 下午
 */
public class LeetCode438 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s == null || s == "" || p == null || p == "" ||
                s.length() < p.length()) {
            return res;
        }
        int[] need = new int[128];
        int[] have = new int[128];
        for (char c : p.toCharArray()) {
            need[c]++;
        }
        int left = 0, right = 0, min = s.length() + 1, count = 0;

        while (right < s.length()) {
            char r = s.charAt(right);

            if (need[r] == 0) {
                right++;
                continue;
            }

            if (have[r] < need[r]) {
                count++;
            }
            have[r]++;
            right++;

            while (count == p.length()) {
                char l = s.charAt(left);
                if (need[l] == 0) {
                    left++;
                    continue;
                }
                if (right - left <= min) {
                    min = right - left;
                    if (min == p.length()) {
                        res.add(left);
                    }
                }

                if (have[l] == need[l]) {
                    count--;
                }
                have[l]--;
                left++;
            }
        }
        if (min == s.length() + 1) {
            return res;
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode438 leetCode438 = new LeetCode438();
        System.out.println(leetCode438.findAnagrams("cbaebabacd", "abc"));
    }
}
