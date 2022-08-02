package com.programmercarl.dynamic;

/**
 * @ClassName LongestPalindromeSubseq
 * @Descriotion TODO
 * @Author nitaotao
 * @Date 2022/8/2 12:22
 * @Version 1.0
 * https://leetcode.cn/problems/longest-palindromic-subsequence/
 * 516. 最长回文子序列
 **/
public class LongestPalindromeSubseq {
    public int longestPalindromeSubseq(String s) {
        return process(s.toCharArray(), 0, s.length() - 1);
    }

    public int process(char[] s, int L, int R) {
        if (L == R) {
            return 1;
        } else if (L + 1 == R) {
            //如果只有两位  0 和  1 位
            return s[L] == s[R] ? 2 : 1;
        } else {
            //其他情况
            //以不以L开头  不以R结尾
            int NLNR = process(s, L + 1, R - 1);
            //以L开头，不以R结尾
            int LNR = process(s, L, R - 1);
            //不以L开头，以R结尾
            int NLR = process(s, L + 1, R);
            //以L开头，以R结尾
            int LR = s[L] == s[R] ? 2 + process(s, L + 1, R - 1) : 0;
            return Math.max(Math.max(NLNR, LNR), Math.max(NLR, LR));
        }
    }

    public int longestPalindromeSubseq2(String s) {
        int n = s.length();
        char[] chars = s.toCharArray();
        int[][] dp = new int[n][n];
        dp[n - 1][n - 1] = 1;
        for (int i = 0; i < n - 1; i++) {
            //当为主对角线上元素时，一定和当前相等，即为1
            dp[i][i] = 1;
            //主对角线上一条线
            dp[i][i + 1] = chars[i] == chars[i + 1] ? 2 : 1;
        }
        for (int i = n - 3; i >= 0; i--) {
            for (int j = i + 2; j < n; j++) {
                //其他情况
                //以不以L开头  不以R结尾
                int NLNR = dp[i + 1][j - 1];
                //以L开头，不以R结尾
                int LNR = dp[i][j - 1];
                //不以L开头，以R结尾
                int NLR = dp[i + 1][j];
                //以L开头，以R结尾
                int LR = chars[i] == chars[j] ? 2 + dp[i + 1][j - 1] : 0;
                dp[i][j] = Math.max(Math.max(NLNR, LNR), Math.max(NLR, LR));
            }
        }

        return dp[0][n - 1];
    }
}
