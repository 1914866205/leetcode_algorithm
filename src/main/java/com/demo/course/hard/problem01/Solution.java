package com.demo.course.hard.problem01;

import java.util.Iterator;
import java.util.TreeSet;

/**
 * author: nitaotao
 * date: 2021/12/22 19:50
 * version: 1.0
 * description: https://leetcode-cn.com/problems/first-missing-positive/
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {0, -1, 3, 1};
        System.out.println(solution.firstMissingPositive(nums));
    }

    /**
     * firstMissingPositive方法：找到缺失的第一个正数
     *
     * @param nums
     * @return
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
            if (max < nums[i]) {
                max = nums[i];
            }
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
                if (i != num) {
                    return i;
                }
                i++;
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
