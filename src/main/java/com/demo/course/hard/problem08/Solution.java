package com.demo.course.hard.problem08;

/**
 * author: nitaotao
 * date: 2021/12/23 1:03
 * version: 1.0
 * description: https://leetcode-cn.com/problems/valid-palindrome-ii/
 * 【解题思路】： 先判断仅有一个值的情况，直接返回 0。如果不是，那么数组先排序找到最大值和最小值，
 * 返回数组中最大值和最小值之间可能存在的最小差值，可以看做是在一维数轴上，两个点的距离如果大于
 * 2k，则返回中间还差的距离，否则返回 0，说明这个中间点双方都能达到。
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "eddboebddcaacddkbebdde";
        System.out.println(solution.validPalindrome(s));
    }

    /**
     * 验证回文字符串：
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
            // 三个里只要有两个相等，则能变为回文字符串
            if (arr[0].equals(arr[1]) || arr[1].equals(arr[2]) || arr[2].equals(arr[0])) {
                return true;
            } else {
                return false;
            }
        }
        int index = 0; //比较的索引
        for (int i = 0; i < arr.length / 2; i++) {
            //两边逐个开始向内比较  因为回文串对称
            if (arr[i].equals(arr[arr.length - 1 - i])) {
                isValidPalindrome = true;
                continue;
            } else {
                //只要有一个不相等，跳过，记住当前索引
                isValidPalindrome = false;
                index = i;
                break;
            }
        }
        // abca   判断左边还是右边跳过后可以重新构成回文串
        // 先判断  是左边跳过后构成 回文字符
        boolean isValidPalindromeLeft = true;
        //如果是遇到不同的退出for，而不是比较完  都相等了  而退出for，说明  有不同的
        if (!isValidPalindrome) {
            //左边跳过该元素，右边不动
            for (int i = index + 1; i < arr.length / 2 + 1; i++) {
                //两边逐个开始比较 abca
                if (i == arr.length - 1 - i) {   //从两边对比，当对比到中间元素（奇数情况下）还在进行for循环，说明除了中间，其余都相等了。则构成 回文
                    return true;
                }
                if (arr[i].equals(arr[arr.length - 1 - (i - 1)])) {  //两边同时对比
                    isValidPalindrome = true;
                    continue;
                } else {
                    isValidPalindromeLeft = false;  //说明左边跳过一个元素依旧不能构成 回文字符串
                    isValidPalindrome = false;  //不是回文
                    break;
                }
            }
        }

        boolean isValidPalindromeRight = true; //开始右边跳过
        if (!isValidPalindrome) {
            //右边跳过该元素，左边不动
            for (int i = index; i < arr.length / 2 + 1; i++) {
                //两边逐个开始比较 abca
                if (i == arr.length - 1 - i) {  //奇数情况下
                    return true;
                }
                if (arr[i].equals(arr[arr.length - 1 - (i + 1)])) {
                    isValidPalindrome = true;
                    continue;
                } else {
                    isValidPalindromeRight = false; //右边跳过了也构成不了 回文串
                    break;
                }
            }
        }
        //只有当从左跳过和从右跳过都未再回文串，才失败
        return isValidPalindromeRight || isValidPalindromeLeft;
    }
}
