package mca.class11;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName TreeMaxWidth
 * @Descriotion TODO
 * @Author nitaotao
 * @Date 2022/10/9 11:58
 * @Version 1.0
 * 求树的最大宽度
 **/
public class TreeMaxWidth {
    public static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public static int maxWidthNoMap(Node head) {
        if (head == null) {
            return 0;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(head);
        //本层尾结点
        Node curEnd = head;
        //当前层尾结点
        Node nextEnd = null;
        //最大宽度
        int max = 0;
        //当前层的宽度
        int curWidth = 0;
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            curWidth++;
            if (cur.left != null) {
                queue.add(cur.left);
                nextEnd = cur.left;
            }
            if (cur.right != null) {
                queue.add(cur.right);
                nextEnd = cur.right;
            }
            if (cur == curEnd) {
                max = Math.max(max, curWidth);
                curWidth = 0;
                curEnd = nextEnd;
            }
        }
        return max;
    }


    public static int maxWidthUseMap(Node head) {
        if (head == null) {
            return 0;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(head);
        HashMap<Node, Integer> map = new HashMap<>();
        map.put(head, 1);

        int maxWidth = 0;
        int curLevelNodes = 0;
        int curLevel = 1;

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            //被遍历的结点的层级
            int nodeLevel = map.get(node);

            if (node.left != null) {
                queue.add(node.left);
                map.put(node, nodeLevel + 1);
            }
            if (node.right != null) {
                queue.add(node.right);
                map.put(node, nodeLevel + 1);
            }
            if (nodeLevel == curLevel) {
                //如果是当前层
                curLevelNodes++;
            } else {
                //如果不是当前层，则说明进入了下一层
                maxWidth = Math.max(maxWidth, curLevelNodes);
                //本层结点计数器置为1
                curLevelNodes = 1;
                //进入下一轮比对
                curLevel++;
            }
        }
        maxWidth = Math.max(maxWidth, curLevelNodes);
        return maxWidth;
    }

}
