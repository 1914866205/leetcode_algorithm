package com.programmercarl.tree;

import java.util.Stack;

/**
 * @ClassName IsSameTree
 * @Descriotion TODO
 * @Author nitaotao
 * @Date 2022/7/4 19:50
 * @Version 1.0
 **/
public class IsSameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        TreeNode tempP = p;
        TreeNode tempQ = q;
        Stack<TreeNode> stackP = new Stack<TreeNode>();
        Stack<TreeNode> stackQ = new Stack<TreeNode>();
        while (p != null || !stackP.isEmpty()) {
            if (p != null) {
                stackP.push(p);
                stackQ.push(q);
                p = p.left;
                if (q == null || stackP.isEmpty()) {
                    return false;
                }
                q = q.left;
            } else {
                p = stackP.pop();
                q = stackQ.pop();
                if (p.val != q.val) {
                    return false;
                }
                p = p.right;
                q = q.right;
            }
        }

        Stack<TreeNode> stackp = new Stack<TreeNode>();
        Stack<TreeNode> stackq = new Stack<TreeNode>();
        while (tempQ != null || !stackq.isEmpty()) {
            if (tempQ != null) {
                stackp.push(tempP);
                stackq.push(tempQ);
                tempQ = tempQ.left;
                if (tempP == null || stackp.isEmpty()) {
                    return false;
                }
                tempP = tempP.left;
            } else {
                tempP = stackp.pop();
                tempQ = stackq.pop();
                if (tempP.val != tempQ.val) {
                    return false;
                }
                tempP = tempP.right;
                tempQ = tempQ.right;
            }
        }

        return true;
    }

    public boolean isSameTree2(TreeNode p, TreeNode q) {
        return compare(p, q);
    }

    //可以看成两个子树，左右子树
    private boolean compare(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        //不是两个都为空
        //其中为空
        if (left == null || right == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        boolean leftResult = compare(left.left, right.left);
        boolean rightResult = compare(left.right, right.right);
        return leftResult && rightResult;
    }
}