package com.programmercarl.array;

/**
 * @ClassName GetKthMagicNumber
 * @Descriotion https://leetcode.cn/problems/get-kth-magic-number-lcci/
 * @Author nitaotao
 * @Date 2022/9/29 0:18
 * @Version 1.0
 **/
public class GetKthMagicNumber {
    public int getKthMagicNumber(int k) {
        if (k == 1) {
            return 1;
        }
        // 1      3              9      27
        // 1    3 5 7     15  21
        // 0    1 2 3     4   5
        int[] arr = new int[k + 1];
        arr[0] = 1;
        int point3 = 0;
        int point5 = 0;
        int point7 = 0;
        for (int i = 1; i < k + 1; i++) {
            int res = Math.min(Math.min(arr[point3] * 3, arr[point5] * 5), arr[point7] * 7);
            arr[i]=res;
            if (res % 3 == 0) {
                point3++;
            }
            if (res % 5 == 0) {
                point5++;
            }
            if (res % 7 == 0) {
                point7++;
            }
        }
        return arr[k-1];
    }

    public static void main(String[] args) {
        System.out.println(new GetKthMagicNumber().getKthMagicNumber(2));

    }
}
