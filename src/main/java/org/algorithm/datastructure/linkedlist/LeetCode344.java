package org.algorithm.datastructure.linkedlist;

/**
 * @fileName: LeetCode344.java
 * @description: LeetCode344.java类说明
 * @author: by echo huang
 * @date: 2020/11/11 10:41 上午
 */
public class LeetCode344 {
    public void reverseString(char[] s) {
        int slow = 0, high = s.length - 1;
        char temp;
        while (slow < high) {
            temp = s[slow];
            s[slow] = s[high];
            s[high] = temp;
            slow++;
            high--;
        }
    }
}
