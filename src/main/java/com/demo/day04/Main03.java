package com.demo.day04;
import java.util.Arrays;
import java.util.Scanner;
public class Main03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int a;
        int[] arr = new int[num];
        for (int i = 0; i < num; i++) {
            a = scanner.nextInt();
            arr[i] = a;
        }
        Arrays.sort(arr);
        System.out.println(arr[num-1]);
    }
}
