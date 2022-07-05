package com.programmercarl.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @ClassName IsValidBST
 * @Descriotion TODO
 * @Author nitaotao
 * @Date 2022/7/5 21:32
 * @Version 1.0
 * https://leetcode.cn/problems/validate-binary-search-tree/
 * 98. 验证二叉搜索树
 **/
public class IsValidBST {
    /**
     * 直接中序遍历获取结果
     * 如果结果遍历后是 递增，则验证成功
     *
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        if (root.left == null && root.right == null) {
            return true;
        }
        Deque<Integer> deque = new ArrayDeque<Integer>();
        inorderTraversal(root, deque);
        Integer pre = deque.poll();
        Integer last = null;
        //前一个值和后一个值比较，如果不是升序，则不是二叉搜索树
        while (!deque.isEmpty()) {
            last = deque.poll();
            if (pre >= last) {
                return false;
            } else {
                pre = last;
            }
        }
        return true;
    }

    public void inorderTraversal(TreeNode root, Deque<Integer> deque) {
        if (root == null) {
            return;
        }
        //中序遍历 左 中 右
        inorderTraversal(root.left, deque);
        deque.offer(root.val);
        inorderTraversal(root.right, deque);
    }

}
