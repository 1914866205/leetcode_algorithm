package com.programmercarl.linkedlist.work;

import com.programmercarl.linkedlist.domain.ListNode;

/**
 * @ClassName Queue
 * @Descriotion TODO
 * @Author nitaotao
 * @Date 2022/5/5 16:20
 * @Version 1.0
 **/
public class Queue {
    public static void main(String[] args) {
        ListNode node5 = ListNode.builder().val(5).build();
        ListNode node4 = ListNode.builder().val(4).next(node5).build();
        ListNode node3 = ListNode.builder().val(3).next(node4).build();
        ListNode node2 = ListNode.builder().val(2).next(node3).build();
        ListNode node1 = ListNode.builder().val(1).next(node2).build();
        node5.next = node1;

        ListNode node6 = ListNode.builder().val(6).build();
        put(node5, node6);
        System.out.println(node1);
        pop(node6, node3);
        System.out.println(node1);
    }

    /**
     * 入队
     *
     * @param targetQueueEnd 队尾指针
     * @param node
     */
    public static void put(ListNode targetQueueEnd, ListNode node) {
        //先加入新结点
        node.next = targetQueueEnd.next;
        //再断开原结点
        targetQueueEnd.next = node;
    }

    /**
     * 出队
     *
     * @param targetQueueEnd 队尾指针
     * @param node
     * @return
     */
    public static void pop(ListNode targetQueueEnd, ListNode node) {
        //当前指针
        ListNode cur = targetQueueEnd.next;
        if (cur.val == node.val) {
            targetQueueEnd.next = targetQueueEnd.next.next;
            return;
        }
        while (targetQueueEnd != cur) {
            if (cur.next.val.equals(node.val)) {
                //断开连接
                cur.next = cur.next.next;
                return;
            }
            cur = cur.next;
        }
    }
}
