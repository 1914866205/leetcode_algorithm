package com.programmercarl.hashtable;


import java.util.HashSet;

/**
 * @ClassName Intersection
 * @Descriotion https://leetcode.cn/problems/intersection-of-two-arrays/
 * @Author nitaotao
 * @Date 2022/6/20 14:32
 * @Version 1.0
 * 给定两个数组 nums1 和 nums2 ，返回 它们的交集 。输出结果中的每个元素一定是 唯一 的。我们可以 不考虑输出结果的顺序 。
 * 两个数组的交集
 **/
public class Intersection {
    public static void main(String[] args) {
        intersection(new int[]{4, 9, 7,7,6,7}, new int[]{5,0,0,6,1,6,2,2,4});
    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        //数组去重
        HashSet<Integer> set1 = new HashSet<Integer>();
        for (int i : nums1) {
            set1.add(i);
        }
        //数的范围是 [0,1001]
        int[] resultTemp = new int[1001];
        for (int i : nums2) {
            if (set1.contains(i)) {
                //如果包含此数
                resultTemp[i] += 1;
            }
        }
        int count = 0;
        //因为返回结果要的是数组，所以最后得转成数组
        for (int i = 0; i < 1001; i++) {
            if (resultTemp[i] != 0) {
                count++;
            }
        }
        int[] result = new int[count];
        for (int i = 0, j = 0; i < 1001; i++) {
            if (resultTemp[i] != 0) {
                result[j] = i;
                j++;
            }
        }
        return result;
    }
}
