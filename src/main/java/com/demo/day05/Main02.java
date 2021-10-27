package com.demo.day05;

import java.util.Scanner;

/**
 * author: nitaotao
 * date: 2021/10/27 13:36
 * version: 1.0
 * description: todo
 * http://noi.openjudge.cn/ch0105/20/
 */
public class Main02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double height = scanner.nextInt(); //球的初始高度
        double sum = 0; //球的轨迹长度
        for (int i = 1; i <= 10; i++) {
            sum += height; //球的下落高度
            height *= 0.5;
            sum += height; //球的上升高度
        }
        sum -= height; //球的上升高度
        System.out.printf("%g", sum);
        System.out.println();
        System.out.printf("%g", height);
    }
}
