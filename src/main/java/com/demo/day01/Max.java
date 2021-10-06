package com.demo.day01;
import java.util.Arrays;
public class Max {
    public static int max;
    public static void main(String[] args) {
        int[] arr = new int[]{
                1, 9, 5, 3, 7, 2, 6, 2
        };
        max = arr[0];
        Arrays.stream(arr).forEach(num -> max = (max > num ? max : num));
        System.out.println("最大值为：" + max);
    }
}