package com.programmercarl.stacks_queues;

import java.util.Stack;

/**
 * @ClassName IsValid
 * @Descriotion TODO
 * @Author nitaotao
 * @Date 2022/6/29 13:41
 * @Version 1.0
 * https://leetcode.cn/problems/valid-parentheses/
 * 20. 有效的括号
 **/
public class IsValid {
    public boolean isValid(String s) {
        /**
         * 显然这题用栈做
         */
        Stack stack = new Stack();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            //左符号加入栈中
            if (chars[i] == '(' || chars[i] == '[' || chars[i] == '{') {
                stack.push(chars[i]);
            } else {
                //如果直接是右括号开头，返回false
                if (stack.size() == 0) {
                    return false;
                }
                char item = (char) stack.pop();
                switch (item) {
                    case '(':
                        if (chars[i] != ')') {
                            return false;
                        }
                        break;
                    case '[':
                        if (chars[i] != ']') {
                            return false;
                        }
                        break;
                    case '{':
                        if (chars[i] != '}') {
                            return false;
                        }
                        break;
                }
            }
        }
        return stack.size() == 0;
    }
}
