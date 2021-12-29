package com.demo.course.mid.problem10;

import java.util.ArrayList;

/**
 * author: nitaotao
 * date: 2021/12/22 19:27
 * version: 1.0
 * description: todo
 * 【解题思路】： 先判断输入的操作后的矩阵是不是可行且合理，如果不是，直接输出原始矩阵，通过矩阵长乘宽是否等于转换后长乘宽判断。
 * 如果合理，创建新的二维数组，行遍历原数组，通过list集合依次接收元素，
 * 再在新的二维数组中使用行遍历，依次再从list首部获取元素添加到新的数组中。
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

    /**
     * matrixReshape方法：重塑矩阵
     * @param mat 矩阵
     * @param r 新的行
     * @param c 新的列
     * @return 重塑后的矩阵
     */
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        //如果具有给定参数的 reshape 操作是不是可行且合理的，则输出原始矩阵。
        // 即比如 原来为5行3列  非让转成100行100列  则返回原矩阵
        //只有总要元素数量不变才能转
        if (mat.length * mat[0].length != r * c) {
            return mat;
        }
        int[][] newArr = new int[r][c];
        //把元素一个个添加到集合，因为要行遍历输出新的，所以直接一行行添加进去即可
        ArrayList list = new ArrayList();
        //行遍历数组所有元素
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                list.add(mat[i][j]);
            }
        }
        //行遍历再输出回去，到新的形状。类似把水倒进不同的形状的容器，等凝固成冰后输出不同形状的冰块
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
