package org.algorithm.skill;

/**
 * @fileName: PrefixSum.java
 * @description: PrefixSum.java类说明
 * @author: by echo huang
 * @date: 2020/11/23 11:29 上午
 */
public class PrefixSum {
    private int[] prefix;

    /* 输入一个数组，构造前缀和 */
    public PrefixSum(int[] nums) {
        prefix = new int[nums.length + 1];
        // 计算 nums 的累加和
        for (int i = 1; i < prefix.length; i++) {
            prefix[i] = prefix[i - 1] + nums[i - 1];
        }
    }

    /* 查询闭区间 [i, j] 的累加和 */
    public int query(int i, int j) {
        return prefix[j + 1] - prefix[i];
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        PrefixSum prefixSum = new PrefixSum(nums);
        System.out.println(prefixSum.query(0, 4));
    }

}
