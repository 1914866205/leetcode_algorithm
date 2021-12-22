package com.demo.course.mid.problem10;

import java.util.ArrayList;

/**
 * author: nitaotao
 * date: 2021/12/22 19:27
 * version: 1.0
 * description: todo
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] arr = new int[][]{{1, 2}, {3, 4}};
        int[][] ints = solution.matrixReshape(arr, 1, 4);
        for (int i = 0; i < ints.length; i++) {
            for (int j = 0; j <ints[i].length ; j++) {
                System.out.print(ints[i][j]+" ");
            }
            System.out.println();
        }
    }

    public int[][] matrixReshape(int[][] mat, int r, int c) {
        //如果具有给定参数的 reshape 操作是不是可行且合理的，则输出原始矩阵。
        if (mat.length * mat[0].length != r * c) {
            return mat;
        }
        int[][] newArr = new int[r][c];
        ArrayList list = new ArrayList();
        //行遍历数组所有元素
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                list.add(mat[i][j]);
            }
        }
        for (int i = 0; i < newArr.length; i++) {
            for (int j = 0; j < newArr[i].length; j++) {
                //集合获取首元素并删除
                int remove = (int) list.remove(0);
                newArr[i][j] = remove;
            }
        }
        return newArr;
    }
}
