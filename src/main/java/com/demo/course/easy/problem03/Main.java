package com.demo.course.easy.problem03;


/**
 * author: nitaotao
 * date: 2021/12/20 13:06
 * version: 1.0
 * description: http://noi.openjudge.cn/ch0104/16
 */

import java.util.Scanner;

public class Main {
    /*以下为main方法*/
    public static void main(String[] args) {
        Main main = new Main();
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int z = scanner.nextInt();
        if (main.isTriAngle(x, y, z)) {
            System.out.print("yes");
        } else {
            System.out.print("no");
        }
        System.out.print(main.isTriAngle(x, y, z) ? "yes" : "no");

    }

    /**
     * isTriAngle方法：判断是不是三角形
     * @param x x边
     * @param y y边
     * @param z z边
     * @return boolean类型
     */
    public boolean isTriAngle(int x, int y, int z) {
        //三角形的性质：两边之和大于第三边
        return x + y > z && y + z > x && z + x > y;
    }
}

