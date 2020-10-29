package org.algorithm.datastructure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * @fileName: LeetCode380.java
 * @description: LeetCode380.java类说明
 * @author: by echo huang
 * @date: 2020/10/29 11:50 上午
 */
public class LeetCode380 {

    class RandomizedSet {
        List<Integer> data;
        Map<Integer, Integer> dict;
        Random random = new Random();

        /**
         * Initialize your data structure here.
         */
        public RandomizedSet() {
            data = new ArrayList<>();
            dict = new HashMap<>();
        }

        /**
         * Inserts a value to the set. Returns true if the set did not already contain the specified element.
         */
        public boolean insert(int val) {
            if (dict.containsKey(val)) return false;
            dict.put(val, data.size());
            data.add(data.size(), val);
            return true;
        }

        /**
         * Removes a value from the set. Returns true if the set contained the specified element.
         */
        public boolean remove(int val) {
            if (!dict.containsKey(val)) return false;

            // move the last element to the place idx of the element to delete
            int lastElement = data.get(data.size() - 1);
            int idx = dict.get(val);
            // 将最后一个元素移动到需要删除的元素的位置
            data.set(idx, lastElement);
            // 修改字典
            dict.put(lastElement, idx);
            // delete the last element
            data.remove(data.size() - 1);
            dict.remove(val);
            return true;
        }

        /**
         * Get a random element from the set.
         */
        public int getRandom() {
            return data.get(random.nextInt(data.size()));
        }
    }
}
