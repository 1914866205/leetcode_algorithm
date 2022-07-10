package com.programmercarl.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @ClassName SubsetsWithDup
 * @Descriotion TODO
 * @Author nitaotao
 * @Date 2022/7/10 20:35
 * @Version 1.0
 * https://leetcode.cn/problems/subsets-ii/
 * 90. 子集 II
 **/
public class SubsetsWithDup {
    public static void main(String[] args) {
        new SubsetsWithDup().subsetsWithDup(new int[]{1, 1, 2, 2});
    }

    List<List<Integer>> result = new ArrayList<List<Integer>>();
    Stack<Integer> stack = new Stack();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backtracking(nums, 0);
        System.out.println(result);
        return result;
    }

    /**
     * @param nums
     * @param startIndex 树的深度/纵向遍历时的层数
     *                   i 同层横向
     */
    public void backtracking(int[] nums, int startIndex) {
        System.out.println("添加：" + stack);
        result.add(new ArrayList(stack));

        for (int i = startIndex; i < nums.length; i++) {
            //和上一题不同，这题可能会出现重复元素
            // 跳过当前层中相同的元素
            // 当 startIndex==i 时，才是基础层，
            // 当startIndex!=i时，是在基础层上变化出来的层，
            //所以只有基础层添加了一次，延伸层不再添加。
            if (i !=startIndex && nums[i] == nums[i - 1]){
                continue;
            }
            stack.push(nums[i]);
            backtracking(nums, i + 1);
            stack.pop();
        }
    }
}
