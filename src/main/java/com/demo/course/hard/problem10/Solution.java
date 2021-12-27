package com.demo.course.hard.problem10;

/**
 * author: nitaotao
 * date: 2021/12/23 9:56
 * version: 1.0
 * description: https://leetcode-cn.com/problems/edit-distance/
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.minDistance("horse", "ros");
    }

    /**
     * 编辑距离
     *
     * @param word1 源单词
     * @param word2 目标单词
     * @return
     */
    public int minDistance(String word1, String word2) {
        int m = word1.length(); //状态转换图 横行数量
        int n = word2.length(); //纵行数量
        int[][] dp = new int[m + 1][n + 1];  //状态转换表
        for (int i = 1; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int j = 1; j <= n; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                //dp数组有效位从1开始
                //当前遍历的字符串位置为 i-1 或者 j -1
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    //如果两个相等，则往前算一位，否则取表中左上，上，左位置中的最小值+1，即为一次操作
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    //如果不相等，选择最短步骤+1
                    dp[i][j] = ((dp[i][j - 1] < dp[i - 1][j - 1] ? dp[i][j - 1] : dp[i - 1][j - 1]) < dp[i - 1][j] ? (dp[i][j - 1] < dp[i - 1][j - 1] ? dp[i][j - 1] : dp[i - 1][j - 1]) : dp[i - 1][j])+1;
                }

//                for (int k = 0; k <dp.length ; k++) {
//                    for (int l = 0; l <dp[k].length ; l++) {
//                        System.out.print(dp[k][l]+" ");
//                    }
//                    System.out.println();
//                }
//                System.out.println("-----------------------");
            }
        }
        return dp[m][n];
    }
}
