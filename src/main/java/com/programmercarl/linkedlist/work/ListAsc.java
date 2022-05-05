package com.programmercarl.linkedlist.work;

import com.programmercarl.linkedlist.domain.ListNode;

/**
 * @ClassName ListAsc
 * @Descriotion TODO
 * @Author nitaotao
 * @Date 2022/5/5 17:23
 * @Version 1.0
 **/
public class ListAsc {
    public static void main(String[] args) {
        ListNode node5 = ListNode.builder().val(5).next(null).build();
        ListNode node4 = ListNode.builder().val(2).next(node5).build();
        ListNode node3 = ListNode.builder().val(16).next(node4).build();
        ListNode node2 = ListNode.builder().val(8).next(node3).build();
        ListNode node1 = ListNode.builder().val(1).next(node2).build();
        order(node1);
        System.out.println(node1);
    }

    /**
     * 简单选择排序
     *
     * @param node
     */
    public static void order(ListNode node) {
        //已排好序的最大结点
        ListNode orderMaxNode = node;
        //当前正在比较的阶段
        ListNode curNode;
        int temp;
        while (orderMaxNode != null) {
            //如果右边无序部分还有元素
            curNode = orderMaxNode.next;
            while (curNode != null) {
                //每次把右边无序部分的最小值选择出来
                if (curNode.val < orderMaxNode.val) {
                    temp = curNode.val;
                    curNode.val = orderMaxNode.val;
                    orderMaxNode.val = temp;
                } else {
                    curNode = curNode.next;
                }
            }
            //逐渐后移，最小值逐渐变大
            orderMaxNode = orderMaxNode.next;
        }
    }
}
