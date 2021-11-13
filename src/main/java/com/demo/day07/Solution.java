package com.demo.day07;

/**
 * author: nitaotao
 * date: 2021/11/10 16:17
 * version: 1.0
 * description: https://leetcode-cn.com/problems/count-primes/
 * 筛法
 * 通过把数组对应的数的值改变，最后统计数组中1的个数
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(countPrimes(10000000));
        System.out.println(countPrimes(3));
    }


    public static int countPrimes(int n) {
        if (n < 2) {
            return 0;
        }

        // 创建一个数组，从1开始计数  n个数
        // 静态初始化，默认值为0，
        //如果当前数是素数，则改为1
        int[] arr = new int[n + 1];
        arr[1] = 1;
        int count = 0; //计数器
        for (int i = 0; i < n; i += 2) {
            //偶数除了2都是合数
            arr[i] = 1;
        }
        arr[2] = 0;
        for (int i = 2; i * i < n; i++) {
            //判断每个数是不是素数
            if (arr[i] != 1 && isPrimes(i)) {
                //本位不变，且倍数变为1
                for (int j = i * i; j <= n; j +=i) {
                    if (j % i == 0 && i != j) {
                        arr[j] = 1;
                    }
                }
            }
        }
        for (int i = 1; i < n; i++) {
            if (arr[i] == 0) {
                count++;
            }
        }
        return count;
    }

    public static boolean isPrimes(int n) {
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
