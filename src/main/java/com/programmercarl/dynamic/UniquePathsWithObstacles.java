package com.programmercarl.dynamic;

import com.programmercarl.util.GenerateArray;

/**
 * @ClassName UniquePathsWithObstacles
 * @Descriotion TODO
 * @Author nitaotao
 * @Date 2022/7/23 9:35
 * @Version 1.0
 * https://leetcode.cn/problems/unique-paths-ii/
 * 63. 不同路径 II
 **/
public class UniquePathsWithObstacles {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        /**
         * dp[ i ] 到达本位置有多少种走法
         */
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        //如果起点是障碍物
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }
        if (m == 1 && n == 1) {
            if (obstacleGrid[0][0] == 0) {
                return 1;
            } else {
                return 0;
            }
        }

        int[][] dp = new int[m][n];
        //第一行初始化
        if (n != 1) {
            if (obstacleGrid[0][1] == 0) {
                dp[0][1] = 1;
            }
            for (int i = 2; i < n; i++) {
                if (obstacleGrid[0][i] == 0) {
                    dp[0][i] = dp[0][i - 1];
                } else {
                    //如果这一位是障碍物
                    dp[0][i] = 0;
                }
            }
        }
        //第一列初始化
        if (m != 1) {
            //如果第一位不是障碍物
            if (obstacleGrid[1][0] == 0) {
                dp[1][0] = 1;
            }
            for (int i = 2; i < m; i++) {
                if (obstacleGrid[i][0] == 0) {
                    dp[i][0] = dp[i - 1][0];
                } else {
                    //如果这一位是障碍物
                    dp[i][0] = 0;
                }
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                //障碍物
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                    continue;
                }
                //每个单元格的位置是左边格子或者上边格子移动过来的
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
    }

    public static void main(String[] args) {
        int[][] arr = new int[2][1];
        arr[0] = new int[]{0};
        arr[1] = new int[]{0};
        System.out.println(new UniquePathsWithObstacles().uniquePathsWithObstacles(arr));
    }
}
