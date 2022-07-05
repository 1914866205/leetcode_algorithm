package com.programmercarl.tree;

/**
 * @ClassName ConstructMaximumBinaryTree
 * @Descriotion TODO
 * @Author nitaotao
 * @Date 2022/7/5 15:45
 * @Version 1.0
 * 654. 最大二叉树
 * https://leetcode.cn/problems/maximum-binary-tree/
 **/
public class ConstructMaximumBinaryTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        int max = -1;
        int maxIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
                maxIndex = i;
            }
        }
        //找到当前最大值
        TreeNode root = new TreeNode(nums[maxIndex]);
        //  6 - 3 = 3
        int[] leftNums = new int[maxIndex];
        //  6 - 3 - 1 = 2
        int[] rightNums = new int[nums.length - maxIndex - 1];
        for (int i = 0; i < nums.length; i++) {
            if (i < maxIndex) {
                leftNums[i] = nums[i];
            } else if (i > maxIndex) {
                rightNums[i - maxIndex - 1] = nums[i];
            }
        }
//        System.out.println(leftNums);
//        System.out.println(rightNums);
        root.left = constructMaximumBinaryTree(leftNums);
        root.right = constructMaximumBinaryTree(rightNums);
        return root;
    }

    public static void main(String[] args) {
        new ConstructMaximumBinaryTree().constructMaximumBinaryTree(new int[]{3,2,1,6,0,5});
    }
}
