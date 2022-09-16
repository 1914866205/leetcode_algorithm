package com.programmercarl.tree;

import com.programmercarl.util.GenerateTreeNode;

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
            int size = deque.size();
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
    public List<List<Integer>> resList = new ArrayList<List<Integer>>();
    public List<List<Integer>> levelOrder2(TreeNode root) {
        checkFun01(root, 0);
        return resList;
    }

    public void checkFun01(TreeNode node, Integer deep) {
        if (node == null) {
            return;
        }
        deep++;
        if (resList.size() < deep) {
            //当层级增加时，list的Item也增加，利用List的索引值进行层级结点
            List<Integer> item = new ArrayList<>();
            resList.add(item);
        }
        resList.get(deep - 1).add(node.val);
        checkFun01(node.left, deep);
        checkFun01(node.right, deep);
    }

    public static void main(String[] args) {
        new LevelOrder().levelOrder2(GenerateTreeNode.generateTreeNode("[3,9,20,null,null,15,7]"));
    }
}
