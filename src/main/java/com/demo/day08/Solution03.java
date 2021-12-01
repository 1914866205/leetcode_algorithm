package com.demo.day08;

/**
 * author: nitaotao
 * date: 2021/11/18 13:19
 * version: 1.0
 * description: https://leetcode-cn.com/problems/powx-n
 * 递归
 */
public class Solution03 {
    public static void main(String[] args) {
//        System.out.println(5/2);
        System.out.printf("%.5f", myPow(2.00000, 15151));
    }

    /**
     * @param x 浮点数 2
     * @param n 幂次  10
     * @return
     */
    public static double myPow(double x, int n) {
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
