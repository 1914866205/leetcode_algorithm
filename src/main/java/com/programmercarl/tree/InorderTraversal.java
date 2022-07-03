package com.programmercarl.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @ClassName InorderTraversal
 * @Descriotion TODO
 * @Author nitaotao
 * @Date 2022/7/1 15:32
 * @Version 1.0
 * https://leetcode.cn/problems/binary-tree-inorder-traversal/
 * 94. 二叉树的中序遍历
 **/
public class InorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        traversal(root, result);
        return result;
    }

    /**
     * 中序遍历
     * @param root
     * @param result
     */
    public void traversal(TreeNode root, List<Integer> result) {
        if(root==null) {
            return;
        }
        //左中右
        traversal(root.left, result);
        result.add(root.val);
        traversal(root.right, result);
    }

    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        //中序遍历，左中右
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            }else{
                root= stack.pop();
                result.add(root.val);
                root = root.right;
            }
        }
        return result;
    }
}
