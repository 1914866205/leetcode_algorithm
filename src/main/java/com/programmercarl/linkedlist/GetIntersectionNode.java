package com.programmercarl.linkedlist;

import java.util.List;

/**
 * @ClassName GetIntersectionNode
 * @Descriotion TODO
 * @Author nitaotao
 * @Date 2022/6/19 13:34
 * @Version 1.0
 **/
public class GetIntersectionNode {
    public static void main(String[] args) {

    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //获取头结点的起始结点
        ListNode curA = headA;
        ListNode curB = headB;
        //两层循环遍历
        while (curA != null) {
            while (curB != null) {
                //地址相等则为同一个结点，即相交
                if (curA == curB) {
                    return curA;
                }
                curB = curB.next;
            }
            curA = curA.next;
            curB = headB;
        }
        return null;
    }
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        //获取头结点的起始结点
        ListNode curA = headA;
        ListNode curB = headB;
        int lenA = 0;
        int lenB = 0;
        //A的长度
        while (curA != null) {
            lenA++;
            curA = curA.next;
        }
        //B的长度
        while (curB != null) {
            lenB++;
            curB = curB.next;
        }
        curA = headA;
        curB = headB;

        //让curA为最长链表的头，lenA为其长度
        if (lenB > lenA) {
            int temLen = lenA;
            lenA = lenB;
            lenB = temLen;
            ListNode tempNode = curA;
            curA = curB;
            curB = tempNode;
        }

        //求长度差
        int gap = lenA - lenB;

        //让curA和curB在同一起点，末尾位置对齐，因为如果是同一结点，后面肯定是相同的。
        while (gap > 0) {
            curA = curA.next;
            gap--;
        }
        //此时，curA和curB右对齐
        while (curA != null) {
            if (curA == curB) {
                return curA;
            }
            curA = curA.next;
            curB = curB.next;
        }
        return null;
    }
}
