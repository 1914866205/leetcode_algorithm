package mca;

import java.util.Scanner;

/**
 * @ClassName Main4
 * @Descriotion 小米一面第二题
 * @Author nitaotao
 * @Date 2022/9/20 19:12
 * @Version 1.0
 **/
public class Main4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String t = sc.nextLine();
        System.out.println(getTimes(s, t));
    }

    public static int getTimes(String s, String t) {
        if (s == null && t == null) {
            return 0;
        }
        if (s == null||s.length()==0) {
            return t.length();
        }
        if (t == null || t.length() == 0) {
            return s.length();
        }
        if (s.equals(t)) {
            return 0;
        }


        //让 s 变成 t
        int[][] dp = new int[t.length()][s.length()];
        char[] chars = s.toCharArray();
        char[] chart = t.toCharArray();

        //增加 1 删除 1 替换

        //行初始化
        for (int i = 0; i < s.length(); i++) {
            if (chars[i] == chart[0]) {
                dp[0][i] = 0;
            } else {
                dp[0][i] = 1;
            }
        }
        //列初始化
        for (int j = 1; j < t.length(); j++) {
            if (chars[0] == chart[j]) {
                dp[j][0] = dp[j - 1][0];
            } else {
                dp[j][0] = dp[j - 1][0] + 1;
            }
        }
        // horse  ros
        /**
         *       h o r s e s
               r 1 1 0 1 1
               o 2 1 1 2 2
               h 3 2 2 3 3
               t
         */
        for (int i = 1; i < dp[0].length; i++) {
            for (int j = 1; j < dp.length; j++) {
                if (chars[i] == chart[j]) {
                    dp[j][i] = dp[j - 1][i];
                } else {
                    dp[j][i] = dp[j - 1][i] + 1;
                }
            }
        }
        int num = Integer.MAX_VALUE;
        for (int i = 0; i < dp[0].length; i++) {
            if (num > dp[chart.length - 1][i]) {
                num = dp[chart.length - 1][i];
            }
        }
        return chars.length - num;
    }
}
