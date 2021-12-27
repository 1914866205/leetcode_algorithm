package com.demo.course.experiment01;

/**
 * author: nitaotao
 * date: 2021/12/27 13:18
 * version: 1.0
 * description: https://leetcode-cn.com/problems/how-many-numbers-are-smaller-than-the-current-number/submissions/
 */
public class Solution02 {

    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] smallerNumbersThanCurrent = new int[nums.length];
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            count = 0;
            for (int j = 0; j < nums.length; j++) {
                if (i != j && nums[j] < nums[i]) {
                    count++;
                }
            }
            smallerNumbersThanCurrent[i] = count;
        }
        return smallerNumbersThanCurrent;
    }
}
