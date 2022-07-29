package com.programmercarl.dynamic;

/**
 * @ClassName Package
 * @Descriotion TODO
 * @Author nitaotao
 * @Date 2022/7/29 11:52
 * @Version 1.0
 * https://blog.csdn.net/niTaoTaoa/article/details/126061917
 * 背包问题
 **/
public class Package {
    public int getMaxValue(int[] weight, int[] value, int bagSize) {
        return getValue(weight, value, bagSize, 0);
    }

    /**
     * 从左往右 01背包
     * @param weight       物品重量数组
     * @param value        物品价值数组
     * @param bagFreeSpace 背包剩余空间
     * @param curIndex
     * @return
     */
    private int getValue(int[] weight, int[] value, int bagFreeSpace, int curIndex) {
        //如果剩余空间<0
        if (bagFreeSpace < 0) {
            return -1;
        }
        if (curIndex == value.length) {
            //如果选完最后一个  value[value.length - 1]
            return 0;
        }
        //如果当前物品不选，则直接选下一个
        int unSelect = getValue(weight, value, bagFreeSpace, curIndex + 1);
        //如果当前物品可以选
        int select = 0;
        int next = getValue(weight, value, bagFreeSpace - weight[curIndex], curIndex + 1);
        if (next != -1) {
            select = value[curIndex] + next;
        }
        //选择最大价值
        return Math.max(unSelect, select);
    }


    public int getMaxValue2(int[] weight, int[] value, int bagSize) {
        int n = weight.length;
        //横向为背包剩余空间
        //纵向为当前选择的物品
        int[][] dp = new int[n + 1][bagSize + 1];
        //由暴力递归可知，当curIndex==n , 则为0
        // Java 默认为0
        for (int i = 0; i <= bagSize; i++) {
            dp[n][i] = 0;
        }
        //物品
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= bagSize; j++) {
                //如果当前物品不选，则直接选下一个
                int unSelect = dp[i + 1][j];
                //如果当前物品可以选
                int select = 0;
                if (j >= weight[i]) {
                    select = value[i] + dp[i + 1][j - weight[i]];
                }
                dp[i][j] = Math.max(unSelect, select);
            }
        }
        return dp[0][bagSize];
    }

    public static void main(String[] args) {
        int[] weights = {3, 2, 4, 7};
        int[] values = {5, 6, 3, 19};
        int bag = 11;
        System.out.println(new Package().getMaxValue(weights, values, bag));
        System.out.println(new Package().getMaxValue2(weights, values, bag));
    }
}
