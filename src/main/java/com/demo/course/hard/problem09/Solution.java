package com.demo.course.hard.problem09;

import java.util.Arrays;

/**
 * author: nitaotao
 * date: 2021/12/23 9:30
 * version: 1.0
 * description: todo
 * 【解题思路】： 先判断仅有一个值的情况，直接返回 0。如果不是，那么数组先排序找到最大值和最小值，
 * 返回数组中最大值和最小值之间可能存在的最小差值，可以看做是在一维数轴上，两个点的距离如果大于
 * 2k，则返回中间还差的距离，否则返回 0，说明这个中间点双方都能达到。
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 3, 6};
        System.out.println(solution.smallestRangeI(nums, 3));
    }

    /**
     * smallestRangeI：最小差值
     *
     * @param nums 数组
     * @param k    被添加的数字
     * @return 最大值和最小值之间可能存在的最小差值。
     * 给数组中的每个元素 nums[i] 都加上一个任意数字 x （-k <= x <= k），从而得到一个新数组 result 。
     */
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
            //如果最小值加k   最大值-k 还是不够，那就返回中间的距离，类似 一维坐标轴
            if (Math.abs(max - min) > 2 * k) {
                return Math.abs(max - min) - 2 * k;
            } else {
                //如果够了，就相等
                return 0;
            }
        }
    }
}
