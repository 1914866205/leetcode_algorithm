package com.programmercarl.backtracking;

import java.util.*;

/**
 * @ClassName Partition
 * @Descriotion TODO
 * @Author nitaotao
 * @Date 2022/7/10 9:42
 * @Version 1.0
 * https://leetcode.cn/problems/palindrome-partitioning/
 * 131. 分割回文串
 **/
public class Partition {
    public static void main(String[] args) {
        System.out.println(new Partition().partition("aab"));
    }
    //结果集
    List<List<String>> result = new ArrayList<>();
    //每次分割到最后时的一轮结果集
    Stack<String> stack = new Stack();

    public List<List<String>> partition(String s) {
        backtracking(s, 0);
        return result;
    }

    /**
     *
     * @param s 源字符串
     * @param splitIndex 当前分割位置
     * 思路
     *     aab
     *     a
     *      a
     *       b
     *     aa
     *       b
     */
    public void backtracking(String s, int splitIndex) {
        //每轮的终止条件： 分割线移动到s的后面了
        if (splitIndex >= s.length()) {
            result.add(new ArrayList(stack));
            return;
        }
        for (int i = splitIndex; i < s.length(); i++) {
            //通过splitIndex和i+1分割每次的字符串
            if (isPartition(s, splitIndex, i + 1)) {
                stack.push(s.substring(splitIndex, i + 1));
            } else {
                continue;
            }
            //此处加1是为了原来的位置不再被使用
            //递归
            backtracking(s, i + 1);
            //回溯每次结果
            stack.pop();
        }
    }

    /**
     * 判断当前字符串指定范围是否是回文字符串
     * @param s
     * @param startIndex
     * @param endIndex
     * @return
     */
    public boolean isPartition(String s, int startIndex, int endIndex) {
        while (startIndex < endIndex) {
            if (s.charAt(startIndex) != s.charAt(endIndex-1)) {
                return false;
            }
            startIndex++;
            endIndex--;
        }
        return true;
    }
}
