package com.programmercarl.dynamic;

/**
 * @ClassName LongestCommonSubsequence
 * @Descriotion TODO
 * @Author nitaotao
 * @Date 2022/8/1 21:30
 * @Version 1.0
 * https://leetcode.cn/problems/qJnOS7/
 * 剑指 Offer II 095. 最长公共子序列
 **/
public class LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        return getLongLest(text1, text1.length() - 1, text2, text2.length() - 1);
    }


    private int getLongLest(String text1, int text1Index, String text2Str, int text2tIndex) {
        if (text1Index == 0 && text2tIndex == 0) {
            //比较当前位是否相等
            return text1.charAt(text1Index) == text2Str.charAt(text2tIndex) ? 1 : 0;
        } else if (text1Index == 0) {
            //左边到头了就左边不动比右边
            return text1.charAt(text1Index) == text2Str.charAt(text2tIndex) ? 1 : getLongLest(text1, text1Index, text2Str, text2tIndex - 1);
        } else if (text2tIndex == 0) {
            //右边到头了就右边不动比左边
            return text1.charAt(text1Index) == text2Str.charAt(text2tIndex) ? 1 : getLongLest(text1, text1Index - 1, text2Str, text2tIndex);
        } else {
            //都不為0
            int p1 = getLongLest(text1, text1Index, text2Str, text2tIndex - 1);
            int p2 = getLongLest(text1, text1Index - 1, text2Str, text2tIndex);
            //都没到头就比中间
            int p3 = text1.charAt(text1Index) == text2Str.charAt(text2tIndex) ? 1 + getLongLest(text1, text1Index - 1, text2Str, text2tIndex - 1) : Integer.MIN_VALUE;
            return Math.max(p1, Math.max(p2, p3));
        }
    }

    public int longestCommonSubsequence2(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        char[] s1 = text1.toCharArray();
        char[] s2 = text2.toCharArray();
        int[][] dp = new int[m][n];
        //首位初始化
        dp[0][0] = s1[0] == s2[0] ? 1 : 0;
        //行列初始化
        for (int i = 1; i < m; i++) {
            dp[i][0] = s1[i] == s2[0] ? 1 : dp[i - 1][0];
        }
        for (int i = 1; i < n; i++) {
            dp[0][i] = s1[0] == s2[i] ? 1 : dp[0][i - 1];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                int left = dp[i][j - 1];
                int up = dp[i - 1][j];
                int cur = s1[i] == s2[j] ? 1 + dp[i - 1][j - 1] : 0;
                dp[i][j] = Math.max(left, Math.max(up, cur));
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        System.out.println(new LongestCommonSubsequence().longestCommonSubsequence2("abcde", "ace"));
    }
}
