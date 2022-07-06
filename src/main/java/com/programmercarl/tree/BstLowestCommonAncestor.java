package com.programmercarl.tree;

/**
 * @ClassName BstLowestCommonAncestor
 * @Descriotion TODO
 * @Author nitaotao
 * @Date 2022/7/6 12:36
 * @Version 1.0
 * https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-search-tree/
 * 235. 二叉搜索树的最近公共祖先
 **/
public class BstLowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //因为是有序的，只要找到最接近两个元素的结点
        // 模板结点在当前结点左边
        if (root.val > p.val && root.val > q.val) {
            root = root.left;
        } else if (root.val < p.val && root.val < q.val) {
            root = root.right;
        } else {
            //root在两个结点位置之间了,是闭区间。而且是 [p,q]的闭区间，不是 p 就是 q
            //因为是一步步位移的，所以是临界点
            return root;
        }
        return lowestCommonAncestor(root, p, q);
    }
}
