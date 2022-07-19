package com.programmercarl.greed;

import com.programmercarl.tree.TreeNode;
import com.programmercarl.util.GenerateTreeNode;


/**
 * @ClassName MinCameraCover
 * @Descriotion TODO
 * @Author nitaotao
 * @Date 2022/7/18 22:19
 * @Version 1.0
 * https://leetcode.cn/problems/binary-tree-cameras/
 * 968. 监控二叉树
 **/
public class MinCameraCover {
    //监控点数量
    int count = 0;

    public int minCameraCover(TreeNode root) {
        if (root.left == null && root.right == null) {
            return 1;
        }
        /**
         * 每个叶子结点的上面结点必是监控
         * 监控结点上面的结点必为0
         * 可以把监控结点视为另类叶子结点
         * 需要从下往上遍历
         * 先序遍历 根左右
         * 中序遍历 左中右
         * 后续遍历 左右中
         *
         * 遇到叶子结点，赋值为2，标记位叶子结点
         * 其父结点赋值为1 ， 标记为监控结点
         * 遇到监控结点，其父结点赋值为2，标记为非监控结点
         * 最后遍历。如果其结点值为1，即为监控结点，sun++
         */
        //标记结点
        int rootVal = flagTraversal(root);
        //如果一个为非监控结点，另一个为空
        if ((root.left == null && root.right.val == 0) || (root.right == null && root.left.val == 0)) {
            root.val = 1;
        }

        //如果两个都为非监控结点
        if (root.left != null && root.left.val == 0 && root.right != null && root.right.val == 0) {
            root.val = 1;
        }

        //如果一个叶子一个是

        //计算总和
        getCameraNumber(root);
        return count;
    }

    /**
     * 贪心思想
     * <p>
     * 标记结点
     * 遇到叶子结点，赋值为2，标记位叶子结点
     * 其父结点赋值为1 ， 标记为监控结点
     * 遇到监控结点，其父结点赋值为2，标记为非监控结点
     *
     * @param node 需要根据子节点的值进行监控结点的标记
     *             左右根
     *             后序遍历
     */
    public int flagTraversal(TreeNode node) {
        //叶子结点标记为2
        //null标记为3
        //监控结点标记为1
        //非监控结点标记为0
        /**
         *         1
         *       2   3
         *     0  3
         *   1  3
         * 3  2
         *   3  3
         *
         */

        //贪心思路：如果左右有一个为null，并且另一个为监控结点，当前结点则为

        if (node == null) {
            // 3为空结点
            return 3;
        }
        //左子树
        int left = flagTraversal(node.left);

        //右子树
        int right = flagTraversal(node.right);

        //如果没有子节点，当前结点即为叶子结点，标记为 2
        //所有的叶子结点
        if (left == 3 && right == 3) {
            node.val = 2;
        }

        //如果左右有一个为叶子结点，当前结点必为监控结点
        if (left == 2 || right == 2) {
            //当前结点设置为监控结点
            node.val = 1;
        }
        //如果一个为非监控结点，另一个为空。或者两个都是非监控结点
        if ((left == 0 && right == 3) || (left == 3 && right == 0) || (left == 0 && right == 0)) {
            //当前结点根据贪心思路，设置为伪叶子结点
            node.val = 2;
        }


        //如果左右都为监控结点
        if (left == 1 && right == 1) {
            //当前结点设为非叶子结点
            node.val = 0;
        }

        //如果只有一个为监控结点，另一个为空
        //非监控结点
        if ((left == 1 && right == 3) || (left == 3 && right == 1)) {
            node.val = 0;
        }

        //返回当前结点的值
        return node.val;
    }

    /**
     * 递归，中序遍历结点获取监控点数量
     *
     * @param node
     */
    public void getCameraNumber(TreeNode node) {
        if (node == null) {
            return;
        }
        getCameraNumber(node.left);
        if (node.val == 1) {
            count++;
        }
        getCameraNumber(node.right);
    }

    public static void main(String[] args) {
        System.out.println(new MinCameraCover().minCameraCover(GenerateTreeNode.generateTreeNode("[0,0,0,null,0,0,null,null,0,null,0,null,0,null,null,0,null,0,0]")));
        System.out.println(new MinCameraCover().minCameraCover(GenerateTreeNode.generateTreeNode("[0,null,0,null,0,null,0]")));
        System.out.println(new MinCameraCover().minCameraCover(GenerateTreeNode.generateTreeNode("[0,0,null,0,0,0,null,null,0]")));
    }
}
