package mca.class11;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName EncodeNaryTreeToBinaryTree
 * @Descriotion TODO
 * @Author nitaotao
 * @Date 2022/10/8 23:22
 * @Version 1.0
 * leetcode431题，将n叉树编码为二叉树
 * https://leetcode.com/problems/encode-n-ary-tree-to-binary-tree
 **/
public class EncodeNaryTreeToBinaryTree {
    /**
     * 多叉树的结点
     */
    public static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    /**
     * 二叉树的结点
     */
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * n叉树转化为二叉树
     *
     * @param root
     * @return
     */
    public TreeNode encode(Node root) {
        if (root == null) {
            return null;
        }
        TreeNode head = new TreeNode(root.val);
        head.left = en(root.children);
        return head;
    }

    /**
     * 子节点的右节点都是父结点的子节点，
     * 子节点的左结点都是自己的子节点。
     * @param children
     * @return
     */
    private TreeNode en(List<Node> children) {
        TreeNode head = null;
        TreeNode cur = null;
        for (Node child : children) {
            TreeNode node = new TreeNode(child.val);
            if (head == null) {
                head = node;
            } else {
                cur.right = node;
            }
            cur = node;
            cur.left = en(child.children);
        }
        return head;
    }

    /**
     * 二叉树转化为n阶树
     *
     * @param root
     * @return
     */
    public Node decode(TreeNode root) {
        // 二叉树的右结点全是子节点
        if (root == null) {
            return null;
        }
        Node head = new Node(root.val);
        head.children = de(root);
        return head;
    }

    public List<Node> de(TreeNode root) {
        List<Node> children = new ArrayList<Node>();
        while (root != null) {
            //解析每个子节点的子节点
            Node cur = new Node(root.val, de(root.left));
            //父结点的子节点添加到列表中
            children.add(cur);
            //遍历右节点，即遍历父结点的所有子节点
            root = root.right;
        }
        return children;
    }

}
