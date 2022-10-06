package mca.class09;

import java.util.ArrayList;

/**
 * @ClassName LinkedListMid
 * @Descriotion TODO
 * @Author nitaotao
 * @Date 2022/10/4 15:56
 * @Version 1.0
 **/
public class LinkedListMid {
    public static class Node {
        public int value;
        public Node next;

        public Node(int v) {
            value = v;
        }
    }

    /**
     * 输入头结点 返回其上中结点
     *
     * @param head head不存值，是标记结点
     * @return
     */
    public static Node midOrUpMidNode(Node head) {
        //如果只有两个结点，那就选第一个
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }
        //如果链表有三个或以上结点
        Node slow = head.next;
        //第一步就不一样
        Node fast = head.next.next;
        while (fast.next != null && fast.next.next != null) {
            //慢指针一次走一格
            slow = slow.next;
            //快指针一次走两格
            fast = fast.next.next;
        }
        //即 fast到达倒数第一个结点，走偶数位
        // 0   1   2   3   4   5
        // 0   2   4   6   8   10
        return slow;
    }

    /**
     * 返回中间结点或中间结点的下一个结点
     *
     * @param head
     * @return
     */
    public static Node midOrDownMidNode(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node slow = head.next;
        //同一起点，初始值先固定移动一步
        Node fast = head.next;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        //即 fast到达倒数第一个结点，走奇数位
        // 1   2   3   4   5
        // 1   3   5   7   9
        return slow;
    }

    /**
     * 奇数返回中间结点的前一个，偶数长度返回下中间结点的前一个(不就是上中的吗)
     *
     * @param head
     * @return
     */
    public static Node midOrUpMidPreNode(Node head) {
        if (head == null || head.next == null || head.next.next == null) {
            return null;
        }
        Node slow = head;
        Node fast = head.next.next;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // 0   1   2   3   4   5
        // 2   4   6   8   10  12
        return slow;
    }

    /**
     * 奇数返回中间结点的前一个，偶数长度返回下中间结点的前一个
     *
     * @param head
     * @return
     */
    public static Node midOrDownMidPreNode(Node head) {
        if (head == null || head.next == null) {
            return null;
        }
        if (head.next.next == null) {
            return head;
        }
        Node slow = head;
        Node fast = head.next;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // 0   2   3   4   5
        // 1   3   5   7   9
        return slow;
    }


    public static Node right1(Node head) {
        if (head == null) {
            return null;
        }
        Node cur = head;
        ArrayList<Node> arr = new ArrayList();
        while (cur != null) {
            arr.add(cur);
            cur = cur.next;
        }
        return arr.get((arr.size() - 1) / 2);
    }

    public static Node right2(Node head) {
        if (head == null) {
            return null;
        }
        Node cur = head;
        ArrayList<Node> arr = new ArrayList();
        while (cur != null) {
            arr.add(cur);
            cur = cur.next;
        }
        return arr.get((arr.size()) / 2);
    }


    public static Node right3(Node head) {
        if (head == null || head.next == null || head.next.next == null) {
            return null;
        }
        Node cur = head;
        ArrayList<Node> arr = new ArrayList<>();
        while (cur != null) {
            arr.add(cur);
            cur = cur.next;
        }
        return arr.get((arr.size() - 3) / 2);
    }

    public static Node right4(Node head) {
        if (head == null || head.next == null) {
            return null;
        }
        Node cur = head;
        ArrayList<Node> arr = new ArrayList<>();
        while (cur != null) {
            arr.add(cur);
            cur = cur.next;
        }
        return arr.get((arr.size() - 2) / 2);

    }
    public static void main(String[] args) {
         Node test = null;
        test = new  Node(0);
        test.next = new  Node(1);
        test.next.next = new  Node(2);
        test.next.next.next = new  Node(3);
        test.next.next.next.next = new  Node(4);
        test.next.next.next.next.next = new  Node(5);
        test.next.next.next.next.next.next = new  Node(6);
        test.next.next.next.next.next.next.next = new  Node(7);
        test.next.next.next.next.next.next.next.next = new  Node(8);

         Node ans1 = null;
         Node ans2 = null;

        ans1 = midOrUpMidNode(test);
        ans2 = right1(test);
        System.out.println(ans1 != null ? ans1.value : "无");
        System.out.println(ans2 != null ? ans2.value : "无");

        ans1 = midOrDownMidNode(test);
        ans2 = right2(test);
        System.out.println(ans1 != null ? ans1.value : "无");
        System.out.println(ans2 != null ? ans2.value : "无");

        ans1 = midOrUpMidPreNode(test);
        ans2 = right3(test);
        System.out.println(ans1 != null ? ans1.value : "无");
        System.out.println(ans2 != null ? ans2.value : "无");

        ans1 = midOrDownMidPreNode(test);
        ans2 = right4(test);
        System.out.println(ans1 != null ? ans1.value : "无");
        System.out.println(ans2 != null ? ans2.value : "无");

    }



}
