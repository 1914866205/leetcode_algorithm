package com.programmercarl.backtracking;

import java.util.*;

/**
 * @ClassName CombinationSum
 * @Descriotion TODO
 * @Author nitaotao
 * @Date 2022/7/9 9:27
 * @Version 1.0
 * https://leetcode.cn/problems/combination-sum/
 * 39. 组合总和
 * 给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。
 * candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。 
 * 对于给定的输入，保证和为 target 的不同组合数少于 150 个。
 **/
public class CombinationSum {

//    List<List<Integer>> result = new ArrayList<List<Integer>>();
//
//    public List<List<Integer>> combinationSum(int[] candidates, int target) {
//        backtracking(new ArrayList<Integer>(), candidates, target,0);
//        return result;
//    }
//
//    /**
//     * @param candidates 选数字的数组
//     * @param target     数字之和目标值
//     * @param startIndex
//     */
//    int sum = 0;
//
//    public void backtracking(List<Integer> list, int[] candidates, int target,int index) {
//        //超出结果值就不用加了
//        if (sum > target) {
//            return;
//        }
//        //返回 和为sum的结果集
//        if (sum == target) {
//            List<Integer> temp = new ArrayList<Integer>(list);
//            //不可在原集合上直接排序，否则会打乱回溯顺序
//            Collections.sort(temp);
//            //如果存在已经重复的结果
//            if (!removeRep(result, temp)) {
//                return;
//            }
//            result.add(new ArrayList<>(temp));
//            return;
//        }
//        for (int i = index; i < candidates.length; i++) {
//            //累加sum，添加元素到集合
//            list.add(candidates[i]);
//            sum += candidates[i];
//            //递归
//            backtracking(list, candidates, target,i);
//            //回溯
//            sum -= candidates[i];
//            list.remove(list.size() - 1);
//        }
//    }
//
//    /**
//     * 结果集去重
//     *
//     * @param result
//     * @param list
//     * @return
//     * false:结果集存在 , 不可添加
//     * true:结果集不存在，可添加
//     */
//    public boolean removeRep(List<List<Integer>> result, List<Integer> list) {
//        for (List<Integer> item : result) {
//            //如果两个 list  完全相同
//            if (isSameList(list, item)) {
//                return false;
//            }
//        }
//        //都不相同，可以添加
//        return true;
//    }
//
//
//    /**
//     * 两个集合元素是否完全相同
//     *
//     * @param list1
//     * @param list2
//     * @return
//     */
//    public boolean isSameList(List<Integer> list1, List<Integer> list2) {
//        if (list1.size() != list2.size()) {
//            return false;
//        }
//        for (int i = 0; i < list1.size(); i++) {
//            if (list1.get(i) != list2.get(i)) {
//                return false;
//            }
//        }
//        return true;
//    }


    List<List<Integer>> result = new ArrayList<List<Integer>>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        //排序后生成的列表顺序都一样了，这点很重要，不用再去去重
        Arrays.sort(candidates); // 先进行排序
        backtracking(new ArrayList<Integer>(), candidates, target, 0);
        return result;
    }

    /**
     * @param candidates 选数字的数组
     * @param target     数字之和目标值
     * @param startIndex
     */
    int sum = 0;

    public void backtracking(List<Integer> list, int[] candidates, int target, int startIndex) {
        //返回 和为sum的结果集
        if (sum == target) {
            System.out.println(list);
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = startIndex; i < candidates.length; i++) {
            //累加sum，添加元素到集合
            if (sum + candidates[i] > target) {
                break;
            }
            sum += candidates[i];
            list.add(candidates[i]);
            //递归 当前元素使用过后，依次往后使用，不再往前来
            backtracking(list, candidates, target, i);
            //回溯
            sum -= candidates[i];
            list.remove(list.size() - 1);
        }
    }


    public static void main(String[] args) {
        System.out.println(new CombinationSum().combinationSum(new int[]{2, 3, 6, 7}, 7));

    }
}
