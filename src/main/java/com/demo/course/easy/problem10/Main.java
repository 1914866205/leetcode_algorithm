package com.demo.course.easy.problem10;


/**
 * author: nitaotao
 * date: 2021/12/20 23:51
 * version: 1.0
 * description: http://noi.openjudge.cn/ch0109/13
 * 整数去重
 * 【解题思路】：本题需要去重，很明显用 Set 集合计算，HashSet 不保证插入和原顺序一致，TreeSet 会自动
 * 排序，LinkedHashSet 保证不重复的同时，保证插入顺序和存储顺序一致。
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
        //HashSet 不保证插入和原顺序一致，TreeSet 会自动排序
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
