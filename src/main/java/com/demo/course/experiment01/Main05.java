package com.demo.course.experiment01;

import java.util.Scanner;

/**
 * author: nitaotao
 * date: 2021/12/27 0:28
 * version: 1.0
 * description: http://acm.zzuli.edu.cn/problem.php?id=1071
 */
public class Main05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        Main05 main05 = new Main05();
        main05.decompositionqualityFactor(num);
    }

    /**
     * 分解质因子
     * @param num
     */
    public void decompositionqualityFactor(int num) {
        for (int i = 2; i <=num; i++) {
            if (num % i == 0) {
                System.out.print(i + " ");
                num = num / i;
                decompositionqualityFactor(num);
                break;
            }
        }
    }
}
