package com.demo.day08;

import java.util.Arrays;
import java.util.Scanner;

/**
 * author: nitaotao
 * date: 2021/11/18 10:35
 * version: 1.0
 * description: http://noi.openjudge.cn/ch0110/06/
 */
public class Main03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //所有数
        int[] all = new int[10];
        //前期作为静态初始化的容量，后期作为指针下标
        int single = 0;
        int dou = 0;
        for (int i = 0; i < all.length; i++) {
            all[i] = scanner.nextInt();
            if (all[i] % 2 == 0) {
                dou++;
            } else {
                single++;
            }
        }
        int[] singleArr = new int[single];
        int[] douArr = new int[dou];
        //作为指针下标
        single = 0;
        dou = 0;
        for (int i = 0; i < all.length; i++) {
            if (all[i] % 2 == 0) {
                douArr[dou] = all[i];
                dou++;
            } else {
                singleArr[single] = all[i];
                single++;
            }
        }
        //降序排序
        for (int i = 0; i < singleArr.length; i++) {
            for (int j = i; j < singleArr.length; j++) {
                //如果后一个比前一个大，交换位置
                if (singleArr[i] < singleArr[j]) {
                    int temp = singleArr[i];
                    singleArr[i] = singleArr[j];
                    singleArr[j] = temp;
                }
            }
        }

        //升序排序
        for (int i = 0; i < douArr.length; i++) {
            for (int j = i; j < douArr.length; j++) {
                //如果后一个比前一个小，交换位置
                if (douArr[i] > douArr[j]) {
                    int temp = douArr[i];
                    douArr[i] = douArr[j];
                    douArr[j] = temp;
                }
            }
        }
        Arrays.stream(singleArr).forEach(item -> {
            System.out.print(item + " ");
        });
        Arrays.stream(douArr).forEach(item -> {
            System.out.print(item + " ");
        });
    }
}
