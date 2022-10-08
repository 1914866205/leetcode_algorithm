package mca.class11;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @ClassName SerializeAndReconstructTree
 * @Descriotion TODO
 * @Author nitaotao
 * @Date 2022/10/7 23:39
 * @Version 1.0
 * 二叉树只能通过先序和后序或者层序进行序列化和反序列化
 * 中序不可以进行序列化和反序列化
 * 比如如下两棵树
 * __2
 * /
 * 1
 * 和
 * 1 __
 * \
 * 2
 * 补足空位置的中序遍历结果都是{ null, 1, null, 2, null}
 **/
public class SerializeAndReconstructTree {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static Queue<String> preSerial(Node head) {
        Queue<String> ans = new LinkedList<>();
        pres(head, ans);
        return ans;
    }

    /**
     * 先序遍历序列化
     *
     * @param head
     * @param ans
     */
    public static void pres(Node head, Queue<String> ans) {
        if (head == null) {
            ans.add(null);
        } else {
            ans.add(String.valueOf(head.value));
            pres(head.left, ans);
            pres(head.right, ans);
        }
    }









    public static Queue<String> inSerial(Node head) {
        Queue<String> ans = new LinkedList<>();
        inSerialBuild(head, ans);
        return ans;
    }

    /**
     * 中序序列化二叉树
     *
     * @param head
     * @param ans
     */
    private static void inSerialBuild(Node head, Queue<String> ans) {
        if (head == null) {
            ans.add(null);
        } else {
            inSerialBuild(head.left, ans);
            ans.add(String.valueOf(head.value));
            inSerialBuild(head.right, ans);
        }
    }












    public static Queue<String> posSerial(Node head) {
        Queue<String> ans = new LinkedList<>();
        posSerialBuild(head, ans);
        return ans;
    }

    /**
     * 后序序列化二叉树
     *
     * @param head
     * @param ans
     */
    private static void posSerialBuild(Node head, Queue<String> ans) {
        if (head == null) {
            ans.add(null);
        } else {
            posSerialBuild(head.left, ans);
            posSerialBuild(head.right, ans);
            ans.add(String.valueOf(head.value));
        }
    }





    /**
     * 层序 序列化二叉树
     *
     * @param head
     * @return
     */
    public static Queue<String> levelSerial(Node head) {
        Queue<String> ans = new LinkedList<>();
        if (head == null) {
            ans.add(null);
        } else {
            ans.add(String.valueOf(head));
            Queue<Node> queue = new LinkedList<>();
            queue.add(head);
            while (!queue.isEmpty()) {
                //层序遍历，有值就添加，无值就添加null
                head = queue.poll();
                ans.add(String.valueOf(head));
                if (head.left != null) {
                    ans.add(String.valueOf(head.left.value));
                    queue.add(head.left);
                } else {
                    ans.add(null);
                }
                if (head.right != null) {
                    ans.add(String.valueOf(head.right.value));
                    queue.add(head.right);
                } else {
                    ans.add(null);
                }
            }
        }
        return ans;
    }




    /////////////反序列化/////////////////

    public static Node buildByPreQueue(Queue<String> preList) {
        if (preList == null || preList.size() == 0) {
            return null;
        }
        return preb(preList);
    }

    /**
     * 先序遍历反序列化二叉树
     *
     * @param preList
     * @return
     */
    private static Node preb(Queue<String> preList) {
        String value = preList.poll();
        if (value == null) {
            return null;
        }
        Node head = new Node(Integer.valueOf(value));
        head.left = preb(preList);
        head.right = preb(preList);
        return head;
    }










    /**
     * 后序 反序列化出二叉树
     *
     * @param posList
     * @return
     */
    public static Node buildByPosQueue(Queue<String> posList) {
        if (posList == null || posList.size() == 0) {
            return null;
        }
        Stack<String> stack = new Stack<>();
        //左右中 ——> 中右左
        while (!posList.isEmpty()) {
            stack.push(posList.poll());
        }
        return posb(stack);
    }

    private static Node posb(Stack<String> stack) {
        String value = stack.pop();
        if (value == null) {
            return null;
        }
        Node head = new Node(Integer.valueOf(value));
        head.right = posb(stack);
        head.left = posb(stack);
        return head;
    }



    /**
     * 层序 反序列化 二叉树
     *
     * @param levelQueue
     * @return
     */
    public static Node buildByLevelQueue(Queue<String> levelQueue) {
        if (levelQueue == null || levelQueue.size() == 0) {
            return null;
        }
        Node head = generateNode(levelQueue.poll());
        Queue<Node> queue = new LinkedList<>();
        queue.add(head);
        while (!queue.isEmpty()) {
            head = queue.poll();
            head.left = generateNode(levelQueue.poll());
            head.right = generateNode(levelQueue.poll());
            //可能左右为null
            if (head.left != null) {
                queue.add(head.left);
            }
            if (head.right != null) {
                queue.add(head.right);
            }
        }
        return head;
    }

    private static Node generateNode(String node) {
        if (node == null) {
            return null;
        } else {
            return new Node(Integer.valueOf(node));
        }

    }

}
