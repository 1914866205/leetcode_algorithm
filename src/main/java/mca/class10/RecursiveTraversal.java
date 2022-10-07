package mca.class10;

/**
 * @ClassName RecursiveTraversal
 * @Descriotion TODO
 * @Author nitaotao
 * @Date 2022/10/7 16:03
 * @Version 1.0
 *
 * 递归法遍历树
 **/
public class RecursiveTraversal {
    public static class Node {
        public int value;
        public Node left;
        public Node right;
        public Node(int v) {
            value = v;
        }
    }

    public static void f(Node head) {
        if (head == null) {
            return;
        }
        f(head.left);
        f(head.right);
    }
    //先序遍历
    public static void pre(Node node) {
        if (node == null) {
            return;
        }
        System.out.println(node.value);
        pre(node.left);
        pre(node.right);
    }
    //中序遍历
    public static void in(Node node) {
        if (node == null) {
            return;
        }
        in(node.left);
        System.out.println(node.value);
        in(node.right);
    }
    //后序遍历
    public static void pos(Node node) {
        if (node == null) {
            return;
        }
        pos(node.left);
        pos(node.right);
        System.out.println(node.value);
    }
}
