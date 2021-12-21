package com.demo.course.mid.problem05;

/**
 * author: nitaotao
 * date: 2021/12/21 22:44
 * version: 1.0
 * description: todo
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reverse(-2147483648));
    }

    public int reverse(int x) {
        //超出int范围
        if (Math.abs(Long.parseLong(String.valueOf(x)))>Math.abs(Long.parseLong(String.valueOf(2147483647)))) {
            return 0;
        }
        boolean isFu = false;
        if (x == 0) {
            return 0;
        }
        if (x < 0) {
            x = -x;
            isFu = true;
        }
        String[] strNum = String.valueOf(x).split("");
        String strRe = isFu ? "-" : "";
        boolean flagEndZero = true;
        for (int i = strNum.length - 1; i > -1; i--) {
            if (strNum[i].equals("0") && flagEndZero) {
                continue;
            } else {
                flagEndZero = false;
                strRe += strNum[i];
            }
        }
        if (strRe.charAt(strRe.length() - 1) == '-') {
            strRe = strRe.substring(0, strRe.length() - 2);
        }
        //如果反转后整数超过 32 位的有符号整数的范围 [−2的31,  2的31 − 1] ，就返回 0
        //MIN_VALUE的绝对值为：2147483648 > Integer.MAX_VALUE(2^31 - 1 = 2147483647)
        long result = Long.parseLong(strRe);
        if ((result > Integer.MAX_VALUE) || (result < Integer.MIN_VALUE)) {
            return 0;
        } else {
            return (int) result;
        }
    }
}


