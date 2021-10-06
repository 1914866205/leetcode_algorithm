package com.demo.day01;

import java.util.Arrays;

public class Second_Max {
    public static int max;
    public static int secondMax;
    public static void main(String[] args) {
        int[] arr = new int[]{
                1, 9, 5, 3, 7, 2, 6, 2
        };
        max = arr[0];
        secondMax = arr[0];
        Arrays.stream(arr).forEach(num -> max = (max > num ? max : num));
        System.out.println("最大值为：" + max);
        int[] arr_no_max = Arrays.stream(arr).filter(num -> num != max).toArray();
        Arrays.stream(arr_no_max).forEach(num -> secondMax = (secondMax > num ? secondMax : num));
        System.out.println("第二大值为：" + secondMax);

    }
}
