package org.algorithm.mianshi;

import java.util.HashSet;

/**
 * @fileName: HappyNum.java
 * @description: HappyNum.java类说明
 * @author: by echo huang
 * @date: 2020/10/30 4:01 下午
 */
public class HappyNum {
    private HashSet<Integer> memo = new HashSet<>();

    public boolean isHappy(int n) {
        int sum = 0;
        while (true) {
            int c = n % 10;
            n = n / 10;
            sum += c * c;
            // 终止条件
            if (n == 0) {
                if (memo.contains(sum)) {
                    return false;
                }
                memo.add(sum);
                n = sum;
                if (sum != 1) {
                    sum = 0;
                } else {
                    return true;
                }
            }
        }
    }

    public static void main(String[] args) {
        HappyNum happyNum = new HappyNum();
        System.out.println(happyNum.isHappy(3));
    }
}
