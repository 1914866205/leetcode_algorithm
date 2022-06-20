package com.programmercarl.hashtable;

import java.util.HashSet;

/**
 * @ClassName IsHappy
 * @Descriotion https://leetcode.cn/problems/happy-number/
 * @Author nitaotao
 * @Date 2022/6/20 16:14
 * @Version 1.0
 * 快乐数
 **/
public class IsHappy {
    public static void main(String[] args) {
        System.out.println(isHappy(19));
    }
    public static boolean isHappy(int n) {
        /**
         * 每次计算出的结果添加到set集合，如果出现重复，则陷入循环，则为不快乐
         */
        HashSet<Integer> set = new HashSet<>();
        //如果这个数没出现过
        while (!set.contains(n)) {
            //记录这个数
            set.add(n);
            int sum = 0;
            while (n / 10 != 0) {
                sum += (n % 10) * (n % 10);
                n = n / 10;
            }
            sum += n * n;
            if (sum == 1) {
                return true;
            }
            n = sum;
        }
        //如果出现过，就进入了循环
        return false;
    }
}
