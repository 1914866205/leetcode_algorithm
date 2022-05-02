package com.programmercarl.linkedlist;

import com.programmercarl.linkedlist.domain.ListNode;

/**
 * @ClassName removeElements
 * @Descriotion 203. 移除链表元素
 * @Author nitaotao
 * @Date 2022/5/2 17:33
 * @Version 1.0
 * https://leetcode-cn.com/problems/remove-linked-list-elements/
 **/
public class RemoveElements {

    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        //head是头结点，是第一个结点
        ListNode node = head;
        //先判断第一位
        while (node.val == val) {
            if (node.next != null) {
                //直接舍弃结点
                node = node.next;
                //头结点移位
                head = node;
            } else {
                //如果只有一个头结点，而且是目标值，直接返回null
                return null;
            }
        }
        //如果第一位不为目标值
        //如果当前结点有下一个元素
        while (node.next != null) {
            //是目标值
            if (node.next.val == val) {
                //判断有无下下个结点
                if (node.next.next != null) {
                    node.next = node.next.next;
                } else {
                    node.next = null;
                }
            } else {
                //元素后移
                node = node.next;
            }
        }
        return head;
    }
}
