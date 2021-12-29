package com.demo.course.mid.problem07;

import java.util.LinkedList;

/**
 * author: nitaotao
 * date: 2021/12/22 15:09
 * version: 1.0
 *  有效的括号
 * description: https://leetcode-cn.com/problems/valid-parentheses/submissions/
 * 【解题思路】： 先把字符串转为字符数组，如果长度不是偶数，一定不是有效的括号; 如果是左括号，添
 * 加到栈中，如果不是，则先判断是不是空栈，如果是，则说明第一个进来的是右括号，则不是有效的括号，
 * 若不是空栈，栈首元素退栈，针对三种不同的右括号进行相应的匹配，不匹配则不是有效的括号。最后，
 * 如果到最后所有右括号都匹配完了，仍存在左括号在栈中，则不是有效的括号。
 */
public class Solution {
    public static void main(String[] args) {
        String s = ")(";
        Solution solution = new Solution();
        System.out.println(solution.isValid(s));

    }

    /**
     * 判断是否是有效的括号
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
        LinkedList queue = new LinkedList(); //栈结构 参考java api 1.6
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
                String left = (String) queue.remove();  //删除栈顶元素，并返回当前元素
                //当前传来的字符和弹出的字符做匹配，如果匹配，则继续，否则返回匹配失败
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
        //最后如果栈不空，说明有左括号在栈中，而有括号已经被匹配完，则数量不一致，返回false
        if (queue.size() != 0) {
            return false;
        }
        return true;
    }
}
