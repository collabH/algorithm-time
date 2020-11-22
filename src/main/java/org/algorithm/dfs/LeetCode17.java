package org.algorithm.dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @fileName: LeetCode17.java
 * @description: LeetCode17.java类说明
 * @author: by echo huang
 * @date: 2020/11/22 4:17 下午
 */
public class LeetCode17 {

    public List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<String>();
        if (digits.length() == 0) {
            return combinations;
        }
        Map<Character, String> phoneMap = new HashMap<>();
        phoneMap.put('2', "abc");
        phoneMap.put('3', "def");
        phoneMap.put('4', "ghi");
        phoneMap.put('5', "jkl");
        phoneMap.put('6', "mno");
        phoneMap.put('7', "pqrs");
        phoneMap.put('8', "tuv");
        phoneMap.put('9', "wxyz");
        dfs(phoneMap, combinations, digits, 0, new StringBuffer());
        return combinations;
    }


    void dfs(Map<Character, String> phoneMap, List<String> combinations, String digits, int index, StringBuffer combination) {
        // 终止条件，index等于数组字符长度
        if (index == digits.length()) {
            combinations.add(combination.toString());
            return;
        }

        // 做选择
        char digit = digits.charAt(index);
        String letters = phoneMap.get(digit);
        int lettersCount = letters.length();
        for (int i = 0; i < lettersCount; i++) {
            combination.append(letters.charAt(i));
            dfs(phoneMap, combinations, digits, index + 1, combination);
            // 撤回选择
            combination.deleteCharAt(index);
        }
    }
}
