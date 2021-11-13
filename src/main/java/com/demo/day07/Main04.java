package com.demo.day07;

import java.util.Scanner;

/**
 * author: nitaotao
 * date: 2021/11/10 14:57
 * version: 1.0
 * description:  http://noi.openjudge.cn/ch0106/06/
 */
public class Main04 {

    public static void main(String[] args) {
        int L; //马路的长度  L+1为树的数目
        int M; //区域的数目
        int[][] area; //区域位置
        int[] arrTree; //树的位置
        Scanner scanner = new Scanner(System.in);
        L = scanner.nextInt();
        M = scanner.nextInt();
        arrTree = new int[L+1];
        area = new int[M][2];
        for (int i = 0; i < M; i++) {
            area[i][0] = scanner.nextInt(); //区域起始位置
            area[i][1] = scanner.nextInt(); //区域终止位置
        }

        for (int i = 0; i < area.length; i++) {
            for (int j = 0; j < area[i].length; j++) {
                for (int k = area[i][0]; k <= area[i][1]; k++) {
                    arrTree[k] = 1;
                }
            }
        }

        for (int i = 0; i < area.length; i++) {
            for (int j = 0; j < area[i].length; j++) {
                for (int k = area[i][0]; k <= area[i][1]; k++) {
                    if (arrTree[k] == 1) {
                        L--;
                    }
                    arrTree[k] = 0;
                }
            }
        }
        L = L + 1;
        System.out.println(L);
    }
}
