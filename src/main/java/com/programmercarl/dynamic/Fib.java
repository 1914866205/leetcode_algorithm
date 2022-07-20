package com.programmercarl.dynamic;

/**
 * @ClassName Fib
 * @Descriotion TODO
 * @Author nitaotao
 * @Date 2022/7/20 8:59
 * @Version 1.0
 * https://leetcode.cn/problems/fibonacci-number/
 * 509. 斐波那契数
 **/
public class Fib {
    /**
     * 递归做法
     *
     * @param n
     * @return
     */
    public int fib(int n) {
        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }

    /**
     * 优化
     */
    int[] arr;

    public int fib2(int n) {
        arr = new int[n + 1];
        getFibArr(n);
        return arr[n];
    }

    public void getFibArr(int cur) {
        if (cur == 0) {
            arr[0] = 0;
            return;
        }
        if (cur == 1) {
            arr[1] = 1;
            return;
        }
        if (cur == 2) {
            arr[2] = 1;
            return;
        }
        arr[cur] = arr[cur - 1] + arr[cur - 2];
        if (arr[cur] == 0) {
            getFibArr(cur - 1);
            getFibArr(cur - 2);
            arr[cur] = arr[cur - 1] + arr[cur - 2];
        }
    }

    public int fib3(int n) {
        if (n <= 1) {
            return n;
        }
        //給0放位置
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new Fib().fib2(3));

    }
}
