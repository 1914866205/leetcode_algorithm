package com.demo.day06;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * author: nitaotao
 * date: 2021/11/3 11:42
 * version: 1.0
 * description: http://noi.openjudge.cn/ch0105/29/
 */
public class Main01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        if (num == 0) {
            System.out.print(0);
        } else {

            boolean flag = false;
            if (num < 0) {
                flag = true;
                num *= -1;
            }
            int a = num / 10; //除了个位数
            int b = num % 10; //个位数
            //处理  b 不能是 第一个 0
            boolean flag_0 = true;
            if (b == 0) {
                flag_0 = false;
            }
            ArrayList list = new ArrayList();
            while (a != 0) {
                if (flag_0) {
                    list.add(b);
                }
                b = a % 10;
                if (b != 0) {
                    //仅变一次
                    flag_0 = true;
                }
                a = a / 10;
            }
            list.add(b);

            // 对符号处理
            if (flag) {
                list.add(0, "-");
            }
            list.forEach(System.out::print);
        }
    }
}
