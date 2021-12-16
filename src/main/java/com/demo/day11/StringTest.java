package com.demo.day11;

import java.util.Scanner;

/**
 * author: nitaotao
 * date: 2021/12/15 17:39
 * version: 1.0
 * description: todo
 */
public class StringTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //输入总字符串
        String str = scanner.nextLine();
        //输入子串
        String subString = scanner.nextLine();
//                //输入总字符串
//        String subString ="ab";
//        //输入子串
//        String str = "abaabab";
        System.out.println(count(str,subString));
    }

    /**
     * 返回指定字符串在源字符串中出现的次数
     * @param source 源字符串
     * @param sub 指定字符串
     * @return
     */
    public static int count(String source, String sub) {
        int count = 0;
        for (int i = 0; i < source.length() - sub.length()+1; i++) {
            if (source.substring(i, i + sub.length()).equals(sub)) {
                count++;
            }
        }
        return count==0?-1:count;
    }

}
