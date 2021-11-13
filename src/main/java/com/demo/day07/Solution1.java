package com.demo.day07;

/**
 * author: nitaotao
 * date: 2021/11/10 16:17
 * version: 1.0
 * description: https://leetcode-cn.com/problems/count-primes/
 * 筛法
 * 通过把数组对应的数的值改变，最后统计数组中1的个数
 */
public class Solution1 {
    public static void main(String[] args) {
        System.out.println(countPrimes(10000000));
    }


    public static int countPrimes(int n) {
        int[] nums = new int[n];
        int count = 0;
        for (int i = 0; i < nums.length; i++) { // 输入数组元素
            nums[i] = 1;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (nums[i] == 1) {
                for (int j = i * i; j < n; j += i) {
                    nums[j] = 0;
                }
            }
        }
        for (int i = 2; i < n; i++)
            if (nums[i] == 1) count++;
        return count;
    }

}
