package org.algorithm.datastructure.stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * @fileName: LeetCode1118.java
 * @description: 一月有多少天高温
 * @author: by echo huang
 * @date: 2020/11/4 11:13 上午
 */
public class LeetCode1118 {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] <= nums[i]) {
                stack.pop();
            }

            res[i] = stack.isEmpty() ? 0 : (stack.peek() - i);
            stack.push(i);
        }
        return res;
    }

    public static void main(String[] args) {
        int [] nums={73,74,75,71,69,76};
        LeetCode1118 leetCode1118 = new LeetCode1118();
        System.out.println(Arrays.toString(leetCode1118.nextGreaterElements(nums)));
    }
}
