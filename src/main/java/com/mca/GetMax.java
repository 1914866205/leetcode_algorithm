package com.mca;

/**
 * @ClassName GetMax
 * @Descriotion TODO
 * @Author nitaotao
 * @Date 2022/9/20 23:28
 * @Version 1.0
 * 递归实现最大值查找
 **/
public class GetMax {

    public static void main(String[] args) {
        int[] arr = {1, 5, 9, 3, 5, 4, 8, 8, 100};
        System.out.println(getMax(arr, 0, arr.length - 1));
    }

    public static int getMax(int[] arr, int start, int end) {
        if (start == end) {
            return arr[start];
        }
        int mid = start + (end - start) / 2;
        int left = getMax(arr, start, mid);
        int right = getMax(arr, mid + 1, end);
        return Math.max(left, right);
    }
}
