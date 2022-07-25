package com.programmercarl.dynamic;

/**
 * @ClassName NumTrees
 * @Descriotion TODO
 * @Author nitaotao
 * @Date 2022/7/25 17:00
 * @Version 1.0
 * https://leetcode.cn/problems/unique-binary-search-trees/
 * 96. 不同的二叉搜索树
 **/
public class NumTrees {
    public int numTrees(int n) {
        /**
         * 二叉搜索树，升序
         * n>=1
         */
        if (n <= 2) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            // n>=1
            for (int j = 1; j < i; j++) {
                //dp[i]的每种可能性为以其中一个数为头结点，左子树的变法*右子树的变法
                // 以 dp[j]为头结点
                //左子树有j-1个    右子树有i-j个
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }
}
