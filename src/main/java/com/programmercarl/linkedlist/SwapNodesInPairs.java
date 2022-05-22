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

    public static ListNode swapPairs(ListNode head) {
        //处理特殊情况
        // 空结点
        if (head == null) {
            return null;
        }
        // 只有一个结点
        if (head.next == null) {
            return head;
        }
        //只有两个结点
        if (head.next.next == null) {
            ListNode secondNode = head.next;
            secondNode.next = head;
            head.next = null;
            return secondNode;
        }

        //如果有两个以上的结点
        int size = 0;
        // 查询结点个数
        ListNode index = new ListNode(0, head);
        while (index.next != null) {
            size++;
            index = index.next;
        }
        if (size % 2 == 0) {
            //偶数个结点
            //newHead直接指向第二个
            ListNode newHead = new ListNode(0, head.next);
            //指向当前结点的虚拟指针
            ListNode preNode = new ListNode(0, head);
            //指向右边下一组变换的左结点  即 3 5 7 9这些，是指向，而不是就是
            ListNode rightNode = new ListNode(0, preNode.next.next.next);

            int i = 1;
            //如果有3 5 7 9
            while (rightNode.next.next != null) {
                System.out.println("循环"+i+"次");
                i++;
                //暂存右侧头结点
                //暂存3 5 7 9
                rightNode.next = preNode.next.next.next;
                //中间结点断开，指向前一个结点
                preNode.next.next.next = preNode.next;
                //当前结点指向右边
                preNode.next.next = rightNode.next.next;
                //左边头指针右移
                preNode.next = rightNode.next;
            }
            return newHead.next;
        } else {
            //奇数个结点
            ListNode newHead = new ListNode(0, head.next);
            //指向当前结点的虚拟指针
            ListNode preNode = new ListNode(0, head);
            ListNode rightNode = preNode.next.next.next;
            //下一组两个结点都存在
            while (preNode.next.next.next != null && preNode.next.next.next.next != null) {
                //暂存右侧头结点
                //暂存3 5 7 9
                rightNode.next = preNode.next.next.next;
                //中间结点断开，指向前一个结点
                preNode.next.next.next = preNode.next;
                //当前结点指向右边
                preNode.next.next = rightNode.next;
                //左边头指针右移
                preNode.next = rightNode.next;
            }
            //此时会余下最后一个结点
            preNode.next = rightNode.next.next;

            return newHead.next;
        }
    }
}
