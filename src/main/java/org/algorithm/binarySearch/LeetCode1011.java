package org.algorithm.binarySearch;

/**
 * @fileName: LeetCode1011.java
 * @description: 在 D 天内送达包裹的能力
 * @author: by echo huang
 * @date: 2020/11/4 5:31 下午
 */
public class LeetCode1011 {
    public int shipWithinDays(int[] weights, int D) {
        int lo = 0, hi = sum(weights);
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (canShip(weights, D, mid)) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    private int sum(int[] weights) {
        int sum = 0;
        for (int weight : weights) {
            sum += weight;
        }
        return sum;
    }

    private boolean canShip(int[] weights, int D, int K) {
        int cur = K; // cur 表示当前船的可用承载量
        for (int weight : weights) {
            if (weight > K) return false;
            if (cur < weight) {
                cur = K;
                D--;
            }
            cur -= weight;
        }
        return D > 0; // 能否在D天内运完
    }
}
