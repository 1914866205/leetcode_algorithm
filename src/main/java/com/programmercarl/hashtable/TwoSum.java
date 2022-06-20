package com.programmercarl.hashtable;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @ClassName TwoSum
 * @Descriotion https://leetcode.cn/problems/two-sum/
 * @Author nitaotao
 * @Date 2022/6/20 16:40
 * @Version 1.0
 * 两数之和
 **/
public class TwoSum {
    public static void main(String[] args) {
        System.out.println(twoSum2(new int[]{2,7,11,19},9));
    }

    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        //处理初始数组
        for (int i = 0; i < nums.length; i++) {
            //因为是两个数，temp为应该出现的结果
            int temp = target - nums[i];
            for (int j = 0; j < nums.length; j++) {
                //不能一个数用两次
                if (i == j) {
                    continue;
                }
                if (temp == nums[j]) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return null;
    }

    public static int[] twoSum2(int[] nums, int target) {
        int[] result = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        //处理初始数组
        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            //根据键查找，需要的值是否存在
            if (map.get(nums[i]) != null) {
                for (int j = 0; j < nums.length; j++) {
                    if (temp == nums[j] && i != j) {
                        result[0] = i;
                        result[1] = j;
                        return result;
                    }
                }
            }
            //把下一次需要的值作为键
            map.put(temp, nums[i]);
        }
        return null;
    }
}
