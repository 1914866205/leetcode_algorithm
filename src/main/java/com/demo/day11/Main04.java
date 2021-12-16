package com.demo.day11;

import java.nio.charset.Charset;
import java.util.Scanner;

/**
 * author: nitaotao
 * date: 2021/12/15 23:02
 * version: 1.0
 * description: todo
 */
public class Main04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
//        String str = "ABxy ";
        // A65  a97
        byte[] bytes = str.getBytes();
        for (int i = 0; i < bytes.length; i++) {
            //是小写
            if (bytes[i] > 96) {
                String subString = str.substring(i, i + 1);
                //小写变大写
                subString = subString.toUpperCase();
                str = str.substring(0, i) + subString + str.substring(i + 1);
            } else {
                //是大写
                String subString = str.substring(i, i + 1);
                //大写变小写
                subString = subString.toLowerCase();
                str = str.substring(0, i) + subString + str.substring(i + 1);
            }
        }
//        System.out.println(str);
        //反转
//         str = "dcba";

        String[] split = str.split("");
        str = "";
        for (int i = split.length - 1; i > -1; i--) {
            str += split[i];
        }
//        System.out.println(str);
        byte[] move = str.getBytes();
        //   A 65  Z90  a97 z122
//        str = "abz";
//        byte[] move = str.getBytes();

        str = "";
        //大写在大写里循环，小写在小写里循环
        for (int i = 0; i < move.length; i++) {
            if (move[i] > 119) {
                move[i] = (byte) (97 - (120 - move[i]));
            } else if (move[i] > 87 && move[i] < 95) {
                move[i] = (byte) (65 - (88 - move[i]));
            } else {
                move[i] += 3;
            }
        }
        str = new String(move, Charset.forName("UTF-8"));
        System.out.println(str);
    }
}
