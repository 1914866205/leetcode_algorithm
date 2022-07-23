package com.programmercarl.dynamic;

/**
 * @ClassName UniquePaths
 * @Descriotion TODO
 * @Author nitaotao
 * @Date 2022/7/23 9:13
 * @Version 1.0
 * https://leetcode.cn/problems/unique-paths/
 * 62. 不同路径
 **/
public class UniquePaths {
    public int uniquePaths(int m, int n) {
        /**
         * dp[ i ] 到达本位置有多少种走法
         */
        int[][] dp = new int[m][n];
        dp[0][0] = 0;
        //初始化第一行
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        //初始化第一列
        for (int i = 1; i < m; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                //每个单元格的位置是左边格子或者上边格子移动过来的
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
