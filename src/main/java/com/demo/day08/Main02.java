package com.demo.day08;

import java.util.Arrays;
import java.util.Scanner;

/**
 * author: nitaotao
 * date: 2021/11/18 10:11
 * version: 1.0
 * description: http://noi.openjudge.cn/ch0110/02
 */
public class Main02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = scanner.nextInt();
        }
//        int[] arr = {6, 8, 3, 4, 3, 9, 8};
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minIndex] > arr[j]) {
                    //如果这个数比最小值小，那么它就是最小值
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
//        Arrays.stream(arr).forEach(System.out::println);
        String result = "";
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 != 0) {
                result += arr[i] + ",";
            }
        }
        System.out.println(result.substring(0, result.length() - 1));
    }
}
