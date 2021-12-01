package com.demo.day08;

import java.util.Scanner;

/**
 * author: nitaotao
 * date: 2021/11/18 10:52
 * version: 1.0
 * description: http://noi.openjudge.cn/ch0106/07
 */
public class Main04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if (n == 1) {
            System.out.print("Jolly");
        } else {
            int[] arr = new int[n];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = scanner.nextInt();
            }
            int[] absArr = new int[n - 1];
//        int[] arr = {1, 4, 2, 3};
//        int[] absArr = new int[3];
            for (int i = 0; i < arr.length - 1; i++) {
                //取绝对值
                absArr[i] = (arr[i + 1] - arr[i] > 0) ? (arr[i + 1] - arr[i]) : (arr[i] - arr[i + 1]);
            }

            //升序排序
            for (int i = 0; i < absArr.length; i++) {
                for (int j = i; j < absArr.length; j++) {
                    //如果后一个比前一个小，交换位置
                    if (absArr[i] > absArr[j]) {
                        int temp = absArr[i];
                        absArr[i] = absArr[j];
                        absArr[j] = temp;
                    }
                }
            }
//        Arrays.stream(absArr).forEach(System.out::println);
            //有趣的跳跃判断
            boolean flag = true;
            //比较数
            int num = absArr[0];
            for (int i = 0; i < absArr.length; i++) {
                if (absArr[i] != num) {
                    flag = false;
                    break;
                }
                num++;
            }
            if (flag) {
                System.out.print("Jolly");
            } else {
                System.out.print("Not jolly");
            }
        }

    }
}
