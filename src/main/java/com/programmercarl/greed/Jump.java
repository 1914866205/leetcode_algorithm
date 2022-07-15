package com.programmercarl.greed;

/**
 * @ClassName Jump
 * @Descriotion TODO
 * @Author nitaotao
 * @Date 2022/7/15 10:58
 * @Version 1.0
 * https://leetcode.cn/problems/jump-game-ii/
 * 45. 跳跃游戏 II
 **/
public class Jump {
    public int jump(int[] nums) {
        //只有一个元素
        if (nums.length <= 1) {
            return 0;
        }
        int curDistance = 0;
        int maxDistance = 0;
        int step = 0;
        for (int i = 0; i < nums.length; i++) {
            //获取当前最大覆盖范围
            curDistance = Math.max(curDistance, i + nums[i]);
            //如果i走到当前最大覆盖范围的边界
            if (i == maxDistance) {
                step++;
                maxDistance = curDistance;
            }
            if (maxDistance >= nums.length - 1) {
                //如果最大覆盖范围抵达数组最后一位
                break;
            }
        }
        return step;
    }

    public static void main(String[] args) {
        System.out.println(new Jump().jump(new int[]{7, 0, 9, 6, 9, 6, 1, 7, 9, 0, 1, 2, 9, 0, 3}));//2
        System.out.println(new Jump().jump(new int[]{4, 1, 1, 3, 1, 1, 1}));//2
        System.out.println(new Jump().jump(new int[]{1, 2, 1, 1, 1}));// 3
        System.out.println(new Jump().jump(new int[]{1, 2, 0, 1}));// 2
        System.out.println(new Jump().jump(new int[]{2, 3, 1, 1, 4}));//2
        System.out.println(new Jump().jump(new int[]{2, 3, 0, 1, 4}));//2
        System.out.println(new Jump().jump(new int[]{1, 1, 1, 1}));//3
        System.out.println(new Jump().jump(new int[]{1, 3, 2}));//2
    }
}
