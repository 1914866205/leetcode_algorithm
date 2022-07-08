package com.programmercarl.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Combine
 * @Descriotion TODO
 * @Author nitaotao
 * @Date 2022/7/8 11:09
 * @Version 1.0
 * https://leetcode.cn/problems/combinations/submissions/
 * 77. 组合
 **/
public class Combine {
    List<List<Integer>> result = new ArrayList<>();

    public static void main(String[] args) {
        new Combine().combine(4, 2);
    }

    public List<List<Integer>> combine(int n, int k) {
        List<Integer> list = new ArrayList<>();
        // [1,n]
        backtracking(n, k, 1, list);
        System.out.println(result);

        return result;
    }

    /**
     * @param n    数字范围
     * @param k    列表限制长度
     * @param t    为了防止全排列，给的范围
     * @param list 结果集
     */
    public void backtracking(int n, int k, int t, List<Integer> list) {

        //如果找到结果集，就添加
        // k为结果集的长度
        if (list.size() == k) {
            result.add(new ArrayList<>(list));
            return;
        }
        // [1,n]
        for (int i = t; i < n; i++) {
            //如果元素已经添加，则跳过
            if (list.contains(i)) {
                continue;
            }
            //构建子树
            list.add(i);
            t++;
            backtracking(n, k, t, list);
            //删除最后一个结点，就是叶子结点
            list.remove(list.size() - 1);
        }
    }
}
