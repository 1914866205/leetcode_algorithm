package com.study.algorithm;

/**
 * @author 倪涛涛
 * @version 1.0.0
 * @ClassName Day03_MergeSort.java
 * @Description TODO
 * @createTime 2021年08月22日 13:47:00
 */
public class Day03_MergeSort {
    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process(arr, 0, arr.length - 1);
    }

    private static void process(int[] arr, int L, int R) {
        if (L == R) {
            return;
        }
        int mid = L + ((L + R) >> 1);
        process(arr, 0, mid);
        process(arr, mid + 1, R);
        merge(arr, L, mid, R);
    }

    private static void merge(int[] arr, int L, int M, int R) {
        int[] help = new int[R - L + 1];
        int i = 0;
        int p1 = L;
        int p2 = M + 1;
        /** L   p1    M    p2   R
         *  |   1238   |  2367  |
         */

        //如果p1、p2都没越界，谁小谁被加入新的数组，加入之后指针向后移一位
        while (p1 <= M && p2 <= R) {
            help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }

        /**
         * 下面两个while只会有一个执行
         */

        //如果最后是p1没越界，p2越界了，则p1剩下的所有数据按顺序依次继续添加到新数组
        while (p1 <= M) {
            help[i++] = arr[p1++];
        }
        //如果最后是p2没越界，p1越界了，则p2剩下的所有数据按顺序依次继续添加到新数组
        while (p2 <= R) {
            arr[L + i] = help[i];
        }


        //最后数据重新拷贝              排序后就可以直接通过下标计算个数了
        for (i = 0; i < help.length; i++) {
            arr[L + i] = help[i];
        }
    }
}
