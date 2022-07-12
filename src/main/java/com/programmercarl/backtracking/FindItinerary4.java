package com.programmercarl.backtracking;

import java.util.*;

/**
 * @ClassName FindItinerary4
 * @Descriotion TODO
 * @Author nitaotao
 * @Date 2022/7/12 15:19
 * @Version 4.0
 * https://leetcode.cn/problems/reconstruct-itinerary/
 * 332. 重新安排行程
 **/
public class FindItinerary4 {
    //当前使用的票
    Stack<String> stack;
    //出发机场  目的机场集合{[目的机场1，机票数量1],[目的机场2，机票数量1]}
    Map<String, Map<String, Integer>> map;

    public List<String> findItinerary(List<List<String>> tickets) {
        stack = new Stack<>();
        map = new HashMap<String, Map<String, Integer>>();
        //遍历每一张机票
        for (List<String> ticket : tickets) {
            Map<String, Integer> curStart;
            //如果当前map中包含该 起始地 为键的 集合
            if (map.containsKey(ticket.get(0))) {
                curStart = map.get(ticket.get(0));
                //更新 当前 起始地 的 目标地 的机票数量，有则+1，无则为1
                curStart.put(ticket.get(1), curStart.getOrDefault(ticket.get(1), 0) + 1);
            } else {
                //保证其中元素按键升序存储
                curStart = new TreeMap<String, Integer>();
                curStart.put(ticket.get(1), 1);
            }
            //更新当前map中 当前 起始地 的 目标地 集合的数据
            map.put(ticket.get(0), curStart);
        }
        //以 JFK 为起始地
        stack.push("JFK");
        //获取机票结果集
        backtracking(tickets.size());
        return new ArrayList(stack);
    }

    /**
     * @param ticketsNum 需要用到的机票的数量
     * @return
     */
    public boolean backtracking(int ticketsNum) {
        // 五个城市 需要 四 个机票连接在一起
        if (stack.size() == ticketsNum + 1) {
            return true;
        }
        //起始地
        String startArea = stack.peek();
        //防止空指针
        if (map.containsKey(startArea)) {
            //获取 当前 出发地 的 所有 目的地 的机票 和 相关 剩余票数
            for (Map.Entry<String, Integer> ticket : map.get(startArea).entrySet()) {
                //当前目的地 的 剩余机票数量
                int remainSum = ticket.getValue();
                if (remainSum > 0) {
                    //当 本目的地 的 机票数量 > 0
                    //机票数量 - 1
                    ticket.setValue(remainSum - 1);
                    stack.push(ticket.getKey());
                    boolean isFind = backtracking(ticketsNum);
                    if (isFind) {
                        //如果找到一条路，就返回，因为treemap自动排序，是最优解
                        return true;
                    }
                    //回溯
                    stack.pop();
                    ticket.setValue(remainSum);
                }
            }
        }
        //此路不通，重新找最优路线
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
        System.out.println(new FindItinerary4().findItinerary(tickets));
    }
}
