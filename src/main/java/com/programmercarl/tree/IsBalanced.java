package com.programmercarl.tree;

import com.programmercarl.util.GenerateTreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @ClassName IsBalanced
 * @Descriotion TODO
 * @Author nitaotao
 * @Date 2022/7/4 11:21
 * @Version 1.0
 * https://leetcode.cn/problems/balanced-binary-tree/
 * 110. 平衡二叉树
 **/
public class IsBalanced {
    /**
     * 递归三部曲
     * 1. 明确递归函数的参数和返回值
     * 参数：当前传入节点
     * 返回值：以当前传入结点为根结点的树的高度
     * 如果当前传入结点为根结点的二叉树不是平衡二叉树，返回 -1
     * <p>
     * 2. 明确终止条件
     * 遇到空节点终止，返回0，表示当前结点以此结点为根结点的树的高度为0
     * <p>
     * 3. 明确单层递归的逻辑
     * 如何判断左右子树不平衡？
     * 左右子树高度差 > 1  返回 -1
     * 返回当前高度差
     *
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        return getHeight(root) != -1;
    }

    // 高度为-1则不是平衡二叉树
    public int getHeight(TreeNode root) {
        //空结点高度为0
        if (root == null) {
            return 0;
        }
        int leftHeight = getHeight(root.left);
        if (leftHeight == -1) {
            return - 1;
        }
        int rightHeight = getHeight(root.right);
        if (rightHeight == -1) {
            return -1;
        }
        //高度差 > 1 , 则不对称
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }
        //如果左右子树为平衡二叉树，返回树的整体高度 + 1
        // 整体高度为 当前最高子树的高度 + 根结点的高度
        return Math.max(leftHeight, rightHeight) + 1;
    }
}

