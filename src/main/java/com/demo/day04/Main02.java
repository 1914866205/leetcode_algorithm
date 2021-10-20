package com.demo.day04;

import java.util.Scanner;

public class Main02 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int i = 0;
        int s = 0;
        double ave;
        while (i < n) {
            int j = input.nextInt();
            if (Math.abs(j) < 10000) {
                s = s + j;
            }
            i++;
        }
        ave = 1.0 * s / n;
        System.out.printf(s + " " + "%.5f", ave);
    }
}

//        Scanner scanner = new Scanner(System.in);
//        int num = scanner.nextInt();
//        int sum = 0;
//        double a;
//        for (int i = 0; i < num; i++) {
//            a = scanner.nextDouble();
//            sum += a;
//        }
//        System.out.print(sum+" ");
//        System.out.printf("%.5f", 1.0*sum / num);
