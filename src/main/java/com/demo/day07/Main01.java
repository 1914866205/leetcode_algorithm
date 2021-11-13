package com.demo.day07;

import java.util.Scanner;

/**
 * author: nitaotao
 * date: 2021/11/10 14:08
 * version: 1.0
 * description: http://noi.openjudge.cn/ch0106/01/
 * 输出一个整数序列中与指定数字相同的数的个数。
 */
public class Main01 {
    public static void main(String[] args) {
        int N; //表示整数序列的长度(N <= 100)；
        int[] arr; //记录存放的数字
        int num; //需要匹配的数
        int count = 0; //记录匹配到的次数
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = scanner.nextInt();
        }
        num = scanner.nextInt();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == num) {
                count++;
            }
        }
        System.out.print(count);
    }
}
