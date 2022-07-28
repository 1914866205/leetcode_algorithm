package com.programmercarl.dynamic;

/**
 * @ClassName RobotMovement
 * @Descriotion TODO
 * @Author nitaotao
 * @Date 2022/7/28 19:40
 * @Version 1.0
 **/
public class RobotMovement {
    /**
     * @param length 总长度
     * @param cur    当前位置
     * @param steps  剩余步数
     * @param target 目标位置
     * @return
     */
    public static int getWays(int length, int cur, int steps, int target) {
        //如果剩余步数为0
        if (steps == 0) {
            //判断当前位置是不是目标位置
            if (cur == target) {
                return 1;
            } else {
                return 0;
            }
        }
        //左边界
        if (cur == 1) {
            //移动到2位置
            return getWays(length, 2, steps - 1, target);
        }
        //右边界
        if (cur == length) {
            //移动到右边倒数第二个位置
            return getWays(length, length - 1, steps - 1, target);
        }
        //中间位置
        return getWays(length, cur - 1, steps - 1, target) + getWays(length, cur + 1, steps - 1, target);
    }

    /**
     * @param length 总长度
     * @param cur    当前位置
     * @param steps  剩余步数
     * @param target 目标位置
     * @return
     */
    public static int getWays2(int length, int cur, int steps, int target) {
        //纵行 为 路径,横行为剩余步数
        int[][] dp = new int[length + 1][steps + 1];
        //第1列初始化,当步数为0的时候，如果
        dp[target][0] = 1;
        for (int i = 1; i <= steps; i++) {
            //第0行为length=0,不存在
            //第一行可以直接初始化，因为是位于左边界，只能移动到第二个位置
            dp[1][i] = dp[2][i - 1];
            for (int j = 2; j < length; j++) {
                //除了一行和最后一行（左右边界），其余行都是左右之和
                dp[j][i] = dp[j - 1][i - 1] + dp[j + 1][i - 1];
            }
            //如果遇到右边界，直接走倒数第二位
            dp[length][i] = dp[length - 1][i - 1];
        }
        //返回目标位置的数量
        return dp[cur][steps];
    }

    public static void main(String[] args) {
        System.out.println(getWays(4, 2, 4, 4));
        System.out.println(getWays(5, 2, 6, 4));
        System.out.println(getWays2(4, 2, 4, 4));
        System.out.println(getWays2(5, 2, 6, 4));
    }
}
