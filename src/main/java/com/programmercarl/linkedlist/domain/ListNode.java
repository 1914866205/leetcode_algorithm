package com.programmercarl.linkedlist.domain;

/**
 * @ClassName ListNode
 * @Descriotion 单链表的结点
 * @Author nitaotao
 * @Date 2022/5/2 17:24
 * @Version 1.0
 **/
public class ListNode {
    /**
     * 结点的值
     */
    public Integer val;

    /**
     * 下一个结点
     */
    public ListNode next;

    /**
     * 无参构造
     */
    public ListNode() {
    }

    /**
     * 带参构造 1
     */
    public ListNode(int val) {
        this.val = val;
    }

    /**
     * 带参构造 2
     */
    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
