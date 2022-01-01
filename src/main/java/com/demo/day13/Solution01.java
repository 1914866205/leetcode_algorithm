package com.demo.day13;

import java.util.HashMap;
import java.util.Map;

/**
 * author: nitaotao
 * date: 2022/1/1 20:54
 * version: 1.0
 * description: todo
 */
public class Solution01 {
    public static void main(String[] args) {

    }

    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            map.put(i, nums[i]);
        }
        for (int i = 0; i < map.size(); i++) {
            for (int j = i+1; j < map.size(); j++) {
                int a = (int) map.get(i);
                int b = (int) map.get(j);
                if (a + b == target) {
                    result[0] = i;
                    result[1] = j;
                }
            }
        }
        return result;
    }
}
