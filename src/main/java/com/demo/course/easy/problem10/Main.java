package com.demo.course.easy.problem10;


/**
 * author: nitaotao
 * date: 2021/12/20 23:51
 * version: 1.0
 * description: http://noi.openjudge.cn/ch0109/13
 */
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();//数的个数
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        Main main = new Main();
        main.noReNum(arr);
    }

    /**
     * noReNum方法：数组去重输出
     * @param arr 待去重的数组
     */
    public void noReNum(int[] arr) {
        //LinkedHashSet保证不重复的同时，保证插入顺序和存储顺序一致
        Set set = new LinkedHashSet();
        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
    }
}
