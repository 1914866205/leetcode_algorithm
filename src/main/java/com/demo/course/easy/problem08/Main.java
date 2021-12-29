package com.demo.course.easy.problem08;


/**
 * author: nitaotao
 * date: 2021/12/20 23:29
 * version: 1.0
 * description:  http://noi.openjudge.cn/ch0106/0
 * 向量点积运算
 * 根据点积的运算法则，各对应位置相乘再相加
 */
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];
        for (int i = 0; i < n; i++) {
            arr1[i] = scanner.nextInt();
        }

        for (int i = 0; i < n; i++) {
            arr2[i] = scanner.nextInt();
        }
        Main main = new Main();
        System.out.println(main.count(arr1, arr2));
    }

    /**
     * count方法：计算向量的点积
     * @param arr1 向量1
     * @param arr2 向量2
     * @return 返回int类型
     */
    public int count(int[] arr1, int[] arr2) {
        int count = 0;
        // 点积公式：  [a,b]=a1*b1 + a2*b2 +....+ an*bn
        for (int i = 0; i <arr1.length ; i++) {
            count += arr1[i] * arr2[i];
        }
        return count;
    }
}
