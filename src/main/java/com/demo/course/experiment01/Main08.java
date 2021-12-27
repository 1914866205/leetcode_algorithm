package com.demo.course.experiment01;


import java.util.*;

/**
 * author: nitaotao
 * date: 2021/12/27 2:26
 * version: 1.0
 * description: http://noi.openjudge.cn/ch0106/13/
 */
public class Main08 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String c = sc.next();
        Main08 main = new Main08();
        main.factor(c);
    }

    /**
     * 顺序输出因子
     *
     * @param c
     */
    public void factor(String c) {
        //最大位数
        int[] a = new int[30];
        String[] str = c.split("");
        //每一位转成数字
        for(int i=0;i<str.length;i++) {
            a[a.length-i-1] = Integer.parseInt(str[str.length-1-i]);
        }
        int t;
        int m = 0;
        for(int i=2;i<=9;i++) {
            t = 0;
            for(int j=0;j<a.length;j++) {
                if (a[j] + t >= i) {
                    t = ((a[j] + t) % i) * 10;
                } else {
                    t = a[j] * 10;
                }
            }
            if(t==0) {
                System.out.print(i+" ");
                m = 1;
            }
        }
        if (m == 0) {
            System.out.println("none");
        }
    }
}
