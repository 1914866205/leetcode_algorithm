package com.programmercarl.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * @ClassName PostorderTraversal
 * @Descriotion TODO
 * @Author nitaotao
 * @Date 2022/7/1 15:27
 * @Version 1.0
 * 145. 二叉树的后序遍历
 * https://leetcode.cn/problems/binary-tree-postorder-traversal/
 **/
public class PostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        traversal(root, result);
        return result;
    }

    /**
     * 后序遍历
     *
     * @param root
     * @param result
     */
    public void traversal(TreeNode root, List<Integer> result) {
        //确定终止条件
        if (root == null) {
            return;
        }
        //左
        traversal(root.left, result);
        //右
        traversal(root.right, result);
        //中
        result.add(root.val);
    }

    public List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        if (root == null) {
            return result;
        }
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            //根
            result.add(node.val);
            //栈，先进后出
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
            //当前顺序   根、右、左
            //再逆序     左、右、根
        }
        //逆序
        Collections.reverse(result);
        return result;
    }
}
