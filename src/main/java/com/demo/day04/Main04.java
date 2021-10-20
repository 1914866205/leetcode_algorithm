package com.demo.day04;


import java.util.Arrays;
import java.util.Scanner;

public class Main04 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int i = 0;
        int min = input.nextInt();
        int max = min;
        while (i < n - 1) {
            int j = input.nextInt();
            if (j > max) {
                max = j;
            }
            if (j < min) {
                min = j;
            }
            i++;
        }
        System.out.println(max - min);
    }
}

//        Scanner scanner = new Scanner(System.in);
//        int num = scanner.nextInt();
//        int a;
//        int[] arr = new int[num];
//        for (int i = 0; i < num; i++) {
//            a = scanner.nextInt();
//            arr[i] = a;
//        }
//        Arrays.sort(arr);
//        System.out.println(arr[num - 1] - arr[0]);
//
//
//    }
//            }
