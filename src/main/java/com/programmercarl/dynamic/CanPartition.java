package com.programmercarl.dynamic;

/**
 * @ClassName CanPartition
 * @Descriotion TODO
 * @Author nitaotao
 * @Date 2022/7/27 0:36
 * @Version 1.0
 * https://leetcode.cn/problems/partition-equal-subset-sum/
 * 416. 分割等和子集
 **/
public class CanPartition {
    public boolean canPartition(int[] nums) {
        /**
         看作 01背包问题
         数组和 是固定的 ， 相当于 总容量 weight
         一共有n 个数
         每个数只能被选择一次
         一旦有的总和 和 为 1/2 sum  ，即结束
         */
        int allSum = 0;
        for (int i = 0; i < nums.length; i++) {
            allSum += nums[i];
        }
        int n = nums.length;
        if (allSum % 2 == 1 || n == 1) {
            // 奇数哪来的平分,一个数哪来的平分
            return false;
        }
        // x轴长度
        int result = allSum / 2;
        //dp[i]为当前占用容量
        int[][] dp = new int[n][result + 1];
        //一共n个数，共需的总和（空间）为  [0,result]
        for (int i = 0; i < n; i++) {
            //第一列初始化为0，即sum还差0时
            dp[i][0] = 0;
        }
        for (int i = 1; i <= result; i++) {
            //第一行初始化
            if (i >= nums[0]) {
                dp[0][i] = nums[0];
            }
        }
        /**  0 1 2 3 4 5  总容量
         * 0 0 1 1 1 1 1
         * 1 0
         * 2 0
         * 3 0
         * 第
         * 几
         * 个
         */
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= result; j++) {
                if (dp[i - 1][j] == result) {
                    return true;
                }
                if (nums[i] + dp[i - 1][j] > result) {
                    //如果当前值放不进来
                    //当前值还用原来的
                    dp[i][j] = dp[i - 1][j];
                } else if (nums[i] + dp[i - 1][j] < result) {
                    //如果当前总和小于result,可以放置进来的
                    if (j >= nums[i]) {
                        //如果容量>这个数，才能放进来
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - nums[i]] + nums[i]);
                    } else {
                        //当前位置放不下则还用原来的
                        dp[i][j] = dp[i - 1][j];
                    }
                } else {
                    //如果遇到刚刚好，满了，就直接返回。
                    return true;
                }
                for (int k = 0; k < n; k++) {
                    for (int l = 0; l <= result; l++) {
                        System.out.print(dp[k][l] + "   ");
                    }
                    System.out.println();
                }

            }
        }
        return false;
    }

    public static void main(String[] args) {
//        System.out.println(new CanPartition().canPartition(new int[]{1, 2, 3, 4, 5, 6, 7}));
        System.out.println(new CanPartition().canPartition(new int[]{1, 1}));
//        System.out.println(new CanPartition().canPartition(new int[]{2, 2, 3, 5}));
//        System.out.println(new CanPartition().canPartition(new int[]{1, 5, 11, 5}));
    }
}
