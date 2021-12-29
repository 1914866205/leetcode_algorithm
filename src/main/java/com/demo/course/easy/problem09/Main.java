package com.demo.course.easy.problem09;


/**
 * author: nitaotao
 * date: 2021/12/20 23:41
 * version: 1.0
 * 数字之和
 * description: http://noi.openjudge.cn/ch0109/07/
 * 【解题思路】：先找到数组中的最大数，再计算时，排除它
 */
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();//数的个数
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        Main main = new Main();
        System.out.print(main.getSumNoMax(arr));
    }

    /**
     * getSumNoMax方法：得到除了最大数，其余数的和
     * @param arr 被计数的数组
     * @return int类型
     */
    public int getSumNoMax(int[] arr) {
        int count = 0;
        int max = arr[0];
        //先找到最大数
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        //计算时排除
        for (int i = 0; i <arr.length ; i++) {
            if (arr[i] != max) {
                count += arr[i];
            }
        }
        return count;
    }
}
