package org.algorithm.mianshi;

/**
 * @fileName: TwoSum.java
 * @description: 不使用运算符 + 和 - ​​​​​​​，计算两整数 ​​​​​​​a 、b ​​​​​​​之和。
 * @author: by echo huang
 * @date: 2020/10/30 4:21 下午
 */
public class TwoSum {
    public int getSum(int a, int b) {
        while(b != 0){
            int temp = a ^ b;
            b = (a & b) << 1;
            a = temp;
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println(2 ^ -2);
    }
}
