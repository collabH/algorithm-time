package org.algorithm.datastructure.arr;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @fileName: LeetCode1.java
 * @description: LeetCode1.java类说明
 * @author: by echo huang
 * @date: 2020/11/11 2:07 下午
 */
public class LeetCode1 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }else{
                map.put(nums[i], i);
            }
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        LeetCode1 leetCode1 = new LeetCode1();
        System.out.println(Arrays.toString(leetCode1.twoSum(nums, 978)));
    }
}
