package org.algorithm.dfs;


/**
 * @fileName: LeetCode494.java
 * @description: 目标和
 * @author: by echo huang
 * @date: 2020/10/21 11:18 上午
 */
public class LeetCode494 {
    public static void main(String[] args) {
        LeetCode494 leetCode494 = new LeetCode494();
        int[] nums = {1, 1, 1, 1, 1};
        System.out.println(leetCode494.findTargetSumWays(nums, 3));

    }

    int result=0;


    public int findTargetSumWays(int[] nums, int S) {
        if (nums.length == 0) {
            return 0;
        }
        backtrack(nums, 0, S);
        return result;
    }

    /**
     * 回溯方法解决，DFS方式解决
     * @param nums
     * @param index
     * @param target
     */
    void backtrack(int[] nums, int index, int target) {
        if (nums.length == index) {
            if (target == 0) {
                result++;
            }
            return;
        }
        // 处理"-"逻辑，因为计算目标target为0为结束条件，所以"-"实际上表现为target+num[i]
        target += nums[index];
        backtrack(nums, index+1, target);
        // 撤销操作
        target -= nums[index];
        // 处理"+"逻辑，因为计算目标target为0为结束条件，所以"+"实际上表现为target-num[i]
        target -= nums[index];
        backtrack(nums, index+1, target);
        target += nums[index];
    }


    /**
     * dp方式解决问题，背包问题解决
     * @param nums
     * @param S
     * @return
     */
    public int findTargetSumWaysDp(int[] nums, int S) {
        if (nums.length == 0) {
            return 0;
        }
        backtrack(nums, 0, S);
        return result;
    }
}
