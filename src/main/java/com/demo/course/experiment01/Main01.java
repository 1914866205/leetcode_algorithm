package com.demo.course.experiment01;

import java.util.Scanner;

/**
 * author: nitaotao
 * date: 2021/12/26 23:32
 * version: 1.0
 * description: http://acm.zzuli.edu.cn/problem.php?id=1007
 */
public class Main01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int heads = scanner.nextInt();  //头个数
        int feet = scanner.nextInt();  //脚个数
        Main01 main01 = new Main01();
        main01.num(heads, feet);
    }

    public void num(int heads, int feet) {
        // 12=x+y
        //40=2x+4y   20=x+2y
        // x=12-y=20-2y
        // y=20-12=8
        //兔子=feet/2-heads
        int y = feet / 2 - heads;
        int x = heads - y;
        System.out.println(x+" "+y);
    }
}
