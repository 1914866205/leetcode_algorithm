package com.programmercarl.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName CombinationSum2
 * @Descriotion TODO
 * @Author nitaotao
 * @Date 2022/7/9 13:03
 * @Version 1.0
 * https://leetcode.cn/problems/combination-sum-ii/
 * 40. 组合总和 II
 **/
public class CombinationSum2 {
    List<List<Integer>> result = new ArrayList<List<Integer>>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        //防止重复列表，保证生成列表唯一顺序
        Arrays.sort(candidates);
        backtracking(candidates, 0, target, 0, new ArrayList<>());
        return result;
    }

    /**
     * @param candidates 数字数组
     * @param sum        总和
     * @param target     目标值
     * @param index      递归索引起始值
     * @param list
     */
    public void backtracking(int[] candidates, int sum, int target, int index, List<Integer> list) {
        if (sum == target) {
            result.add(new ArrayList<>(list));
            return;
        }
        //剪枝操作，当 sum + candidates[i] >target 不进入
        for (int i = index; i < candidates.length; i++) {
            //如果当前和比目标值大，则返回。
            if (sum + candidates[i] > target) {
                break;
            }
            /**
             * 正确剔除重复解的办法
             * 跳过同一树层使用过的元素
             */
            if (i != index && candidates[i] == candidates[i - 1]) {
                continue;
            }
            list.add(candidates[i]);
            //    i+1 本元素不重复使用
            //    i   本元素可重复使用
            backtracking(candidates, sum + candidates[i], target, i + 1, list);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new CombinationSum2().combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
    }
}
