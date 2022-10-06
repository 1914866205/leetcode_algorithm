package mca.class09;

import java.util.HashMap;

/**
 * @ClassName CopyListWithRandom
 * @Descriotion TODO
 * @Author nitaotao
 * @Date 2022/10/6 22:45
 * @Version 1.0
 * 复制带随机指针的链表 https://leetcode.cn/problems/copy-list-with-random-pointer/
 **/
public class CopyListWithRandom {
    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    /**
     * 使用容器
     *
     * @param head
     * @return
     */
    public Node copyRandomList(Node head) {
        // key  老结点   value   新结点
        HashMap<Node, Node> map = new HashMap<>();
        Node cur = head;
        while (cur != null) {
            //创建映射关系，可以直接根据map找到对应的结果
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }
        cur = head;
        while (cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }

    public static Node copyRandomList2(Node head) {
        if (head == null) {
            return null;
        }
        Node cur = head;
        Node next = null;
        // 1 -> 2 -> 3
        // 变为 1 -> 1` -> 2 -> 2` -> 3 -> 3`
        while (cur != null) {
            next = cur.next;
            cur.next = new Node(cur.val);
            cur.next.next = next;
            cur = next;
        }
        cur = head;
        Node copy = null;
        //  1 1` 2 2` 3 3`
        // 依次设置 1` 2` 3`的random指针
        while (cur != null) {
            next = cur.next.next;
            copy = cur.next;
            copy.random = cur.random == null ? null : cur.random.next;
            cur = next;
        }
        Node res = head.next;
        cur = head;
        //新 老 混在一起，next方向上，random正确
        while (cur != null) {
            next = cur.next.next;
            copy = cur.next;

            cur.next = next;
            copy.next = next == null ? null : next.next;
            cur = next;
        }
        return res;
    }

}
