package mca.class06;

import java.util.Arrays;

/**
 * @ClassName MyHeap
 * @Descriotion TODO
 * @Author nitaotao
 * @Date 2022/9/28 17:36
 * @Version 1.0
 **/
public class MyHeap {
    public static void main(String[] args) {
        int[] arr = {1, 2, 5, 6};
        MyMaxHeap maxHeap=new MyMaxHeap(4);
        for (int i = 0; i < arr.length; i++) {
            maxHeap.push(arr[i]);
        }
        Arrays.stream(arr).forEach(System.out::print);
    }
    public static class MyMaxHeap{
        private int[]heap;
        private final int limit;
        private int heapSize;

        public MyMaxHeap(int limit){
            heap = new int[limit];
            this.limit = limit;
            heapSize = 0;
        }
        public boolean isEmpty(){
            return heapSize == 0;
        }
        public boolean isFull(){
            return heapSize == limit;}

        /**
         * 添加元素
         * @param value
         */
        public void push(int value){
            if (heapSize == limit) {
                throw new RuntimeException("heap is full");
            }
            heap[heapSize] = value;
            heapInsert(heap, heapSize);
            heapSize++;
        }

        /**
         * 在堆的末尾插入元素
         * @param heap
         * @param heapSize
         */
        private void heapInsert(int[] heap, int heapSize) {
            //大顶堆
            while (heap[heapSize] > heap[(heapSize - 1) / 2]) {
                swap(heap, heapSize, (heapSize - 1) / 2);
                heapSize = (heapSize - 1) / 2;
            }

        }

        private void swap(int[] heap, int heapSize, int i) {
            int temp = heap[i];
            heap[i] = heap[heapSize];
            heap[heapSize] = temp;
        }

        //返回最大值，并且大根堆依旧保持结构
        public int pop(){
            int res = heap[0];
            swap(heap, 0, heapSize);
            heapSize--;
            heapify(heap, 0, heapSize);
            return res;
        }

        /**
         * 在该位置调整堆
         *
         * @param heap
         * @param index
         * @param heapSize
         */
        private void heapify(int[] heap, int index, int heapSize) {
            int left = index * 2 + 1;
            while (left < heapSize) {
                int largest = left + 1 < heapSize && heap[left + 1] > heap[left] ? left + 1 : left;
                largest = heap[index] > heap[largest] ? index : largest;
                if (largest == index) {
                    break;
                }
                swap(heap, largest, index);
                //index此时为最大的值
                index = largest;
                left = index * 2 + 1;
            }

        }
    }
}
