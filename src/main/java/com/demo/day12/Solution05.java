package com.demo.day12;

import com.demo.course.hard.problem08.Solution;

/**
 * author: nitaotao
 * date: 2021/12/25 12:49
 * version: 1.0
 * description: https://leetcode-cn.com/problems/power-of-two/
 */
public class Solution05 {
    public static void main(String[] args) {
        Solution05 solution05 = new Solution05();
//        System.out.println(solution05.isPowerOfTwoNoRecursive(-2147483648));
//        System.out.println(solution05.isPowerOfTwoByRecursive(-2147483648));
        System.out.println(solution05.isPowerOfTwoByRecursive(8));

    }

    /**
     * isPowerOfTwoNoRecursive 2进制思想，如果是2的幂次，则转换为2进制为 100000等等，只有首位为1，其余为0
     *
     * @param n
     * @return
     */
    public boolean isPowerOfTwoNoRecursive(int n) {
//        java: 过大的整数: -2147483650
        //最大范围的int
        if (n == -2147483648) {
            return false;
        }
        if (n == 1) {
            return true;
        }
        String binaryString = Integer.toBinaryString(n);
        //截取第一位之后
        binaryString = binaryString.substring(1);
        String[] split = binaryString.split("");
        for (int i = 0; i < split.length; i++) {
            if (!"0".equals(split[i])) {
                return false;
            }
        }
        return true;
    }

    public boolean isPowerOfTwoByRecursive(int n) {
        if (n == 0) {
            return false;
        }
        if (n == 1) {
            return true;
        }
        if (n % 2 != 0) {
            return false;
        }
        while (n != 1) {
            n = n / 2;
            if (n % 2 != 0 && n != 1) {
                return false;
            }
        }
        return true;
    }
}
