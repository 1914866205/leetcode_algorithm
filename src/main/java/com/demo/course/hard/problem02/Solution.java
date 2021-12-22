package com.demo.course.hard.problem02;

/**
 * author: nitaotao
 * date: 2021/12/22 21:56
 * version: 1.0
 * description: todo
 */
public class Solution {
    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        Solution solution = new Solution();
        solution.rotate(arr);
        for (int i = 0; i <arr.length ; i++) {
            for (int j = 0; j <arr[i].length ; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }

    public void rotate(int[][] matrix) {
        //新的空矩阵存储
        int[][] rotate = new int[matrix.length][matrix[0].length];
        //根据发现的规律，旋转后的矩阵各元素是原各元素轴对称位置
        for (int i = 0; i < matrix.length; i++) {
            int k = matrix[i].length-1;
            for (int j = 0; j < matrix[i].length; j++) {
                rotate[i][j] = matrix[k][i];
                k--;
            }
        }
        //再把空矩阵赋值回去
        for (int i = 0; i <matrix.length ; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = rotate[i][j];
            }
        }
    }
}
