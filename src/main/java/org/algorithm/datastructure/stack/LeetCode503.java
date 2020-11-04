package org.algorithm.datastructure.stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * @fileName: LeetCode503.java
 * @description: 下一个更大元素 II
 * @author: by echo huang
 * @date: 2020/11/4 10:43 上午
 */
public class LeetCode503 {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        Stack<Integer> s = new Stack<>();
        int[] res = new int[n];
        // 假装这个数组长度翻倍了
        for (int i = 2 * n - 1; i >= 0; i--) {
            // 索引要求模
            while (!s.empty() && s.peek() <= nums[i % n]) {
                s.pop();
            }
            res[i % n] = s.empty() ? -1 : s.peek();
            s.push(nums[i % n]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 1};
        LeetCode503 leetCode503 = new LeetCode503();
        System.out.println(Arrays.toString(leetCode503.nextGreaterElements(nums)));
    }
}
