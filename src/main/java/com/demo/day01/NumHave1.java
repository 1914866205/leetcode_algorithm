package com.demo.day01;
public class NumHave1 {
    public static void main(String[] args) {
        int num = 12;
        int count = 0;
        for (int i = 1; i <= num; i++) {
            // indexOf 大串不包括小串，返回-1，否则返回索引处
            if (String.valueOf(i).indexOf("1") != -1) {
                count++;
            }
        }
        System.out.println("包含1的个数为："+count);
    }
}
