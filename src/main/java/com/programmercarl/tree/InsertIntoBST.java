package com.programmercarl.tree;

/**
 * @ClassName InsertIntoBST
 * @Descriotion TODO
 * @Author nitaotao
 * @Date 2022/7/6 14:47
 * @Version 1.0
 * https://leetcode.cn/problems/insert-into-a-binary-search-tree/
 * 701. 二叉搜索树中的插入操作
 **/
public class InsertIntoBST {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        //空根结点，就创建一个结点返回
        if (root == null) {
            return new TreeNode(val);
        }
        TreeNode node = root;
        insert(node, val);
        return root;
    }

    public void insert(TreeNode root, int val) {
        //当前结点是叶子结点
        if (root.left == null && root.right == null) {
            if (root.val > val) {
                //当前值比目标值大
                root.left = new TreeNode(val);
            } else {
                root.right = new TreeNode(val);
            }
            return;
        }
        //单出度情况
        if (root.left == null && root.right != null) {
            if (root.val > val) {
                //当前值比目标值大
                root.left = new TreeNode(val);
                return;
            }
        }

        if (root.left != null && root.right == null) {
            if (root.val < val) {
                //当前值比目标值小
                root.right = new TreeNode(val);
                return;
            }
        }
        if (root.val > val) {
            //当前值比目标值大
            insert(root.left, val);
        } else {
            insert(root.right, val);
        }
    }
}
