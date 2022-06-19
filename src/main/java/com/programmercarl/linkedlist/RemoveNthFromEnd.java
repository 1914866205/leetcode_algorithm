package com.programmercarl.linkedlist;
import com.programmercarl.linkedlist.domain.ListNode;

/**
 * @ClassName RemoveNthFromEnd
 * @Descriotion https://leetcode.cn/problems/remove-nth-node-from-end-of-list/
 * @Author nitaotao
 * @Date 2022/6/19 13:06
 * @Version 1.0
 * 19. 删除链表的倒数第 N 个结点
 **/
public class RemoveNthFromEnd {
    public static void main(String[] args) {
        ListNode node8 = ListNode.builder().val(8).next(null).build();
        ListNode node7 = ListNode.builder().val(7).next(node8).build();
        ListNode node6 = ListNode.builder().val(6).next(node7).build();
        ListNode node5 = ListNode.builder().val(5).next(node6).build();
        ListNode node4 = ListNode.builder().val(4).next(node5).build();
        ListNode node3 = ListNode.builder().val(3).next(node4).build();
        ListNode node2 = ListNode.builder().val(2).next(node3).build();
        ListNode node1 = ListNode.builder().val(1).next(node2).build();
        System.out.println(removeNthFromEnd(node1,1));
    }

    /**
     * 19. 删除链表的倒数第 N 个结点
     *
     * @param head
     * @param n
     * @return
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        //链表结点数量
        int size = 0;
        ListNode index = head;
        while (index != null) {
            size++;
            index = index.next;
        }
        if (n == size) {
            return head.next;
        }
        if (n == 0) {
            return head;
        }
        if (n > size) {
            return head;
        }

        int distance = 0;

        ListNode curNode = head;
        //当前结点的后n位置的结点，当nextNNode==null,当前结点则断开下一个结点
        ListNode nextNNode = head;

        while (distance <= n) {
            distance++;
            nextNNode = nextNNode.next;
        }
        while (nextNNode != null) {
            curNode = curNode.next;
            nextNNode = nextNNode.next;
        }
        curNode.next = curNode.next.next;
        return head;
    }
}
