package org.algorithm.window;


import java.util.HashMap;
import java.util.Map;

/**
 * @fileName: SlidingWindow.java
 * @description: SlidingWindow.java类说明
 * @author: by echo huang
 * @date: 2020/11/5 10:33 上午
 */
public class SlidingWindow {
    // 滑动窗口算法框架
    void slidingWindow(String s, String t) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0;
        int valid = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            // 进行窗口内数据的一系列更新

            // debug输出位置
            System.out.printf("window: [%s, %s)\n", left, right);
            // 判断左侧窗口是否要收缩
//            while (window needs shrink) {
//                // d 是将移出窗口的字符
//                char d = s[left];
//                // 左移窗口
//                left++;
//                // 进行窗口内数据的一系列更新
//            ...
//            }
        }
    }
}
