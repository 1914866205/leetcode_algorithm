package com.demo.course.mid.problem07;

import java.util.LinkedList;

/**
 * author: nitaotao
 * date: 2021/12/22 15:09
 * version: 1.0
 * description: https://leetcode-cn.com/problems/valid-parentheses/submissions/
 */
public class Solution {
    public static void main(String[] args) {
        String s = ")(";
        Solution solution = new Solution();
        System.out.println(solution.isValid(s));

    }

    /**
     * 判断是否是有效的括号
     *
     * @param s 括号串
     * @return
     */
    public boolean isValid(String s) {
        String[] arr = s.split("");
        if (arr.length % 2 != 0) {
            //如果不是偶数，必有一个不匹配
            return false;
        }
        // ( [ {  为进   ) ] }为出
        LinkedList queue = new LinkedList(); //栈结构
//        for (int i = 0; i < arr.length; i++) {
//            System.out.print(arr[i]);
//        }
//        System.out.println();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals("{") || arr[i].equals("[") || arr[i].equals("(")) {
                queue.addFirst(arr[i]);
            } else {
                //如果先进来的是右括号
                if (queue.size() == 0) {
                    return false;
                }
                String left = (String) queue.remove();


                if (left.equals("{")) {
                    if (arr[i].equals("}")) {
                        continue;
                    } else {
                        return false;
                    }
                } else if (left.equals("[")) {
                    if (arr[i].equals("]")) {
                        continue;
                    } else {
                        return false;
                    }
                } else if (left.equals("(")) {
                    if (arr[i].equals(")")) {
                        continue;
                    } else {
                        return false;
                    }
                }
            }
        }
        if (queue.size() != 0) {
            return false;
        }
        return true;
    }
}
