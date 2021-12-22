package com.demo.course.hard.problem04;

/**
 * author: nitaotao
 * date: 2021/12/22 23:19
 * version: 1.0
 * description: todo
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
     * 轮转数组
     *
     * @param nums 被轮转的数组
     * @param k    向右轮转的位数
     */
    public void rotate(int[] nums, int k) {
        int[] newArr = new int[nums.length];
        int temp = 0;
        for (int i = 0; i < nums.length; i++) {
            temp = k % nums.length;
            //新索引为 temp+i-nums.length
            newArr[temp + i - nums.length < 0 ? temp + i : temp + i - nums.length] = nums[i];
        }
        for (int i = 0; i < newArr.length; i++) {
            nums[i] = newArr[i];
        }
    }
}
