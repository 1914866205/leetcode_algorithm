package com.programmercarl.array;

/**
 * @ClassName SpiralMatrixIi
 * @Descriotion https://leetcode-cn.com/problems/spiral-matrix-ii/
 * @Author nitaotao
 * @Date 2022/5/2 13:12
 * @Version 1.0
 * 螺旋矩阵 II
 **/
public class SpiralMatrixIi {
    public static void main(String[] args) {
        final int[][] ints = generateMatrix(5);
        for (int i = 0; i < ints.length; i++) {
            for (int j = 0; j <ints[i].length ; j++) {
                System.out.print(ints[i][j]+" ");
            }
            System.out.println();
        }
    }

    /**
     * 00 01 02 03 04
     * 10 11 12 13 14
     * 20 21 22 23 24
     * 30 31 32 33 34
     * 40 41 42 43 44
     */
    public static int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int stop = n * n;
        int num = 1;
        //行、列边界值
        //设都是闭区间
        int rowStart = 0;
        int rowEnd = n - 1;
        int colStart = 0;
        int colEnd = n - 1;

        while (num <= stop) {
            // 00 01 02 03
            int i = colStart;
            for (; i <= colEnd; i++) {
                result[rowStart][i] = num;
                if (stop == num) {
                    return result;
                } else {
                    num++;
                }
            }
            // 03
            // 13
            // 23
            // 33
            rowStart++;
            int j = rowStart;
            for (; j <=rowEnd ; j++) {
                result[j][colEnd] = num;
                if (stop == num) {
                    return result;
                } else {
                    num++;
                }
            }
            // 30 31 32 33
            colEnd--;
            i = colEnd;
            for (; i >= colStart; i--) {
                result[rowEnd][i] = num;
                if (stop == num) {
                    return result;
                } else {
                    num++;
                }
            }
            //10
            //20
            //30
            //40
            rowEnd--;
            j = rowEnd;
            for (; j >= rowStart; j--) {
                result[j][colStart] = num;
                if (stop == num) {
                    return result;
                } else {
                    num++;
                }
            }
            colStart++;
        }
        return result;
    }
}
