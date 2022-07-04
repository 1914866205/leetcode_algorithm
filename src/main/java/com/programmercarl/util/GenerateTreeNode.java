package com.programmercarl.util;


import com.programmercarl.tree.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @ClassName GenerateTreeNode
 * @Descriotion TODO
 * @Author nitaotao
 * @Date 2022/7/4 12:02
 * @Version 1.0
 **/
public class GenerateTreeNode {
    public static TreeNode generateTreeNode(String treeStr) {
        String[] strs = treeStr.substring(1, treeStr.length() - 1).split(",");
        Integer[] nums = new Integer[strs.length];
        for (int i = 0; i < strs.length; i++) {
            if ("null".equals(strs[i])) {
                nums[i] = null;
            } else {
                nums[i] = Integer.parseInt(strs[i]);
            }
        }
        if (nums == null || nums.length == 0) {
            return null;
        }
        int len = nums.length;
        int index = 0;
        TreeNode head = new TreeNode(nums[index]);
        Deque<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.offer(head);
        TreeNode cur;
        while (index < len) {
            index++;
            if (index >= len) {
                return head;
            }
            cur = nodeQueue.poll();
            Integer left = nums[index];
            if (left != null) {
                cur.left = new TreeNode(left);
                nodeQueue.offer(cur.left);
            }

            index++;
            if (index >= len) {
                return head;
            }
            Integer right = nums[index];
            if (right != null) {
                cur.right = new TreeNode(right);
                nodeQueue.offer(cur.right);
            }
        }
        return head;
    }

    public static void main(String[] args) {
        TreeNode node = GenerateTreeNode.generateTreeNode("[1,2,3,4,5,6,null,8]");
        System.out.println();
    }
}

