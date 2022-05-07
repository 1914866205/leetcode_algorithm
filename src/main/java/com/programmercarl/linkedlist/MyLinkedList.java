package com.programmercarl.linkedlist;

/**
 * @ClassName DesignLinkedList
 * @Descriotion https://leetcode-cn.com/problems/design-linked-list/
 * @Author nitaotao
 * @Date 2022/5/7 9:17
 * @Version 1.0
 * 707. 设计链表
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 * 设计链表的实现。您可以选择使用单链表或双链表。
 * 单链表中的节点应该具有两个属性：val 和 next。val 是当前节点的值，next 是指向下一个节点的指针/引用。
 * 如果要使用双向链表，则还需要一个属性 prev 以指示链表中的上一个节点。假设链表中的所有节点都是 0-index 的。
 * 在链表类中实现这些功能：
 * <p>
 * get(index)：获取链表中第 index 个节点的值。如果索引无效，则返回-1。
 * addAtHead(val)：在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。
 * addAtTail(val)：将值为 val 的节点追加到链表的最后一个元素。
 * addAtIndex(index,val)：在链表中的第 index 个节点之前添加值为 val  的节点。如果 index 等于链表的长度，则该节点将附加到链表的末尾。如果 index 大于链表长度，则不会插入节点。如果index小于0，则在头部插入节点。
 * deleteAtIndex(index)：如果索引 index 有效，则删除链表中的第 index 个节点。
 */
class ListNode {
    int val;
    ListNode next;

    public ListNode() {
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}

public class MyLinkedList {
    //链表长度
    int size;
    //虚拟头结点
    ListNode head;

    @Override
    public String toString() {
        return "MyLinkedList{" +
                "size=" + size +
                ", head=" + head +
                '}';
    }

    public MyLinkedList() {
        this.size = 0;
        this.head = new ListNode(0, null);
    }

    /**
     * 获取链表中第 index 个节点的值。如果索引无效，则返回-1。
     *
     * @param index
     * @return
     */
    public int get(int index) {
        if (index >= size || index < 0) {
            return -1;
        }
        if (index == 0) {
            return head.next.val;
        }
        ListNode curNode = head;
        int curIndex = -1;
        while (curIndex != index) {
            curNode = curNode.next;
            curIndex++;
        }
        return curNode.val;
    }

    /**
     * 在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。
     *
     * @param val
     */
    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    /**
     * 将值为 val 的节点追加到链表的最后一个元素。
     *
     * @param val
     */
    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    /**
     * 在链表中的第 index 个节点之前添加值为 val  的节点。
     * 如果 index 等于链表的长度，则该节点将附加到链表的末尾。
     * 如果 index 大于链表长度，则不会插入节点。如果index小于0，则在头部插入节点。
     *
     * @param index
     * @param val
     */
    public void addAtIndex(int index, int val) {
        if (index > size) {
            return;
        }
        if (index < 0) {
            index = 0;
        }
        size++;
        ListNode prep = head;
        for (int i = 0; i < index; i++) {
            prep = prep.next;
        }
        //待插入的位置
        prep.next = new ListNode(val, prep.next);
    }

    /**
     * 如果索引 index 有效，则删除链表中的第 index 个节点。
     *
     * @param index
     */
    public void deleteAtIndex(int index) {
        //结点范围 [0,size-1]
        if (index < 0 || index >= size) {
            return;
        }
        size--;
        ListNode prep = head;
        for (int i = 0; i < index; i++) {
            prep = prep.next;
        }
        prep.next = prep.next.next;
    }
}

