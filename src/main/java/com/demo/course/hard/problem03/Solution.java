package com.demo.course.hard.problem03;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 * author: nitaotao
 * date: 2021/12/22 22:38
 * version: 1.0
 * description: todo
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
     * @return
     */
    public int majorityElement(int[] nums) {
        //准备一个map集合，键为数组元素，值为该元素出现的次数
        Map<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < nums.length; i++) {
            //如果这个元素第一次出现，则添加这个元素
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
            } else {
                //如果不是第一次出现，则元素出现次数+1
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
            keys[index] = key;
            values[index] = value;
            index++;
        }
        int max = values[0];
        int maxIndex = 0;
        for (int i = 0; i < values.length; i++) {
            if (max < values[i]) {
                max = values[i];
                maxIndex = i;
            }
        }
        return keys[maxIndex];
    }
}
