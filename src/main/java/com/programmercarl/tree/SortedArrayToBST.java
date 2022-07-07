package com.programmercarl.tree;

/**
 * @ClassName SortedArrayToBST
 * @Descriotion TODO
 * @Author nitaotao
 * @Date 2022/7/7 17:11
 * @Version 1.0
 * 将有序数组转换为二叉搜索树
 * https://leetcode.cn/problems/convert-sorted-array-to-binary-search-tree/
 * 这题显然用二分法，遍历数组，然后用递归进行创建树。道理咱都懂，做的时候就头大了，可能是太久没做二分了，
 * 我不知道结束条件怎么写。还在边界判断。
 * 二分的结束条件是 start > end ,这里每次二分创建结点，然后左子树最大位置 -1，右子树 最小位置 +1
 **/
public class SortedArrayToBST {
    public TreeNode SortedArrayToBST(int[]nums) {
        return traversal(nums, 0, nums.length-1);
    }

    /**
     * 二分法
     * @param nums
     * @param start
     * @param end
     * @return
     */
    public TreeNode traversal(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        //这样可以保证不越界
        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = traversal(nums, start, mid - 1);
        root.right = traversal(nums, mid + 1, end);
        return root;
    }
}
