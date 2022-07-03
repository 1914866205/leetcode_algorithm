package com.programmercarl.tree;

/**
 * @ClassName InvertTree
 * @Descriotion TODO
 * @Author nitaotao
 * @Date 2022/7/3 12:57
 * @Version 1.0
 * https://leetcode.cn/problems/invert-binary-tree/
 * 226. 翻转二叉树
 **/
public class InvertTree {
    public TreeNode invertTree(TreeNode root) {
        invert(root);
        return root;
    }
    public void invert(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);
        invertTree(root.right);
    }
}
