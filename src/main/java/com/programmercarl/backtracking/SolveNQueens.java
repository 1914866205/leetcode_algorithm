package com.programmercarl.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @ClassName SolveNQueens
 * @Descriotion TODO
 * @Author nitaotao
 * @Date 2022/7/12 15:48
 * @Version 1.0
 * https://leetcode.cn/problems/n-queens/
 * 51. N 皇后
 **/
public class SolveNQueens {
    List<List<String>> result = new ArrayList<>();
    HashMap<String, List<String>> map = new HashMap<>();

    public List<List<String>> solveNQueens(int n) {
        //0为空 1为棋 2作为标记 表示不能放置棋子
        int[][] arr = new int[n][n];
        backtracking(arr, 0, n,0);
        for (String key : map.keySet()) {
            result.add(map.get(key));
        }
        System.out.println(result);
        return result;
    }

    /**
     * @param arr      棋盘
     * @param queueNum 当前皇后出现数量
     * @param n        已放置的皇后数量
     * @param startX   从之前走过的路接着走
     */
    public void backtracking(int[][] arr, int queueNum, int n,int startX) {
        //当 n 个皇后全部放置完毕，则返回
        if (queueNum == n) {
            String all = "";
            List<String> list = new ArrayList();
            for (int i = 0; i < arr.length; i++) {
                String s = "";
                for (int j = 0; j < arr.length; j++) {
                    if (arr[i][j] == 1) {
                        s += "Q";
                    } else {
                        s += ".";
                    }
                }
                all += s;
                list.add(s);
            }
            if (!map.containsKey(all)) {
                map.put(all, list);
            }
            return;
        }

        for (int i = startX; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                //简单判断一下当前位置是否可以下棋
                if (arr[i][j] != 0) {
                    continue;
                }
                boolean findQueue = false;
                //横向纵向不能有 1
                for (int k = 0; k < arr.length; k++) {
                    findQueue = arr[i][k] == 1 || arr[k][j] == 1;
                    if (findQueue) {
                        break;
                    }
                }
                if (findQueue) {
                    //如果这些位置有1，则有冲突
                    continue;
                }

                //左斜右斜不能有 1

                //左上
                int x = i - 1;
                int y = j - 1;
                while (x > -1 && y > -1) {
                    findQueue = arr[x][y] == 1;
                    if (findQueue) {
                        break;
                    }
                    x--;
                    y--;
                }
                if (findQueue) {
                    //如果这些位置有1，则有冲突
                    continue;
                }

                //左下
                x = i - 1;
                y = j + 1;
                while (x > -1 && y < n) {
                    findQueue = arr[x][y] == 1;
                    if (findQueue) {
                        break;
                    }
                    x--;
                    y++;
                }
                if (findQueue) {
                    //如果这些位置有1，则有冲突
                    continue;
                }

                //右上
                x = i + 1;
                y = j - 1;
                while (x < n && y > -1) {
                    findQueue = arr[x][y] == 1;
                    if (findQueue) {
                        break;
                    }
                    x++;
                    y--;
                }
                if (findQueue) {
                    //如果这些位置有1，则有冲突
                    continue;
                }

                //右下
                x = i + 1;
                y = j + 1;
                while (x < n && y < n) {
                    findQueue = arr[x][y] == 1;
                    if (findQueue) {
                        break;
                    }
                    x++;
                    y++;
                }
                // 如果 findQueue == true ,即当前位置横向、纵向或斜向出现 1 ，
                // 即出现了其他皇后，跳过
                if (findQueue) {
                    //如果这些位置有1，则有冲突
                    continue;
                }

                if (arr[i][j] == 0) {
                    //若为0，才能添加棋子，否则跳过
                    //此元素 横、纵、左斜、右斜元素标记为2，不可再写
                    for (int k = 0; k < arr.length; k++) {
                        arr[i][k] = 2;
                        arr[k][j] = 2;
                    }

                    //左上
                    x = i - 1;
                    y = j - 1;
                    while (x > -1 && y > -1) {
                        arr[x][y] = 2;
                        x--;
                        y--;
                    }

                    //左下
                    x = i - 1;
                    y = j + 1;
                    while (x > -1 && y < n) {
                        arr[x][y] = 2;
                        x--;
                        y++;
                    }

                    //右上
                    x = i + 1;
                    y = j - 1;
                    while (x < n && y > -1) {
                        arr[x][y] = 2;
                        x++;
                        y--;
                    }

                    //右下
                    x = i + 1;
                    y = j + 1;
                    while (x < n && y < n) {
                        arr[x][y] = 2;
                        x++;
                        y++;
                    }


                    // 在此处下棋
                    arr[i][j] = 1;
                    queueNum++;
                    //递归
                    backtracking(arr, queueNum, n, i + 1);
                    //回溯
                    queueNum--;
                    for (int k = 0; k < arr.length; k++) {
                        arr[i][k] = 0;
                        arr[k][j] = 0;
                    }

                    //左上
                    x = i - 1;
                    y = j - 1;
                    while (x > -1 && y > -1) {
                        arr[x][y] = 0;
                        x--;
                        y--;
                    }

                    //左下
                    x = i - 1;
                    y = j + 1;
                    while (x > -1 && y < n) {
                        arr[x][y] = 0;
                        x--;
                        y++;
                    }

                    //右上
                    x = i + 1;
                    y = j - 1;
                    while (x < n && y > -1) {
                        arr[x][y] = 0;
                        x++;
                        y--;
                    }

                    //右下
                    x = i + 1;
                    y = j + 1;
                    while (x < n && y < n) {
                        arr[x][y] = 0;
                        x++;
                        y++;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        new SolveNQueens().solveNQueens(4);
    }
}
