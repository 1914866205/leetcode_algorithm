package com.programmercarl.tree;

import com.programmercarl.util.GenerateTreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @ClassName MergeTrees
 * @Descriotion TODO
 * @Author nitaotao
 * @Date 2022/7/5 18:02
 * @Version 1.0
 **/
public class MergeTrees {

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 != null) {
            return root2;
        }
        if (root1 != null && root2 == null) {
            return root1;
        }
        if (root1 == null && root2 == null) {
            return null;
        }
        merge(root1, root2, false, null);
        return root1;
    }

    public void merge(TreeNode root1, TreeNode root2, boolean isLeft, TreeNode parent) {
        if (root1 == null && root2 == null) {
            return;
        }
        // 以第一棵树为基准
        if (root1 != null && root2 != null) {
            root1.val = root1.val + root2.val;
        }

        if (root1 == null && root2 != null) {
            //如果 1 没有，2 有
            if (isLeft) {
                parent.left = root2;
                return;
            } else {
                parent.right = root2;
                return;
            }
        }
        //如果 1 有 ，  2 没有  不做改变
        if (root1 != null && root2 == null) {
            return;
        }
        merge(root1.left, root2.left, true, root1);
        merge(root1.right, root2.right, false, root1);
    }

    // 递归  大佬的代码
    public TreeNode mergeTrees2(TreeNode root1, TreeNode root2) {
        if (root1 == null) return root2;
        if (root2 == null) return root1;

        TreeNode newRoot = new TreeNode(root1.val + root2.val);
        newRoot.left = mergeTrees(root1.left, root2.left);
        newRoot.right = mergeTrees(root1.right, root2.right);
        return newRoot;
    }

    public static void main(String[] args) {
        new MergeTrees().mergeTrees(
                GenerateTreeNode.generateTreeNode("[9,-1,null,-2,0,-4,null,null,8,-5,-3,6,null,null,null,null,null,null,7]")
                ,
                GenerateTreeNode.generateTreeNode("[-1,-2,0,null,null,null,8,6,null,null,7]")
        );
    }

}
