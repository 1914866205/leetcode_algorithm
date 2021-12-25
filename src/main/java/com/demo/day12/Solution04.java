package com.demo.day12;

import com.demo.course.hard.problem05.Solution;

/**
 * author: nitaotao
 * date: 2021/12/25 12:48
 * version: 1.0
 * description: https://leetcode-cn.com/problems/powx-n/
 */
public class Solution04 {
    public static void main(String[] args) {
        Solution04 solution = new Solution04();
        System.out.println(solution.myPowByResursive(2.00000, 10));
        System.out.println(solution.myPowByNoRecursive(2.00000, 11));
    }

    public double myPowByResursive(double x, int n) {
        //任何数的0次方都为1
        if (n == 0) {
            return 1;
        }
        //折半
        double half = myPowByResursive(x, n / 2);  // 5/2=2  默认向下取整
        if (n % 2 == 0) {
            return half * half;
        }
        if (n > 0) {
            return half * half * x;
        }
        return half * half / x;
    }


    /**
     * myPowByNoRecursive：使用非递归方法返回x的n次幂
     *
     * @param x 基数
     * @param n 指数
     * @return x的n次幂
     */
    public double myPowByNoRecursive(double x, int n) {
        int temp = n; //存放临时指数    比如2^11
        double result = 1.0;  //结果
        while (temp != 0) { //当指数不为0时
            result = (temp % 2 != 0 ? result * x : result);  //余数1次幂先乘进去  result * x   再乘一个余数次幂 result * x   再乘一个余数次幂 result * x
            temp = temp / 2; //自动向下取整 剩下temp=5   temp=2
            x = x * x;  //双边同时计算 2^5 * 2^5  双边同时计算  2^2 * 2^2   *   2^2 *2^2      双边同时计算 2^2 * 2^2 * 2   *    2^2 * 2^2 * 2
        }
        return (n < 0 ? 1 / result : result);
    }
}
