package com.programmercarl.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName FindItinerary
 * @Descriotion TODO
 * @Author nitaotao
 * @Date 2022/7/11 21:14
 * @Version 1.0
 * https://leetcode.cn/problems/reconstruct-itinerary/
 * 332. 重新安排行程
 *
 * 找到所有结果
 * 筛选最小路径
 *
 **/
public class FindItinerary1 {
    //结果集
    List<List<String>> result = new ArrayList<>();
    List<String> path = new ArrayList<>();


    public List<String> findItinerary(List<List<String>> tickets) {
        boolean[] used = new boolean[tickets.size()];
        // false 表示该车票没有用
        // true 表示该车票已经用了
        Arrays.fill(used, false);
        path.add("JFK");
        //获取所有机票
        backtracking(tickets, used, "JFK");
//        System.out.println(result);
        //删除多于的机票。得到最小路径机票
        getMinPath(0);
        System.out.println("最终结果：" + result);
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


    //删除多于的机票
    public void getMinPath(int curIndex) {
        if (result.size() == 1) {
            return;
        }
        char[] chars = new char[result.size()];
        char min = 'Z';
        //获取当前curIndex城市的字典第一位最小值
        for (int i = 0; i < result.size(); i++) {
            chars[i] = result.get(i).get(curIndex).charAt(0);
            if (chars[i] < min) {
                min = chars[i];
            }
        }
        //凡是比这个值不一样的都删除
        List<List<String>> temp = new ArrayList<>();
        for (int i = 0; i < result.size(); i++) {
            if (result.get(i).get(curIndex).charAt(0) == min) {
                temp.add(new ArrayList<>(result.get(i)));
            }
        }
        result = temp;



        min = 'Z';
        //获取当前curIndex城市的字典第二位最小值
        for (int i = 0; i < result.size(); i++) {
            chars[i] = result.get(i).get(curIndex).charAt(1);
            if (chars[i] < min) {
                min = chars[i];
            }
        }


        temp = new ArrayList<>();
        //凡是比这个值不一样的都删除
        for (int i = 0; i < result.size(); i++) {
            if (result.get(i).get(curIndex).charAt(1) == min) {
                temp.add(new ArrayList<>(result.get(i)));
            }
        }
        result = temp;

        min = 'Z';
        //获取当前curIndex城市的字典第三位最小值
        for (int i = 0; i < result.size(); i++) {
            chars[i] = result.get(i).get(curIndex).charAt(2);
            System.out.println(chars[i]);
            if (chars[i] < min) {
                min = chars[i];
            }
        }
        temp = new ArrayList<>();
        //凡是比这个值不一样的都删除

        for (int i = 0; i < result.size(); i++) {
            if (result.get(i).get(curIndex).charAt(2) == min) {
                temp.add(new ArrayList<>(result.get(i)));
            }
        }
        result = temp;

        curIndex++;
        if (curIndex == result.get(0).size()) {
            return;
        }
        getMinPath(curIndex);
    }


}