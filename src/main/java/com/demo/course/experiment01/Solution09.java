package com.demo.course.experiment01;

/**
 * author: nitaotao
 * date: 2021/12/27 13:08
 * version: 1.0
 * description: todo
 */
public class Solution09 {
    public int[] twoSum(int[] nums, int target) {
        int[] twoSum = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    twoSum[0] = i;
                    twoSum[1] = j;
                }
            }
        }
        return twoSum;
    }
}
