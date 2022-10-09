package mca.class11;

/**
 * @ClassName SuccessorNode
 * @Descriotion TODO
 * @Author nitaotao
 * @Date 2022/10/9 14:06
 * @Version 1.0
 * 给你二叉树中的某个结点，返回该结点的后继结点
 **/
public class SuccessorNode {
    public static class Node {
        public int value;
        public Node left;
        public Node right;
        public Node parent;

        public Node(int data) {
            value = data;
        }
    }

    /**
     * 得到当前结点的后继结点
     * 后继结点：中序遍历下本节点的下一个结点
     * 左中右
     *
     * @param node
     * @return
     */
    public static Node getSuccessorNode(Node node) {
        if (node == null) {
            return null;
        }
        if (node.right != null) {
            node = node.right;
            while (node.left != null) {
                node = node.left;
            }
            return node;
        } else {
            //如果右子树为空，则下一个结点在父结点，其当前子树不得为右子树
            Node parent = node.parent;
            while (parent != null && parent.right == node) {
                node = parent;
                parent = parent.parent;
            }
            return parent;
        }
    }
}
