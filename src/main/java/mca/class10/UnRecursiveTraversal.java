package mca.class10;

import mca.class11.Code04_PrintBinaryTree;

import java.util.Stack;

/**
 * @ClassName UnRecursiveTraversal
 * @Descriotion TODO
 * @Author nitaotao
 * @Date 2022/10/7 16:24
 * @Version 1.0
 * 非递归方式遍历树
 **/
public class UnRecursiveTraversal {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    /**
     * 非递归法 先序遍历树
     *
     * @param head
     */
    public static void pre(Node head) {
        if (head == null) {
            return;
        }
        Node node = head;
        Stack<Node> stack = new Stack<>();
        stack.push(head);
        while (!stack.isEmpty()) {
            node = stack.pop();
            System.out.println(node.value);
            //根左右
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
    }

    public static void in(Node head) {
        if (head == null) {
            return;
        }
        Node node = head;
        Stack<Node> stack = new Stack<>();
        stack.push(node);
        while (!stack.isEmpty() || node != null) {
            //中序遍历，左中右
            if (node != null) {
                //有左子节点
                stack.push(node.left);
                node = node.left;
            } else {
                //无左子节点
                node=stack.pop();
                node = node.right;
            }
        }
    }

    /**
     * 后序遍历
     * @param head
     */
    public static void pos1(Node head) {
        //中 右 左遍历，然后逆序
        if (head == null) {
            return;
        }
        Stack<Node> reverse = new Stack<Node>();
        Stack<Node> stack = new Stack<Node>();
        stack.push(head);
        while (!stack.isEmpty()) {
            head = stack.pop();
            reverse.push(head);

            if (head.left != null) {
                stack.push(head.left);
            }
            if (head.right != null) {
                stack.push(head.right);
            }
        }

        while (!reverse.isEmpty()) {
            System.out.println(reverse.pop().value+" ");
        }
    }

    public static void pos2(Node head) {
        if (head == null) {
            return;
        }
        Stack<Node> stack = new Stack<Node>();
        stack.push(head);
        Node node = null;
        while (!stack.isEmpty()) {
            //查看当前结点
            node = stack.peek();
            if (node.left != null && head != node.left && head != node.right) {
            //如果有左子结点，并且左右子结点未被遍历  则加入
                stack.push(node);
            } else if (node.right != null && head != node.right) {
                //如果有右节点，并且右子节点未被遍历 则加入
                stack.push(node);
            } else {
                System.out.println(stack.pop());
                //如果是叶子结点，或者左右已经遍历过了，则弹出，标记遍历过的结点
                head = node;
            }
        }
    }
}
