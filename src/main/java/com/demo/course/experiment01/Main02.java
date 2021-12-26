package com.demo.course.experiment01;

import java.util.Scanner;

/**
 * author: nitaotao
 * date: 2021/12/26 23:47
 * version: 1.0
 * description: http://acm.zzuli.edu.cn/problem.php?id=1056
 */
public class Main02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        Main02 main02 = new Main02();
        main02.bestLucky(m, n);
    }

    public void bestLucky(int m, int n) {
        int maxLuck = 0;
        for (int i = m; i <= n; i++) {
            if (i % 4 == 0) {
                continue;
            } else if (i % 7 == 0) {
                if (i > maxLuck) {
                    maxLuck = i;
                }
            }
        }
        if (maxLuck == 0) {
            System.out.print("no");
        } else {
            System.out.print(maxLuck);
        }
    }
}
