package com.programmercarl.tree;

/**
 * @ClassName BuildTree
 * @Descriotion TODO
 * @Author nitaotao
 * @Date 2022/7/5 12:37
 * @Version 1.0
 * https://leetcode.cn/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 * 106. 从中序与后序遍历序列构造二叉树
 **/
public class BuildTree {
    /**
     * @param inorder   中序遍历 1 2
     * @param postorder 后序遍历 2 1
     * @return
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0 && postorder.length == 0) {
            return null;
        }
        //上个数组的长度是相等的，因为元素个数相同
        //后序遍历的第一个元素为根结点
        TreeNode root = new TreeNode(postorder[postorder.length - 1]);
        //在中序遍历中找到根结点
        int rootIndex = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (root.val == inorder[i]) {
                rootIndex = i;
            }
        }
        //中序数组分成左子树和右子树
        int[] leftIn = new int[rootIndex];
        int[] rightIn = new int[inorder.length - rootIndex - 1];
        for (int i = 0; i < inorder.length; i++) {
            if (i < rootIndex) {
                leftIn[i] = inorder[i];
            } else if (i > rootIndex) {
                rightIn[i-rootIndex-1] = inorder[i];
            }
        }
        //后序遍历数组 前rootIndex位是左子树的，后rootIndex位是右子树
        int[] leftPost = new int[rootIndex];
        int[] rightPost = new int[inorder.length - rootIndex - 1];
        //最后一位结点，已经作为根结点被构建了。
        for (int i = 0; i < postorder.length - 1; i++) {
            if (i < rootIndex) {
                leftPost[i] = postorder[i];
            } else {
                rightPost[i - rootIndex] = postorder[i];
            }
        }
        //构建左右子树
        root.left = buildTree(leftIn, leftPost);
        root.right = buildTree(rightIn, rightPost);
        return root;
    }

    public static void main(String[] args) {
        new BuildTree().buildTree(new int[]{1, 2}, new int[]{2, 1});
    }
}
