package com.mca.sort;

import java.util.Arrays;
import java.util.Stack;

/**
 * @ClassName Sort
 * @Descriotion 排序算法总结
 * @Author nitaotao
 * @Date 2022/9/16 16:08
 * @Version 1.0
 **/
public class Sort {


    /**
     * 交换数组 i 位置 和 j 位置的元素
     *
     * @param arr
     * @param i
     * @param j
     */
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    ///////////////////////1. 选择排序 ///////////////////////////////

    /**
     * 选择排序：遍历当前数组，每次把 当前位置右边 最小（大）的放到当前位置。每次前面的先排好。
     * <p>
     * 分成两端，左侧是已经排序的，右侧是未排序的
     * 分界线是当前的 i
     * 每次选择 [i,arr.length-1]上最小的元素的坐标
     * 这个元素和 i 位置互换
     * 就能做到每次 i 位置都是右边最小的了
     *
     * @param arr
     */
    public static void selectionSort(int[] arr) {
        //这种情况不用排
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                //如果当前位比最小值还小，那么这个位置就是最小值
                minIndex = arr[minIndex] < arr[j] ? minIndex : j;
            }
            swap(arr, i, minIndex);
        }
    }
    ///////////////////////2. 冒泡排序 ///////////////////////////////

    /**
     * 冒泡排序：遍历当前数组，每次 把 当前位置 和 下一个位置 比较，如果比后一个位置大（小）则交换位置。
     * 比较完之后，当前的 arr[n-1]位置元素 比 前 n-2 个元素都大（小）
     *
     * @param arr
     */
    public static void bubbleSort(int[] arr) {
        //这种情况不用排
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                //两两对比，大的后面去
                if (arr[i] > arr[j]) {
                    swap(arr, i, j);
                }
            }
        }
    }
    ///////////////////////3. 插入排序 ///////////////////////////////

    /**
     * 插入排序：每次让前 i 个数有序
     * 遍历数组，当前 i 位置的元素的前面是有序的，i位置元素和前一个元素比较，小于则交换位置
     *
     * @param arr
     */
    public static void insertSort(int[] arr) {
        //这种情况不用排
        if (arr == null || arr.length < 2) {
            return;
        }
        //第一位默认有序
        for (int i = 1; i < arr.length; i++) {
            //当前位 和 前一位 开始比较
            for (int j = i - 1; j >= 0; j--) {
                //如果 前一位 比 当前为 大 ，就交换位置
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j + 1, j);
                } else {
                    // 已经有序了就跳出本次循环
                    break;
                }
            }
        }
    }

    ///////////////////////4. 归并排序 ///////////////////////////////

    /**
     * 归并排序：把整个数组分成不同的小段
     * 递归实现
     *
     * @param arr
     * @param L
     * @param R
     */
    public static void mergeProcess(int[] arr, int L, int R) {
        if (L == R) {
            return;
        }
        int mid = L + (R - L) / 2;
        mergeProcess(arr, L, mid);
        mergeProcess(arr, mid + 1, R);
        merge(arr, L, mid, R);
    }

    /**
     * 归并排序，非递归实现
     * 外循环，步长两倍递增，O(logN)
     * 内循环，L为每组左组起点，左组范围[L,M] 右组范围[M+1,N]
     * M=L+step-1
     * N=Math.min(M+step,N-1)
     *
     * @param arr 1 2 5 9 7 2 3 1
     *            0 1 2 3 4 5 6 7
     *            L
     */
    public static void mergeProcess2(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int N = arr.length;
        int step = 1;
        //当步长不足N
        while (step < N) {
            //每组左边界
            int L = 0;
            //如果左边界> arr.length了，就退出
            while (L < N) {
                //每一次范围分为左右组  左组[L,M],右组[M+1,N]
                //[0,7]   [0,3][4,7] 步长为4  M=L+step-1
                //        [L,M][M+1,N] N=Math.min(M+step,N-1)

                int M = L + step - 1;
                if (M > N) {
                    break;
                }
                //每组右边界
                int R = Math.min(M + step, N - 1);
                merge(arr, L, M, R);
                //新的左边界=右边界+1
                L = R + 1;
            }
            if (step > N / 2) {
                //步长超过一半就退出
                break;
            }
            step *= 2;
        }
    }


    public static void merge(int[] arr, int L, int mid, int R) {
        //辅助数组
        int[] help = new int[R - L + 1];
        //当前数组的位置
        int helpIndex = 0;
        //原数组左部分起始位置
        int leftIndex = L;
        //原数组右部分起始位置 mid就不行
        int rightIndex = mid + 1;

        //当左右两侧都还有数组，没有越界时
        while (leftIndex <= mid && rightIndex <= R) {
            help[helpIndex++] = arr[leftIndex] < arr[rightIndex] ? arr[leftIndex++] : arr[rightIndex++];
        }

        //当右边越界
        while (leftIndex <= mid) {
            help[helpIndex++] = arr[leftIndex++];
        }

        //当左边越界
        while (rightIndex <= R) {
            help[helpIndex++] = arr[rightIndex++];
        }
        helpIndex = 0;
        //排好序的部分归还原数组
        for (int i = L; i <= R; i++) {
            arr[i] = help[helpIndex++];
        }
    }

    ///////////////////////5. 快速排序 ///////////////////////////////


    /**
     * 快速排序
     * 思路：从右往左开始定义基准数，比这个数大的放右边，小的放左边
     */
    public  void quickSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int N = arr.length;
        //随机一个数和末尾数交换
        swap(arr, (int) (Math.random() * (N)), N - 1);
        //全范围迭代
        int[] equalsArea = neitherlandsFlag(arr, 0, N - 1);
        //获取当前基准的左部分和有部分边界值（包含）
        int leftArea = equalsArea[0];
        int rightArea = equalsArea[1];
        Stack<Op> stack = new Stack();
        //左右分别迭代
        stack.push(new Op(0, leftArea - 1));
        stack.push(new Op(rightArea + 1, N - 1));
        while (!stack.isEmpty()) {
            Op op = stack.pop();
            if (op.left < op.right) {
                //如果左边小于右边，继续迭代
                swap(arr, (int) (op.left + (Math.random() * (op.right - op.left + 1))), op.right);
                //在当前子范围继续拆分左右部分
                equalsArea = neitherlandsFlag(arr, op.left, op.right);
                leftArea = equalsArea[0];
                rightArea = equalsArea[1];
                stack.push(new Op(op.left, leftArea-1));
                stack.push(new Op(rightArea+1, op.right));
            }
        }

    }

    class Op{
        int left;
        int right;

        Op(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }

    public static int[] neitherlandsFlag(int[] arr, int L, int R) {
        if (L > R) {
            return new int[]{-1, -1};
        }
        if (L == R) {
            return new int[]{L, L};
        }
        //小于基准数的左边界
        int less = L - 1;
        //大于基准数的右边界
        int more = R;
        int cur = L;
        while (cur < more) {
            if (arr[cur] == arr[R]) {
                //如果当前数和基准数相同
                cur++;
            } else if (arr[cur] < arr[R]) {
                //当前数比基准数小
                swap(arr, less + 1, cur);
                less++;
                cur++;
            } else if (arr[cur] > arr[R]) {
                more--;
                swap(arr, cur, more);
            }
        }
        //交换基准数和 大于基准数的最小边界值
        swap(arr, more, R);
        return new int[]{less + 1, more};
    }


    public static void main(String[] args) {
        int[] arr = {1, 2, 5, 6, 8, 9, 8, 5, 3, 4, 2, 4, 2, 4, 1, 2, 5, 4, 8, 5};
        new Sort().quickSort(arr);
        Arrays.stream(arr).forEach(System.out::print);
    }
}
