package com.programmercarl.tree;

import java.util.*;

/**
 * @ClassName FindMode
 * @Descriotion TODO
 * @Author nitaotao
 * @Date 2022/7/6 9:34
 * @Version 1.0
 * https://leetcode.cn/problems/find-mode-in-binary-search-tree/
 * 501. 二叉搜索树中的众数
 **/
public class FindMode {
    HashMap<Integer, Integer> result = new HashMap<Integer, Integer>();

    public int[] findMode2(TreeNode root) {
        //本题可以使用哈希表做
        traversal(root);
        Set<Integer> keys = result.keySet();
        int max = -1;
        for (Integer key : keys) {
            if (result.get(key) > max) {
                max = result.get(key);
            }
        }
        Set<Integer> resultSet = new HashSet<Integer>();
        for (Integer key : keys) {
            if (result.get(key) == max) {
                resultSet.add(key);
            }
        }
        int[] resultArr = new int[resultSet.size()];
        int index = 0;
        for (Integer key : resultSet) {
            resultArr[index] = key;
            index++;
        }
        return resultArr;
    }

    public void traversal(TreeNode root) {
        if (root == null) {
            return;
        }
        traversal(root.left);
        if (result.containsKey(root.val)) {
            result.put(root.val, result.get(root.val) + 1);
        } else {
            result.put(root.val, 1);
        }
        traversal(root.right);
    }


    List<Integer> list = new ArrayList<>();
    TreeNode parent;
    int maxTimes = 0;
    int curTimes = 0;

    public void inorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left);
        if (root.val == parent.val) {
            curTimes++;
            //如果当前元素出现次数比最大次数大，则新的众数出现，原来的不是众数了
            if (curTimes > maxTimes) {
                maxTimes = curTimes;
                list.clear();
                list.add(root.val);
            } else if (curTimes == maxTimes) {
                //如果当前元素出现次数和最大次数相等，则新的众数出现
                list.add(root.val);
            }
        } else {
            curTimes = 1;
            if (curTimes > maxTimes) {
                maxTimes = curTimes;
                list.clear();
                list.add(root.val);
            } else if (curTimes == maxTimes) {
                //如果当前元素出现次数和最大次数相等，则新的众数出现
                list.add(root.val);
            }
            parent = root;
        }
        inorderTraversal(root.right);
    }


    public int[] findMode(TreeNode root) {
        parent = root;
        inorderTraversal(root);
        int index = 0;
        int[] resultArr = new int[list.size()];
        for (Integer result : list) {
            resultArr[index] = result;
            index++;
        }
        return resultArr;
    }
}
