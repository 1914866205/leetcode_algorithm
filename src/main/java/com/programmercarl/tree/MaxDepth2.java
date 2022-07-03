package com.programmercarl.tree;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @ClassName MaxDepth2
 * @Descriotion TODO
 * @Author nitaotao
 * @Date 2022/7/3 22:24
 * @Version 1.0
 * 559. N 叉树的最大深度
 * https://leetcode.cn/problems/maximum-depth-of-n-ary-tree/
 **/
public class MaxDepth2 {
    public int maxDepth(Node root) {
        int maxDepth = 0;
        if (root == null) {
            return maxDepth;
        }
        Deque<Node> deque = new ArrayDeque<Node>();
        //层次遍历当前树，一层深度+1
        deque.offer(root);
        while (!deque.isEmpty()) {
            //这句话是核心， size是控制每层有多少元素的变量
            int size = deque.size();
            maxDepth++;
            while (size > 0) {
                root = deque.poll();
                for (Node item : root.children) {
                    deque.offer(item);
                }
                size--;
            }
        }
        return maxDepth;
    }
}
