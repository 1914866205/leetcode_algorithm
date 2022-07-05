package com.programmercarl.tree;

import java.util.*;

/**
 * @ClassName GetMinimumDifference
 * @Descriotion TODO
 * @Author nitaotao
 * @Date 2022/7/5 21:58
 * @Version 1.0
 * https://leetcode.cn/problems/minimum-absolute-difference-in-bst/
 * 530. 二叉搜索树的最小绝对差
 **/
public class GetMinimumDifference {

    public int getMinimumDifference(TreeNode root) {
        List<Integer> result = new ArrayList();
        //遍历二叉树获取结果集
        //二叉搜索树本身就是升序的
        inorderTraversal(root, result);
        //定义一个不可能出现的最大值
        int minimumDifference = 100001;
        for (int i = 1; i < result.size(); i++) {
            if (minimumDifference == 0) {
                return minimumDifference;
            }
            if (result.get(i) - result.get(i - 1) < minimumDifference) {
                minimumDifference = result.get(i) - result.get(i - 1);
            }
        }
        return minimumDifference;
    }

    public void inorderTraversal(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        //中序遍历 左 中 右
        inorderTraversal(root.left, result);
        result.add(root.val);
        inorderTraversal(root.right, result);
    }

    TreeNode parent;
    int result = Integer.MAX_VALUE;

    public void inorderTraversalParent(TreeNode root) {
        if (root == null) {
            return;
        }
        //中序遍历 左 中 右
        inorderTraversalParent(root.left);
        if (parent != null) {
            if (result > root.val - parent.val) {
                result = root.val - parent.val;
            }
        }
        parent = root;
        inorderTraversalParent(root.right);
    }

    public int getMinimumDifference2(TreeNode root) {
        inorderTraversalParent(root);
        return result;
    }
}
