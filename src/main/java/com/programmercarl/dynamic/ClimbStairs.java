package com.programmercarl.dynamic;

/**
 * @ClassName ClimbStairs
 * @Descriotion TODO
 * @Author nitaotao
 * @Date 2022/7/21 8:18
 * @Version 1.0
 * https://leetcode.cn/problems/climbing-stairs/
 * 70. 爬楼梯
 **/
public class ClimbStairs {
    public int climbStairs(int n) {
        if (n <= 1) {
            return n;
        }
        /**
         * 第一级楼梯      1
         * 第二级楼梯      2        11 或  2
         * 第三级楼梯      3        111   12    21
         * 第四级楼梯      5        1111  112  121  211  22
         * 第五级楼梯      8        11111 1112 1121 1211 122 2111 212 221
         */
        // dp[0]不用
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        int first = dp[1];
        int second = dp[2];
        for (int i = 3; i <= n; i++) {
            //类似斐波那契数列
            //根据前两个推出第三个
            int cur = first + second;
            dp[i] = cur;
            first = second;
            second=cur;
        }
        return dp[n];
    }
}
