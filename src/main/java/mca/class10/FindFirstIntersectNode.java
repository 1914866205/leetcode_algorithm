package mca.class10;

/**
 * @ClassName FindFirstIntersectNode
 * @Descriotion TODO
 * @Author nitaotao
 * @Date 2022/10/7 14:07
 * @Version 1.0
 * 给定两个可能有环也可能无环的单链表，头节点head1和head2。
 * 请实现一个函数，如果两个链表相交，请返回相交的 第一个节点。如果不相交，返回null
 * 【要求】
 * 如果两个链表长度之和为N，时间复杂度请达到O(N)，额外空间复杂度 请达到O(1)
 **/
public class FindFirstIntersectNode {
    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    public static Node getIntersectNode(Node head1, Node head2) {
        if (head1 == null || head2 == null) {
            return null;
        }
        //要么两个都有环，要么两个都无环
        //如果一个有环，则代表无止尽，另一个无环，代表有止尽，则代表不相交
        Node loop1 = getLoopNode(head1);
        Node loop2 = getLoopNode(head2);
        if (loop1 == null && loop2 == null) {
            return noLoop(head1, head2);
        }
        if (loop1 != null && loop2 != null) {
            return bothLoop(head1,loop1,head2, loop2);
        }
        return null;
    }




    /**
     * 返回当前链表的环点
     *
     * @param head
     * @return
     */
    private static Node getLoopNode(Node head) {
        if (head == null || head.next == null || head.next.next == null) {
            return null;
        }
        Node fast = head.next.next;
        Node slow = head.next;
        while (fast != slow) {
            if (fast.next == null || fast.next.next == null) {
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        //此时 fast == slow
        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }

    /**
     * 无环时找共同结点
     *
     * @param head1
     * @param head2
     * @return
     */
    private static Node noLoop(Node head1, Node head2) {
        if (head1 == null || head2 == null) {
            return null;
        }
        int count1 = 0;
        int count2 = 0;
        Node cur1 = head1;
        Node cur2 = head2;
        while (cur1 != null) {
            count1++;
            cur1 = cur1.next;
        }
        while (cur2 != null) {
            count2++;
            cur2 = cur2.next;
        }
        //如果尾结点不同，则直接无共同点
        if (cur1 != cur2) {
            return null;
        }

        //使长的为1  短的为2
        if (count2 > count1) {
            Node temp = head2;
            head2 = head1;
            head1 = temp;
        }
        //此时 head1为长的，head2为短的
        int time = Math.abs(count1 - count2);
        cur1 = head1;
        cur2 = head2;
        while (time > 0) {
            cur1 = cur1.next;
            time--;
        }
        //此时双方后半段的长度相同
        while (cur1 != cur2) {
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        //因为是无环，所以有尾结点
        //要么双方同时为null，要么双方同时为某结点
        return cur1;
    }

    /**
     * 返回两个带环链表的第一个相交节点
     *
     * @param loop1
     * @param loop2
     * @return
     */
    private static Node bothLoop(Node head1, Node loop1, Node head2, Node loop2) {
        Node cur1 = null;
        Node cur2 = null;
        if (loop1 == loop2) {
            cur1 = head1;
            cur2 = head2;
            //当双方有同一个环点
            //则在之前可以看做为无环的，在之前必有交点
            int n = 0;
            while (cur1 != loop1) {
                n++;
                cur1 = cur1.next;
            }
            while (cur2 != loop2) {
                n--;
                cur2 = cur2.next;
            }
            //此时 n 即为 head1 和 head2 的长度之差
            cur1 = n > 0 ? head1 : head2;
            cur2 = cur1 == head1 ? head2 : head1;
            //cur1为较长，cur2较短
            n = Math.abs(n);
            while (n != 0) {
                cur1 = cur1.next;
            }
            while (cur1 != cur2) {
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
            return cur1;
        } else {
            //如果双方是两个不同的环点
            //则判断双方在不在同一个环
            // 即在loop1中找一遍 看看能不能找到loop2
            cur1 = loop1.next;
            while (cur1 != loop1) {
                if (cur1 == loop2) {
                    //找到就返回cur1
                    return cur1;
                }
                cur1 = cur1.next;
            }
            //否则就返回null
            return null;
        }
    }

}
