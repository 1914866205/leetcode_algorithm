package com.programmercarl.tree;

/**
 * @ClassName SearchBST
 * @Descriotion TODO
 * @Author nitaotao
 * @Date 2022/7/5 21:17
 * @Version 1.0
 * https://leetcode.cn/problems/search-in-a-binary-search-tree/
 * 700. 二叉搜索树中的搜索
 **/
public class SearchBST {
    /**
     * BST，又叫平衡二叉树，是一种循关键码访问的二叉树，
     * 并且要求保持顺序性，即任一节点不小于其左后代，不大于其右后代（注意是后代，不是孩子）。
     * BST的顺序性使得其中序遍历序列一定是单调非降的。
     *
     * @param root
     * @param val
     * @return
     */
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        } else if (root.val < val) {
            //当前值比目标值小，在右子树上搜
            return searchBST(root.right, val);
        } else {
            //当前值比目标值大，在左子树上搜
            return searchBST(root.left, val);
        }
    }
}
