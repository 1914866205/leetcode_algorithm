package com.programmercarl.dynamic;

/**
 * @ClassName LastStoneWeightII
 * @Descriotion TODO
 * @Author nitaotao
 * @Date 2022/7/27 15:55
 * @Version 1.0
 * https://leetcode.cn/problems/last-stone-weight-ii/
 * 1049. 最后一块石头的重量 II
 **/
public class LastStoneWeightII {
    public int lastStoneWeightII(int[] stones) {
        /**
         * 把石头总重量均分为两堆，最后一相减，就得到最后是否还有剩余石头
         * 即：找到容量为一半时可以装入的石头，和剩余石头容量比较，就可以得到所求剩余石头重量
         * 1. dp[j]:容量为j的背包可以装下的最大石头数量。j取石头总数的一半，dp[j]<=j
         * 因为到时候需要与剩下的石头重量相减
         * 2. 确定递推公式 stones是背包已经装的石头数量，dp[j-stones[i]]求背包剩下容量还可以装的石头
         * 3.dp数组初始化：dp[j]每次取最大值，所以取0就可以，dp[j]才不会初始值覆盖，石头重量肯定>0
         * 4.确定遍历顺序：先遍历石头个数，再重后往前遍历背包（从前往后会导致已经得到的dp[i]被重复使用）
         */
        //总石头重量和
        int sum = 0;
        for (int i = 0; i < stones.length; i++) {
            sum += stones[i];
        }
        //   / 向下取整    sum/2>=target
        int target = sum / 2;
        //dp[j]:容量为j的背包可以装下的最大石头数量。j取石头总数的一半，dp[j]<=j
        // j 容量   dp[j] 容量为j的背包
        int[] dp = new int[target + 1];
        //先遍历石头
        for (int i = 0; i < stones.length; i++) {
            //从后往前遍历的
            //j 初始值为背包总容量
            for (int j = target; stones[i] <= j; j--) {
                //stones[i]<=j   石头体积<=背包容量
                //                放      当前j-store[i] 容量的背包 装 stones[i]
                dp[j] = Math.max(dp[j], dp[j - stones[i]] + stones[i]);
            }
        }
        //减去两个相同大小的石堆
        return sum - dp[target] * 2;
    }

    public static void main(String[] args) {
        System.out.println(new LastStoneWeightII().lastStoneWeightII(new int[]{2, 7, 4, 1, 8, 1}));
    }
}
