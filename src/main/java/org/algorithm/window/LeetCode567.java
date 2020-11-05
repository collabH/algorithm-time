package org.algorithm.window;

/**
 * @fileName: LeetCode567.java
 * @description: 字符串的排列
 * @author: by echo huang
 * @date: 2020/11/5 11:46 上午
 */
public class LeetCode567 {
    public boolean checkInclusion(String s1, String s2) {
        if (s1 == null || "".equals(s1) || s2 == null || "".equals(s2) || s1.length() > s2.length()) {
            return false;
        }
        // ASCII码个数
        int[] need = new int[128];
        int[] have = new int[128];
        for (char c : s1.toCharArray()) {
            need[c]++;
        }
        int left = 0, right = 0, min = s2.length() + 1, count = 0;
        while (right < s2.length()) {
            char r = s2.charAt(right);
            if (need[r] == 0) {
                right++;
                continue;
            }
            if (have[r] < need[r]) {
                count++;
            }
            have[r]++;
            right++;

            while (count == s1.length()) {
                char l = s2.charAt(left);
                if (need[l] == 0) {
                    left++;
                    continue;
                }
                // 更新长度最小值
                if (right - left < min) {
                    min = right - left;
                }

                // 如果l元素相等的化，count数-1
                if (need[l] == have[l]) {
                    count--;
                }
                have[l]--;
                left++;
            }
        }
        if (min == s2.length() + 1) {
            return false;
        }
        return min == s1.length();
    }

    public static void main(String[] args) {
        LeetCode567 leetCode567 = new LeetCode567();
        System.out.println(leetCode567.checkInclusion("ab", "eidbaooo"));
    }
}
