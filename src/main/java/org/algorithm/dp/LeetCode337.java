package org.algorithm.dp;

import org.algorithm.base.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @fileName: LeetCode337.java
 * @description: 打家劫舍 III
 * @author: by echo huang
 * @date: 2020/10/26 2:28 下午
 */
public class LeetCode337 {
    private Map<TreeNode, Integer> memo = new HashMap<>();

    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (memo.get(root) != null) {
            return memo.get(root);
        }
        // 抢劫，然后去下下家
        int rob = root.val +
                // 左子树
                (root.left == null ? 0 : rob(root.left.left) + rob(root.left.right))
                +
                // 右子树
                (root.right == null ? 0 : rob(root.right.left) + rob(root.right.right));
        // 不抢，去下家
        int notRob = rob(root.left) + rob(root.right);

        int res = Math.max(notRob, rob);
        memo.put(root, res);
        return res;
    }


    /**
     * 评论区解法，用状态和状态转移方程来解决
     *
     * @param root
     * @return
     */
    int rob1(TreeNode root) {
        int[] res = dp(root);
        return Math.max(res[0], res[1]);
    }

    /* 返回一个大小为 2 的数组 arr
    arr[0] 表示不抢 root 的话，得到的最大钱数
    arr[1] 表示抢 root 的话，得到的最大钱数 */
    int[] dp(TreeNode root) {
        if (root == null)
            return new int[]{0, 0};
        int[] left = dp(root.left);
        int[] right = dp(root.right);
        // 抢，下家就不能抢了
        int rob = root.val + left[0] + right[0];
        // 不抢，下家可抢可不抢，取决于收益大小
        int not_rob = Math.max(left[0], left[1])
                + Math.max(right[0], right[1]);

        return new int[]{not_rob, rob};
    }
}
