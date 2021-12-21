package com.demo.course.hard.problem01;

import com.study.stream.Main;

/**
 * author: nitaotao
 * date: 2021/12/21 19:16
 * version: 1.0
 * description: https://leetcode-cn.com/problems/first-missing-positive/
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {1,2,0};
        System.out.println(solution.firstMissingPositive(arr));
    }

    /**
     * firstMissingPositive方法：找出其中没有出现的最小的正整数
     *
     * @param nums
     * @return
     */
    public int firstMissingPositive(int[] nums) {
        //处理左边界
        int min = nums[0];
        int max = nums[0];
        int sum = 0; //数组的和
        boolean flag_0 = false;
        for (int i = 0; i < nums.length; i++) {
            //如果这个数比最小值还小，那么它就是最小值
            if (min > nums[i]) {
                min = nums[i];
            }
            //如果这个数比最大值还小，那么它就是最大值
            if (max < nums[i]) {
                max = nums[i];
            }
            sum += nums[i];
        }
        if (min > 1) {
            return 1;
        }


        //处理右边界，即左边为从0——n
        //判断是不是顺序无差
        System.out.println((min+max) * (max-min)*1.0 / 2);
        if ((nums[0] + nums[nums.length - 1] * nums.length / 2 == sum)) {
            if (max <= 0) {
                return 1;
            } else {
                return max + 1;
            }
        }

        //只处理正数
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {

            }
        }
        return min;
    }
}
