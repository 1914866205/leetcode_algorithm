package com.programmercarl.tree;

import java.util.*;

/**
 * @ClassName MaxDepth
 * @Descriotion TODO
 * @Author nitaotao
 * @Date 2022/7/3 20:39
 * @Version 1.0
 * https://leetcode.cn/problems/maximum-depth-of-binary-tree/
 * 104. 二叉树的最大深度
 **/
public class MaxDepth {
    public int maxDepth(TreeNode root) {
        int maxDepth = 0;
        if (root == null) {
            return maxDepth;
        }
        Deque<TreeNode> deque = new ArrayDeque<TreeNode>();
        //层次遍历当前树，一层深度+1
        deque.offer(root);
        while (!deque.isEmpty()) {
            //这句话是核心， size是控制每层有多少元素的变量
            int size = deque.size();
            maxDepth++;
            while (size > 0) {
                root = deque.poll();
                if (root.left != null) {
                    deque.offer(root.left);
                }
                if (root.right != null) {
                    deque.offer(root.right);
                }
                size--;
            }
        }
        return maxDepth;
    }
}
