package com.programmercarl.backtracking;

import java.util.*;

/**
 * @ClassName FindItinerary
 * @Descriotion TODO
 * @Author nitaotao
 * @Date 2022/7/11 21:14
 * @Version 3.0
 * https://leetcode.cn/problems/reconstruct-itinerary/
 * 332. 重新安排行程
 **/
public class FindItinerary3 {
    Stack<String> stack;
    // 出发机场   到达机场  航班次数
    //通过航班次数来判断当前到达机场是否使用过了
    Map<String, Map<String, Integer>> map;

    public List<String> findItinerary(List<List<String>> tickets) {
        // 出发机场   到达机场  航班次数
        map = new HashMap<String, Map<String, Integer>>();
        stack = new Stack<>();
        for (List<String> ticket : tickets) {
            // 目的机场，班次数量
            Map<String, Integer> temp;
            if (map.containsKey(ticket.get(0))) {
                //如果map包含当前出发机场
                temp = map.get(ticket.get(0));
                //则当前出发机场的目的机场的班次+1
                //如果没有这个 ticket.get(1) 的目的机场，就添加一个，默认是0+1
                // 如果有，就获取其值，然后+1，再更新
                temp.put(ticket.get(1), temp.getOrDefault(ticket.get(1), 0) + 1);
            } else {
                //如果没有这个出发机场
                temp = new TreeMap<>();
                //就添加这个map，把目的机场信息加上
                temp.put(ticket.get(1), 1);
            }
            // map 键：出发机场  值 ：目标机场集
            //   如  key   JFK     值   TreeMap    值以 treemap存储，自动升序
            //                          ATL      1
            //                          SFO      1
            //更新出发机场的map
            map.put(ticket.get(0), temp);
        }
        //初始机场
        stack.push("JFK");
        backtracking(tickets.size());
        return new ArrayList(stack);
    }


    /**
     * @param ticketNum 机票数量
     * @return
     */
    public boolean backtracking(int ticketNum) {
        // stack有六个元素时，说明用了五个机票
        if (stack.size() == ticketNum + 1) {
            //如果已使用票数和一共需要用的票数相等，则返回
            return true;
        }
        //获取队尾元素
        String last = stack.peek();
        //防止出现null
        if (map.containsKey(last)) {
            for (Map.Entry<String, Integer> target : map.get(last).entrySet()) {
                //获取 出发地为 last 的 所有 目的地 机票及数量
                //机票数量
                int count = target.getValue();
                //如果机票还有
                if (count > 0) {
                    //如果还有航班次数
                    //使用当前机票
                    stack.push(target.getKey());
                    //可使用航班次数 - 1
                    target.setValue(count - 1);
                    //递归
                    //如果找到一条路径，因为 treemap 默认最优解，直接返回
                    boolean isEnd = backtracking(ticketNum);
                    if (isEnd) {
                        return true;
                    }
                    //回溯
                    stack.pop();
                    target.setValue(count);
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        List<List<String>> tickets = new ArrayList<List<String>>();
        ArrayList ticket1 = new ArrayList<ArrayList>();
        ArrayList ticket2 = new ArrayList<ArrayList>();
        ArrayList ticket3 = new ArrayList<ArrayList>();
        ArrayList ticket4 = new ArrayList<ArrayList>();
        ArrayList ticket5 = new ArrayList<ArrayList>();
        ticket1.add("JFK");
        ticket1.add("SFO");
        ticket2.add("JFK");
        ticket2.add("ATL");
        ticket3.add("SFO");
        ticket3.add("ATL");
        ticket4.add("ATL");
        ticket4.add("JFK");
        ticket5.add("ATL");
        ticket5.add("SFO");
        tickets.add(ticket1);
        tickets.add(ticket2);
        tickets.add(ticket3);
        tickets.add(ticket4);
        tickets.add(ticket5);
        System.out.println(tickets);
        System.out.println(new FindItinerary3().findItinerary(tickets));
    }
}