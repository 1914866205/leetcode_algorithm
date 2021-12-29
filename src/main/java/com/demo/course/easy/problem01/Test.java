package com.demo.course.easy.problem01;


/**
 * author: nitaotao
 * date: 2021/12/20 10:16
 * version: 1.0
 * description:  两数比较I
 * 从键盘输入两个不同的浮点数x和y。在第一行中，先输出较小的数，再输出较大的数，之间用一个逗号隔开；
 * 在第二行中，先输出较大的数，再输出较小的数，之间用一个空格隔开。
 * 要求通过两个程序，分别利用if…else决策语句和条件运算符? :完成题目。题目保证所有运算不会超过double数据类型范围。
 */

import java.util.Scanner;

public class Test {
    /* 以下为main方法 */
    public static void main(String[] args) {
        Test test = new Test(); //test负责调用方法
        Scanner scanner = new Scanner(System.in);
        double x = scanner.nextDouble(); //输入参数x的实际值
        double y = scanner.nextDouble(); //输入参数y的实际值
        System.out.println(test.compareByIf(x, y));
        System.out.print(test.compareByTh(x, y));
    }

    /**
     * compare方法: 判断参数x和参数y的大小,输出较大的数
     *
     * @param x 待判断的浮点数
     * @param y 待判断的浮点数
     * @return 返回String类型
     */
    public String compareByIf(double x, double y) {
        if (x < y) {
            return x + "," + y;
        } else {
            return y + "," + x;
        }
    }

    /**
     * compareByTh方法: 使用三目表达式，判断参数x和参数y的大小,输出较大的数
     *
     * @param x 待判断的浮点数
     * @param y 待判断的浮点数
     * @return 返回String类型
     */
    public String compareByTh(double x, double y) {
        return x > y ? x + " " + y : y + " " + x;
    }
}
