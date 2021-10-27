package com.demo.day05;

import java.util.Scanner;

/**
 * author: nitaotao
 * date: 2021/10/27 11:22
 * version: 1.0
 * description: for循环
 * http://noi.openjudge.cn/ch0105/16/
 */
public class Main01 {
    public static void main(String[] args) {
        int N; //程序员的工资
        int K; //房价每年增长K%
        int save; //程序员的积蓄
        double price = 200.0;
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        K = scanner.nextInt();
        save = N;
        int i = 1;
        for (; save < price; i++) {
//            System.out.println("第"+i+"年的积蓄："+save+"  第"+i+"年的房价："+price);
            price = (1 + 1.0 * K / 100) * price;
            save += N;
            if (save >= price) {
                if (i <= 20) {
                    System.out.println(i + 1);
                } else {
                    System.out.print("Impossible");
                }
                break;
            }
            if (1.0 * K / 100 * price >= N) {
                System.out.print("Impossible");
                break;
            }
        }
    }
}

