package com.demo.day13;

import java.util.*;

/**
 * author: nitaotao
 * date: 2022/1/1 23:58
 * version: 1.0
 * description: todo
 */
public class Solution03 {
    public static void main(String[] args) {

    }
    public int[] intersection(int[] nums1, int[] nums2) {
        Set setN1 = new HashSet();
        Set setN2 = new HashSet();
        for (int i = 0; i < nums1.length; i++) {
            setN1.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            setN2.add(nums2[i]);
        }
        List list = new ArrayList();
        Iterator iteratorN1 = setN1.iterator();
        while (iteratorN1.hasNext()) {
            int nextN1 = (int) iteratorN1.next();
            Iterator iteratorN2 = setN2.iterator();
            while (iteratorN2.hasNext()) {
                int nextN2 = (int) iteratorN2.next();
                if (nextN1 == nextN2) {
                    list.add(nextN1);
                }
            }
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = (int) list.get(i);
        }
        return result;
    }
}
