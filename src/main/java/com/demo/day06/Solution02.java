package com.demo.day06;

/**
 * author: nitaotao
 * date: 2021/11/3 13:36
 * version: 1.0
 * description:  https://leetcode-cn.com/problems/ugly-number
 */
public class Solution02 {
    public static void main(String[] args) {
        System.out.println(isUgly(0));
    }

    public static boolean isUgly(int n) {
        if (n == 0) {
            return false;
        }
        while (n % 2 == 0) {
            n = n / 2;
        }
        while (n % 3 == 0) {
            n = n / 3;
        }
        while (n % 5 == 0) {
            n = n / 5;
        }
        return n == 1;
    }
}
