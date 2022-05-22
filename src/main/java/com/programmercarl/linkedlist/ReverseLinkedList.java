package com.programmercarl.linkedlist;
import com.programmercarl.linkedlist.domain.ListNode;
/**
 * @ClassName ReverseLinkedList
 * @Descriotion 206.反转链表
 * @Author nitaotao
 * @Date 2022/5/10 7:58
 * @Version 1.0
 * https://leetcode.cn/problems/reverse-linked-list/
 **/
public class ReverseLinkedList {
    public static void main(String[] args) {
        ListNode node5 = ListNode.builder().val(5).next(null).build();
        ListNode node4 = ListNode.builder().val(4).next(node5).build();
        ListNode node3 = ListNode.builder().val(3).next(node4).build();
        ListNode node2 = ListNode.builder().val(2).next(node3).build();
        ListNode node1 = ListNode.builder().val(1).next(node2).build();
        System.out.println( reverseList(node1));
    }

    /**
     * 反转链表
     *
     * @param head 单链表的头结点(不是头指针)，是不一定存在的
     * @return 思路：
     * 一、考虑特殊情况
     * 1. 如果头结点是空，返回空
     * 2. 如果只有一个头结点，返回头结点
     * 3. 如果只有两个结点，逆序一下
     * <p>
     * 二、 如果两个以上
     * 1. 设置临时结点指向右边的第二个
     * 2. 右虚拟头结点指向的元素指向左虚拟头结点指向的元素
     * 3. 左虚拟头结点左移（右虚拟头结点的值赋值为左虚拟头结点的值）
     * 4. 右虚拟头结点归位（临时结点的值赋值为右虚拟头结点）
     */
    public static ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        if (head.next.next == null) {
            ListNode newHead = head.next;
            newHead.next = head;
            head.next = null;
            return newHead;
        }

        //左边虚拟头结点，是左边第一个元素的左边（实际不存在）
        ListNode leftHead = new ListNode(0, head);
        //右边虚拟头结点，是右边第一个元素的左边（实际不存在)
        ListNode rightHead = new ListNode(0, head.next);

        //右边第二个元素
        ListNode rightSecond =head.next.next;
        //头结点断开
        head.next = null;
        //如果右边第二个元素存在
        while (rightSecond != null) {
            // 右虚拟头结点指向的元素指向左虚拟头结点指向的元素
            rightHead.next.next = leftHead.next;
            // 左虚拟头结点左移
            leftHead.next = rightHead.next;
            // 右虚拟头结点归位
            rightHead.next = rightSecond;
            // 右边第二个元素右移
            rightSecond = rightSecond.next;
        }
        //如果右边第二个元素不存在，右边只剩一个元素
        rightHead.next.next = leftHead.next;
        return rightHead.next;
    }
}
