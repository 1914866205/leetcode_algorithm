package com.programmercarl.stacks_queues;

import java.util.Stack;

/**
 * @ClassName MyQueue
 * @Descriotion TODO
 * @Author nitaotao
 * @Date 2022/6/29 10:57
 * @Version 1.0
 * 232. 用栈实现队列
 * https://leetcode.cn/problems/implement-queue-using-stacks/
 * 思路：
 * 栈，先进后出
 * 队列，先进先出
 * 栈模拟队列，一个元素从第一个栈入，出来后再推入第二个栈，则 先进 后出  后进 先出 ==  先进 先出
 **/
public class MyQueue {
    private Stack stackIn;
    private Stack stackOut;

    public MyQueue() {
        stackIn = new Stack();
        stackOut = new Stack();
    }

    /**
     * 推入一个元素
     *
     * @param x
     */
    public void push(int x) {
        stackIn.push(x);
    }

    /**
     * 返回栈顶元素
     *
     * @return
     */
    public int pop() {
        int lenIn = stackIn.size();
        int lenOut = stackOut.size();
        //老区先出完，新区再进
        if (lenOut > 0) {
            return (int) stackOut.pop();
        } else {
            //老区无元素，新区进老区
            while (lenIn > 0) {
                stackOut.push(stackIn.pop());
                lenIn--;
            }
            return (int) stackOut.pop();
        }
    }

    /**
     * 查看栈顶元素
     *
     * @return
     */
    public int peek() {
        int lenIn = stackIn.size();
        int lenOut = stackOut.size();
        //老区先出完，新区再进
        if (lenOut > 0) {
            return (int) stackOut.peek();
        } else {
            //老区无元素，新区进老区
            while (lenIn > 0) {
                stackOut.push(stackIn.pop());
                lenIn--;
            }
            return (int) stackOut.peek();
        }
    }

    /**
     * 判空
     *
     * @return
     */
    public boolean empty() {
        return stackIn.isEmpty() && stackOut.isEmpty();
    }
}
