package com.programmercarl.tree;

import com.programmercarl.util.GenerateTreeNode;

import java.util.Stack;

/**
 * @ClassName HasPathSum
 * @Descriotion TODO
 * @Author nitaotao
 * @Date 2022/7/5 11:40
 * @Version 1.0
 * https://leetcode.cn/problems/path-sum/
 * 112. 路径总和
 **/
public class HasPathSum {
    /**
     * 给你二叉树的根节点 root 和一个表示目标和的整数 targetSum 。判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和 targetSum 。如果存在，返回 true ；否则，返回 false 。
     * 叶子节点 是指没有子节点的节点。
     * <p>
     * ..不就是遍历每条路径和嘛
     *
     * @param root
     * @param targetSum
     * @return
     */
    public boolean hasPathSum(TreeNode root, int targetSum) {
        //使用递归
        if (root == null) {
            return false;
        }
        return traversal(root, 0, targetSum);
    }

    public boolean traversal(TreeNode root, int sum, int targetSum) {
        if (root == null) {
            return sum == targetSum;
        }
        //只计算到叶子结点
        sum += root.val;
        //只计算右子树的结果
        if (root.left == null && root.right != null) {
            return traversal(root.right, sum, targetSum);
        }
        //只计算左子树的结果
        if (root.left != null && root.right == null) {
            return traversal(root.left, sum, targetSum);
        }
        return traversal(root.left, sum, targetSum) || traversal(root.right, sum, targetSum);
    }

    public static void main(String[] args) {
        System.out.println(new HasPathSum().hasPathSum(GenerateTreeNode.generateTreeNode("[5,4,8,11,null,13,4,7,2,null,null,null,1]"), 22));
    }
}
