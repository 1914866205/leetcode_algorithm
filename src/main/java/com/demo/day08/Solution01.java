package com.demo.day08;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

/**
 * author: nitaotao
 * date: 2021/11/18 11:35
 * version: 1.0
 * description:  https://leetcode-cn.com/problems/third-maximum-number/
 */
public class Solution01 {
    public static void main(String[] args) {
        Integer[] arr = {3,1,2};
        Arrays.sort(arr, Collections.reverseOrder());
        Arrays.stream(arr).forEach(System.out::println);
//        System.out.println(thirdMax(arr));

    }

    public static int thirdMax(int[] nums) {
        int maxNum;
        //去重
        HashSet hashSet = new HashSet();
        Arrays.stream(nums).forEach(item -> hashSet.add(item));
        //去重数组
        Object[] array = hashSet.toArray();
//        System.out.println("去重后的数组");
//        Arrays.stream(array).forEach(System.out::print);
//        System.out.println();
        if (array.length == 1) {
            return (int) array[0];
        }
        if (array.length == 2) {
            return (int) array[0] > (int) array[1] ? (int) array[0] : (int) array[1];
        }
        //找到最大值删掉
        maxNum = (int) array[0];
        for (int i = 0; i < array.length; i++) {
            if (maxNum < (int) array[i]) {
                maxNum = (int) array[i];
            }
        }
        hashSet.remove(maxNum);
//        for (Object i : hashSet) {
//            System.out.print(i + " ");
//
//        }
//        System.out.println("以上是第一次删除最大元素的集合");
        array = hashSet.toArray();
//        Arrays.stream(array).forEach(System.out::print);
//        System.out.println("以上是第一次删除最大元素的集合后转化的数组");
        maxNum = (int) array[0];
        for (int i = 0; i < array.length; i++) {
            if (maxNum < (int) array[i]) {
                maxNum = (int) array[i];
            }
        }
        hashSet.remove(maxNum);
//        for (Object i : hashSet) {
//            System.out.print(i + " ");
//
//        }
//        System.out.println("以上是第二次删除最大元素的集合");
        array = hashSet.toArray();
//        Arrays.stream(array).forEach(System.out::print);
//        System.out.println("以上是第二次删除最大元素的集合后转化的数组");
        maxNum = (int) array[0];
        for (int i = 0; i < array.length; i++) {
            if (maxNum < (int) array[i]) {
                maxNum = (int) array[i];
            }
        }

        return maxNum;
    }
}
