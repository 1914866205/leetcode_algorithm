package com.mca;

/**
 * @ClassName SmallSum2
 * @Descriotion TODO
 * @Author nitaotao
 * @Date 2022/9/22 17:58
 * @Version 1.0
 **/
public class SmallSum2 {

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
    }

    /**
     * 递归过程
     *
     * @param arr 原数组
     * @param L   左边界
     * @param R   右边界
     * @return
     */
    public static int process(int[] arr, int L, int R) {
        if (L == R) {
            return 0;
        }
        int mid = L + ((R - L) >> 1);
        return process(arr, L, mid) + process(arr, mid + 1, R) + merge(arr, L, mid, R);
    }

    private static int merge(int[] arr, int L, int mid, int R) {
        //辅助数组
        int[] helpArr = new int[R - L + 1];
        int helpIndex = 0;
        int sum = 0;
        //左边界起始位置
        int leftIndex = L;
        //右边界起始位置
        int rightIndex = mid + 1;
        //左右两边对比，如果左和右都不越界
        while (leftIndex <= mid && rightIndex <= R) {
            //如果左边的数比右边最小的数小，那么sum就+=(R - rightIndex + 1) * arr[leftIndex],否则就+0
            sum += arr[leftIndex] < arr[rightIndex] ? (R - rightIndex + 1) * arr[leftIndex] : 0;
            helpArr[helpIndex++] = arr[leftIndex] < arr[rightIndex] ? arr[leftIndex++] : arr[rightIndex++];
        }
        while (leftIndex <= mid) {
            helpArr[helpIndex++] = arr[leftIndex++];
        }
        while (rightIndex <= R) {
            helpArr[helpIndex++] = arr[rightIndex++];
        }
        for (int i = 0; i < helpArr.length; i++) {
            arr[L + i] = helpArr[i];
        }
        return sum;

    }
}
