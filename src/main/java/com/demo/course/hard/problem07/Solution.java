package com.demo.course.hard.problem07;

import java.util.Arrays;

/**
 * author: nitaotao
 * date: 2021/12/23 0:12
 * version: 1.0
 * description: todo
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
     *
     * @param ghosts
     * @param target
     * @return
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
