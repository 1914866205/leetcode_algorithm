package com.programmercarl.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @ClassName PreorderTraversal
 * @Descriotion TODO
 * @Author nitaotao
 * @Date 2022/7/1 15:21
 * @Version 1.0
 * 144. 二叉树的前序遍历
 * https://leetcode.cn/problems/binary-tree-preorder-traversal/
 **/
public class PreorderTraversal {
    /**
     * 前序遍历，根左右。
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        traversal(root, result);
        return result;
    }

    /**
     * 前序遍历，根左右。
     *
     * @param root
     * @param result
     * 1.确定递归函数的参数和返回值
     * 2.确定终止条件
     * 3.确定单层递归的逻辑
     */
    public  void traversal(TreeNode root, List<Integer> result) {
        //终止条件
        if (root == null) {
            return;
        }
        //访问根结点
        result.add(root.val);
        //访问左子树
        traversal(root.left, result);
        //访问右子树
        traversal(root.right,result);
    }

    /**
     * 迭代法
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.val);
            //栈，先进后出，先存右子树
            if (node.right!=null) {
                stack.add(node.right);
            }
            if (node.left!=null) {
                stack.add(node.left);
            }
        }
        return result;
    }
}
