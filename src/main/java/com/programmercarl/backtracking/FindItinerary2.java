package com.programmercarl.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName FindItinerary
 * @Descriotion TODO
 * @Author nitaotao
 * @Date 2022/7/11 21:14
 * @Version 2.0
 * https://leetcode.cn/problems/reconstruct-itinerary/
 * 332. 重新安排行程
 * 贪心算法思想
 *
 * 每步找到最优解
 *
 **/
public class FindItinerary2 {
    //结果集
    List<List<String>> result = new ArrayList<>();
    List<String> path = new ArrayList<>();
    List<String> to = new ArrayList<>();

    /**
     * 使用贪心算法思想，每次寻找最优解
     *
     * @param tickets
     * @return
     */

    public List<String> findItinerary(List<List<String>> tickets) {
        boolean[] used = new boolean[tickets.size()];
        // false 表示该车票没有用
        // true 表示该车票已经用了
        Arrays.fill(used, false);
        path.add("JFK");
        //获取所有机票
        backtracking(tickets, used, "JFK");
//        System.out.println(result);
        return result.get(0);
    }

    /**
     * @param tickets 所有车票
     * @param from    上一个出发的地方
     */
    public void backtracking(List<List<String>> tickets, boolean[] used, String from) {
        //找到最优解
        if (result.size() == 1) {
            return;
        }
        //如果规划好一个行程，则添加
        if (path.size() == tickets.size() + 1) {
            result.add(new ArrayList(path));
            return;
        }
        //找到当前机场的所有下一个机场
        for (int i = 0; i < tickets.size(); i++) {
            //如果该机票已经被使用，则跳过
            if (used[i]) {
                continue;
            }
            //如果该机票的出发地不是之前的降落地，则跳过
            if (!tickets.get(i).get(0).equals(from)) {
                continue;
            }
            //没有使用的，下一个机场
            //下一个机场的集合
            to.add(tickets.get(i).get(1));
        }
        if (to.size() == 0 && path.size() < tickets.size() + 1) {
            //此路不通
            return;
        }
        String minTo = getMinPath();
        to.clear();

        for (int i = 0; i < tickets.size(); i++) {
            if (used[i]) {
                continue;
            }
            //如果 to 不是 最优机场
            if (!tickets.get(i).get(1).equals(minTo)) {
                continue;
            }
            used[i] = true;
            path.add(minTo);
            // 降落地点要更新
            backtracking(tickets, used, minTo);
            //回溯
            used[i] = false;
            path.remove(path.size() - 1);
        }
    }


    //获取最近的机票
    public String getMinPath() {
        if (to.size() == 1) {
            return to.get(0);
        }
        char[] chars = new char[to.size()];
        char min = 'Z';
        //获取当前curIndex城市的字典第一位最小值
        for (int i = 0; i < to.size(); i++) {
            chars[i] = to.get(i).charAt(0);
            if (chars[i] < min) {
                min = chars[i];
            }
        }
        //凡是比这个值不一样的都删除
        List<String> temp = new ArrayList<>();
        for (int i = 0; i < to.size(); i++) {
            if (to.get(i).charAt(0) == min) {
                temp.add(to.get(i));
            }
        }
        to = temp;
        if (to.size() == 1) {
            return to.get(0);
        }
        min = 'Z';
        chars = new char[to.size()];
        //获取当前curIndex城市的字典第二位最小值
        for (int i = 0; i < to.size(); i++) {
            chars[i] = to.get(i).charAt(1);
            if (chars[i] < min) {
                min = chars[i];
            }
        }

        temp = new ArrayList<>();
        //凡是比这个值不一样的都删除
        for (int i = 0; i < to.size(); i++) {
            if (to.get(i).charAt(1) == min) {
                temp.add(to.get(i));
            }
        }
        to = temp;
        if (to.size() == 1) {
            return to.get(0);
        }
        min = 'Z';
        chars = new char[to.size()];
        //获取当前curIndex城市的字典第三位最小值
        for (int i = 0; i < to.size(); i++) {
            chars[i] = to.get(i).charAt(2);
            if (chars[i] < min) {
                min = chars[i];
            }
        }
        //凡是和这个值不一样的都删除
        temp = new ArrayList<>();
        for (int i = 0; i < to.size(); i++) {
            if (to.get(i).charAt(2) == min) {
                temp.add(to.get(i));
            }
        }
        to = temp;
        return to.get(0);
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
        System.out.println(new FindItinerary2().findItinerary(tickets));
    }
}
