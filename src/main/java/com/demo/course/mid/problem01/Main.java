package com.demo.course.mid.problem01;


/**
 * author: nitaotao
 * date: 2021/12/21 0:28
 * version: 1.0
 * description: http://noi.openjudge.cn/ch0106/10/
 * 大整数加法
 * 【解题思路】：本题显然考核大整数类的应用。也有另外一种解题思路：先比较两个输入的字符数字长度，
 * 判断其最大串长度，以此为模板创建数组，构建竖式计算，较小的左边至为 0，需要使用进位变量来控制。
 */

import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String num1 = scanner.next();
        String num2 = scanner.next();
        Main main = new Main();
        System.out.println(main.sum(num1, num2));
//        main.sumByArr(num1, num2);
    }


    /**
     * sum方法：对大整数进行加法运算
     *
     * @param num1 大整数1
     * @param num2 大整数2
     * @return
     */
    public BigInteger sum(String num1, String num2) {
        BigInteger bigInteger1 = new BigInteger(num1);
        BigInteger bigInteger2 = new BigInteger(num2);
        return bigInteger1.add(bigInteger2);
    }

    /**
     * sumByArr方法：对大整数进行加法运算
     *
     * @param num1 大整数1
     * @param num2 大整数2
     * @return
     */
    public void sumByArr(String num1, String num2) {
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
        //位置计数器，用来对齐竖式计算，初始定位字符串末尾
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
        /**处理之后的结果
         * 22222222222222222222
         * 00000033333333333333
         */
        int temp = 0; //进位标记
        String[] result = new String[num1Str.length + 1];
        //初始化为0
        result[0] = "0";
        for (int i = num1Str.length - 1; i > -1; i--) {
            result[i + 1] = String.valueOf((Integer.parseInt(num1Str[i]) + Integer.parseInt(newNum2[i]) + temp) % 10);
            //进位标志
            temp = Integer.valueOf(num1Str[i]) + Integer.valueOf(newNum2[i]) + temp > 9 ? 1 : 0;
        }
        //首位进位
        result[0] = temp == 0 ? "0" : "1";

        //判断结果是不是全是0   0 + 0 = 0
        int count = 0;
        for (int i = 0; i < result.length; i++) {
            if (result[i].equals("0")) {
                count++;
            }
        }
        //判断结果是不是全是0
        if (count == result.length) {
            //如果全是0
            System.out.print("0");
        } else {
            //输出时注意首位不能为0
            boolean flag = false;
            for (int i = 0; i < result.length; i++) {
                if (flag) {
                    //已判断前有不为0的数
                    System.out.print(result[i]);
                } else {
                    if (!result[i].equals("0")) {
                        //已找到首位不为0的数
                        System.out.print(result[i]);
                        flag = true;
                    }
                }
            }
        }
    }
}
