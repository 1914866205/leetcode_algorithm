package com.study.algorithm;

import java.util.Arrays;

/**
 * @author 倪涛涛
 * @version 1.0.0
 * @ClassName Day02_InsertSort.java
 * @Description TODO
 * @createTime 2021年08月16日 15:16:00
 */
public class Day02_InsertSort {
    public static void insertSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i; j >= 1; j--) {
                if (array[j-1] > array[j]) {
                    int temp = array[j-1];
                    array[j-1] = array[j];
                    array[j] = temp;
                }
            }
            Arrays.stream(array).forEach(System.out::print);
            System.out.println("----第"+(i+1)+"轮---");
        }
    }

    public static void main(String[] args) {
        int[]1r1 array = new int[]{2, 1, 3, 5, 1};
        insertSort(array);
    }
}
