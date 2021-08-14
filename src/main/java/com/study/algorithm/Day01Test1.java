package com.study.algorithm;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * @author 倪涛涛
 * @version 1.0.0
 * @ClassName Day01Test1.java
 * @Description TODO
 * @createTime 2021年08月14日 16:57:00
 */
public class Day01Test1 {
    public static void process1(){
        int N=1000;
        int a = 0;
        for (int i = 0; i < N; i++) {
            a = 2 + 5;
            a = 4 * 7;
            a = 6 + 8;
                    
        }
    }
    public static void process2() {
        int N = 1000;
        int a = 0;
        for (int i = 0; i < N; i++) {
            a = 3 | 6;   //或  有1则1
            a = 3 & 4;   //且   有0则0
            a = 4 ^ 7;   //疑惑 同0异1
        }
        System.out.println(3 | 6);
        System.out.println(3 & 4);
        System.out.println(4^2);
    }

    public static void main(String[] args) {
        System.out.println(LocalDateTime.now());
        process1();
        System.out.println(LocalDateTime.now());
        process2();
        System.out.println(LocalDateTime.now());
    }
}
