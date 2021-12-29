package com.demo.course.hard.problem06;

import java.util.Arrays;

/**
 * author: nitaotao
 * date: 2021/12/22 23:57
 * version: 1.0
 * description: https://leetcode-cn.com/problems/missing-number/
 * 【解题思路】：先对数组排序，因为数组从 0 开始，所以只要从 0 开始和数组元素一个个对比，如果在数
 * 组没有遍历结束，有不相同，则为缺失数字，如果数组遍历结束，未找到丢失的数，最后还会执行一次 i++，
 * 此时 i 的值比数组最大值大 1，即为未出现的数。
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {0, 1};
        System.out.println(solution.missingNumber(nums));

    }

    /**
     * missingNumber方法：找到消失的数字
     * @param nums
     * @return 找出 [0, n] 这个范围内没有出现在数组中的那个数
     */
    public int missingNumber(int[] nums) {
        //先对数组排序
        Arrays.sort(nums);
        int i = 0;  //缺失的数字 从数组起始数 0  开始比较
        //判断当前数值和数组元素是否相同
        for (; i < nums.length; i++) {
            //如果一直相同。for循环结束自动i++，返回i，即不缺数字的顺序数组中没有出现的元素、
            if (i == nums[i]) {
                continue;
            } else {
                //如果不相等，break出去后返回i，for语句中的i++不会被执行到，返回i，即为缺失的数字
                break;
            }
        }
        return i;
    }
}
