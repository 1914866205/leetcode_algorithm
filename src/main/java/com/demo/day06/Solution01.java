package com.demo.day06;

/**
 * author: nitaotao
 * date: 2021/11/3 13:23
 * version: 1.0
 * description: https://leetcode-cn.com/problems/perfect-number/,/
 */
public class Solution01 {
    public static void main(String[] args) {
        System.out.println(checkPerfectNumber(28));
    }

    public static boolean checkPerfectNumber(int num) {
        int sum = 1;
        if (num != 1) {
            int i = 2;
            while (i * i < num) {
                if (num % i == 0) {
                    sum += i + num / i;
                }
                i++;
            }
            if (i * i == num) {
                sum += i;
            }
            return sum == num;
        }
        return false;
    }
}
