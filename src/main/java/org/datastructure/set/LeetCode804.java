package org.datastructure.set;

import java.util.HashSet;
import java.util.Set;

/**
 * @fileName: LeetCode804.java
 * @description: 唯一摩尔斯密码词
 * @author: by echo huang
 * @date: 2020/10/29 10:39 下午
 */
public class LeetCode804 {
    public int uniqueMorseRepresentations(String[] words) {
        String[] MORSE = new String[]{".-", "-...", "-.-.", "-..", ".", "..-.", "--.",
                "....", "..", ".---", "-.-", ".-..", "--", "-.",
                "---", ".--.", "--.-", ".-.", "...", "-", "..-",
                "...-", ".--", "-..-", "-.--", "--.."};
        Set<String> seen = new HashSet<>();
        for (String word : words) {
            StringBuilder sb = new StringBuilder();
            for (char c : word.toCharArray()) {
                String s = MORSE[c - 'a'];
                sb.append(s);
            }
            seen.add(sb.toString());
        }
        return seen.size();
    }
}
