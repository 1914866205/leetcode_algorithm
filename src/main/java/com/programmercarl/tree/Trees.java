package com.programmercarl.tree;

import sun.reflect.generics.tree.Tree;

import java.util.*;

/**
 * @ClassName Trees
 * @Descriotion TODO
 * @Author nitaotao
 * @Date 2022/8/20 9:33
 * @Version 1.0
 **/
public class Trees {
    /**
     * 前序遍历，根左右。
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preTraversal(root, result);
        return result;
    }

    private void preTraversal(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        result.add(root.val);
        preTraversal(root.left, result);
        preTraversal(root.right, result);
    }

    /**
     * 前序遍历，根左右。
     * 栈
     *
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack();
        stack.add(root);
        while (!stack.isEmpty()) {
            //当栈不为空
            root = stack.pop();
            result.add(root.val);
            if (root.right != null) {
                stack.push(root.right);
            }
            if (root.left != null) {
                stack.push(root.left);
            }
        }
        return result;
    }

    /**
     * 中序遍历 递归
     * 左中右
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        inTraversal(root, result);
        return result;
    }

    private void inTraversal(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        inTraversal(root.left, result);
        result.add(root.val);
        inTraversal(root.right, result);
    }

    /**
     * 中序遍历  栈
     * 左中右
     * 中序遍历不用提前添加结点
     * 判断时需要判断当前结点是否为空
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                stack.add(root);
                root = root.left;
            } else {
                root = stack.pop();
                result.add(root.val);
                root = root.right;
            }
        }
        return result;
    }

    /**
     * 后序遍历，左右根
     *
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        postTraversal(root, result);
        return result;
    }

    private void postTraversal(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        postTraversal(root.left, result);
        postTraversal(root.right, result);
        result.add(root.val);
    }

    /**
     * 后序遍历，左右根
     * 栈
     *
     * @param root
     * @return
     */
    public List<Integer> postTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<>();
        //根右左，然后逆序遍历，和先序差不多
        stack.add(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            result.add(root.val);
            if (root.left != null) {
                stack.add(root.left);
            }
            if (root.right != null) {
                stack.add(root.right);
            }
        }
        Collections.reverse(result);
        return result;
    }

    /**
     * 层序遍历，队列
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Deque<TreeNode> deque = new ArrayDeque();
        if (root == null) {
            return result;
        }
        deque.offer(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            List<Integer> level = new ArrayList<>();
            while (size > 0) {
                root = deque.poll();
                level.add(root.val);
                if (root.left != null) {
                    deque.offer(root.left);
                }
                if (root.right != null) {
                    deque.offer(root.right);
                }
                size--;
            }
            result.add(level);
        }
        return result;
    }

    /**
     * 层序遍历 递归
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder2(TreeNode root) {
        //里面的list是每层的元素
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        checkFun01(root, 0, result);
        return result;
    }

    private void checkFun01(TreeNode root, int deep, List<List<Integer>> result) {
        if (root == null) {
            return;
        }
        //深度增加
        deep++;
        if (result.size() < deep) {
            //如果出现了新的一层
            result.add(new ArrayList<>());
        }
        //本层元素加入本层列表
        result.get(deep - 1).add(root.val);
        checkFun01(root.left, deep, result);
        checkFun01(root.right, deep, result);
    }
}
