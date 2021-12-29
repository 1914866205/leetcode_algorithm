package com.demo.course.hard.problem04;

/**
 * author: nitaotao
 * date: 2021/12/22 23:19
 * version: 1.0
 * description:  https://leetcode-cn.com/problems/rotate-array/
 * 【解题思路】： 本题思路和题 22 基本一致，找到变换后的索引变化规律，进行对应操作。新的索引总是
 * 为 k%长度+当前索引 或者 k%长度 + 当前索引 - 长度
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        solution.rotate(nums, 3);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]);
        }
    }

    /**
     * rotate方法：轮转数组
     *
     * @param nums 被轮转的数组
     * @param k    向右轮转的位数
     * 本题思路和 hard 22 完全一致，找规律
     */
    public void rotate(int[] nums, int k) {
        int[] newArr = new int[nums.length];
        int temp = 0;
        for (int i = 0; i < nums.length; i++) {
            temp = k % nums.length;  //实际偏移量
            //新索引为 temp+i-nums.length      圈内偏移，不涉及从另一头出来      从另一头出来
            newArr[temp + i - nums.length < 0 ? temp + i : temp + i - nums.length] = nums[i];
        }
        for (int i = 0; i < newArr.length; i++) {
            nums[i] = newArr[i];
        }
    }
}
