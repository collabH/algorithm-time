package org.datastructure.tree;

// leetCode303
class NumArray {
    private int [] data;
    private int [] tree;

    public NumArray(int[] nums) {
        if(nums.length>0){
            data=new int[nums.length];
            for(int i=0;i<nums.length;i++){
                data[i]=nums[i];
            }
            tree=new int[4*nums.length];
            bulidSegmentTree(0,0,data.length-1);
        }  
    }
    
    private void bulidSegmentTree(int treeIndex,int l,int r){
        if (l==r){
            tree[treeIndex]=data[l];
            return;
        }
        int mid = l+(r-l)/2;
        int leftTreeIndex=leftChild(treeIndex);
        int rightTreeIndex=rightChild(treeIndex);
        
        // 构建左子树
        bulidSegmentTree(leftTreeIndex,l,mid);
        // 构建右子树
        bulidSegmentTree(rightTreeIndex,mid+1,r);
        tree[treeIndex]=tree[leftTreeIndex]+tree[rightTreeIndex];
    }
    
    
    private int leftChild(int index){
        return 2*index+1;
    }
    
     private int rightChild(int index){
        return 2*index+2;
    }
    
    public int sumRange(int i, int j) {
        return query(0,0,data.length-1,i,j);
    }
    
    private int query(int treeIndex,int l,int r,int queryL,int queryR){
        if(queryL<0||queryL>=data.length||queryR<0||queryR>=data.length||queryL>queryR){
              throw new IllegalArgumentException();
        }
        if(l==queryL&&r==queryR){
            return tree[treeIndex];
        }
         int mid = l+(r-l)/2;
        int leftTreeIndex=leftChild(treeIndex);
        int rightTreeIndex=rightChild(treeIndex);
        // 判断区间在左子树还是在右子树
        if(queryR<=mid){
            return query(leftTreeIndex,l,mid,queryL,queryR);
        }else if(queryL>=mid+1){
            return query(rightTreeIndex,mid+1,r,queryL,queryR);
        }
        // 区间在左右子树上
        int leftResult=query(leftTreeIndex,l,mid,queryL,mid);
        
        int rightResult=query(rightTreeIndex,mid+1,r,mid+1,queryR);
        return leftResult+rightResult;
    }

    public static void main(String[] args) {
        int [] nums={-2,0,3,-5,2,-1};
        NumArray numArray = new NumArray(nums);
        System.out.println(numArray.sumRange(0, 2));
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */