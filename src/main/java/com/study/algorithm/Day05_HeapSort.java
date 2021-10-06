package com.study.algorithm;

import com.sun.org.apache.bcel.internal.generic.SWAP;

/**
 * @author 倪涛涛
 * @version 1.0.0
 * @ClassName Day05_HeapSort.java
 * @Description TODO
 * @createTime 2021年09月01日 17:18:00
 */
public class Day05_HeapSort {
    public static void heapSort(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }
        for (int i = 0; i < array.length; i++) {
            //依次添加数组中的数进入堆结构
            heapInsert(array, i);
        }
        //堆的大小
        int size = array.length;
        while (size > 0) {
            heapify(array, 0, size);
            //调换堆结构中第一个结点和最后一个结点的数，并把末尾结点（已找到的最大值）从堆结构中删除
            swap(array, 0, --size);
        }
    }

    /**
     *
     * @param array 原数组
     * @param index 父结点下标
     * @param size  数列逻辑长度，即堆逻辑大小
     */
    private static void heapify(int[] array, int index, int size) {
        //左结点下标
        int left = index * 2 + 1;
        //如果左结点下标＜总大小，则左结点存在
        while (left < size) {
            //判断右结点是否存在并且比较左右结点哪个大，取最大值
            int largest = left + 1 < size && array[left + 1] > array[left] ? left + 1 : left;
            //比较左右结点中较大的结点和父结点哪个大
            largest = array[largest] > array[index] ? largest : index;
            //如果较大的子节点没有父结点大，则退出本次比较
            if (largest == index) {
                break;
            }
            //如果较大的子节点比父结点大，则较大的子节点和父结点交换位置
            swap(array, largest, index);
            //向上继续查找，把父结点的下标赋值为原较大子节点的下标
            index = largest;
            //左子树变为父结点的父结点的左子树
            left = index * 2 + 1;
        }
    }

    /**
     *
     * @param array 原数组
     * @param index 父结点下标
     */
    private static void heapInsert(int[] array, int index) {
        //如果当前节点的数比父结点的数大
        while (array[index] > array[index - 1] / 2) {
            //当前节点和父结点换位置
            swap(array, index, (index - 1) / 2);
            //当前节点的下标变为父结点的下标
            index = (index - 1) / 2;
        }
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[j];
        array[j] = array[i];
        array[i] = temp;
    }
}
