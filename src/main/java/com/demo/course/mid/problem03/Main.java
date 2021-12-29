package com.demo.course.mid.problem03;

import java.util.Scanner;

/**
 * author: nitaotao
 * date: 2021/12/21 13:42
 * version: 1.0
 * description: http://noi.openjudge.cn/ch0111/01
 *  查找最接近元素
 * 【解题思路】：使用二分查找，每次折半找到中间元素，和 value 作差，取绝对值，即为距离。注意事项：
 * 需要处理左边界情况，右边界情况，后几位重复，
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
        for (int i = 0; i < selectNum.length - 1; i++) { //从查找数组中取出元素进行查询
            System.out.println(main.binarySearch(data, selectNum[i]));
        }
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
        //处理左边界情况  非降序数组  最左边为最小值   最右边为最大值
        if (value <= arr[0]) {
            return arr[0];
        } else if (value >= arr[arr.length - 1]) {
            //处理右边界情况
            //判断原数组的后几位是否相等，比如 [1,2,3,3,3,3]
            int index = arr.length - 1;
            int distant = arr[index] - value;
            //当倒数第一位和value的距离 与 倒数第二位和value的距离 相等时，说明后最后两个为重复元素，依次往前继续比较，直到不相等 ，再加加回去，返回那个最大值
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
                // 若有多个值满足条件，输出最小的一个,最前面的即为最小值
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
                int startDistance = Math.abs(arr[start] - value);
                int endDistance = Math.abs(arr[end] - value);
                if (startDistance == endDistance) {
                    return arr[end]; //此时start>end,选较小的，而end在左边
                } else {
                    return startDistance < endDistance ? arr[start] : arr[end];
                }
            }
        }
    }
}