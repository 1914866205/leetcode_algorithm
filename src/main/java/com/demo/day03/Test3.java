package com.demo.day03;

import java.util.Scanner;

/**
 * @author 倪涛涛
 * @version 1.0.0
 * @ClassName Test3.java
 * @Description TODO
 * @createTime 2021年10月13日 13:04:00
 */
public class Test3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        if (-10000 < a && a < 10000 && -10000 < b && b < 10000 && -10000 < c && c < 10000 && c != 0) {
            System.out.println(a);
            System.out.println(b);
            System.out.println(c);
            System.out.println("a+b)/c=" + (a + b) / c);
        }
    }
}
