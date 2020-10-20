package org.algorithm.binarySearch;

/**
 * @fileName: LeetCode744.java
 * @description: 寻找比目标字母大的最小字母
 * @author: by echo huang
 * @date: 2020/10/20 2:52 下午
 */
public class LeetCode744 {
    public static void main(String[] args) {
        char[]letters={'c','f','j'};
        LeetCode744 leetCode744 = new LeetCode744();
        System.out.println(leetCode744.nextGreatestLetter(letters, 'c'));
    }
    public char nextGreatestLetter(char[] letters, char target) {
        int left=0;
        int right=letters.length;

        if(target>=letters[letters.length-1]){//循环比较的处理
            return letters[0];
        }else{
            while (left<right){//二分搜索的应用
                int mid=(left+right)/2;
                if(letters[mid]<=target)left=mid+1;
                if(letters[mid]>target)right=mid;
            }
            return letters[left];
        }
    }
}
