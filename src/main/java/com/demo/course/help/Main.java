package com.demo.course.help;

/**
 * author: nitaotao
 * date: 2021/12/23 12:46
 * version: 1.0
 * description: todo
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int h = input.nextInt();  //输入参数h的实际值
        int w = input.nextInt();  //输入参数w的实际值
        Scanner sc = new Scanner(System.in);
        String a = input.next(); //输入参数a的实际值
        int n = input.nextInt();  //输入参数n的实际值
        Main test = new Main();  //创建一个新的对象,test负责调用方法
        test.number(h, w, n, a);
    }

    //调用方法
    public void number(int h, int w, int n, String a) {

        if (n == 1) {
            for (int i = 1; i <= h; i++) {
                for (int j = 1; j <= w; j++)
                    System.out.print(a);
                System.out.print("\n");
            }
        }

        if (n == 0) {
            for (int i = 1; i <= h; i++) {
                if (i == 1 || i == h) {
                    for (int j = 0; j < w; j++) {
                        System.out.print(a);
                    }
                    System.out.print("\n");
                } else {
                    for (int j = 1; j < w; j++) {
                        if (j == 1 || j == w) {
                            System.out.print(a);
                        } else {
                            System.out.print(" ");
                        }
                    }
                    System.out.print("\n");
                }
            }

        }
    }
}