package com.demo.day11;

/**
 * author: nitaotao
 * date: 2021/12/15 22:24
 * version: 1.0
 * description: todo
 */

import java.util.Scanner;

public class Main002 {
    public static void main(String[] args) {
//        Scanner input = new Scanner(System.in);
//        String str = input.nextLine();
        String str = "abbada";
        boolean flag = true;
        for (int i = 0; i < str.length(); i++) {
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(i) == str.charAt(j)) {
                    if(i!=j){
                        flag = false;
                        break;
                    }
                }
            }
            if (flag) {
                System.out.println(str.charAt(i));
                break;
            }
            flag = true;
        }
    }
}