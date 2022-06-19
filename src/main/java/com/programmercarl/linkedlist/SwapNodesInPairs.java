package com.programmercarl.linkedlist;

import com.programmercarl.linkedlist.domain.ListNode;


/**
 * @ClassName SwapNodesInPairs
 * @Descriotion TODO
 * @Author nitaotao
 * @Date 2022/5/10 11:16
 * @Version 1.0
 **/
public class SwapNodesInPairs {
    public static void main(String[] args) {
        ListNode node8 = ListNode.builder().val(8).next(null).build();
        ListNode node7 = ListNode.builder().val(7).next(node8).build();
        ListNode node6 = ListNode.builder().val(6).next(node7).build();
        ListNode node5 = ListNode.builder().val(5).next(node6).build();
        ListNode node4 = ListNode.builder().val(4).next(node5).build();
        ListNode node3 = ListNode.builder().val(3).next(node4).build();
        ListNode node2 = ListNode.builder().val(2).next(node3).build();
        ListNode node1 = ListNode.builder().val(1).next(node2).build();
        System.out.println(swapPairs(node1));
    }

    /**
     * 虚拟头结点
     * 一共需要四个指针
     * 当前结点前一个结点 当前结点 当前结点后一个结点 当前结点后第二个结点
     *
     * @param head
     * @return
     */
    public static ListNode swapPairs(ListNode head) {
        //判断是否是空头结点
        if (head == null) {
            return null;
        }

        //当前结点
        ListNode curNode = head;
        //设置虚拟头结点
        ListNode preHead = new ListNode(0, head);
        //当前结点的前一个结点的位置,初始值代表虚拟头结点
        ListNode preCurNode = preHead;
        while (curNode != null) {
            if (curNode.next == null) {
                //如果当前结点是最后一个结点
                return preHead.next;
            }
            //当前结点还有下一个结点
            ListNode nextNode = curNode.next;
            //当前结点的下下个结点，这个可能为null
            ListNode thirdNode = nextNode.next;

            //当前结点的前一个结点位置后移
            preCurNode.next = nextNode;
            //2->1
            nextNode.next = curNode;
            //1->3
            curNode.next = thirdNode;

            //当前结点的前一个结点位置后移
            preCurNode = curNode;

            //当前结点后移
            curNode = curNode.next;
        }
        return preHead.next;
    }
}
