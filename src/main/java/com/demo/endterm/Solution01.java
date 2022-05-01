package com.demo.endterm;

/**
 * author: nitaotao
 * date: 2022/1/5 14:27
 * version: 1.0
 * description:  https://leetcode-cn.com/problems/count-primes/
 */
public class Solution01 {
    public int countPrimes(int num) {
        if (num <= 2) { // 小于 2 没有素数
            return 0;
        }
        if (num == 3) { // 小于 3 只有 1 个素数
            return 1;
        }
        if (num == 4) { // 小于 4 只有 2 个素数
            return 2;
        }
        // 对不小于 4 的整数，至少包含 2 和 3 两个素数
        int count = 2;
        // 设置数字 i 是否为素数，默认全否
        boolean[] isPrime = new boolean[num];
        isPrime[2] = true; // 标记 2 是素数
        isPrime[3] = true; // 标记 3 是素数
        // 从 5 开始，通过素数的六倍数特性设置可能的素数，步长显然为 6
        for (int i = 5; i < num; i = i + 6) {
            // 6X-1 位置可能为素数
            isPrime[i] = true;
            count++; // 素数个数+1
            // 6X+1 位置也可能为素数
            if (i + 2 < num) { // 防止 6X+1 位置超界
                isPrime[i + 2] = true;
                count++; // 素数个数+1
            }
        }
        // 从 5 开始，对所有奇数进行筛查
        for (int i = 5; i * i < num; i = i + 2) {
            // 当前数字 i 是素数
            if (isPrime[i]) {
                // 则 i 的奇数倍均不是素数
                for (int j = i; j * i < num; j = j + 2) {
                    // 若 i 的奇数倍之前设置为素数，需要改为非素数
                    if (isPrime[j * i]) {
                        isPrime[j * i] = false;
                        count--;
                    }
                }
            }
        }
        return count; // 返回结果
    }
}
