package com.programmercarl.linkedlist;


/**
 * @ClassName MyLinkedListAgent
 * @Descriotion TODO
 * @Author nitaotao
 * @Date 2022/5/7 18:15
 * @Version 1.0
 **/
class NodeList{
    int val;
    NodeList next;

    public NodeList() {
    }

    public NodeList(int val, NodeList next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return "NodeList{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}


public class MyLinkedListAgent {
    //长度
    int size;
    //虚拟头结点
    ListNode head;

    public MyLinkedListAgent() {
        this.size = 0;
        this.head = new ListNode(0, null);
    }

    /**
     * get(index)：获取链表中第 index 个节点的值。如果索引无效，则返回-1。
     *
     * @param index
     * @return
     */
    public int get(int index) {
        //无效索引
        if (index >= size || index < 0) {
            return -1;
        }
        //此时剩下的范围就是 [0,size-1]
        //当然要左右都闭区间
        ListNode preNode = head;
        for (int i = 0; i <=index; i++) {
            preNode = preNode.next;
        }
        return preNode.val;
    }

    /**
     * addAtHead(val)：在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。
     * @param val
     */
    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    /**
     * addAtTail(val)：将值为 val 的节点追加到链表的最后一个元素。
     * @param val
     */
    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    /**
     * addAtIndex(index,val)：在链表中的第 index 个节点之前添加值为 val  的节点。
     * 如果 index 等于链表的长度，则该节点将附加到链表的末尾。
     * 如果 index 大于链表长度，则不会插入节点。
     * 如果index小于0，则在头部插入节点。
     * @param index
     * @param val
     */
    public void addAtIndex(int index, int val) {
//     * 如果 index 大于链表长度，则不会插入节点。
        if (index > size) {
            return;
        }
        if (index < 0) {
            index = 0;
        }
        size++;
        ListNode preNode = head;
        for (int i = 0; i < index; i++) {
            preNode = preNode.next;
        }
        //如果是最后一位。preNode.next==null，此时依旧为null
        preNode.next = new ListNode(val, preNode.next);
    }

    /**
     * deleteAtIndex(index)：如果索引 index 有效，则删除链表中的第 index 个节点。
     *
     * @param index
     */
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        size--;
        ListNode preNode = head;
        for (int i = 0; i < index; i++) {
            preNode = preNode.next;
        }
        preNode.next = preNode.next.next;
    }
}
