package com.programmercarl.tree;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @ClassName CountNodes
 * @Descriotion TODO
 * @Author nitaotao
 * @Date 2022/7/4 10:15
 * @Version 1.0
 * https://leetcode.cn/problems/count-complete-tree-nodes/
 * 222. 完全二叉树的节点个数
 **/
public class CountNodes {
    public int countNodes2(TreeNode root) {
        /**
         * 层序遍历
         */
        if (root == null) {
            return 0;
        }
        Deque<TreeNode> deque = new ArrayDeque<TreeNode>();
        deque.offer(root);
        int sum = 0;
        while (!deque.isEmpty()) {
            int size = deque.size();
            while (size > 0) {
                root = deque.pop();
                sum++;
                if (root.left != null) {
                    deque.offer(root.left);
                }
                if (root.right != null) {
                    deque.offer(root.right);
                }
                size--;
            }
        }
        return sum;
    }

    /**
     * 根据完全二叉树的性质计算
     *
     * @param root
     * @return
     */
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = getDepth(root.left);
        int rightDepth = getDepth(root.right);
        if (leftDepth == rightDepth) {
            //如果深度相等，则左边为满二叉树
            // leftDepth是从当前子树的头结点开始计算深度，不是两棵树的根结点
            // ( 2 ^ leftDepth - 1 ) + 1   1为两棵树的根结点
            return ((1 << leftDepth) - 1) + 1 + countNodes(root.right);
        } else {
            //右子树为满二叉树
            return ((1 << rightDepth) - 1) + 1 + countNodes(root.left);
        }
    }

    /**
     * 从当前子树 开始计算深度
     *
     * @param root
     * @return
     */
    public int getDepth(TreeNode root) {
        int depth = 0;
        while (root != null) {
            root = root.left;
            depth++;
        }
        return depth;
    }
}
