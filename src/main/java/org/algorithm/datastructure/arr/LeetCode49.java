package org.algorithm.datastructure.arr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @fileName: LeetCode49.java
 * @description: LeetCode49.java类说明
 * @author: by echo huang
 * @date: 2020/11/15 3:58 下午
 */
public class LeetCode49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> records = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            List<String> arr = records.getOrDefault(key, new ArrayList<>());
            arr.add(str);
            records.put(key, arr);
        }
        return new ArrayList<>(records.values());
    }
}
