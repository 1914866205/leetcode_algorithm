package com.study.algorithm;

import java.util.Arrays;

/**
 * @author 倪涛涛
 * @version 1.0.0
 * @ClassName Day04_QuickSort.java
 * @Description TODO
 * @createTime 2021年08月28日 12:03:00
 */
public class Day04_QuickSort {
    public static void quickSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        quickSort(arr, 0, arr.length - 1);
    }

    // arr[1...r]排好序
    public static void quickSort(int[] arr, int L, int R) {
        if (L < R) {
            //等概率随机选一个位置，把它和最右侧的数据交换
            swap(arr, L + (int) (Math.random() * (R - L + 1)), R);
            // 在 L ---- R 范围上，以及选出的最后的那个数，做partition
            int[] p = partition(arr, L, R);
            quickSort(arr, L, p[0] - 1);//   <区
            quickSort(arr, p[1] + 1, R);//   >区
        }
    }

    /**
     * 这是一个处理arr[1...r]的函数
     * 默认以arr[r]做划分，arr[r] -> p     <p   ==p  >p
     * 返回等于区域（左边界，有边界），所以返回一个长度为2的数组res,res[0] res[1]
     */

    public static int[] partition(int[] arr, int L, int R) {
        int less = L - 1;//  <区右边界
        int more = R;  //  >区左边界
        while (L < more) { //L 表示当前数的位置 arr[R]  -> 划分值
            if (arr[L] < arr[R]) {
                //当前数 < 划分值
                swap(arr, ++less, L++);
            } else if (arr[L] > arr[R]) {
                // 当前数 > 划分值
                swap(arr, --more, L);
            } else {
                L++;
            }
        }
        swap(arr, more, R);
        return new int[]{less + 1, more};
    }

    public static void swap(int[] arr, int m, int n) {
        int temp = arr[n];
        arr[n] = arr[m];
        arr[m] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 5, 7, 2, 4};
        swap(arr, 2, 3);
        Arrays.stream(arr).forEach(System.out::print);
    }
}
