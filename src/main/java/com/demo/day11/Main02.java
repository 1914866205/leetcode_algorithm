package com.demo.day11;

import java.util.Scanner;

/**
 * author: nitaotao
 * date: 2021/12/15 18:13
 * version: 1.0
 * description: http://noi.openjudge.cn/ch0107/02/
 * 找第一个只出现一次的字符
 */
public class Main02 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        //源字符串
        String str = scanner.nextLine();
//        String str = "abbada";
        String[] split = str.split("");
        //发现标志
        boolean find = false;
        for (int i = 0; i < split.length; i++) {
            //如果没有发现
            if (!find) {
                for (int j = 0; j < split.length; j++) {
                    //如果找到一样的，就换下一个
                    if (split[i].equals(split[j])&&i!=j) {
                        break;
                    }

                    if (j == split.length - 1) {
                        find = true;
                        System.out.print(split[i]);
                    }
                }
            }
        }
        if (!find) {
            System.out.print("no");
        }
    }
}