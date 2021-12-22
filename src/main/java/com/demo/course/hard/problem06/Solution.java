package com.demo.course.hard.problem06;

import java.util.Arrays;

/**
 * author: nitaotao
 * date: 2021/12/22 23:57
 * version: 1.0
 * description: https://leetcode-cn.com/problems/missing-number/
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
     * @return
     */
    public int missingNumber(int[] nums) {
        //先对数组排序
        Arrays.sort(nums);
        int i = 0;
        boolean isFind = false;
        //判断当前数值和数组元素是否相同
        for (; i < nums.length; i++) {
            //如果一直相同。for循环结束自动i++，返回i，即不缺数字的顺序数组中没有出现的元素、
            if (i == nums[i]) {
                isFind = true;
                continue;
            } else {
                //如果不相等，break出去后返回i，for语句中的i++不会被执行到，返回i，即为缺失的数字
                isFind = false;
                break;
            }
        }
        return i;
    }
}
