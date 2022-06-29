package com.programmercarl.string;

import java.util.Arrays;

/**
 * @ClassName StrStr
 * @Descriotion TODO
 * @Author nitaotao
 * @Date 2022/6/25 15:52
 * @Version 1.0
 * https://leetcode.cn/problems/implement-strstr/
 * 实现 strStr()
 **/
public class StrStr {


    /**
     * 串的模式匹配算法
     * 除了特殊情况
     * 1. 遍历大串
     * 2. 遍历小串
     * 当小串的当前字符和大串的一样时，比较下一位，如果一直到最后都相等，返回
     * 如果中间遇到不相等的，则大串后移n位
     * n为小串中下一个和首字母相同的位
     *
     * @param haystack
     * @param needle
     * @return
     */
    public static int strStr2(String haystack, String needle) {
        //判断特殊情况
        if ("".equals(needle)) {
            return 0;
        }

        if (haystack.length() < needle.length()) {
            return -1;
        }

        int bigIndex = 0;

        //串内偏移量
        int offset = 0;
        while (bigIndex < haystack.length()) {
            while (needle.charAt(offset) == haystack.charAt(bigIndex + offset)) {
                //双方后移继续比较
                if (offset == needle.length() - 1) {
                    return bigIndex;
                } else {
                    offset++;
                }
                //大串结束
                if (bigIndex + offset > haystack.length() - 1) {
                    break;
                }
            }
            bigIndex++;
            offset = 0;
        }

        return -1;
    }


    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }

        int[] next = new int[needle.length()];
        //获取模式串的前缀表
        getNext(next, needle);

        int j = 0;
        //i 为父串当前被匹配的字符的位置
        for (int i = 0; i < haystack.length(); i++) {
            // j 在子串中遍历      i 在父串中遍历
            while (j > 0 && needle.charAt(j) != haystack.charAt(i)) {
                // 如果 父串的 I 位置 与 子串的 J 位置发生不匹配，
                // 子串 就跳到 与这个后缀相等的 前缀 的后面 继续匹配
                // 就是 前一个匹配后缀的前缀的后面
                j = next[j - 1];
            }
            //如果当前字符匹配成功，继续匹配下一位，i++在for循环中
            if (needle.charAt(j) == haystack.charAt(i)) {
                j++;
            }
            //如果子串已匹配长度和子串长度相等，返回结果
            if (j == needle.length()) {
                return i - needle.length() + 1;
            }
        }

        //没有找到
        return -1;
    }

    /**
     * 是根据子串算出next数组的
     *
     * @param next
     * @param s
     */
    public static void getNext(int[] next, String s) {
        // j 指向后缀末尾位置
        int j = 0;
        //第0位不计入，因为第0位没有前缀
        // i 指向前缀末尾位置
        next[0] = 0;
        //从第一位开始算
        for (int i = 1; i < s.length(); i++) {
            // 当 j == 0 时，直接跳出while循环了
            // J 是后缀末尾 ， 同时也是I包括I位置之前 最长子串前后缀相等的长度
            // I 是前缀末尾
            //前后缀不相同的情况
            while (j > 0 && s.charAt(j) != s.charAt(i)) {
                // 遇到不匹配的，要看前一位！
                // 同理，相同时j是一个个加上来的，不相同时，j也是一个个比较去掉的
                j = next[j - 1];
            }
            //前后缀相同的情况
            if (s.charAt(j) == s.charAt(i)) {
                // j 也是最长子串前后缀相等的长度
                // 长度一次只能在原有的基础上最多加一！这句话很重要
                j++;
                // i++在循环里
            }
            //更新当前 I 位置 next数组 的值
            next[i] = j;
        }
    }

    public static void getNext2(int[] next, String s) {
        // j 是后缀的最后一位，也是 i包括 i 之前最长子串前后缀相等的长度
        int j = 0;
        //第0位不计入，因为第0位没有前缀
        next[0] = 0;
        // i 是前缀的最后一位
        // 从第一位开始算
        for (int i = 1; i < s.length(); i++) {
            //遍历i的每一位
            // 当 前后缀 不相等 并且 j > 0 防止越界
            while (j > 0 && s.charAt(i) != s.charAt(j)) {
                //查找前缀表的前一位，就是上一个j的值，让上一个j的位置的元素和当前i进行比较
                // j-1是前一位
                //因为相等时 最大相同前后缀 是一个个加上来的，比较时也要一个个回退回去比较
                j = next[j - 1];
            }
            //如果相等
            if (s.charAt(i) == s.charAt(j)) {
                // j 是后缀表的最后一位
                // 同时！也是 包括 I 的最长子串前后缀相等的长度
                // 相等位数 j+1
                j++;
                //此时 i 也需要后移，继续比较下一位
                // 在 for 循环中会自动 i + 1
            }
            //更新当前 i 位置 的 next 数组的值
            next[i] = j;
        }
    }


}
