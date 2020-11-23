package org.algorithm.skill;

/**
 * @fileName: DiffArr1109.java
 * @description: 差分数组
 * @author: by echo huang
 * @date: 2020/11/23 10:47 上午
 */
public class DiffArr1109 {
    //    int[] diff = new int[nums.length];
//// 构造差分数组
//    diff[0] = nums[0];
//    for (int i = 1; i < nums.length; i++) {
//        diff[i] = nums[i] - nums[i - 1];
//    }

    /**
     * diff反推nums数组的过程
     * int[] res = new int[diff.length];
     * // 根据差分数组构造结果数组
     * res[0] = diff[0];
     * for (int i = 1; i < diff.length; i++) {
     * res[i] = res[i - 1] + diff[i];
     * }
     * <p>
     * 这样构造差分数组diff，就可以快速进行区间增减的操作，如果你想对区间nums[i..j]的元素全部加 3，
     * 那么只需要让diff[i] += 3，然后再让diff[j+1] -= 3
     */
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] nums = new int[n];
        Difference difference = new Difference(nums);
        for (int[] booking : bookings) {
            int i = booking[0] - 1;
            int j = booking[1] - 1;
            int val = booking[2];
            difference.increment(i, j, val);
        }
        return difference.result();
    }


    class Difference {
        // 差分数组
        private int[] diff;

        public Difference(int[] nums) {
            assert nums.length > 0;
            diff = new int[nums.length];
            // 构造差分数组
            diff[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                diff[i] = nums[i] - nums[i - 1];
            }
        }

        /* 给闭区间 [i,j] 增加 val（可以是负数）*/
        public void increment(int i, int j, int val) {
            diff[i] += val;
            if (j + 1 < diff.length) {
                diff[j + 1] -= val;
            }
        }

        public int[] result() {
            int[] res = new int[diff.length];
            // 根据差分数组构造结果数组
            res[0] = diff[0];
            for (int i = 1; i < diff.length; i++) {
                res[i] = res[i - 1] + diff[i];
            }
            return res;
        }
    }

}
