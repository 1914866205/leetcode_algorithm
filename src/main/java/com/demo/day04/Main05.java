package com.demo.day04;


import java.util.Arrays;
import java.util.Scanner;

public class Main05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int a;
        int b;
        int c;
        int[] arr = new int[3];
        for (int i = 0; i < num; i++) {
            a = scanner.nextInt();
            b = scanner.nextInt();
            c = scanner.nextInt();
            arr[0] += a;
            arr[1] += b;
            arr[2] += c;
        }
        System.out.println(arr[0] + " " + arr[1] + " " + arr[2] + " " + (Arrays.stream(arr).sum()));
    }
}
