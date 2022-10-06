package mca.class09;

/**
 * @ClassName SmallerEqualBigger
 * @Descriotion TODO
 * @Author nitaotao
 * @Date 2022/10/6 20:26
 * @Version 1.
 * 把单向链表按某个值分成 左边小 中间相等 右边大的形式
 **/
public class SmallerEqualBigger {
    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }


    /**
     * 使用数组
     *
     * @param head
     * @param pivot
     * @return
     */
    public static Node listPartition(Node head, int pivot) {
        if (head == null) {
            return head;
        }
        Node cur = head;
        //计算有多少个结点
        int count = 0;
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        Node[] arr = new Node[count];
        cur = head;
        int i = 0;
        //把结点依次存到数组中
        for (; i < count; i++) {
            arr[i] = cur;
            cur = cur.next;
        }
        arrPartition(arr, pivot);
        //从左往右 依次串起来
        for (i = 1; i < count; i++) {
            arr[i - 1].next = arr[i];
        }
        //链表头
        return arr[0];
    }

    /**
     * 从左往右找，大的放右边，等于直接后移，小于 和 等于 最左的 交换
     *
     * @param arr
     * @param pivot
     */
    private static void arrPartition(Node[] arr, int pivot) {
        int small = -1;
        int big = arr.length;
        //仿照快速排序
        int index = 0;
        while (index != big) {
            if (arr[index].value > pivot) {
                //如果当前值比目标值大
                big--;
                swap(arr, index, big);
            } else if (arr[index].value == pivot) {
                index++;
            } else {
                //当前值比目标值小
                small++;
                //交换等于位置的左边界和当前的小于元素的位置
                swap(arr, small, index);
                index++;
            }
        }
    }

    public static void swap(Node[] arr, int a, int b) {
        Node temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }


    public static Node listPartition2(Node head, int pivot) {
        Node smallHead = null;
        Node smallTail = null;
        Node equalHead = null;
        Node equalTail = null;
        Node moreHead = null;
        Node moreTail = null;

        Node cur = null;
        while (head != null) {
            cur = head.next;
            //断开连接
            head.next = null;
            if (head.value < pivot) {
                if (smallHead == null) {
                    smallHead = cur;
                    smallTail = cur;
                } else {
                    smallTail.next = cur;
                    smallTail = cur;
                }
            } else if (head.value == pivot) {
                if (equalHead == null) {
                    equalHead = cur;
                    equalTail = cur;
                } else {
                    equalTail.next = cur;
                    equalTail = cur;
                }
            } else {
                if (moreHead == null) {
                    moreHead = cur;
                    moreTail = cur;
                } else {
                    moreTail.next = cur;
                    moreTail = cur;
                }
            }
            head = cur;
        }
        // 小于 等于 大于
        //可能没有小于
        //可能没有等于
        //可能没有大于


        //小于区域的尾巴 连接 等于区域的头，等于区域的尾巴连接大于区域的头
        if (smallTail != null) {
            //如果有小于区域
            smallTail.next = equalHead;
            //如果有等于区域就连接等于区域，如果没有等于区域，则小于即等于
            equalTail = equalTail == null ? smallTail : equalTail;
        }
        //连大于区域的头
        if (equalTail != null) {
            equalTail.next = moreHead;
        }
        //如果没有等于区域
        //则可能只有
        return smallHead != null ? smallHead : (equalHead != null ? equalHead : moreHead);
    }

    public static void printLinkedList(Node node) {
        System.out.print("Linked List: ");
        while (node != null) {
            System.out.print(node.value + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head1 = new Node(7);
        head1.next = new Node(9);
        head1.next.next = new Node(1);
        head1.next.next.next = new Node(8);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(2);
        head1.next.next.next.next.next.next = new Node(5);
        printLinkedList(head1);
        head1 = listPartition(head1, 4);
//        head1 = listPartition2(head1, 5);
        printLinkedList(head1);

    }

}
