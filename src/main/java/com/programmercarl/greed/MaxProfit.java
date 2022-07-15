package com.programmercarl.greed;

/**
 * @ClassName MaxProfit
 * @Descriotion TODO
 * @Author nitaotao
 * @Date 2022/7/15 9:55
 * @Version 1.0
 * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-ii/
 * 122. 买卖股票的最佳时机 II
 **/
public class MaxProfit {
    public int maxProfit(int[] prices) {
        //如果只有一个元素直接返回0
        if (prices.length == 1) {
            return 0;
        }
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            //如果当前元素比前一个大，就加上差值
            if (prices[i] > prices[i - 1]) {
                maxProfit += prices[i] - prices[i - 1];
            }
        }
        return maxProfit;
    }
}
