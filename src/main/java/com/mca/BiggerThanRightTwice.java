package com.mca;

/**
 * @ClassName BiggerThanRightTwice
 * @Descriotion TODO
 * @Author nitaotao
 * @Date 2022/9/23 11:49
 * @Version 1.0
 **/
public class BiggerThanRightTwice {
    public static void main(String[] args) {

        int[] arr = {1, 4, 6, 8, 9, 1, 1, 2, 3, 3, 4};
        System.out.println(process(arr, 0, arr.length - 1));
    }

    public static int process(int[] arr, int left, int right) {
        if (left == right) {
            return 0;
        }
        int mid = left + ((right - left) >> 1);
        return process(arr, left, mid) + process(arr, mid + 1, right) + merge(arr, left, mid, right);
    }

    private static int merge(int[] arr, int left, int mid, int right) {
        int[] help = new int[right - left + 1];
        int helpIndex = 0;
        int leftIndex = left;
        int rightIndex = mid + 1;

        int result = 0;
        int windowsR = mid + 1;
        //左边在左组里后移
        for (int i = left; i <= mid; i++) {
            while (windowsR <= right && arr[i] > 2 * arr[windowsR]) {
                windowsR++;
            }
            result += windowsR - (mid + 1);
        }

        while (leftIndex <= mid && rightIndex <= right) {
            help[helpIndex++] = arr[leftIndex] <= arr[rightIndex] ? arr[leftIndex++] : arr[rightIndex++];
        }
        while (leftIndex <= mid) {
            help[helpIndex++] = arr[leftIndex++];
        }
        while (rightIndex <= right) {
            help[helpIndex++] = arr[rightIndex++];
        }
        for (int i = 0; i < help.length; i++) {
            arr[i + left] = help[i];
        }
        return result;
    }
}
