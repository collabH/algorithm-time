package org.algorithm.datastructure.arr;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @fileName: LeetCode477.java
 * @description: 回旋镖的数量
 * @author: by echo huang
 * @date: 2020/11/15 4:36 下午
 */
public class LeetCode447 {
    public int numberOfBoomerangs(int[][] points) {
        int result=0;
        for(int i=0;i<points.length;i++){
            //存储点i到所有其他点的距离出现的频次（Key为距离，Value为频次）
            Map<Integer, Integer> map = new HashMap<>();
            for(int j=0;j<points.length;j++){
                if(i!=j){
                    int dis = dis(points[i], points[j]);
                    if(map.containsKey(dis))
                        map.put(dis,map.get(dis)+1);
                    else
                        map.put(dis,1);
                }
            }
            Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
            for (Map.Entry<Integer, Integer> entry : entries) {
                if(entry.getValue()>1)
                    //如果存在距离相等的两点的数量大于一，则可以组队（回旋镖）
                    //如果存在2个则2种排列方法，存在3个则6种排列方法，存在n个则n（n-1）中排列方法
                    result=result+entry.getValue()*(entry.getValue()-1);
            }
        }
        return result;
    }
    //计算两元组距离
    public static int dis(int[] left, int[] right){
        return (int) (Math.pow(left[0]-right[0],2)+Math.pow(left[1]-right[1],2));
    }
}
