package com.demo.course.mid.problem05;

/**
 * author: nitaotao
 * date: 2021/12/21 22:44
 * version: 1.0
 * description:
 * 整数反转
 * 题目描述详见 https://leetcode-cn.com/problems/reverse-integer/。
 * 【解题思路】：先检查特定条件，比如输入为 0，输入超出 int 范围等，转成字符串，反转，字符串拼接。
 * 关于超出范围的 int 处理参考文献
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reverse(-2147483648));
    }

    /**
     * reverse方法：整数反转
     * @param x 被反转的整数
     * @return 反转后的整数
     */
    public int reverse(int x) {
        //超出int范围
        if (Math.abs(Long.parseLong(String.valueOf(x)))>Math.abs(Long.parseLong(String.valueOf(2147483647)))) {
            return 0;   //越界直接返回0
        }
        boolean isFu = false;  //负数记号
        if (x == 0) {
            return 0;
        }
        if (x < 0) {
            x = -x;   //取正
            isFu = true;
        }
        String[] strNum = String.valueOf(x).split("");
        String strRe = isFu ? "-" : "";  //转换后的数字
        boolean flagEndZero = true;   //末尾为0标记
        for (int i = strNum.length - 1; i > -1; i--) {
            if (strNum[i].equals("0") && flagEndZero) {   //控制  -000001  这种类型的数出现，删除前面的0
                continue;
            } else {
                flagEndZero = false;  //只要有一个不是0，上面的if就不用执行了
                strRe += strNum[i];
            }
        }
        if (strRe.charAt(strRe.length() - 1) == '-') {   //如果数字为  - 10001 -   删除最后一位
            strRe = strRe.substring(0, strRe.length() - 2);    //   length-1 为最后一位    length-2是倒数第二位
        }
        //如果反转后整数超过 32 位的有符号整数的范围 [−2的31,  2的31 − 1] ，就返回 0
        //MIN_VALUE的绝对值为：2147483648 > Integer.MAX_VALUE(2^31 - 1 = 2147483647)
        long result = Long.parseLong(strRe);
        if ((result > Integer.MAX_VALUE) || (result < Integer.MIN_VALUE)) {
            return 0;   //越界直接返回0
        } else {
            return (int) result;
        }
    }
}


