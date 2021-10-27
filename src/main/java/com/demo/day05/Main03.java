package com.demo.day05;

import java.util.Scanner;

/**
 * author: nitaotao
 * date: 2021/10/27 14:15
 * version: 1.0
 * description: todo
 * http://noi.openjudge.cn/ch0105/39/
 */
public class Main03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = 0;
        for (int i = 1; i <=n ; i++) {
            if (i % 7 == 0 || String.valueOf(i).contains("7")) {
                continue;
            }
            sum += i * i;
        }
        System.out.print(sum);
    }
}
