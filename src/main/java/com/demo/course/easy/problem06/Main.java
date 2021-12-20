package com.demo.course.easy.problem06;


/**
 * author: nitaotao
 * date: 2021/12/20 21:26
 * version: 1.0
 * description: http://noi.openjudge.cn/ch0105/42
 */
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int high = scanner.nextInt();
        int width = scanner.nextInt();
        String paint = scanner.next();
        int isCir = scanner.nextInt();
        Main main = new Main();
        main.paint(high,width,paint,isCir);
    }

    /**
     * paint方法 画矩形
     * @param high 高
     * @param width 宽
     * @param paint 图案
     * @param isCir 1代表实心，0代表空心
     */
    public void paint(int high, int width, String paint, int isCir) {
        if (isCir == 1) { //如果是实心
            for (int i = 0; i < high; i++) {
                for (int j = 0; j < width; j++) {
                    System.out.print(paint); //每行都是不换行的字符
                }
                System.out.println();//每行结束后换行
            }
        } else {
            //如果是空心
            for (int i = 0; i < high; i++) {
                for (int j = 0; j < width; j++) {
                    //如果是第一行或者最后一行
                    if (i == 0 || i == high - 1) {
                        //如果是最后一列
                        if (j == width - 1) {
                            //就输出字符+换行
                            System.out.println(paint);
                        } else {
                            //否则就是不换行字符
                            System.out.print(paint);
                        }
                    } else { //如果不是第一行或最后一行
                        if (j == 0) {
                            //第一列打印不换行字符
                            System.out.print(paint);
                        } else if (j == width - 1) {
                            //最后一列打印换行字符
                            System.out.println(paint);
                        } else {
                            //否则打印空格
                            System.out.print(" ");
                        }
                    }
                }
            }
        }
    }
}
