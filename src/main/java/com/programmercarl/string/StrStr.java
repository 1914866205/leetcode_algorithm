package com.programmercarl.string;

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
    public static void main(String[] args) {
        System.out.println(strStr("bababbababbbabbaa", "" +
                "abbba"));
    }

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
    public static int strStr(String haystack, String needle) {
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
}
