package com.programmercarl.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @ClassName FindItinerary
 * @Descriotion TODO
 * @Author nitaotao
 * @Date 2022/7/11 21:14
 * @Version 1.0
 * https://leetcode.cn/problems/reconstruct-itinerary/
 * 332. 重新安排行程
 **/
public class FindItinerary {
    //结果集
    List<List<String>> result = new ArrayList<>();
    List<String> path = new ArrayList<>();

    //删除多于的机票
    public void getMinPath(int startIndex) {
        if (result.size() == 1) {
            return;
        }
        String min = result.get(0).get(startIndex);
        System.out.println("当前最小值：" + min);
        //城市列表循环
        for (int i = 0; i < result.get(0).size(); i++) {
            //城市路径循环
            for (int j = startIndex; j < result.size(); j++) {
                System.out.println();
                //前者为最小值
                int temp = min(min, result.get(j).get(i));
                if (temp == 0) {
                    //和最小值相等，不变
                    continue;
                } else if (temp == 1) {
                    //比最小值大,删除当前值
                    System.out.println("比最小值大,删除当前值:" + result.get(j).get(i));
                    result.remove(j);
                    System.out.println(result);
                    getMinPath(startIndex);
                    return;
                } else if(temp==2){
                    //比最小值小
                    System.out.println("比最小值小,删除原最小值:" + result.get(startIndex).get(i));
                    result.remove(startIndex);
                    System.out.println(result);
                    getMinPath(j);
                    return;
                }
            }
        }
    }

    public int min(String city1, String city2) {
        for (int i = 0; i < city1.length(); i++) {
            if (city1.charAt(i) < city2.charAt(i)) {
                return 1;
            } else if (city1.charAt(i) > city2.charAt(i)) {
                return 2;
            }
        }
        //若相等，返回0
        return 0;
    }


    public List<String> findItinerary(List<List<String>> tickets) {
        boolean[] used = new boolean[tickets.size()];
        // false 表示该车票没有用
        // true 表示该车票已经用了
        Arrays.fill(used, false);
        path.add("JFK");
        //获取所有机票
        backtracking(tickets, used, "JFK");
        System.out.println(result);
        //删除多于的机票。得到最小路径机票
        getMinPath(0);
        System.out.println(result);
        return result.get(0);
    }

    /**
     * @param tickets 所有车票
     * @param from    上一个出发的地方
     */
    public void backtracking(List<List<String>> tickets, boolean[] used, String from) {
        //如果规划好一个行程，则添加
        if (path.size() == tickets.size() + 1) {
            result.add(new ArrayList(path));
            return;
        }
        for (int i = 0; i < tickets.size(); i++) {
            //如果该机票已经被使用，则跳过
            if (used[i]) {
                continue;
            }
            //如果该机票的出发地不是之前的降落地，则返回
            if (!tickets.get(i).get(0).equals(from)) {
                continue;
            }
            used[i] = true;
            path.add(tickets.get(i).get(1));
            // 降落地点要更新
            backtracking(tickets, used, tickets.get(i).get(1));
            //回溯
            used[i] = false;
            path.remove(path.size() - 1);
        }
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
        new FindItinerary().findItinerary(tickets);

//        List<List<String>> tickets = new ArrayList<List<String>>();
//        ArrayList ticket1 = new ArrayList<ArrayList>();
//        ArrayList ticket2 = new ArrayList<ArrayList>();
//        ArrayList ticket3 = new ArrayList<ArrayList>();
//        ArrayList ticket4 = new ArrayList<ArrayList>();
//        ticket1.add("MUC");
//        ticket1.add("LHR");
//        ticket2.add("JFK");
//        ticket2.add("MUC");
//        ticket3.add("SFO");
//        ticket3.add("SJC");
//        ticket4.add("LHR");
//        ticket4.add("SFO");
//        tickets.add(ticket1);
//        tickets.add(ticket2);
//        tickets.add(ticket3);
//        tickets.add(ticket4);
//        System.out.println(tickets);
//        new FindItinerary().findItinerary(tickets);
        System.out.println(new FindItinerary().min("JFK", "SFO"));
    }
}
