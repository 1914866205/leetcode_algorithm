package com.programmercarl.dynamic;

/**
 * @ClassName StrConver
 * @Descriotion TODO
 * @Author nitaotao
 * @Date 2022/7/29 19:04
 * @Version 1.0
 **/
public class StrConvert {

    public int number(String str) {
        return getNumber(str.toCharArray(), 0);
    }

    private int getNumber(char[] chars, int curIndex) {
        //如果到达最后一位，则返回 1
        if (curIndex == chars.length) {
            return 1;
        }

        //可以选择变一位 或 变两位
        //变一位
        //如果当前值为 数字 0 ，则没有与之对应的字母
        if (chars[curIndex] == '0') {
            return 0;
        }

        int ways = getNumber(chars, curIndex + 1);
        //变两位,一共26个字母
        if (curIndex + 1 < chars.length && (chars[curIndex] - '0') * 10 + (chars[curIndex + 1] - '0') < 27) {
            ways += getNumber(chars, curIndex + 2);
        }
        return ways;
    }

    public int number2(String str) {
        return getNumber2(str.toCharArray());
    }

    private int getNumber2(char[] chars) {
        int[] dp = new int[chars.length + 1];
        //只有当前位置这一个变量
        // 最后一位为1
        dp[chars.length] = 1;
        for (int curIndex = chars.length - 1; curIndex >= 0; curIndex--) {
            //此位不为0
            if (chars[curIndex] != '0') {
                //此位可单变为字母
                int ways = dp[curIndex + 1];
                if (curIndex + 1 < chars.length && ((chars[curIndex] - '0') * 10 + (chars[curIndex + 1] - '0')) < 27) {
                    ways += dp[curIndex + 2];
                }
                dp[curIndex] = ways;
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {
        System.out.println(new StrConvert().number("111"));
        System.out.println(new StrConvert().number2("111"));
    }

}
