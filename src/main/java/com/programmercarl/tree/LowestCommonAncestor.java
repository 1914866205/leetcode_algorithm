package com.programmercarl.tree;

import com.programmercarl.util.GenerateTreeNode;

import java.util.*;

/**
 * @ClassName LowestCommonAncestor
 * @Descriotion TODO
 * @Author nitaotao
 * @Date 2022/7/6 10:12
 * @Version 1.0
 * https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree/
 * 236. 二叉树的最近公共祖先
 **/
public class LowestCommonAncestor {
    /**
     * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
     * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，
     * 满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        /**
         * 思路清晰：
         * 找到两个结点的路径
         * 路径值比较，当值不相等了，返回上一个路径值
         */
        this.p = p;
        this.q = q;
        traversal(root);

        int size = Math.min(pPathNode.size(), qPathNode.size());
        //指向公共元素
        TreeNode result = pPathNode.get(0);
        for (int i = 1; i < size; i++) {
            if (pPathNode.get(i).val == qPathNode.get(i).val) {
                result = pPathNode.get(i);
            }
        }
//        pPathNode.stream().forEach((item) -> System.out.print(item.val));
//        System.out.println();
//        qPathNode.stream().forEach((item) -> System.out.print(item.val));
//        System.out.println();
        return result;
    }

    boolean isFindPandQ = false;
    TreeNode p;
    TreeNode q;
    List<TreeNode> pPathNode = new ArrayList<TreeNode>();
    List<TreeNode> qPathNode = new ArrayList<TreeNode>();
    List<TreeNode> curPathNode = new ArrayList();

    public void traversal(TreeNode root) {
        if (isFindPandQ) {
            //发现完毕，停止递归
            return;
        }


        curPathNode.add(root);

        if (root.val == p.val) {
            pPathNode = new ArrayList<>(curPathNode);
            //当两个都找到时停止递归
            isFindPandQ = pPathNode.size() > 0 && qPathNode.size() > 0;
        }

        if (root.val == q.val) {
            qPathNode = new ArrayList<>(curPathNode);
            //当两个都找到时停止递归
            isFindPandQ = pPathNode.size() > 0 && qPathNode.size() > 0;
        }
        //如果当前结点是叶子结点
        if (root.left != null) {
            traversal(root.left);
        }
        if (root.right != null) {
            traversal(root.right);
        }
        curPathNode.remove(curPathNode.size() - 1);
    }

    public static void main(String[] args) {
        System.out.println(new LowestCommonAncestor().lowestCommonAncestor(GenerateTreeNode.generateTreeNode("[3,5,1,6,2,0,8,null,null,7,4]"), new TreeNode(5), new TreeNode(4)).val);
        System.out.println(new LowestCommonAncestor().lowestCommonAncestor(GenerateTreeNode.generateTreeNode("[3,5,1,6,2,0,8,null,null,7,4]"), new TreeNode(5), new TreeNode(1)).val);
    }
}
