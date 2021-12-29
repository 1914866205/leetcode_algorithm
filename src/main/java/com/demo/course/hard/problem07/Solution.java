package com.demo.course.hard.problem07;

import java.util.Arrays;

/**
 * author: nitaotao
 * date: 2021/12/23 0:12
 * version: 1.0
 * description: https://leetcode-cn.com/problems/escape-the-ghosts/
 * 【解题思路】： 先判断仅有一个值的情况，直接返回 0。如果不是，那么数组先排序找到最大值和最小值，
 * 返回数组中最大值和最小值之间可能存在的最小差值，可以看做是在一维数轴上，两个点的距离如果大于
 * 2k，则返回中间还差的距离，否则返回 0，说明这个中间点双方都能达到。
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] ghosts = {{1, 9}, {2,-5}, {3,8}, {9,8}, {-1, 3}};
        int[] target = new int[]{8,-10};
        System.out.println(solution.escapeGhosts(ghosts, target));
    }

    /**
     * escapeGhosts 逃脱阻碍者
     * @param ghosts 阻碍者
     * @param target 目标
     * @return 返回我能否成功逃脱
     */
    public boolean escapeGhosts(int[][] ghosts, int[] target) {
        //速度一样，只有我的比阻碍者距离终点近，我才成功
        int[] ghostsDistance = new int[ghosts.length];
        for (int i = 0; i < ghosts.length; i++) {
            //此处不用开平方   因为每次走一格，不是走斜线，所以不能这么计算
//            ghostsDistance[i] = (target[0] - ghosts[i][0]) * (target[0] - ghosts[i][0]) + (target[1] - ghosts[i][1]) * (target[1] - ghosts[i][1]);
            ghostsDistance[i] = Math.abs(target[0] - ghosts[i][0]) + Math.abs(target[1] - ghosts[i][1]);
//            System.out.println(ghostsDistance[i]+" "+i);
        }
        Arrays.sort(ghostsDistance);
//        Arrays.stream(ghostsDistance).forEach(System.out::println);
        //我的位置是原点位置
//        int myDistance = target[0] * target[0] + target[1] * target[1];
        int myDistance = Math.abs(target[0]) + Math.abs(target[1]);
//        System.out.println(myDistance);
//        System.out.println(ghostsDistance[0]);
        return ghostsDistance[0] <= myDistance ? false : true;
    }
}
