package com.demo.course.hard.problem10;

/**
 * author: nitaotao
 * date: 2021/12/23 9:56
 * version: 1.0
 * description: https://leetcode-cn.com/problems/edit-distance/
 * 【解题思路】：
 * 构建 dp 数组，横行数为单词 1 长度，纵行为单词 2 长度，计算每一次单词变化，需要改变的步数。
 * 使用动态规划算法，自底而上，有点寻找最短路径的感觉。
 * 从上一次的变化中，即增，删，改，即对应的当前表格位置的左，左上，上的三个位置的值，即为上
 * 次变化后的总次数，从中选取最小的次数。
 * 如果这次要比较的单词不相等，则选择之前的三个数的最小值+1，即为当前最短路径；
 * 如果当前要比较的单词相等，即第 dp[i][0]==dp[0][j]，则在判断上一个的位置是否也相等，如果
 * dp[i-1][0]= d p[0][j-1]，则说明重复，不可以选择三者最小值+1，只有在第一位相同时，才能选择三者最小
 * 值，保持不变填入 dp[i][j]。不是第一位，且当前 dp[i][0]==dp[0][j]，且当 dp[i-1][0]= d p[0][j-1]，则不是不
 * 变，而是选择三者最短+1，因为连续出现两个相同的，另一个单词的这个字母不能当两次用。
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.minDistance("horse", "ros");
    }

    /**
     * 编辑距离
     * @param word1 源单词
     * @param word2 目标单词
     * @return 最短编辑距离
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
        // 从 1 取 ，因为表中的元素是从第一行第一列开始放的
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
