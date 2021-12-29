package com.demo.course.hard.problem05;

/**
 * author: nitaotao
 * date: 2021/12/22 23:39
 * version: 1.0
 * description: https://leetcode-cn.com/problems/powx-n/
 * 【解题思路】： 使用折半计算，比如计算 2 的 100 次方，可以看成 2^50 * 2^50,如果刚好是偶数，又可以
 * 拆分成两个，比如 2^50 可以分成 2^25 * 2^25，如果是奇数，即 2^25，可以分成 2^12 * 2^12 * 2。直到最
 * 后幂次为 0，任何数的 0 次方都为 1。注意最后负奇次方。
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.myPow(2.00000, -5));
    }

    /**
     * myPow方法：求指数函数
     *
     * @param x 指数
     * @param n 底数
     * @return
     */
    public double myPow(double x, int n) {   //  2  10
        //任何数的0次方都为1
        if (n == 0) {
            return 1;
        }
        //折半
        double half = myPow(x, n / 2);  // 10/2=5  默认向下取整
        if (n % 2 == 0) {     // n为偶数
            return half * half;
        }
        if (n > 0) {
            return half * half * x;
        }
        return half * half / x;  //n是负的   (5)^-1  等于1/5  针对负奇数情况
    }
}
