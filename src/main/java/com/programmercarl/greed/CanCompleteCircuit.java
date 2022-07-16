package com.programmercarl.greed;

/**
 * @ClassName CanCompleteCircuit
 * @Descriotion TODO
 * @Author nitaotao
 * @Date 2022/7/16 9:02
 * @Version 1.0
 * https://leetcode.cn/problems/gas-station/
 * 134. 加油站
 **/
public class CanCompleteCircuit {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        //加油站编号
        int n = gas.length;
        //构建环型数组的一维化
        int[] gas2 = new int[2 * gas.length];
        int[] cost2 = new int[2 * cost.length];
        int gasSum = 0;
        int costSum = 0;
        for (int i = 0; i < n; i++) {
            if (gas[i] == 0 && cost[i] == 0) {
                continue;
            }
            gasSum += gas[i];
            costSum += cost[i];
            gas2[i] = gas[i];
            gas2[i + n] = gas[i];
            cost2[i] = cost[i];
            cost2[i + n] = cost[i];
        }
        if (gasSum < costSum) {
            return -1;
        }
        //当前车里的汽油
        int curGas = 0;
        for (int i = 0; i < n; i++) {
            if (gas2[i] == 0) {
                //没有初始油量
                //车子动不起来
                continue;
            }
//            System.out.println("----------------" + i + "----------------");
            boolean noEnd = false;
            //初始的汽车汽油容量
            curGas = gas2[i];
            for (int j = i; j < i + n - 1; j++) {
//                System.out.println("" + curGas + "-" + cost2[j] + "+" + gas2[j + 1]);
                curGas -= cost2[j];
                if (curGas < 0) {
                    //中间不够用
                    noEnd = true;
                    break;
                }
                curGas += gas2[j + 1];
            }
            //最后一步
            int temp = i + n - 1;
//            System.out.println("" + curGas + "-" + cost2[temp]);
            curGas = curGas - cost2[temp];

            if (curGas < 0) {
                //最后一步不够用
                noEnd = true;
            }

            if (!noEnd) {
                //够用
                return i;
            }
        }
        //都不够用
        return -1;
    }

    public int canCompleteCircuit2(int[] gas, int[] cost) {
        /**
         * 贪心思想
         */
        //当前油量
        int curSum = 0;
        int totalSum = 0;
        int start = 0;
        for (int i = start; i < gas.length; i++) {
            //当前剩余油量
            curSum += gas[i] - cost[i];
            //总耗油量
            totalSum += gas[i] - cost[i];
            //如果剩余油量<0，则不够开往下一站，则本起始点不可用，回溯
            if (curSum < 0) {
                curSum = 0;
                start = i + 1;
            }
        }
        //如果总加油站油量不够总行程
        if (totalSum < 0) {
            //则无法完成环型
            return -1;
        }
        return start;
    }


        public static void main(String[] args) {
        System.out.println(new CanCompleteCircuit().canCompleteCircuit2(new int[]{1, 2, 3, 4, 5}, new int[]{3, 4, 5, 1, 2}));
    }
}
