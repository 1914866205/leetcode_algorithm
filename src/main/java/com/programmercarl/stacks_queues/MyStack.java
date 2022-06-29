package com.programmercarl.stacks_queues;


import java.util.ArrayDeque;
/**
 * @ClassName MyStack
 * @Descriotion TODO
 * @Author nitaotao
 * @Date 2022/6/29 12:10
 * @Version 1.0
 * https://leetcode.cn/problems/implement-stack-using-queues/
 * 225. 用队列实现栈
 * 思路：
 * 栈 先进后出  只能A端进，A端出
 * 队列 先进先出 只能A端进，B端出
 * pop 栈尾出元素
 * push 栈尾入元素
 * peek 查看栈首元素
 *
 * offer 队尾入元素
 * poll 队头出元素
 * peek 查看队列元素
 *
 *
 **/
public class MyStack {
    //源队列
    private ArrayDeque queueOrigin;
    //复制队列
    private ArrayDeque queueCopy;
    public MyStack() {
        queueOrigin = new ArrayDeque();
        queueCopy = new ArrayDeque();
    }

    /**
     * 推入一个元素
     * @param x
     */
    public void push(int x) {
        //源队列尾部推入数据
        queueOrigin.offer(x);
    }

    /**
     * 推出一个元素
     * @return
     */
    public int pop() {
        /**
         * 源队列把除了 最后一个元素，其余所有元素推入复制队列
         */
        int lenOrigin = queueOrigin.size();
        while (lenOrigin > 1) {
            queueCopy.offer(queueOrigin.poll());
            lenOrigin--;
        }
        //获取要推出的值
        int result = (int) queueOrigin.poll();
        /**
         * 复制队列再把所有元素推入原队列
         */
        int lenCopy = queueCopy.size();
        while (lenCopy > 0) {
            queueOrigin.offer(queueCopy.poll());
            lenCopy--;
        }
        return result;
    }

    /**
     * 查看顶部元素
     * @return
     */
    public int top() {
        /**
         * 源队列把除了 最后一个元素，其余所有元素推入复制队列
         */
        int lenOrigin = queueOrigin.size();
        while (lenOrigin > 1) {
            queueCopy.offer(queueOrigin.poll());
            lenOrigin--;
        }
        //获取要推出的值
        int result = (int) queueOrigin.peek();
        queueCopy.offer(queueOrigin.poll());
        /**
         * 复制队列再把所有元素推入原队列
         */
        int lenCopy = queueCopy.size();
        while (lenCopy > 0) {
            queueOrigin.offer(queueCopy.poll());
            lenCopy--;
        }
        return result;
    }

    /**
     * 判空
     * @return
     */
    public boolean empty() {
        return queueOrigin.size() == 0;
    }
}
