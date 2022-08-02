package com.programmercarl.dynamic;

/**
 * @ClassName Jump
 * @Descriotion TODO
 * @Author nitaotao
 * @Date 2022/8/2 14:55
 * @Version 1.0
 * 小马儿走棋
 * https://blog.csdn.net/niTaoTaoa/article/details/126125224
 **/
public class Jump {
    public int ways(int a, int b, int step) {
        System.out.println(jump(a, b, 0, 0, step));
        return process(a, b, 0, 0, step);
    }

    /**
     * @param a    目标位置x
     * @param b    目标位置y
     * @param i    当前位置i
     * @param j    当前位置j
     * @param step 剩余步数 step
     * @return 横9线，纵10线
     * 9行10列
     * [0-8] [0-9]
     */
    private int jump(int a, int b, int i, int j, int step) {
        if (step == 0) {
            //当前是一种方法
            return a == i && b == j ? 1 : 0;
        }
        // i j 跳跃情况：i+1,j+2   i+2,j+1           i-1,j+2  i-2,j+1          i+1,j-2      i+2,j-1
        int upRightDown = i + 1 <= 9 && j + 2 <= 8 ? jump(a, b, i + 1, j + 2, step - 1) : 0;
        int upRightUp = i + 2 <= 9 && j + 1 <= 8 ? jump(a, b, i + 2, j + 1, step - 1) : 0;
        //  i-2,j+1    i-2,j-1
        int upLeftDown = i - 2 >= 0 && j + 1 <= 8 ? jump(a, b, i - 2, j + 1, step - 1) : 0;
        int upLeftUp = i - 1 >= 0 && j + 2 <= 8 ? jump(a, b, i - 1, j + 2, step - 1) : 0;
        //   i-1,j-2   i-2,j-1
        int downLeftDown = i - 1 >= 0 && j - 2 >= 0 ? jump(a, b, i - 1, j - 2, step - 1) : 0;
        int downLeftUp = i - 2 >= 0 && j - 1 >= 0 ? jump(a, b, i - 2, j - 1, step - 1) : 0;
        // i+1,j-2    i+2,j-1
        int downRightDown = i + 1 <= 9 && j - 2 >= 0 ? jump(a, b, i + 1, j - 2, step - 1) : 0;
        int downRightUp = i + 2 <= 9 && j - 1 >= 0 ? jump(a, b, i + 2, j - 1, step - 1) : 0;
        return upRightDown + upRightUp + upLeftDown + upLeftUp + downLeftDown + downLeftUp + downRightDown + downRightUp;
    }

    private int process(int a, int b, int i, int j, int step) {
        if (i > 9 || j > 8 || i < 0 || j < 0) {
            return 0;
        }
        if (step == 0) {
            //当前是一种方法
            return a == i && b == j ? 1 : 0;
        }
        // i j 跳跃情况：i+1,j+2   i+2,j+1           i-1,j+2  i-2,j+1          i+1,j-2      i+2,j-1
        int ways = process(a, b, i + 1, j + 2, step - 1);
        ways += process(a, b, i + 2, j + 1, step - 1);
        //  i-2,j+1    i-2,j-1
        ways += process(a, b, i - 2, j + 1, step - 1);
        ways += process(a, b, i - 1, j + 2, step - 1);
        //   i-1,j-2   i-2,j-1
        ways += process(a, b, i - 1, j - 2, step - 1);
        ways += process(a, b, i - 2, j - 1, step - 1);
        // i+1,j-2    i+2,j-1
        ways += process(a, b, i + 1, j - 2, step - 1);
        ways += process(a, b, i + 2, j - 1, step - 1);
        return ways;
    }

    public int dp(int a, int b, int k) {
        int[][][] dp = new int[10][9][k + 1];
        //第一层填好
        dp[a][b][0] = 1;
        for (int step = 1; step <=k; step++) {
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 9; j++) {
                    // i j 跳跃情况：i+1,j+2   i+2,j+1           i-1,j+2  i-2,j+1          i+1,j-2      i+2,j-1
                    int upRightDown = i + 1 <= 9 && j + 2 <= 8 ? dp[i + 1][j + 2][step - 1] : 0;
                    int upRightUp = i + 2 <= 9 && j + 1 <= 8 ? dp[i + 2][j + 1][step - 1] : 0;
                    //  i-2,j+1    i-2,j-1
                    int upLeftDown = i - 2 >= 0 && j + 1 <= 8 ? dp[i - 2][j + 1][step - 1] : 0;
                    int upLeftUp = i - 1 >= 0 && j + 2 <= 8 ? dp[i - 1][j + 2][step - 1] : 0;
                    //   i-1,j-2   i-2,j-1
                    int downLeftDown = i - 1 >= 0 && j - 2 >= 0 ? dp[i - 1][j - 2][step - 1] : 0;
                    int downLeftUp = i - 2 >= 0 && j - 1 >= 0 ? dp[i - 2][j - 1][step - 1] : 0;
                    // i+1,j-2    i+2,j-1
                    int downRightDown = i + 1 <= 9 && j - 2 >= 0 ? dp[i + 1][j - 2][step - 1] : 0;
                    int downRightUp = i + 2 <= 9 && j - 1 >= 0 ? dp[i + 2][j - 1][step - 1] : 0;
                    dp[i][j][step] = upRightDown + upRightUp + upLeftDown + upLeftUp + downLeftDown + downLeftUp + downRightDown + downRightUp;
                }
            }
        }
        return dp[0][0][k];
    }


    public static void main(String[] args) {
        System.out.println(new Jump().ways(7, 7, 10));
        System.out.println(new Jump().dp(7, 7, 10));
    }
}
