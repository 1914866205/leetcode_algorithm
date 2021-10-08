package com.demo.day03;

import java.util.Scanner;

/**
 * @author 倪涛涛
 * @version 1.0.0
 * @ClassName Test4.java
 * @Description 描述
 * 输入一个浮点数，输出这个浮点数的绝对值。
 * 输入一个浮点数，其绝对值不超过10000。
 * 输出这个浮点数的绝对值，保留到小数点后两位。
 * @createTime 2021年10月13日 13:04:00
 */
public class Test4 {
    public static void main(String[] args) {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            Double a = scanner.nextDouble();
            System.out.println("输入：" + a);
            // a 取绝对值
            if (a < 0) {
                a = -a;
            }
            // a 的范围
            if (a > 10000 || a < -10000) {
                System.out.println(" a 不符合范围 -10000 < a < 10000");
            }

            if (String.valueOf((double) Math.round(a * 100) / 100).split("\\.")[1].length() == 1) {
                System.out.println("输出：" + (double) Math.round(a * 100) / 100 + "0");
            } else {
                System.out.println("输出：" + (double) Math.round(a * 100) / 100);
            }
        }
    }
}
