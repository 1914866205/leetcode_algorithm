package com.demo.day03;

import java.util.Scanner;

/**
 * @author 倪涛涛
 * @version 1.0.0
 * @ClassName Test5.java
 * @createTime 2021年10月13日 13:04:00
 */
public class Test5 {
    public static void main(String[] args) {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            int a = scanner.nextInt();
            System.out.println("输入：" + a);
            if (a > 1000) {
                System.out.println("输入的数不超过1000");
            }
            if (a >= 10 && a < 100) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }
}
