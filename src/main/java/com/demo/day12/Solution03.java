package com.demo.day12;

import com.demo.course.hard.problem08.Solution;

/**
 * author: nitaotao
 * date: 2021/12/25 12:48
 * version: 1.0
 * description:  https://leetcode-cn.com/problems/valid-palindrome-ii/
 */
public class Solution03 {
    public static void main(String[] args) {
        Solution03 solution = new Solution03();
        String s = "eddboebddcaacddkbebdde";
        System.out.println(solution.validPalindrome(s));
    }

    /**
     * 验证回文字符串：
     *
     * @param s
     * @return 回文字符串：正反读都一样
     */
    public boolean validPalindrome(String s) {
        // s长度为1时恒成立，长度为2时，只要删除一个字符，也能构成
        if (s.length() < 3) {
            return true;
        }
        boolean isValidPalindrome = true;
        String[] arr = s.split("");
        if (s.length() == 3) {
            if (arr[0].equals(arr[1]) || arr[1].equals(arr[2]) || arr[2].equals(arr[0])) {
                return true;
            } else {
                return false;
            }
        }
        int index = 0;
        for (int i = 0; i < arr.length / 2; i++) {
            //两边逐个开始比较
            if (arr[i].equals(arr[arr.length - 1 - i])) {
                isValidPalindrome = true;
                continue;
            } else {
                isValidPalindrome = false;
                index = i;
                break;
            }
        }
        // abca
        boolean isValidPalindromeLeft = true;
        //如果是遇到不同的退出for，而不是比较完都相等而退出for，说明有不同的
        if (!isValidPalindrome) {
            //左边跳过该元素，右边不动
            for (int i = index + 1; i < arr.length / 2 + 1; i++) {
                //两边逐个开始比较 abca
                if (i == arr.length - 1 - i) {
                    return true;
                }
                if (arr[i].equals(arr[arr.length - 1 - (i - 1)])) {
                    isValidPalindrome = true;
                    continue;
                } else {
                    isValidPalindromeLeft = false;
                    isValidPalindrome = false;
                    break;
                }
            }
        }

        boolean isValidPalindromeRight = true;
        if (!isValidPalindrome) {
            //右边跳过该元素，左边不动
            for (int i = index; i < arr.length / 2 + 1; i++) {
                //两边逐个开始比较 abca
                if (i == arr.length - 1 - i) {
                    return true;
                }
                if (arr[i].equals(arr[arr.length - 1 - (i + 1)])) {
                    isValidPalindrome = true;
                    continue;
                } else {
                    isValidPalindromeRight = false;
                    break;
                }
            }
        }
        //只有当从左跳过和从右跳过都未再回文串，才失败
        return isValidPalindromeRight || isValidPalindromeLeft;
    }
}
