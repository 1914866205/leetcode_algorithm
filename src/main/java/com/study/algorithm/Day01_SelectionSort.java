package com.study.algorithm;

import java.util.Arrays;
import java.util.List;

/**
 * @author 倪涛涛
 * @version 1.0.0
 * @ClassName Day01_SelectionSort.java
 * @Description 简单排序
 * @createTime 2021年08月14日 17:10:00
 */
public class Day01_SelectionSort {
    public static void selectionSort(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }
        for (int i = 0; i < array.length-1; i++) { //i~N-1
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                //如果后面的数比前面的数小，就把后面的索引换成最小的索引，否则不变
                minIndex = array[j] < array[minIndex] ? j : minIndex;
                }
            //交换索引处的数
            int temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 6, 9, 8, 5, 2, 7};
        selectionSort(arr);
        Arrays.stream(arr).forEach(System.out::print);
    }
}
