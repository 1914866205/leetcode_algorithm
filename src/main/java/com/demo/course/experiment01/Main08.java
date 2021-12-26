package com.demo.course.experiment01;


import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * author: nitaotao
 * date: 2021/12/27 2:26
 * version: 1.0
 * description: http://noi.openjudge.cn/ch0106/13/
 */
public class Main08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        Main08 main08 = new Main08();
        main08.factor(str);
    }

    /**
     * 顺序输出因子
     *
     * @param c
     */
    public void factor(String c) {
        //自动排序
        TreeSet treeSet = new TreeSet();

        //大整数，一个个判断

    }
}
