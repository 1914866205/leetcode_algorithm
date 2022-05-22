package com.datastruct;

/**
 * @ClassName UndirectedGraph
 * @Descriotion TODO
 * @Author nitaotao
 * @Date 2022/5/20 14:59
 * @Version 1.0
 * 数据结构实验三   无向图
 * 0  1  2  3  4  5
 * 0  0  1  1  0  0  1
 * 1  1  0  1  0  0  0
 * 2  1  1  0  1  1  0
 * 3  0  0  1  0  1  1
 * 4  0  0  1  1  0  0
 * 5  1  0  0  1  0  0
 **/
public class UndirectedGraph {
    public static void main(String[] args) {
        int[][] vertexes = new int[6][6];
        vertexes[0] = new int[]{0, 1, 1, 0, 0, 1};
        vertexes[1] = new int[]{1, 0, 1, 0, 0, 0};
        vertexes[2] = new int[]{1, 1, 0, 1, 1, 0};
        vertexes[3] = new int[]{0, 0, 1, 0, 1, 1};
        vertexes[4] = new int[]{0, 0, 1, 1, 0, 0};
        vertexes[5] = new int[]{1, 0, 0, 1, 0, 0};
        //深度优先遍历
        // 0->1->2->3->4->5
        System.out.print("深度优先遍历： ");
        deepPrint(vertexes);

        System.out.println();

        vertexes[0] = new int[]{0, 1, 1, 0, 0, 1};
        vertexes[1] = new int[]{1, 0, 1, 0, 0, 0};
        vertexes[2] = new int[]{1, 1, 0, 1, 1, 0};
        vertexes[3] = new int[]{0, 0, 1, 0, 1, 1};
        vertexes[4] = new int[]{0, 0, 1, 1, 0, 0};
        vertexes[5] = new int[]{1, 0, 0, 1, 0, 0};
        //广度优先遍历
        System.out.print("广度优先遍历： ");
        // 0->1->2->5->3->4
        borderPrint(vertexes);
    }

    /**
     * 广度优先遍历
     *
     * @param arr
     */
    public static void borderPrint(int[][] arr) {
        int size = arr.length;
        System.out.print(0 + " ");
        for (int k = 0; k < arr.length; k++) {
            arr[k][0] = 0;
        }
        size--;
        int i = 0;
        int j = 0;
        while (size > 0) {
            if (arr[i][j] == 1) {
                System.out.print(j + " ");
                size--;
                for (int k = 0; k < arr.length; k++) {
                    arr[k][j] = 0;
                }
            }
            if (j == arr.length - 1) {
                //本次广度优先建立结束，开始下一轮
                i++;
                j = 0;
            } else {
                j++;
            }
        }
    }

    /**
     * 深度优先遍历
     *
     * @param arr
     */
    public static void deepPrint(int[][] arr) {
        int size = arr.length;
        System.out.print(0 + " ");
        for (int k = 0; k < arr.length; k++) {
            arr[k][0] = 0;
        }
        size--;
        int i = 0;
        int j = 0;
        int index = 0;
        int temp;
        while (size > 0) {
            if (arr[i][j] == 1) {
                System.out.print(j + " ");
                size--;
                for (int k = 0; k < arr.length; k++) {
                    arr[k][j] = 0;
                }
                temp = i;
                i = j;
                j = temp;
            } else {
                if (j == arr.length - 1) {
                    //本次深度优先遍历结束，开始下一轮
                    index++;
                    i = index;
                    j = 0;
                } else {
                    j++;
                }
            }
        }
    }


}
