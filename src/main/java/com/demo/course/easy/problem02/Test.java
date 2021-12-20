package com.demo.course.easy.problem02;


/**
 * author: nitaotao
 * date: 2021/12/20 12:36
 * version: 1.0
 * description: 两数比较II
 * 从键盘输入两个不同的正整数x和y。
 * 如果x大于y，输出x是y的多少整数倍；
 * 如果x小于y，输出至少几个x相乘后可以不小于y；
 * 如果x等于y，输出x个位上的数字。
 * 题目保证所有运算不会超过int数据类型范围。
 */
import java.util.Scanner;
public class Test {
    /* 以下为main方法 */
    public static void main(String[] args) {
        Test test = new Test();  //test负责调用方法
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt(); //输入参数x的实际值
        int y = scanner.nextInt(); //输入参数y的实际值
        System.out.print(test.compare(x, y));
    }

    /**
     * compare方法: 判断参数x和参数y的大小，进行相应的处理
     * @param x 待判断的整数x
     * @param y 待判断的整数y
     * @return 返回int类型
     */
    public int compare(int x, int y) {
        int count = 1; //计数器，用来计算当x<y时，几个x相乘不小于y
        if (x == y) {
            while (x / 10 != 0) { //获取x的个位数
                x = x % 10;
            }
            return x;
        } else if (x > y) { //获取x是y的几倍
            return x / y;
        } else {
            while (x < y) { //判断当多少个x相乘不小于y
                x *= x;
                count++;
            }
            return count; //返回x的数量
        }
    }
}
