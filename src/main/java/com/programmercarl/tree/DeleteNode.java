package com.programmercarl.tree;

import com.programmercarl.util.GenerateTreeNode;

/**
 * @ClassName DeleteNode
 * @Descriotion TODO
 * @Author nitaotao
 * @Date 2022/7/6 15:08
 * @Version 1.0
 * https://leetcode.cn/problems/delete-node-in-a-bst/
 * 450. 删除二叉搜索树中的节点
 **/
public class DeleteNode {

    public static void main(String[] args) {
        System.out.println(new Traversal().inorderTraversal(
                new DeleteNode().deleteNode(GenerateTreeNode.generateTreeNode("[2,0,33,null,1,25,40,null,null,11,31,34,45,10,18,29,32,null,36,43,46,4,null,12,24,26,30,null,null,35,39,42,44,null,48,3,9,null,14,22,null,null,27,null,null,null,null,38,null,41,null,null,null,47,49,null,null,5,null,13,15,21,23,null,28,37,null,null,null,null,null,null,null,null,8,null,null,null,17,19,null,null,null,null,null,null,null,7,null,16,null,null,20,6]"), 33)
        ));
    }


    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            //当前值的结点不存在
            return null;
        }
        if (root.val == key) {
            // 父结点不存在
            if (root.left != null && root.right == null) {
                return root.left;
            }

            if (root.left == null && root.right != null) {
                return root.right;
            }
            //只有一个结点
            if (root.left == null && root.right == null) {
                return null;
            }
            //剩下的情况就是左右结点均存在了
            TreeNode left = root.left;
            TreeNode right = root.right;
            if (root.right.left == null) {
                //如果右子节点的左边不存在
                // 则直接右子节点的左边为左子节点
                root.right.left = left;
                //返回头结点 右子节点
                return root.right;
            } else if (root.left.right == null) {
                //如果左子节点的右边不存在
                // 则直接左子节点的右边为右子节点
                root.left.right = right;
                //返回头结点 右子节点
                return root.left;
            } else {
                //如果左右子树都有自己的左右子树
                //就让左子树的最右下子节点替换root的值即可
                TreeNode leftRightNode = left.right;
                while (leftRightNode.right != null) {
                    left = left.right;
                    leftRightNode = leftRightNode.right;
                }
                //此时leftRightNode为最右下角子节点
                int value = leftRightNode.val;
                //删除最右下角结点
                left.right = null;
                root.val = value;
                return root;
            }
        }
        TreeNode rootNode = root;
        parentNode = root;
        findNode(rootNode, key, false);
        return root;
    }

    TreeNode parentNode;

    public TreeNode findNode(TreeNode root, int key, boolean isLeft) {
        if (root == null) {
            //当前值的结点不存在
            return null;
        }
        if (root.val > key) {
            parentNode = root;
            findNode(root.left, key, true);
        } else if (root.val < key) {
            parentNode = root;
            findNode(root.right, key, false);
        } else {
            //找到值
            // root.val == key
            // root 可能有老有小
            // 父结点  左子节点  右子节点
            //如果父结点存在
            if (root.left != null && root.right == null) {
                //当前结点左结点存在，右结点不存在
                //当前结点是父结点的左子节点，即父节点比当前结点大
                if (isLeft) {
                    parentNode.left = root.left;
                } else {
                    // 如果当前结点是父结点的右子节点，即父节点比当前结点小
                    parentNode.right = root.left;
                }
                return null;
            }

            if (root.left == null && root.right != null) {
                //当前结点左结点不存在，右结点存在
                //当前结点是父结点的左子节点，即父节点比当前结点大
                if (isLeft) {
                    parentNode.left = root.right;
                } else {
                    // 如果当前结点是父结点的右子节点，即父节点比当前结点小
                    parentNode.right = root.right;
                }
                return null;
            }

            if (root.left == null && root.right == null) {
                //如果当前结点是叶子结点
                if (isLeft) {
                    parentNode.left = null;
                } else {
                    parentNode.right = null;
                }
                return null;
            }

            //左右父结点均存在
            // 如果当前结点是父结点的左结点
            // 即当前结点比父结点小
            if (isLeft) {
                //如果左右子树都有自己的左右子树
                //找右子树最左下角的元素替代自己
                if (root.left == null && root.right == null) {
                    parentNode.left = null;
                } else if (root.left == null && root.right != null) {
                    parentNode.left = root.right;
                } else {
                    //左 右 都不为空
                    if (root.left.right == null) {
                        parentNode.left = root.left;
                        root.left.right = root.right;
                    } else {
                        //左子树右下角不为空
                        TreeNode left = root.left;
                        TreeNode leftRightNode = left.right;
                        while (leftRightNode.right != null) {
                            left = left.right;
                            leftRightNode = leftRightNode.right;
                        }
                        int value = leftRightNode.val;
                        if (leftRightNode.left != null) {
                            left.right = leftRightNode.left;
                        } else {
                            left.right = null;
                        }
                        root.val = value;
                        return root;
                    }
                }
                return root;
            } else {
                //如果左右子树都有自己的左右子树
                //找左子树最右下角的元素替代自己
                if (root.left == null && root.right == null) {
                    parentNode.right = null;
                } else if (root.right == null && root.left != null) {
                    parentNode.right = root.left;
                } else {
                    //左 右 都不为空
                    if (root.right.left == null) {
                        parentNode.right = root.right;
                        root.right.left = root.left;
                    } else {
                        //右子树左下角不为空
                        TreeNode right = root.right;
                        TreeNode rightRightNode = right.left;
                        while (rightRightNode.left != null) {
                            right = right.left;
                            rightRightNode = rightRightNode.left;
                        }
                        int value = rightRightNode.val;
                        if (rightRightNode.right != null) {
                            right.left = rightRightNode.right;
                        } else {
                            right.left = null;
                        }
                        root.val = value;
                        return root;
                    }
                }
                return root;
            }
        }
        return null;
    }
}
