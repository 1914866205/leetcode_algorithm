package com.programmercarl.string;

/**
 * @ClassName ReverseString
 * @Descriotion TODO
 * @Author nitaotao
 * @Date 2022/6/23 17:32
 * @Version 1.0
 * https://leetcode.cn/problems/reverse-string/
 * 344. 反转字符串
 **/
public class ReverseString {
    public void reverseString(char[] s) {
        //双指针法
        int left = 0;
        int right = s.length - 1;
        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }
}
