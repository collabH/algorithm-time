package org.algorithm.sort;


import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @fileName: HeapSort.java
 * @description: 堆排序
 * @author: by echo huang
 * @date: 2020/11/9 10:00 上午
 */
public class HeapSort {
    public static void sort(int[] nums) {
        PriorityQueue<Integer> minHeap =
                new PriorityQueue<>();
        for (int num : nums) {
            minHeap.add(num);
        }
        for (int i = 0; i < nums.length && !minHeap.isEmpty(); i++) {
            nums[i] = minHeap.poll();
        }
    }

    /*	 调整大顶堆（仅是调整过程，建立在大顶堆已构建的基础上），
     *  即[s..m]中记录的关键字除[s]之外均满足堆的定义 ；
     *  s表示所要调整的范围的开始下标，m表示结束的下标，
     *  即[s,...,m]，总个数为m-s+1，m可以取到
     */
    private void HeapAdjust(int[] nums,int s,int m){
        int i,temp;
        temp = nums[s];//先取出当前元素s
        for(i=2*s+1;i<=m;i=i*2+1){//从s结点的左子结点开始，也就是2s+1处开始,沿关键字较大的孩子结点向下筛选
            if(i<m && nums[i]<nums[i+1]){//i为孩子节点中关键字较大的记录的下标;i<m保证右孩子存在
                i++;
            }
            if(temp<nums[i]){
                //如果子节点大于父节点，将子节点值赋给父节点（不用进行交换）
                nums[s]=nums[i];
                s=i;
            }else
                break;
        }
        nums[s]=temp;//将当前元素插入到最终的位置
    }
    //堆排序
    public void sort1(int[] nums,int n){
        int i;
        //1、构建大顶堆
        for(i=n/2-1;i>=0;i--){
            //从第一个非叶结点从下至上，从右至左调整结构
            HeapAdjust(nums,i,n-1);//长度为n，则最后一个元素下标为n-1
        }
        //2.调整堆结构+交换堆顶元素与末尾元素
        for(i=n-1;i>=0;i--){
            BubbleSort.swap(nums,0,i);//将堆顶元素与末尾元素进行交换
            HeapAdjust(nums,0,i-1);//重新对堆进行调整
        }
    }



    public static void main(String[] args) {
        int[] nums = {1, 5, 4, 3, 10, 8, 6, 7};

        sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
