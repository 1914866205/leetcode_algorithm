package com.study.algorithm;

/**
 * @author 倪涛涛
 * @version 1.0.0
 * @ClassName Day04_SmallSum.java
 * @Description 小和
 * @createTime 2021年08月28日 10:09:00
 */
public class Day04_SmallSum {
    public static int smallSun(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        return process(arr, 0, arr.length - 1);
    }

    // arr[L...R]既要排好序，也要求小和
    public static int process(int[] arr, int l, int r) {
        if (l == r) {
            return 0;
        }
        int mid = l + ((r - 1) >> 1);
        return process(arr, l, mid)  //左侧排序小和的数量
                + process(arr, mid + 1, r) //右侧排序小和的数量
                + merge(arr, l, mid, r); //排序后合并小和的数量
    }

    private static int merge(int[] arr, int l, int m, int r) {
        int[] help = new int[r - l + 1];
        int i = 0;  // i是辅助数组的下标
        int p1 = l;
        int p2 = m + 1;
        int res = 0;
        while (p1 <= m && p2 <= r) {
            // res+= 右边比p2位置的数大的数的数量 * p1位置的数
            // 如果左组的数不比右组的数小，小和增加的数量就是0
            res += arr[p1] < arr[p2] ? (r - p2 + 1) * arr[p1] : 0;
            // 必须左组比右组小，如果右组大于等于左组，就先拷贝右组
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }

        while (p1 <= m) {
            help[i++] = arr[p1++];
        }

        while (p2 <= r) {
            help[i++] = arr[p2++];
        }

        // 把数组重新赋值为有序数组
        for (i = 0; i < help.length; i++) {
            arr[l + i] = help[i];
        }
        return res;


    }

}
