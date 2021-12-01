package com.demo.day09.array;

import java.util.Arrays;

/**
 * author: nitaotao
 * date: 2021/12/1 13:31
 * version: 1.0
 * description: todo
 */
public class Test {
    public static void main(String[] args) {
        int[] nums = {1, 3, 4, 2, 5};
        ArrayTools arrayTools = new ArrayTools();
        System.out.println("当前数组");
        System.out.println("最大值："+arrayTools.getMax(nums));
        System.out.println("最小值："+arrayTools.getMin(nums));
        System.out.println("平均值：" + arrayTools.getMean(nums));
        arrayTools.sort(nums);
        System.out.println("排序后数组");
        Arrays.stream(nums).forEach(System.out::print);
        System.out.println("素数个数：" + arrayTools.countPrimes(nums));
    }
}
