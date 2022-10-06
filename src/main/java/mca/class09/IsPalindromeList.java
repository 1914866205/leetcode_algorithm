package mca.class09;

import java.util.Stack;

/**
 * @ClassName IsPalindromeList
 * @Descriotion TODO
 * @Author nitaotao
 * @Date 2022/10/6 17:59
 * @Version 1.0
 * 第77集，判断该链表是否是回文链表
 **/
public class IsPalindromeList {
    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    /**
     * 判断链表是否是回文链表
     * <p>
     * 需要n个额外空间
     *
     * @param head
     * @return
     */
    public static boolean isPalindrome1(Node head) {
        //借助容器 栈
        Stack<Node> stack = new Stack<>();
        //先全部压栈，再一个个弹出比较。
        //因为栈是先进后出，所以是后面的元素和链表前面的元素比较
        Node cur = head;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        while (head != null) {
            if (stack.pop().value != head.value) {
                return false;
            } else {
                head = head.next;
            }
        }
        return true;
    }

    /**
     * 对上面代码进行改进，使其额外空间缩小一半
     *
     * @param head
     * @return
     */
    public static boolean isPalindrome2(Node head) {
        if (head == null || head.next == null) {
            return true;
        }
        //右边第一个结点
        Node right = head.next;
        //当前结点
        Node cur = head;
        while (cur.next != null && cur.next.next != null) {
            right = right.next;
            cur = cur.next.next;
        }
        //此时cur结点到尾部，right到中间
        Stack<Node> stack = new Stack<>();
        while (right != null) {
            stack.push(right);
            right = right.next;
        }
        while (!stack.isEmpty()) {
            if (stack.pop().value != head.value) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    /**
     * 遍历到中点，之后的链表反转指向，相互比较，再转回来
     *
     * @param head
     * @return
     */
    public static boolean isPalindrome(Node head) {
        if (head == null || head.next == null) {
            return true;
        }
        Node slow = head;
        Node fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        //此时快指针到倒数第二个
        //慢指针到达中点 奇数个就到达中点前一个
        //            偶数个就到达左中点
        // 让快指针到达中点
        fast = slow.next;
        //断开中点
        slow.next = null;
        Node node = null;
        while (fast != null) {
            //存储下一个结点
            node = fast.next;
            fast.next = slow;
            //慢指针后移
            slow = fast;
            //快指针后移
            fast = node;
        }
        //此时 node==fast==null,即slow为尾结点
        // 让node为尾结点
        node = slow;
        fast = head;
        boolean res = true;
        while (fast != null && slow != null) {
            if (fast.value != slow.value) {
                res = false;
                break;
            }
            fast = fast.next;
            slow = slow.next;
        }
        //slow此时为倒数第二个结点
        slow = node.next;
        //断开尾结点
        node.next = null;
        //node此时为尾结点
        //fast此时为发送不一致位置的结点
        //恢复链表
        //  fast  slow | node
        while (slow != null) {
            //逆置回去
            fast = slow.next;
            slow.next = node;
            //慢指针前移
            node = slow;
            //快指针前移
            slow = fast;
        }
        return res;
    }

}
