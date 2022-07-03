package com.programmercarl.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @ClassName MinDepth
 * @Descriotion TODO
 * @Author nitaotao
 * @Date 2022/7/3 22:32
 * @Version 1.0
 * 111. 二叉树的最小深度
 * https://leetcode.cn/problems/minimum-depth-of-binary-tree/
 **/
public class MinDepth {
    public int minDepth(TreeNode root) {
        //层序遍历，哪一行不满，即有缺省，则为最短深度
        int minDepth = 0;
        if (root == null) {
            return minDepth;
        }
        Deque<TreeNode> deque = new ArrayDeque<TreeNode>();
        deque.offer(root);
        int length = 1;
        while (!deque.isEmpty()) {
            int size = deque.size();
            boolean flag = false;
            while (size > 0) {
                root = deque.poll();
                //出现叶子结点
                if (root.left == null && root.right == null) {
                    flag = true;
                }
                if (root.left != null) {
                    deque.offer(root.left);
                }
                if (root.right != null) {
                    deque.offer(root.right);
                }
                size--;
            }
            length *= 2;
            minDepth++;
            if (deque.size() != length && flag) {
                return minDepth;
            }
        }
        return minDepth;
    }
}
