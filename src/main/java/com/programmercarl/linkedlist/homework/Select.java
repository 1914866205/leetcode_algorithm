package com.programmercarl.linkedlist.homework;

/**
 * @ClassName Select
 * @Descriotion TODO
 * @Author nitaotao
 * @Date 2022/5/5 17:15
 * @Version 1.0
 **/
public class Select {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 9, 9, 10};
        getIndex(arr, 0);
        getIndex(arr, 1);
        getIndex(arr, 9);
        getIndex(arr, 10);
        getIndex(arr, 11);
    }

    public static void getIndex(int[] arr, int target) {
        //设置哨兵
        int end = arr.length;
        if (arr[end - 1] < target || arr[0] > target) {
            System.out.println("查找到元素 " + target + " 不在当前顺序表中");
        }
        for (int i = 0; i < end; i++) {
            if (arr[i] == target) {
                System.out.println("查找到元素 " + target + " 位置为：" + i);
            }
        }
    }
}
