package com.demo.day04;


import java.util.Arrays;
import java.util.Scanner;

public class Main06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int sum = 0;
        for (; m <= n; m++) {
            if (m%17 == 0) {
                sum += m;
            }
        }
        System.out.println(sum);
    }
}
