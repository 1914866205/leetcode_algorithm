package com.demo.course.mid.problem09;

/**
 * author: nitaotao
 * date: 2021/12/22 18:53
 * version: 1.0
 * description: 二进制求和
 * https://leetcode-cn.com/problems/add-binary/submissions/
 * 【解题思路】： 先比较两个输入的字符数字长度，判断其最大串长度，以此为模板创建数组，构建竖式计
 * 算，较小的左边至为 0，需要使用进位变量来控制。本题思路和大整数相加思路基本一致，将十进制思想
 * 改为二进制即可。
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.addBinary("1010", "1011"));
    }

    /**
     *  addBinary：二进制求和
     * @param a 参数a
     * @param b 参数b
     * @return 二进制求和后的结果
     * 本题思路和 mid 01 完全一致
     */
    public String addBinary(String a, String b) {
        String num1 = a;
        String num2 = b;

        //把长度较长的作为num1,长度较短的作为num2
        //判断最大长度，进行竖式计算
        if (num1.length() < num2.length()) {
            String temp = num2;
            num2 = num1;
            num1 = temp;
        }
        //两个数分割成数组
        String[] num1Str = num1.split("");
        String[] num2Str = num2.split("");
        //化两个数分割为等长数组
        //位置计数器，用来对齐竖式计算
        int indexNum2 = num2Str.length - 1;
        //如果num1位数较多
        String[] newNum2 = new String[num1.length()];
        //indexNum2和i控制左边不越界
        for (int i = newNum2.length - 1; indexNum2 > -1 || i > -1; i--) {
            //一位一位对齐，从后往前
            if (indexNum2 < 0) {
                //因为String数组默认为null而不是0，所以要手动至0
                newNum2[i] = "0";
            } else {
                newNum2[i] = num2Str[indexNum2];
                indexNum2--;
            }
        }
        int temp = 0; //进位标记
        String[] result = new String[num1Str.length + 1];
        //初始化为0
        result[0] = "0";
        for (int i = num1Str.length - 1; i > -1; i--) {
            result[i + 1] = String.valueOf((Integer.parseInt(num1Str[i]) + Integer.parseInt(newNum2[i]) + temp) % 2);
            //进位标志
            temp = Integer.valueOf(num1Str[i]) + Integer.valueOf(newNum2[i]) + temp > 1 ? 1 : 0;
        }
        //首位进位
        result[0] = temp == 0 ? "0" : "1";
        //判断是不是全是0
        int count = 0;
        for (int i = 0; i < result.length; i++) {
            if (result[i].equals("0")) {
                count++;
            }
        }

        String resultNum = "";
        if (count == result.length) {
            //如果全是0
            return "0";
        } else {
            //输出时注意首位不能为0
            boolean flag = false;
            for (int i = 0; i < result.length; i++) {
                if (flag) {
                    //已判断前有不为0的数
                    resultNum += result[i];
//                    System.out.print(result[i]);
                } else {
                    if (!result[i].equals("0")) {
                        //已找到首位不为0的数
                        resultNum += result[i];
//                        System.out.print(result[i]);
                        flag = true;
                    }
                }
            }
        }
        return resultNum;
    }
}
