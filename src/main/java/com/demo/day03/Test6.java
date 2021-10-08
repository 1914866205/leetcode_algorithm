package com.demo.day03;

import java.util.Scanner;

/**
 * @author 倪涛涛
 * @version 1.0.0
 * @ClassName Test6.java
 * @createTime 2021年10月13日 13:04:00
 */
public class Test6 {
    public static void main(String[] args) {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            if (a <= 100 && a >= 0 && b <= 100 && b >= 0) {
                if (a < 60 || b < 60) {
                    System.out.println(0);
                } else {
                    System.out.println(1);
                }
            }
        }
    }
}
