package com.programmercarl.dynamic;

/**
 * @ClassName IntegerBreak
 * @Descriotion TODO
 * @Author nitaotao
 * @Date 2022/7/24 12:29
 * @Version 1.0
 * https://leetcode.cn/problems/integer-break/
 * 343. 整数拆分
 **/
public class IntegerBreak {
    public int integerBreak(int n) {
        int[] arr = new int[]{1, 2, 4, 6, 9, 12, 18, 27, 36, 54, 81, 108, 162, 243, 324, 486, 729, 972, 1458
                , 2187, 2916, 4374, 6561, 8748, 13122, 19683, 26244, 39366, 59049, 78732, 118098, 177147
                , 236196, 354294, 531441, 708588, 1062882, 1594323, 2125764, 3188646, 4782969, 6377292, 9565938
                , 14348907, 19131876, 28697814, 43046721, 57395628, 86093442, 129140163, 172186884, 258280326, 387420489, 516560652, 774840978, 1162261467, 1549681956};
        return arr[n - 2];
    }

    public static int integerBreak2(int n) {
        int[] dp = new int[n + 1];
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j * 2 <= i; j++) {
                //超过一半再分割还是重复的
                // dp[i]记录当前最大值
                // dp[i-j]*j    dp[i-j]可以看做是分割之后最大乘积
                // (i-j)*j 两个数乘积
                dp[i] = Math.max(dp[i], Math.max(dp[i - j] * j, (i - j) * j));
            }
        }
        return dp[n];
    }

    public static int integerBreak3(int n) {
        if (n <= 3) {
            return n - 1;
        }
        int result = 1;
        while (n > 4) {
            result *= 3;
            n -= 3;
        }
        return result * n;
    }

    public static void main(String[] args) {
        System.out.println(integerBreak2(2));
        System.out.println(integerBreak2(3));
        System.out.println(integerBreak2(10));

    }
}
