package com.demo.day11;

import java.util.Scanner;

/**
 * author: nitaotao
 * date: 2021/12/16 0:08
 * version: 1.0
 * description: todo
 */
public class Main05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        String subString = scanner.next();
//        String str = "CDAA";
//        String subString = "AABCD";

        //把较短的串作为子串
        if (subString.length() > str.length()) {
            String temp = subString;
            subString = str;
            str = temp;
        }

        String foot;
        String head;
        boolean isSub = false;
        for (int i = 0; i < str.length(); i++) {
            foot = str.substring(1);
            head = str.substring(0, 1);
            str = foot + head;
//            System.out.println("str:"+str+"-------"+"substr:"+subString);
            if (str.contains(subString)) {
                isSub = true;
                break;
            }
        }
        if (isSub) {
            System.out.print(true);
        } else {
            System.out.print(false);
        }
    }
}
