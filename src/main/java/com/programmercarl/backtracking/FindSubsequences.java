package com.programmercarl.backtracking;

import java.util.*;

/**
 * @ClassName FindSubsequences
 * @Descriotion TODO
 * @Author nitaotao
 * @Date 2022/7/11 10:06
 * @Version 1.0
 * https://leetcode.cn/problems/increasing-subsequences/
 * 491. 递增子序列
 **/
public class FindSubsequences {
    //结果集
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    Stack<Integer> stack = new Stack();

    public List<List<Integer>> findSubsequences(int[] nums) {
        //至少有两个元素
        if (nums.length < 2) {
            return result;
        }
        backtracking(nums, 0);
        return result;
    }

    public void backtracking(int[] nums, int startIndex) {
        if (stack.size() > 1) {
            result.add(new ArrayList(stack));
        }
        //每层中加入set去重，当本层某个元素已经用过了，就跳过
        HashSet<Integer> set = new HashSet<>();
        for (int i = startIndex; i < nums.length - 1; i++) {
            //同父元素结点下重复使用 某 数，跳过
            if (set.contains(nums[i])) {
                continue;
            }
            set.add(nums[i]);
            //跳过当前层相同的元素
            if (i != startIndex && nums[i] == nums[i - 1]) {
                continue;
            }

            //如果当前元素比前一个大或等于，则添加，否则跳过
            //空栈，则添加
            if (stack.isEmpty()) {
                stack.push(nums[i]);
            } else if (stack.peek() <= nums[i]) {
                stack.push(nums[i]);
            } else {
                continue;
            }
            //递归
            backtracking(nums, i + 1);
            //回溯
            stack.pop();

        }
    }

    public static void main(String[] args) {
        System.out.println(new FindSubsequences().findSubsequences(new int[]{1, 2, 3, 1, 1, 1, 1}));
    }
}
