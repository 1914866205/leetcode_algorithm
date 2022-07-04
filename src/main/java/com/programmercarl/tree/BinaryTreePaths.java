package com.programmercarl.tree;

import com.programmercarl.util.GenerateTreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName BinaryTreePaths
 * @Descriotion TODO
 * @Author nitaotao
 * @Date 2022/7/4 18:16
 * @Version 1.0
 **/
public class BinaryTreePaths {
    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<String>();
        //先序遍历
        getPath(root, result, "");
        return result;
    }

    public static void getPath(TreeNode root, List<String> result, String path) {
//        if (root == null) {
//            result.add(path.substring(0, path.length() - 2));
//            return;
//        }
        //先序遍历
        path += root.val + "->";
        //如果接下来只剩一个方向了 选路
        if (root.left == null && root.right != null) {
            getPath(root.right, result, path);
        } else if (root.left != null && root.right == null) {
            getPath(root.left, result, path);
        } else if (root.left == null && root.right == null){
            result.add(path.substring(0, path.length() - 2));
            return;
        }else{
            getPath(root.left, result, path);
            getPath(root.right, result, path);
        }
    }

    public static void main(String[] args) {
        TreeNode node = GenerateTreeNode.generateTreeNode("[1]");
        binaryTreePaths(node);
    }
}
