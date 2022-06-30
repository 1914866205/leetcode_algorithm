package com.programmercarl.stacks_queues;

import java.util.Stack;

/**
 * @ClassName EvalRPN
 * @Descriotion TODO
 * @Author nitaotao
 * @Date 2022/6/30 13:26
 * @Version 1.0
 * https://leetcode.cn/problems/evaluate-reverse-polish-notation/
 * 150. 逆波兰表达式求值
 **/
public class EvalRPN {
    public int evalRPN(String[] tokens) {
        Stack stack = new Stack();
        for (int i = 0; i < tokens.length; i++) {
            switch (tokens[i]) {
                case "+":
                    //加数
                    Integer num1 = Integer.valueOf((String) stack.pop());
                    //被加数
                    Integer num2 = Integer.valueOf((String) stack.pop());
                    stack.push(String.valueOf(num2 + num1));
                    break;
                case "-":
                    //减数
                    Integer num3 = Integer.valueOf((String) stack.pop());
                    //被减数
                    Integer num4 = Integer.valueOf((String) stack.pop());
                    stack.push(String.valueOf(num4 - num3));
                    break;
                case "*":
                    //乘数
                    Integer num5 = Integer.valueOf((String) stack.pop());
                    //被乘数
                    Integer num6 = Integer.valueOf((String) stack.pop());
                    stack.push(String.valueOf(num6 * num5));
                    break;
                case "/":
                    //除数
                    Integer num7 = Integer.valueOf((String) stack.pop());
                    //被除数
                    Integer num8 = Integer.valueOf((String) stack.pop());
                    stack.push(String.valueOf(num8 / num7));
                    break;
                default:
                    stack.push(tokens[i]);
            }
        }
        return Integer.valueOf((String) stack.pop());
    }
}
