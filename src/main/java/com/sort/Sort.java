package com.sort;

import java.util.Arrays;

/**
 * @ClassName Sort
 * @Descriotion 排序算法总结
 * @Author nitaotao
 * @Date 2022/9/16 16:08
 * @Version 1.0
 **/
public class Sort {
    public static void main(String[] args) {
        int[] arr = {1, 2, 5, 6, 3, 5};
        sSort(arr);
        Arrays.stream(arr).forEach(System.out::print);
    }

    /**
     * 交换数组 i 位置 和 j 位置的元素
     *
     * @param arr
     * @param i
     * @param j
     */
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
///////////////////////1. 选择排序 ///////////////////////////////

    /**
     * 选择排序：遍历当前数组，每次把 当前位置右边 最小（大）的放到当前位置。每次前面的先排好。
     * <p>
     * 分成两端，左侧是已经排序的，右侧是未排序的
     * 分界线是当前的 i
     * 每次选择 [i,arr.length-1]上最小的元素的坐标
     * 这个元素和 i 位置互换
     * 就能做到每次 i 位置都是右边最小的了
     *
     * @param arr
     */
    public static void selectionSort(int[] arr) {
        //这种情况不用排
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                //如果当前位比最小值还小，那么这个位置就是最小值
                minIndex = arr[minIndex] < arr[j] ? minIndex : j;
            }
            swap(arr, i, minIndex);
        }
    }
    ///////////////////////2. 冒泡排序 ///////////////////////////////

    /**
     * 冒泡排序：遍历当前数组，每次 把 当前位置 和 下一个位置 比较，如果比后一个位置大（小）则交换位置。
     * 比较完之后，当前的 arr[n-1]位置元素 比 前 n-2 个元素都大（小）
     *
     * @param arr
     */
    public static void sSort(int[] arr) {
        //这种情况不用排
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                //两两对比，大的后面去
                if (arr[i] > arr[j]) {
                    swap(arr, i, j);
                }
            }
        }
    }
}
