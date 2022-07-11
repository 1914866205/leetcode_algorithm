package com.programmercarl.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @ClassName Permute
 * @Descriotion TODO
 * @Author nitaotao
 * @Date 2022/7/11 11:40
 * @Version 1.0
 * https://leetcode.cn/problems/permutations/
 * 46. 全排列
 **/
public class Permute {
    List<List<Integer>> result = new ArrayList<List<Integer>>();

    public List<List<Integer>> permute(int[] nums) {
        /**
         * 回溯，当到最大深度则返回，不可重复
         */
        backtracking(nums, new ArrayList<Integer>());
        return result;
    }

    public void backtracking(int[] nums, ArrayList<Integer> list) {
        if (list.size() == nums.length) {
            //当到达最大深度，则返回
            result.add(new ArrayList(list));
            return;
        }
        //   每层都要从0开始
        for (int i = 0; i < nums.length; i++) {
            //如果元素已经添加，则跳过
            if (list.contains(nums[i])) {
                continue;
            }
            list.add(nums[i]);
            //不可重复，深度增加
            backtracking(nums, list);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Permute().permute(new int[]{0,1}));
    }
}
