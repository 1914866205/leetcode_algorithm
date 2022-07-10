package com.programmercarl.backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @ClassName Subsets
 * @Descriotion TODO
 * @Author nitaotao
 * @Date 2022/7/10 18:16
 * @Version 1.0
 * https://leetcode.cn/problems/subsets/
 * 78. 子集
 **/
public class Subsets {
    List<List<Integer>> result = new ArrayList<>();
    Stack<Integer> stack = new Stack();

    public List<List<Integer>> subsets(int[] nums) {

        backtracking(nums, 0);
        System.out.println(result);
        return result;
    }

    /**
     * @param nums       数字数组
     * @param startIndex
     */
    public void backtracking(int[] nums, int startIndex) {
        //直接添加
        result.add(new ArrayList(stack));
        for (int i = startIndex; i < nums.length; i++) {
            stack.push(nums[i]);
            // 添加每次递归后的结果
            backtracking(nums, i + 1);
            //回溯
            stack.pop();
        }
    }

    public static void main(String[] args) {
        new Subsets().subsets(new int[]{1, 2, 3});
    }
}
