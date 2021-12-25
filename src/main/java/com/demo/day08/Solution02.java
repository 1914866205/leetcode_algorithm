package com.demo.day08;

/**
 * author: nitaotao
 * date: 2021/11/18 13:19
 * version: 1.0
 * description: https://leetcode-cn.com/problems/powx-n
 * 非递归   分治思想
 */
public class Solution02 {
    public static void main(String[] args) {
        System.out.printf("%.5f", myPow(2.00000, 15151));
    }

    /**
     *
     * @param x 浮点数
     * @param n 幂次
     * @return
     */
    public static double myPow(double x, int n) {
        double result = 1.0;
        // 2的99次方＝2的49次方 * 2的49次方 * 2
        for (int i = n; i != 0; i /= 2) {
            //如果是偶数次方
            //折半思想  2的100次方＝2的50次方 * 2的50次方
            // 50次方=25次方 * 25次方
            //25次方 = 12次方 *12次方 *2次方
            if (i % 2 != 0) {
                //如果不是偶数次方 ，则先乘以一遍该数
                result *= x;
            }
            x *= x;
        }
        return n < 0 ? 1 / result : result;
    }




}
