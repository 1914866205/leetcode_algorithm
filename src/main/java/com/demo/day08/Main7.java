package com.demo.day08;

/**
 * author: nitaotao
 * date: 2021/11/20 13:05
 * version: 1.0
 * description: todo
 */

import java.util.Scanner;

public class Main7 {
    public static void main(String[] strgs) {
        Scanner input = new Scanner(System.in);
        int a[] = new int[501];
        int n = input.nextInt();
        int t1;
        int t2;
        for (int i = 0; i < n; i++) {
            a[i] = input.nextInt();
        }
        for (int j = 0; j < n - 1; j++) {
            for (int k = j + 1; k < n; k++) {
                if (a[k] < a[j]) {
                    t1 = a[k];
                    a[k] = a[j];
                    a[j] = t1;
                }
            }
        }
        for (int m = 0; m < n; m++) {
            if (a[m] % 2 != 0) {
                //System.out.println(a[m]);
                t2 = m;
                break;
            }
        }
        for (int h = 0; h < n-1; h++) {
            System.out.print(a[h] + ",");
        }
            System.out.print(a[n-1]);
    }

}