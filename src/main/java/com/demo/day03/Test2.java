package com.demo.day03;

import java.util.Scanner;

/**
 * @author 倪涛涛
 * @version 1.0.0
 * @ClassName Test2.java
 * @Description TODO
 * @createTime 2021年10月13日 13:04:00
 */
public class Test2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        System.out.println("输入：" + a);
        String s = "";
        while (a / 10 > 0) {
            s += String.valueOf(a % 10);
            a /= 10;
        }
        s += String.valueOf(a % 10);
        System.out.println("输出: " +s);
    }
}
