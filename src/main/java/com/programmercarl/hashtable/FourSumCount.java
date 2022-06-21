package com.programmercarl.hashtable;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @ClassName FourSumCount
 * @Descriotion TODO
 * @Author nitaotao
 * @Date 2022/6/21 13:19
 * @Version 1.0
 * https://leetcode.cn/problems/4sum-ii/
 * 四数相加 II
 **/
public class FourSumCount {
    public static void main(String[] args) {
        fourSumCount(new int[]{1, 2}, new int[]{-2, -1}, new int[]{-1, 2}, new int[]{0, 2});
    }

    /**
     * @param nums1
     * @param nums2
     * @param nums3
     * @param nums4
     * @return
     * @Version 3.0
     * 增强for改写一下
     *
     */
    public static int fourSumCount3(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        /**
         * 可以类似两数之和。把O(N^4)转化为O(N^2),用两数之和思想
         */
        //总数
        int count = 0;
        //数组长度
        int n = nums1.length;
        //结果集，键为需要的结果，值为键出现的次数，因为set中键唯一
        HashMap<Integer, Integer> result = new HashMap<>();
        for (int i:nums1) {
            for (int j :nums2) {
                //set中键不重复
                if (result.containsKey(-(i + j))) {
                    //如果键重复出现，要记录键出现的次数
                    int value = result.get(-(i + j)) + 1;
                    result.put(-(i + j), value);
                } else {
                    result.put(-(i + j), 1);
                }
            }
        }
        for (int i:nums3) {
            for (int j :nums4) {
                if (result.containsKey(i + j)) {
                    //比如1 2 之和出现4次-1，3 4 之和 每出现1次1，则就加4次
                    count += result.get(i + j);
                }
            }
        }
        return count;
    }
    /**
     * @param nums1
     * @param nums2
     * @param nums3
     * @param nums4
     * @return
     * @Version 2.0
     *
     * 1，1   0.2 -1.1
     * -1 1 2 4
     */
    public static int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        /**
         * 可以类似两数之和。把O(N^4)转化为O(N^2),用两数之和思想
         */
        //总数
        int count = 0;
        //数组长度
        int n = nums1.length;
        //结果集，键为需要的结果，值为键出现的次数，因为set中键唯一
        HashMap<Integer, Integer> result = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                //set中键不重复
                if (result.containsKey(-(nums1[i] + nums2[j]))) {
                    //如果键重复出现，要记录键出现的次数
                    int value = result.get(-(nums1[i] + nums2[j])) + 1;
                    result.put(-(nums1[i] + nums2[j]), value);
                } else {
                    result.put(-(nums1[i] + nums2[j]), 1);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (result.containsKey(nums3[i] + nums4[j])) {
                    //比如1 2 之和出现4次-1，3 4 之和 每出现1次1，则就加4次
                    count += result.get(nums3[i] + nums4[j]);
                }
            }
        }
        return count;
    }

    /**
     * @param nums1
     * @param nums2
     * @param nums3
     * @param nums4
     * @return
     * @Version 1.0
     */
    public int fourSumCount1(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int count = 0;
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums1.length; j++) {
                for (int k = 0; k < nums1.length; k++) {
                    for (int l = 0; l < nums1.length; l++) {
                        if (nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0) {
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }
}
