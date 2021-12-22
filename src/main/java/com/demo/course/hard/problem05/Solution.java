package com.demo.course.hard.problem05;

/**
 * author: nitaotao
 * date: 2021/12/22 23:39
 * version: 1.0
 * description: https://leetcode-cn.com/problems/powx-n/
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.myPow(2.00000,10));
    }
    public double myPow(double x, int n) {
        //任何数的0次方都为1
        if (n == 0) {
            return 1;
        }
        //折半
        double half = myPow(x, n / 2);  // 5/2=2  默认向下取整
        if (n % 2 == 0) {
            return half * half;
        }
        if (n > 0) {
            return half * half * x;
        }
        return half * half / x;
    }
}
