package com.demo.day07;

import java.util.Scanner;

/**
 * author: nitaotao
 * date: 2021/11/10 14:42
 * version: 1.0
 * description:  http://noi.openjudge.cn/ch0106/04/
 */
public class Main03 {
    public static void main(String[] args) {
        int N;
        int[] arr;
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = scanner.nextInt();
        }
        for (int i = 0; i * 2 < N; i++) {
            int temp = arr[i];
            arr[i] = arr[N - i - 1];
            arr[N - i - 1] = temp;
        }
        for (int i = 0; i < N-1; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.print(arr[N-1]);
    }
}
