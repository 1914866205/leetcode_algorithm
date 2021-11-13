package com.demo.day07;

import java.util.Arrays;
import java.util.Scanner;

/**
 * author: nitaotao
 * date: 2021/11/10 14:22
 * version: 1.0
 * description: http://noi.openjudge.cn/ch0106/02/
 */
public class Main02 {
    public static void main(String[] args) {
        final int chair = 30; //凳子的高度
        int h; //陶陶把手伸直的高度
        int[] arr = new int[10]; //十个苹果的高度
        int height; //陶陶最大高度
        int count = 0; // 陶陶总共能摘到的苹果数
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scanner.nextInt();
        }
        h = scanner.nextInt();
        height = h + chair;
        for (int i : arr) {
            count = i > height ? count : count+1;
        }
        System.out.println(count);

//        System.out.println("==========老田的大爱心================");
//        // 分三个大部分 上中下
//        for (int i = 0, k = 0; i < 14; i++) {// 打印行
//            // 上部分 上分为 四个部分
//            if (i < 3) {
//                for (int j = 0; j < 5 - 2 * i; j++) {// 1、空心
//                    System.out.print(" ");
//                }
//                if (i == 2) {// 2、*
//                    for (int j = 0; j < 6 + 4 * i - 1; j++) {
//                        System.out.print("*");
//                    }
//                    for (int j = 0; j < 7 - 4 * i + 2; j++) {// 3、空心
//                        System.out.print(" ");
//                    }
//                    for (int j = 0; j < 6 + 4 * i - 1; j++) {// 4、*
//                        System.out.print("*");
//                    }
//                } else {
//                    for (int j = 0; j < 6 + 4 * i; j++) {// 2、*
//                        System.out.print("*");
//                    }
//                    for (int j = 0; j < 7 - 4 * i; j++) {// 3、空心
//                        System.out.print(" ");
//                    }
//                    for (int j = 0; j < 6 + 4 * i; j++) {// 4、*
//                        System.out.print("*");
//                    }
//                }
//            } else if (i < 6) {// 中间
//                for (int j = 0; j < 29; j++) {
//                    System.out.print("*");
//                }
//            } else {// 下部分 6
//                if (i == 13) {
//                    for (int j = 0; j < 2 * (i - 6); j++) {// 打印空格
//                        System.out.print(" ");
//                    }
//                    System.out.print("*");
//                } else {
//                    for (int j = 0; j < 2 * (i - 6) + 1; j++) {// 打印空格
//                        System.out.print(" ");
//                    }
//                    for (int j = 1; j < 28 - 4 * k; j++) {
//                        System.out.print("*");
//                    }
//                    k++;
//                }
//            }
//            System.out.println();// 换行
//        }
    }
}
