package com.demo.day11;

import java.util.Scanner;

/**
 * author: nitaotao
 * date: 2021/12/15 19:35
 * version: 1.0
 * description: http://noi.openjudge.cn/ch0107/03
 */
public class Main03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double num = scanner.nextDouble();
        String str = scanner.nextLine();
        String str1 = scanner.nextLine();
        String str2 = scanner.nextLine();
        String[] arr1 = str1.split("");
        String[] arr2 = str2.split("");
        double count = 0;
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i].equals(arr2[i])) {
                count++;
            }
        }
        double finalNum = count/(arr2.length*1.0);
        if (finalNum < num) {
            System.out.print("no");
        } else {
            System.out.print("yes");
        }
    }
}

