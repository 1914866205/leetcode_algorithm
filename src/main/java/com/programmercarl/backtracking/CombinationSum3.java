package com.programmercarl.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName CombinationSum3
 * @Descriotion TODO
 * @Author nitaotao
 * @Date 2022/7/8 15:36
 * @Version 1.0
 * https://leetcode.cn/problems/combination-sum-iii/
 * 216. 组合总和 III
 **/
public class CombinationSum3 {
    public static void main(String[] args) {
        System.out.println(new CombinationSum3().combinationSum3(3, 9));
    }

    //最终结果集
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<Integer> list = new ArrayList<>();
        //从1开始
        backtracking(k, n, list,1);
        return result;
    }

    //记录总和
    int sum = 0;

    /**
     *
     * @param k 数字个数
     * @param n 目标数字
     * @param list 临时结果集
     * @param t 当前位置
     */
    public void backtracking(int k, int n, List<Integer> list,int t) {
        System.out.println(sum);
        //升序加，如果当前结果超出目标值，则返回
        if (sum > n) {
            return;
        }
        //只要当前结果等于目标集 并且 数字的数量和目标数字相等时，才返回结果
        if (sum == n && k == list.size()) {
            result.add(new ArrayList<>(list));
            return;
        }
        //数字范围 1 - 9
        for (int i = t; i <= 9; i++) {
            //用过的数字就不用了
            if (list.contains(i)) {
                continue;
            }
            //开始递归
            list.add(i);
            sum += i;
            t++;
            backtracking(k, n, list, t);
            //开始迭代
            sum -= list.get(list.size() - 1);
            list.remove(list.size() - 1);
        }
    }
}
