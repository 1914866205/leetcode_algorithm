package com.demo.course.hard.problem03;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 * author: nitaotao
 * date: 2021/12/22 22:38
 * version: 1.0
 * description: https://leetcode-cn.com/problems/majority-element/
 * 【解题思路】： 准备一个map集合，键存出现的元素，值为该元素出现的次数，
 * 取出后分别放入键和值数组，对值数组排序，找到最大的数，即为出现的最大次数，返回对应的键。
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {3, 3, 4};
        System.out.println(solution.majorityElement(arr));
    }

    /**
     * 多数元素
     * @param nums
     * @return 找到其中的多数元素。多数元素是指在数组中出现次数 大于  n/2  的元素。
     */
    public int majorityElement(int[] nums) {
        //准备一个map集合，键为数组元素，值为该元素出现的次数
        Map<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < nums.length; i++) {
            //如果这个元素第一次出现，则添加这个元素
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
            } else {
                //如果不是第一次出现，则元素出现次数+1  自动拆箱
                map.put(nums[i], map.get(nums[i]).intValue() + 1);
            }
        }

        //根据获取的不同元素出现的次数，找到最大次数，再找到对应的键进行输出
        int[] keys = new int[map.size()];
        int[] values = new int[map.size()];
        Iterator<Integer> iterator = map.keySet().iterator();
        int index = 0;
        while (iterator.hasNext()) {
            int key = iterator.next();
            int value = map.get(key);
            keys[index] = key;  //键的集合
            values[index] = value;  //值的集合
            index++;
        }
        int max = values[0];
        int maxIndex = 0;  //指向最大值的索引
        //  因为键唯一，值是这个键出现的次数，最大值对应的键即为多数元素
        // 因为给定的数组总是存在多数元素，所以不用判断没有 唯一 最大值的情况，即 多数元素 永远存在
        for (int i = 0; i < values.length; i++) {
            //找到最大值，并且索引紧跟最大值
            if (max < values[i]) {
                max = values[i];
                maxIndex = i;
            }
        }
        return keys[maxIndex];
    }
}
