package org.algorithm.datastructure.stack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @fileName: LeetCode496.java
 * @description: 下一个更大元素 I
 * @author: by echo huang
 * @date: 2020/11/4 10:00 上午
 */
public class LeetCode496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> store = new HashMap<>();
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums2.length; i++) {
            while (!stack.isEmpty() && stack.peek() < nums2[i]) {
                store.put(stack.pop(), nums2[i]);
            }
            stack.push(nums2[i]);
        }
        while (!stack.isEmpty()) {
            store.put(stack.pop(), -1);
        }
        for (int i = 0; i < nums1.length; i++) {
            res[i] = store.getOrDefault(nums1[i], -1);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums1 = {2, 4}, nums2 = {1, 2, 3, 4};
        LeetCode496 leetCode496 = new LeetCode496();
        System.out.println(Arrays.toString(leetCode496.nextGreaterElement(nums1, nums2)));
    }
}
