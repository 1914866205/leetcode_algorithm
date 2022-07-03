package com.programmercarl.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @ClassName LevelOrder
 * @Descriotion TODO
 * @Author nitaotao
 * @Date 2022/7/3 11:55
 * @Version 1.0
 * https://leetcode.cn/problems/binary-tree-level-order-traversal/
 * 102. 二叉树的层序遍历
 **/
public class LevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Deque<TreeNode> deque = new ArrayDeque();
        if (root == null) {
            return result;
        }
        //入队
        deque.offer(root);
        while (!deque.isEmpty()) {
            int size=deque.size();
            List<Integer> floor = new ArrayList();
            while (size > 0) {
                //每次遍历一层
                TreeNode node = deque.poll();
                floor.add(node.val);
                if (node.left != null) {
                    deque.offer(node.left);
                }
                if (node.right != null) {
                    deque.offer(node.right);
                }
                size--;
            }
            result.add(floor);
        }
        return result;
    }
}
