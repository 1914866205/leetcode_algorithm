package com.programmercarl.tree;

import java.util.TreeMap;

/**
 * @ClassName TreeNode
 * @Descriotion TODO
 * @Author nitaotao
 * @Date 2022/7/1 15:17
 * @Version 1.0
 * 树的结点类
 **/
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
