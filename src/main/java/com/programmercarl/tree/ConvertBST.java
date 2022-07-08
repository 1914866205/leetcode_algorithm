package com.programmercarl.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @ClassName ConvertBST
 * @Descriotion TODO
 * @Author nitaotao
 * @Date 2022/7/8 9:57
 * @Version 1.0
 * https://leetcode.cn/problems/convert-bst-to-greater-tree/
 * 538. 把二叉搜索树转换为累加树
 **/
public class ConvertBST {
    public TreeNode convertBST(TreeNode root) {
        /**
         * 思路：
         * 1. 把原结点的各值中序遍历存在集合中
         * 2. 写一个方法，入参为 当前结点的值，输出为sum，内部逻辑是累加数组中当前结点往后的结果
         * 3. 遍历树，每个结点调用这个方法
         */
        if (root == null) {
            return root;
        }
        inorderTraversal(root);
        TreeNode node=root;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(node);
        while (!stack.isEmpty()) {
            node = stack.pop();
            node.val = getSum(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return root;
    }

    List<Integer> nums = new ArrayList<>();

    /**
     * 中序遍历，保证有序
     *
     * @param root
     */
    public void inorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left);
        nums.add(root.val);
        inorderTraversal(root.right);
    }

    public int getSum(int val) {
        int sum = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (nums.get(i) >= val) {
                sum += nums.get(i);
            }
        }
        return sum;
    }
}
