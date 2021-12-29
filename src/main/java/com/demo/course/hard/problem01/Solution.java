package com.demo.course.hard.problem01;

import java.util.Iterator;
import java.util.TreeSet;

/**
 * author: nitaotao
 * date: 2021/12/22 19:50
 * version: 1.0
 * description: https://leetcode-cn.com/problems/first-missing-positive/
 * 【解题思路】：使用TreeSet，自动排序且去重，如果全是负数或者最大值小于1或者最小值大于1，返回1。
 * 遍历元素，当元素开始大于0时，开始从1比较，返回没出现的第一个正数，如果都出现了，返回最大值+1。
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {0, -1, 3, 1};
        System.out.println(solution.firstMissingPositive(nums));
    }

    /**
     * firstMissingPositive方法：找到缺失的第一个正数
     * @param nums 被查询的数组
     * @return 如果全是负数或者最大值小于 1 或者最小值大于 1，返回 1
     */
    public int firstMissingPositive(int[] nums) {
        //TreeSet 自动排序，去重
        TreeSet treeSet = new TreeSet();
        int max = nums[0];
        int min = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                min = nums[i];
            }
        }
        //如果全是负数，返回1
        if (min == -1) {
            return 1;
        }
        for (int i = 0; i < nums.length; i++) {
            //找到最大值
            if (max < nums[i]) {
                max = nums[i];
            }
            //找到 最小 正整数
            if (nums[i] > 0 && min > nums[i]) {
                min = nums[i];
            }
            treeSet.add(nums[i]);
        }
        //如果最大值小于1或者最小值大于1，返回1
        if (max < 1 || min > 1) {
            return 1;
        }
        Iterator iterator = treeSet.iterator();
        int i = 1;
        int num;
        while (iterator.hasNext()) {
            //遍历元素，当元素开始大于0时，开始比较。返回没出现的第一个正数
            num = (int) iterator.next();
            if (num > 0) {
//                System.out.println(i + " " + num);
                // 依次比较，如果不相等，则为没出现的正数
                if (i != num) {
                    return i;
                }
                i++;
                //如果到了最右边，那么没出现的就是最大值+1
                if (i == max) {
                    break;
                }
            }
        }
        //如果都出现了，就返回最大值+1
        max++;
        return max;
    }
}
