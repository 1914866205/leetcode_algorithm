package com.programmercarl.tree;

import com.programmercarl.util.GenerateTreeNode;

/**
 * @ClassName SumOfLeftLeaves
 * @Descriotion TODO
 * @Author nitaotao
 * @Date 2022/7/5 10:54
 * @Version 1.0
 * https://leetcode.cn/problems/sum-of-left-leaves/
 * 404. 左叶子之和
 **/
public class SumOfLeftLeaves {
    Integer sum = 0;

    public int sumOfLeftLeaves(TreeNode root) {
        traversal(root, false);
        return sum;
    }

    public boolean traversal(TreeNode root, boolean isLeft) {
        if (root == null) {
            //是否为叶子结点
            return true;
        }
        boolean leftLeaf = traversal(root.left, true);
        //是否是左叶子结点
        if (leftLeaf && isLeft && root.left == null && root.right == null) {
            sum += root.val;
        }
        traversal(root.right, false);
        return false;
    }

    public static void main(String[] args) {
        TreeNode root = GenerateTreeNode.generateTreeNode("[0,2,4,1,null,3,-1,5,1,null,6,null,8]");
        System.out.println(new SumOfLeftLeaves().sumOfLeftLeaves(root));

    }
}
