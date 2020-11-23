package org.algorithm.skill;

/**
 * @fileName: PrefixSumOffer.java
 * @description: PrefixSumOffer.java类说明
 * @author: by echo huang
 * @date: 2020/11/23 11:37 上午
 */
public class PrefixSumOffer42 {
    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int i = new PrefixSumOffer42().maxSubArray(nums);
        System.out.println(i);
    }

    public int maxSubArray(int[] nums) {
        PrefixSum prefixSum = new PrefixSum(nums);
        int minIndex = 0, maxIndex = 0;
        int max = prefixSum.prefix[0];
        int min = prefixSum.prefix[0];
        for (int i = 0; i < prefixSum.prefix.length; i++) {
            if (prefixSum.prefix[i] > max) {
                max=prefixSum.prefix[i];
                maxIndex = i;
            }
            if (prefixSum.prefix[i] < min) {
                min=prefixSum.prefix[i];
                minIndex = i;
            }
        }
        int sum=0;
        for (int i=minIndex;i<maxIndex;i++){
            sum+=nums[i];
        }
        return sum;
    }

    class PrefixSum {
        public int[] prefix;

        /* 输入一个数组，构造前缀和 */
        public PrefixSum(int[] nums) {
            prefix = new int[nums.length + 1];
            // 计算 nums 的累加和
            for (int i = 1; i < prefix.length; i++) {
                prefix[i] = prefix[i - 1] + nums[i - 1];
            }
        }
    }
}
