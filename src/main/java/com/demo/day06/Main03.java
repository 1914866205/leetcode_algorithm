package com.demo.day06;

import java.util.Scanner;

/**
 * author: nitaotao
 * date: 2021/11/3 12:44
 * version: 1.0
 * description: http://noi.openjudge.cn/ch0105/45/
 */
public class Main03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int days = scanner.nextInt();
        int steps = 1;
        int sum = 0;
        while (days > 0) {
            sum += steps * steps;
            days -= steps;
            steps++;
        }
        System.out.println(sum + days * (steps - 1));
    }
}
