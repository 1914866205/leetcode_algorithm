package com.programmercarl.tree;

import com.programmercarl.util.GenerateTreeNode;

/**
 * @ClassName TrimBST
 * @Descriotion TODO
 * @Author nitaotao
 * @Date 2022/7/6 20:27
 * @Version 1.0
 * https://leetcode.cn/problems/trim-a-binary-search-tree/
 * 669. 修剪二叉搜索树
 **/
public class TrimBST {
    public static void main(String[] args) {
        /**
         *
         *             5
         *         4           8
         *     2          6        10
         *   1   3          7    9
         */
        System.out.println(new TrimBST().trimBST(GenerateTreeNode.generateTreeNode("[5,4,8,2,null,6,10,1,3,null,7,9]"),3,8));
    }
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) {
            return null;
        }
        //如果当前元素比边界值最小值小，则去当前元素右子树找较大值
        if (root.val < low) {
            return trimBST(root.right, low, high);
        }
        //如果当前元素比边界值最大值大，则去寻找左子树，比当前值小一点的数
        if (root.val > high) {
            return trimBST(root.left, low, high);
        }
        //当前元素接收传来的处理后的新的左子树
        root.left = trimBST(root.left, low, high);
        //当前元素接收传来的处理后的新的右子树
        root.right = trimBST(root.right, low, high);
        return root;
    }















    /**
     * 迭代
     *
     * @return
     */
    public TreeNode trimBst(TreeNode root, int L, int R) {
        if (root == null) {
            return null;
        }
        //处理头结点，让 root 移动到 [ l , R ]范围内，闭区间
        while (root != null && (root.val < L || root.val > R)) {
            if (root.val < L) {
                //当前结点的值比最小区间小，往右走
                root = root.right;
            } else {
                //当前结点的值比最大区间大，往左走
                root = root.left;
            }
        }
        //此时 root 在 [ L , R ]范围内，，处理左孩子元素小于L的情况
        TreeNode cur = root;
        while (cur != null) {
            //此时 root 不是 L 结点  就是 R 结点

            //如果是 root 是 L 结点 curLeft.val < L
            //因为curLeft是root的左结点，比root小，
            TreeNode curLeft = cur.left;
            //如果当前结点不为空， 且当前结点的左子节点不为空，
            //且当前结点左子节点的值比最小区间小
            while (curLeft != null && curLeft.val < L) {
                curLeft = curLeft.right;
            }
            cur =curLeft;
        }

        cur=root;
        //此时root已经在[L,R]范围内，处理右孩子大于R的情况
        while (cur != null) {
            TreeNode right = cur.right;
            while (right != null && right.val > R) {
                right = right.left;
            }
            cur = right;
        }
        return root;
    }
}
