package com.programmercarl.greed;

/**
 * @ClassName MaxSubArray
 * @Descriotion TODO
 * @Author nitaotao
 * @Date 2022/7/15 9:05
 * @Version 1.0
 * https://leetcode.cn/problems/maximum-subarray/
 * 53. 最大子数组和
 **/
public class MaxSubArray {
    public int maxSubArray1(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        //最大总和
        int maxSum = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            //当前总和
            int curSum = 0;
            for (int j = i; j < nums.length; j++) {
                curSum += nums[j];
                if (curSum < 0 && i != j) {
                    //如果总和 < 0 就只会拉低当前总和
                    //并且不是一个数的和
                    break;
                }
                if (curSum > maxSum) {
                    maxSum = curSum;
                }
            }
        }
        return maxSum;
    }

    public int maxSubArray(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int maxSum = Integer.MIN_VALUE;
        int curSum = 0;
        for (int i = 0; i < nums.length; i++) {
            curSum += nums[i];
            if (curSum > maxSum) {
                maxSum = curSum;
            }
            if (curSum < 0) {
                //如果当前值小于0，则重置，舍弃之前的，因为负数只会拉低总和
                curSum = 0;
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        System.out.println(new MaxSubArray().maxSubArray(new int[]{-2, 1}));
    }
}
