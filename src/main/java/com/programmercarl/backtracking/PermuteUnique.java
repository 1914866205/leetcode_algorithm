package com.programmercarl.backtracking;

import java.util.*;

/**
 * @ClassName PermuteUnique
 * @Descriotion TODO
 * @Author nitaotao
 * @Date 2022/7/11 13:03
 * @Version 1.0
 * https://leetcode.cn/problems/permutations-ii/
 * 47. 全排列 II
 **/
public class PermuteUnique {
    /**
     * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
     *
     * @param nums
     * @return
     */
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        //先排序
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        // true 代表被使用过，false 代表没被用过
        Arrays.fill(used, false);
        backtracking(nums, used);
        return result;
    }

    public void backtracking(int[] nums, boolean[] used) {
        if (nums.length == path.size()) {
            result.add(new ArrayList(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            //如果当前元素和之前元素一样，并且   之前的元素被使用过
            if (i > 0 && nums[i] == nums[i - 1] && used[i-1]) {
                continue;
            }
            if (!used[i]) {
                //如果没被使用
                used[i] = true;
                path.add(nums[i]);
                backtracking(nums, used);
                //回溯
                used[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new PermuteUnique().permuteUnique(new int[]{1, 1, 2}));
    }
}
