package com.demo.course.mid.problem03;

import java.util.Scanner;

/**
 * author: nitaotao
 * date: 2021/12/21 13:42
 * version: 1.0
 * description: http://noi.openjudge.cn/ch0111/01
 */
public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); //非降序列长度
        int[] data = new int[n]; //非降序列
        for (int i = 0; i < n; i++) {
            data[i] = scanner.nextInt();
        }
        int m = scanner.nextInt(); //要询问的给定值个数
        int[] selectNum = new int[m];
        for (int i = 0; i < m; i++) {
            selectNum[i] = scanner.nextInt();
        }
//        int[] data = new int[]{1, 1, 1, 2, 5, 6, 6, 7, 80, 81, 81, 82, 93, 93, 93};
//        int[] selectNum = new int[]{3, 4, 79, 83};
        for (int i = 0; i < selectNum.length - 1; i++) { //从查找数组中取出元素进行查询
//            System.out.print(selectNum[i] + "最近为:");
            System.out.println(main.binarySearch(data, selectNum[i]));
        }
//        System.out.print(selectNum[selectNum.length - 1] + "最近为:");
        System.out.print(main.binarySearch(data, selectNum[selectNum.length - 1]));

    }

    /**
     * binarySearch 二分查找最近元素
     *
     * @param arr
     * @param value 总体思路，使用二分查找，每次折半找到中间元素，和value作差，取绝对值，即为距离
     */
    public int binarySearch(int[] arr, int value) {
        //处理单值数组情况
        if (arr.length == 1) {
            return arr[0];
        }
        //处理左边界情况
        if (value <= arr[0]) {
            return arr[0];
        } else if (value >= arr[arr.length - 1]) {
            //处理右边界情况
            //判断后几位是否相等
            int index = arr.length - 1;
            int distant = arr[index] - value;
            while (distant == arr[arr.length - 1] - value || index == 0) {
                //最后一位往前移
                index--;
                //如果变化，则跳出循环
                distant = arr[index] - value;
            }
            index++;
            return arr[index];
        }
        int start = 0; //起始位置
        int end = arr.length - 1; //结束位置
        while (true) {
            int mid = (start + end) / 2; //计算中间位置下标
            int midValue = arr[mid]; //中间值
            int distance = midValue - value; //距离
            if (distance == 0) {
                //System.out.println("距离最近为：" + distance + "-----最近中间值：" + midValue);
                // 若有多个值满足条件，输出最小的一个
                for (int i = 0; i < arr.length; i++) {
                    if (arr[i] - value == 0) {
                        //如果距离为0，返回中间值
                        return arr[i];
                    }
                }
            } else {
                //如果是正数,说明待查找数值比中间数值小，即待查找数值在数轴中间位置左边，则需要将end=mid-1
                if (distance > 0) {
                    end = mid - 1;
                } else {
                    //如果是负数,说明待查找数值比中间数值大，即待查找数值在数轴中间位置右边，则需要将start=mid+1
                    start = mid + 1;
                }
            }

            if (start > end) {
                // start>end,则没找到,打印当前的distant
                //另一种情况是已找到，在左右，取最小
//                System.out.println("距离最近为：" + distance + "-----最近中间值-1：" + arr[mid - 1]);
//                System.out.println("距离最近为：" + distance + "-----最近中间值：" + arr[mid]);
//                System.out.println("距离最近为：" + distance + "-----最近中间值+1：" + arr[mid + 1]);
//                int result = arr[0] - value;
//                // 若有多个值满足条件，输出最小的一个
//                for (int i = 0; i < arr.length; i++) {
//                    if (Math.abs(arr[i] - value) == Math.abs(distance)) {
//                        result = arr[i];
//                        break;
//                    }
//                }
//                if (Math.abs(result) <= Math.abs(arr[mid + 1] - value)) {
//                    return result;
//                } else {
//                    return arr[mid + 1];
//                }
//                System.out.println(arr[mid-1]+" "+arr[mid]);
                int startDistance = Math.abs(arr[start] - value);
                int endDistance = Math.abs(arr[end] - value);
//                System.out.println(startDistance+"  "+endDistance);
                if (startDistance == endDistance) {
                    return arr[end]; //此时start>end,选较小的
                } else {
                    return startDistance < endDistance ? arr[start] : arr[end];
                }
//                System.out.println(startDistance > endDistance ? arr[end] : arr[start]);
            }
        }

    }
}
