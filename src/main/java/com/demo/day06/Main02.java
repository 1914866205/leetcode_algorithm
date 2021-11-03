package com.demo.day06;

import java.util.Scanner;

/**
 * author: nitaotao
 * date: 2021/11/3 12:28
 * version: 1.0
 * description: http://noi.openjudge.cn/ch0105/40/
 */
public class Main02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int a;
        int b;
        int count = 0;
        for (int i = 1; i <= num; i++) {
            if ((i - 1) % 10 == 0) {
                count++;
            }
            a = i / 10;
            while (a != 0) {
                if ((a - 1) % 10 == 0) {
                    count++;
                }
                a = a / 10;
            }
            if (a == 1) {
                count++;
            }
        }
        System.out.print(count);
    }
}
