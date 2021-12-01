package com.demo.day09.array;

import java.util.Arrays;

/**
 * author: nitaotao
 * date: 2021/12/1 13:05
 * version: 1.0
 * description: todo
 */
public class ArrayTools {
    /**
     * 获取数组最大值
     *
     * @param nums
     * @return
     */
    public int getMax(int[] nums) {
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        return max;
    }

    /**
     * 获取数组最小值
     *
     * @param nums
     * @return
     */
    public int getMin(int[] nums) {
        int min = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < min) {
                min = nums[i];
            }
        }
        return min;
    }

    /**
     * 获取平均值
     *
     * @param nums
     * @return
     */
    public double getMean(int[] nums) {
        double sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        return sum / nums.length;
    }

    /**
     * 数组排序 升序
     *
     * @param nums
     * @return
     */
    public int[] sort(int[] nums) {
        //升序排序
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                //如果后一个比前一个小，交换位置
                if (nums[i] > nums[j]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        return nums;
    }

    /**
     * 获取素数的个数
     *
     * @param nums
     * @return
     */
    public int countPrimes(int[] nums) {
        int count = 0;
        boolean isPrimes;
        for (int i = 0; i < nums.length; i++) {
            //默认是素数
            isPrimes = true;
            for (int j = 2; j < nums[i]; j++) {
                if (nums[i] % j == 0) {
                    //不是素数
                    isPrimes = false;
                    break;
                }
            }
            //如果是素数，计数器++
            if (isPrimes) {
                count++;
            }
        }
        return count;
    }
}
