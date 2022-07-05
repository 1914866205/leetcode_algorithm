package com.programmercarl.tree;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @ClassName FindBottomLeftValue
 * @Descriotion TODO
 * @Author nitaotao
 * @Date 2022/7/5 11:26
 * @Version 1.0
 * https://leetcode.cn/problems/find-bottom-left-tree-value/
 * 513. 找树左下角的值
 **/
public class FindBottomLeftValue {
    /**
     * 给定一个二叉树的 根节点 root，请找出该二叉树的 最底层 最左边 节点的值。
     * 假设二叉树中至少有一个节点。
     * <p>
     * ..不就是层序遍历最后一行第一个嘛
     * @param root
     * @return
     */
    public int findBottomLeftValue(TreeNode root) {
        if (root.left == null && root.right == null) {
            return root.val;
        }
        int result = root.val;
        Deque<TreeNode> deque = new ArrayDeque();
        deque.offer(root);
        while (!deque.isEmpty()) {
            //每层的开始
            result = deque.peek().val;
            int size = deque.size();
            while (size > 0) {
                root = deque.pop();
                if (root.left != null) {
                    deque.offer(root.left);
                }
                if (root.right != null) {
                    deque.offer(root.right);
                }
                size--;
            }
            //每层的结束
        }
        return result;
    }
}
