package com.demo.course.hard.problem09;

import java.util.Arrays;

/**
 * author: nitaotao
 * date: 2021/12/23 9:30
 * version: 1.0
 * description: todo
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1,3,6};
        System.out.println(solution.smallestRangeI(nums, 3));
    }

    public int smallestRangeI(int[] nums, int k) {
        //处理只有一个值的情况
        if (nums.length == 1) {
            return 0;
        }
        //可以加的范围在  [-k,k] 之间
        Arrays.sort(nums);
        //返回数组 result 的最大值和最小值之间可能存在的最小差值。
        int min = nums[0];
        int max = nums[nums.length - 1];
        if (min == max) {
            return 0;
        } else {
            if (Math.abs(max - min) > 2 * k) {
                //如果最小加k   最大-k 还是不够，那就返回中间的距离，类似数轴
                return Math.abs(max - min) - 2 * k;
            }else {
                //如果够了，就相等
                return 0;
            }
        }
    }
}
