package com.programmercarl.backtracking;

import com.programmercarl.util.GenerateArray;

import java.util.Arrays;

/**
 * @ClassName SolveSudoku
 * @Descriotion TODO
 * @Author nitaotao
 * @Date 2022/7/13 9:57
 * @Version 1.0
 * https://leetcode.cn/problems/sudoku-solver/
 * 37. 解数独
 **/
public class SolveSudoku {
    //递归终止条件，一共有多少个数字要填
    int needNums = 0;
    char[][] result;

    public void solveSudoku(char[][] board) {
        //把当前字符数组转化为引用类型
        Character[][] temp = new Character[board.length][board.length];
        //计算一共有多少要填的数字
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == '.') {
                    needNums++;
                }
                temp[i][j] = board[i][j];
            }
        }
        backtracking(temp);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = result[i][j];
            }
        }
    }


    public void backtracking(Character[][] board) {
        if (needNums == 0) {
            result = new char[board.length][board.length];
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board.length; j++) {
                    result[i][j] = board[i][j];
                }
            }
            return;
        }
        for (int i = 0; i < board.length; i++) {
            //可用数组
            char[] flag = new char[9];
            Arrays.fill(flag, '0');
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] != '.') {
                    //如果当前元素不是 .
                    continue;
                }
                for (char k = '1'; k <= '9'; k++) {
                    //如果在周围或横或纵没有这个元素  并且 这个元素没有被用过
                    if (isNoFindSelfInAround(board, i, j, k) && flag[k - '1'] == '0') {
                        board[i][j] = k;
                        needNums--;
                        //递归
                        backtracking(board);
                        //回溯
                        needNums++;
                        board[i][j] = '.';
                    }
                }
                //如果能运行到这，说明 1 - 9 没有找到需要的数字，则返回
                return;
            }
        }
    }

    /**
     * 在周围、横向、纵向 有没有发现了自己
     *
     * @param board
     * @param x
     * @param y
     * @return
     */
    public boolean isNoFindSelfInAround(Character[][] board, int x, int y, char curNum) {
        int offsetX = x - x % 3;
        int offsetY = y - y % 3;
        //周围九个相对位置
        boolean flag;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                flag = (board[offsetX + i][offsetY + j] == curNum);
                if (flag) {
                    //发现相同
                    return false;
                }
            }
        }

        //横纵不得相同
        for (int i = 0; i < board.length; i++) {
            flag = (board[x][i] == curNum) || (board[i][y] == curNum);
            if (flag) {
                //发现相同
                return false;
            }
        }
        return true;
    }


    public void printArr(Character[][] board) {
        System.out.println();
        System.out.println("======================");
        for (int ii = 0; ii < board.length; ii++) {
            for (int jj = 0; jj < board.length; jj++) {
                System.out.print(board[ii][jj] + " ");
            }
            System.out.println();
        }
    }

//    public static void main(String[] args) {
//        System.out.println("==============原结果==============");
//        char[][] board = GenerateArray.generateArrays("[[\"5\",\"3\",\".\",\".\",\"7\",\".\",\".\",\".\",\".\"],[\"6\",\".\",\".\",\"1\",\"9\",\"5\",\".\",\".\",\".\"],[\".\",\"9\",\"8\",\".\",\".\",\".\",\".\",\"6\",\".\"],[\"8\",\".\",\".\",\".\",\"6\",\".\",\".\",\".\",\"3\"],[\"4\",\".\",\".\",\"8\",\".\",\"3\",\".\",\".\",\"1\"],[\"7\",\".\",\".\",\".\",\"2\",\".\",\".\",\".\",\"6\"],[\".\",\"6\",\".\",\".\",\".\",\".\",\"2\",\"8\",\".\"],[\".\",\".\",\".\",\"4\",\"1\",\"9\",\".\",\".\",\"5\"],[\".\",\".\",\".\",\".\",\"8\",\".\",\".\",\"7\",\"9\"]]\n");
//        for (int ii = 0; ii < board.length; ii++) {
//            for (int jj = 0; jj < board.length; jj++) {
//                System.out.print(board[ii][jj] + " ");
//            }
//            System.out.println();
//        }
//        System.out.println("==============目标结果==============");
//        char[][] board2 = GenerateArray.generateArrays("[[\"5\",\"3\",\"4\",\"6\",\"7\",\"8\",\"9\",\"1\",\"2\"],[\"6\",\"7\",\"2\",\"1\",\"9\",\"5\",\"3\",\"4\",\"8\"],[\"1\",\"9\",\"8\",\"3\",\"4\",\"2\",\"5\",\"6\",\"7\"],[\"8\",\"5\",\"9\",\"7\",\"6\",\"1\",\"4\",\"2\",\"3\"],[\"4\",\"2\",\"6\",\"8\",\"5\",\"3\",\"7\",\"9\",\"1\"],[\"7\",\"1\",\"3\",\"9\",\"2\",\"4\",\"8\",\"5\",\"6\"],[\"9\",\"6\",\"1\",\"5\",\"3\",\"7\",\"2\",\"8\",\"4\"],[\"2\",\"8\",\"7\",\"4\",\"1\",\"9\",\"6\",\"3\",\"5\"],[\"3\",\"4\",\"5\",\"2\",\"8\",\"6\",\"1\",\"7\",\"9\"]]");
//        for (int ii = 0; ii < board2.length; ii++) {
//            for (int jj = 0; jj < board2.length; jj++) {
//                System.out.print(board2[ii][jj] + " ");
//            }
//            System.out.println();
//        }
//
//        new SolveSudoku().solveSudoku(board);
//    }
}
