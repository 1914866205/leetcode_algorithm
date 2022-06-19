package com.programmercarl.linkedlist;

import com.programmercarl.linkedlist.domain.ListNode;
import org.apache.bcel.generic.NEW;

/**
 * @ClassName DetectCycle
 * @Descriotion https://leetcode.cn/problems/linked-list-cycle-ii/
 * @Author nitaotao
 * @Date 2022/6/19 14:38
 * @Version 1.0
 * 环形链表 II
 **/
public class DetectCycle {
    public static void main(String[] args) {
        ListNode node4 = ListNode.builder().val(4).next(null).build();
        ListNode node3 = ListNode.builder().val(3).next(node4).build();
        ListNode node2 = ListNode.builder().val(2).next(node3).build();
        ListNode node1 = ListNode.builder().val(1).next(node2).build();
        node4.next = node2;
        System.out.println(detectCycle(node1).val);
    }

    /**
     * 给定一个链表的头节点 head，返回链表开始入环的第一个节点。如果链表无环，则返回null。
     * <p>
     * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
     * <p>
     * 不允许修改 链表。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/linked-list-cycle-ii
     *
     * @param head
     * @return
     */
    public static ListNode detectCycle(ListNode head) {
        /**
         * 提示：
         * 链表中节点的数目范围在范围 [0, 104] 内
         * -10^5 <= Node.val <= 10^5
         * pos 的值为 -1 或者链表中的一个有效索引
         */
        //我打算从边界值入手
        if (head == null || head.next == null) {
            return null;
        }
        ListNode newHead = head;
        while (newHead.val < 100000 ) {
            newHead.val += 1000000;
            newHead = newHead.next;
            if (newHead == null) {
                return null;
            }
        }
        //此时的newHead就是要返回的结果结点
        ListNode resultNode = newHead;
        //此时所有遍历过的结点，值是>100000的
        newHead = head;
        while (newHead.val > 100000) {
            newHead.val -= 1000000;
            newHead = newHead.next;
        }
        return resultNode;
    }
}
