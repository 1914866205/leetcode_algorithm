package com.demo.day02;

import java.util.Scanner;

/**
 * 输入
 * 输入只有一行， 包含一个字符。
 * 输出
 * 该字符构成的等腰三角形，底边长5个字符，高3个字符
 */
public class IsoscelesTriangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String img = sc.nextLine();
        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 3 - i; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= (2 * i - 1); j++) {
                System.out.print(img);
            }
            System.out.println("");
        }
    }
}
