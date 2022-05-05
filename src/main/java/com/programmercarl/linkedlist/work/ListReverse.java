package com.programmercarl.linkedlist.work;

import com.programmercarl.linkedlist.domain.ListNode;

import java.util.List;

/**
 * @ClassName ListReverse
 * @Descriotion TODO
 * @Author nitaotao
 * @Date 2022/5/5 13:31
 * @Version 1.0
 **/
public class ListReverse {
    public static void main(String[] args) {
        ListNode node5 = ListNode.builder().val(5).next(null).build();
        ListNode node4 = ListNode.builder().val(4).next(node5).build();
        ListNode node3 = ListNode.builder().val(3).next(node4).build();
        ListNode node2 = ListNode.builder().val(2).next(node3).build();
        ListNode node1 = ListNode.builder().val(1).next(node2).build();
        listReverse(node1);
    }

    public static void listReverse(ListNode node) {
        //当前结点
        ListNode temp1 = new ListNode();
        //当前结点下一个结点
        ListNode temp2 = new ListNode();
        //处理头结点
        if (node == null) {
            return;
        }
        //只有1个结点
        if (node.next == null) {
            System.out.println(node.val);
            return;
        } else {
            temp1.next = node;
            if (node.next.next != null) {
                temp2.next = node.next;
                node.next = null;
            } else {
                //只有2个结点
                node.next.next = node;
                node.next = null;
                return;
            }
        }
        //当有下个结点
        ListNode temp;
        while (temp2.next.next != null) {
            //下下个结点
            temp = ListNode.builder().next(temp2.next.next).build();
            //原链表结点断开，变换
            temp2.next.next = temp1.next;
            //当前结点后移
            temp1.next = temp2.next;
            //当前结点下一个结点后移
            temp2.next = temp.next;
        }
        //最后一个结点
        temp2.next.next = temp1.next;
        System.out.println(temp2.next);
    }
}
