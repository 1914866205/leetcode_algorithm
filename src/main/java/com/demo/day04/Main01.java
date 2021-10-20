package com.demo.day04;

import java.util.Scanner;

public class Main01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        double sum = 0;
        double a;
        for (int i = 0; i < num; i++) {
            a = scanner.nextDouble();
            sum += a;
        }
        System.out.printf("%.4f", sum / num);
    }
}
