package com.programmercarl.stacks_queues;

import java.util.Stack;

/**
 * @ClassName RemoveDuplicates
 * @Descriotion TODO
 * @Author nitaotao
 * @Date 2022/6/29 18:04
 * @Version 1.0
 * https://leetcode.cn/problems/remove-all-adjacent-duplicates-in-string/
 * 1047. 删除字符串中的所有相邻重复项
 **/
public class RemoveDuplicates {
    /**
     * 这题双指针法能做，栈也能做
     *
     * @param s
     * @return
     */
    public static String removeDuplicates(String s) {
        String result = "";
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack();
        for (int i = chars.length - 1; i >= 0; i--) {
            //无元素时直接入栈
            if (stack.size() == 0) {
                stack.push(chars[i]);
            } else if (stack.peek() != chars[i]) {
                //如果当前元素和栈顶元素不同，入栈
                stack.push(chars[i]);
            } else {
                stack.pop();
            }
        }
        while (stack.size() != 0) {
            result += stack.pop();
        }
        return result;
    }

    public static String removeDuplicates2(String s) {
         char[] chars = s.toCharArray();
        int right = 0;
        int left = 0;
        while (right < s.length()) {
            chars[left] = chars[right];
            if (left > 0 && chars[left] == chars[left - 1]) {
                left--;
            } else {
                left++;
            }
            right++;
        }
        return new String(chars, 0, left);
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates2("aababaab"));
    }
}
