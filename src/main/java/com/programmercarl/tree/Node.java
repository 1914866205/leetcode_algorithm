package com.programmercarl.tree;

import java.util.List;

/**
 * @ClassName Node
 * @Descriotion TODO
 * @Author nitaotao
 * @Date 2022/7/3 22:23
 * @Version 1.0
 **/
public class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
