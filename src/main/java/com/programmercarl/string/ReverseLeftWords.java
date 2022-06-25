package com.programmercarl.string;

/**
 * @ClassName ReverseLeftWords
 * @Descriotion TODO
 * @Author nitaotao
 * @Date 2022/6/25 15:26
 * @Version 1.0
 * https://leetcode.cn/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof/
 * 剑指 Offer 58 - II. 左旋转字符串
 **/
public class ReverseLeftWords {
    /**
     * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。
     * 比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
     * @param s
     * @param n
     * @return
     */
    public String reverseLeftWords1(String s, int n) {
        //截取当前字符串前左n位
        String head = s.substring(0, n);
        return s.substring(n) + head;
    }


    public String reverseLeftWords(String s, int n) {
        StringBuilder result = new StringBuilder(s);
        //反转前半段
        reverseStr(result, 0, n);
        //反转后半段
        reverseStr(result, n, s.length());
        //反转整段
        reverseStr(result, 0, s.length());
        return String.valueOf(result);
    }
    /**
     * 反转指定区间内字符串
     *
     * @param s
     * @param start
     * @param end
     * @return
     */
    public static StringBuilder reverseStr(StringBuilder s, int start, int end) {
        while (start < end) {
            char temp = s.charAt(start);
            s.setCharAt(start, s.charAt(end - 1));
            s.setCharAt(end-1, temp);
            start++;
            end--;
        }
        return s;
    }
}
