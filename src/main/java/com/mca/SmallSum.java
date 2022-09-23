package com.mca;

/**
 * @ClassName SmallSum
 * @Descriotion 小和问题
 * @Author nitaotao
 * @Date 2022/9/22 17:09
 * @Version 1.0
 **/
public class SmallSum {
    public static void main(String[] args) {
        int[] arr = {3, 5, 6, 9, 6, 2, 4, 2};
        int sum = 0;
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    sum += arr[j];
                }
            }
        }
        System.out.println(sum);

        System.out.println(process(arr, 0, arr.length - 1));
        System.out.print(arr);

    }

    public static int process(int[] arr, int L, int R) {
        if (L == R) {
            return 0;
        }
        int mid = L + ((R - L) / 2);
        return process(arr, L, mid) + process(arr, mid + 1, R) + merge(arr, L, mid, R);

    }

    private static int merge(int[] arr, int L, int mid, int R) {
        int[] help = new int[R - L + 1];
        int helpIndex = 0;

        int leftIndex = L;
        int rightIndex = mid + 1;
        int sum = 0;

        while (leftIndex <= mid && rightIndex <= R) {
            //如果左边比右边小时
            sum += arr[leftIndex] < arr[rightIndex] ? arr[leftIndex] * (R - rightIndex + 1) : 0;
            help[helpIndex++] = arr[leftIndex] < arr[rightIndex] ? arr[leftIndex++] : arr[rightIndex++];
        }
        while (leftIndex <= mid) {
            help[helpIndex++] = arr[leftIndex++];
        }
        while (rightIndex <= R) {
            help[helpIndex++] = arr[rightIndex++];
        }
        for (int i = 0; i < help.length; i++) {
            arr[L + i] = help[i];
        }
        return sum;
    }
}

