package com.programmercarl.string;

/**
 * @ClassName ReverseStr
 * @Descriotion TODO
 * @Author nitaotao
 * @Date 2022/6/23 17:45
 * @Version 1.0
 * https://leetcode.cn/problems/reverse-string-ii/
 * 541. 反转字符串 II
 **/
public class ReverseStr {
    public static void main(String[] args) {
        System.out.println(reverseStr("abcdefg", 3));
    }

    public static String reverseStr(String s, int k) {
        //说白了就是每  [0,k-1] 反转  [k,2k-1]不变
        // 轮转time次 45
        int time = s.length() / (2 * k);
        String result = "";

        if (s.length() < k) {
            result += reverseString(s.substring(0, s.length()).toCharArray());
            return result;
        }

        if (s.length() <= 2 * k) {
            result += reverseString(s.substring(0, k).toCharArray());
            result += s.substring(k);
            return result;
        }

        int index = 0;
        while (index < time) {
            result += reverseString(s.substring(index * 2 * k, index * 2 * k + k).toCharArray());
            result += s.substring(index * 2 * k + k, index * 2 * k + 2 * k);
            index++;
        }
        // 多于的部分
        //如果剩余字符少于 k 个，则将剩余字符全部反转。
        if (s.length() - time * 2 * k < k) {
            result += reverseString(s.substring(time * 2 * k).toCharArray());
        } else {
            //如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
            result += reverseString(s.substring(time * 2 * k, time * 2 * k + k).toCharArray());
            result += s.substring(time * 2 * k + k);
        }
        return result;
    }

    public static String reverseString(char[] s) {
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
        return String.valueOf(s);
    }
}
