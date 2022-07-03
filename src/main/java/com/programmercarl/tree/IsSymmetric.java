package com.programmercarl.tree;

import java.util.*;

/**
 * @ClassName IsSymmetric
 * @Descriotion TODO
 * @Author nitaotao
 * @Date 2022/7/3 13:18
 * @Version 1.0
 * https://leetcode.cn/problems/symmetric-tree/
 * 101. 对称二叉树
 **/
public class IsSymmetric {
    public static boolean isSymmetric(TreeNode root) {
        //只有根元素，直接通过
        if (root.left == null && root.right == null) {
            return true;
        }

        /**
         * 翻转右半段，然后左右层序遍历比较
         */
        if (root.left == null || root.right == null) {
            return false;
        }
        //左子树不懂，右子树变换
        reverse(root.right);
        return getNum(root.left, root.right);
    }

    public static boolean getNum(TreeNode root1, TreeNode root2) {
        if ((root1 == null && root2 != null) || (root1 != null && root2 == null)) {
            return false;
        }

        if (root1 == null && root2 == null) {
            return true;
        }

        if (root1.val == root2.val) {
            boolean left = getNum(root1.left, root2.left);
            boolean right = getNum(root1.right, root2.right);
            //有错再进来
            return left && right;
        } else {
            return false;
        }
    }

    public static void reverse(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        reverse(root.left);
        reverse(root.right);
    }

    public static void main(String[] args) {
        TreeNode node15 = new TreeNode(6, null, null);
        TreeNode node8 = new TreeNode(6, null, null);
        TreeNode node7 = new TreeNode(5, null, node15);
        TreeNode node4 = new TreeNode(5, node8, null);
        TreeNode node3 = new TreeNode(4, null, node7);
        TreeNode node2 = new TreeNode(4, node4, null);
        TreeNode node1 = new TreeNode(3, node2, node3);
        System.out.println(isSymmetric(node1));
    }
}
