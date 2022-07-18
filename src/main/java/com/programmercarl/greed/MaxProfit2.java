package com.programmercarl.greed;

/**
 * @ClassName MaxProfit2
 * @Descriotion TODO
 * @Author nitaotao
 * @Date 2022/7/18 17:47
 * @Version 1.0
 * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
 * 714. 买卖股票的最佳时机含手续费
 **/
public class MaxProfit2 {
    public int maxProfit(int[] prices, int fee) {
        int sum = 0;
        //当前最小收益
        int minProfit = prices[0];
        for (int i = 1; i < prices.length; i++) {
            //如果当前价位比最低价小，就记录最低价
            if (prices[i] < minProfit) {
                minProfit = prices[i];
            } else if (prices[i] > minProfit + fee) {
                //有收益就加上
                sum += prices[i] - minProfit - fee;
                //假设今天继续买当天的
                minProfit = prices[i] - fee;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new MaxProfit2().maxProfit(new int[]{1, 3, 2, 8, 4, 9}, 2));
        System.out.println(new MaxProfit2().maxProfit(new int[]{1, 3, 7, 5, 10, 3}, 3));
    }
}
