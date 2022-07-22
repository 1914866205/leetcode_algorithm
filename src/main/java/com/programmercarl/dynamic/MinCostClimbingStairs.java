package com.programmercarl.dynamic;


/**
 * @ClassName MinCostClimbingStairs
 * @Descriotion TODO
 * @Author nitaotao
 * @Date 2022/7/22 12:34
 * @Version 1.0
 * https://leetcode.cn/problems/min-cost-climbing-stairs/
 * 746. 使用最小花费爬楼梯
 **/
public class MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        //每次选择两个位置加之后一步里最便宜的
        //跳出这层台阶需要花费的最少消费
        int[] dp = new int[cost.length];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < dp.length; i++) {
            //状态转移方程
            dp[i] = Math.min(dp[i - 1], dp[i - 2]) + cost[i];
        }
        return Math.min(dp[cost.length - 1], dp[cost.length - 2]);
    }

    public static void main(String[] args) {
        System.out.println(new MinCostClimbingStairs().minCostClimbingStairs(new int[]{0, 0, 1, 1}));
        System.out.println(new MinCostClimbingStairs().minCostClimbingStairs(new int[]{1,100,1,1,1,100,1,1,100,1}));
    }
}
