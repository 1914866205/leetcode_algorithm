package com.programmercarl.greed;

/**
 * @ClassName CanJump
 * @Descriotion TODO
 * @Author nitaotao
 * @Date 2022/7/15 10:24
 * @Version 1.0
 * https://leetcode.cn/problems/jump-game/
 * 55. 跳跃游戏
 **/
public class CanJump {
    public boolean canJump(int[] nums) {
        /**
         * 找到所有的0，计算0元素之前的元素有没有能跳过这个0的
         */
        if (nums.length == 1) {
            return true;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= nums.length - i - 1) {
                //一步到头
                return true;
            }
            //如果找到0，就在0之前找有没有能跳过0的
            if (nums[i] == 0) {
                int offset = 1;
                int j = i-1;
                for (; j >= 0; j--) {
                    if (nums[j] > offset) {
                        break;
                    } else {
                        offset++;
                    }
                }
                //跳到头了
                if (j == -1) {
                    return false;
                }
            }
        }
        return true;
    }
}
