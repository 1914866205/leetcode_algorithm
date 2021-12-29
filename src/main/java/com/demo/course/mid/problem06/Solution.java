package com.demo.course.mid.problem06;

/**
 * author: nitaotao
 * date: 2021/12/22 10:52
 * version: 1.0
 * description: https://leetcode-cn.com/problems/longest-common-prefix/
 * 最长公共前缀
 * 【解题思路】： 找出当前字符数组的最小串，它是理论上当前字符数组会出现的最长公共前缀，以它为基
 * 准，把字符数组遍历，引入位置指针，每次比较当前字符的第 index 位置是否都相等，如果相等，index 指
 * 针后移一位，如果不相等，则相同的串为 index 之前。记得特殊情况处理，如空字符，如只有一个字符串
 * 等。
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] str2 = {"ab", "aa"};
        System.out.println(solution.longestCommonPrefix(str2));
    }

    /**
     * 最长公共前缀
     *
     * @param strs 被比较的字符串
     * @return 最长公共前缀
     */
    public String longestCommonPrefix(String[] strs) {
        //如果是空串，返回 ""
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].equals("")) {
                return "";
            }
        }
        //如果只有一个字符，直接返回
        if (strs.length == 1) {
            return strs[0];
        }

        boolean isCommonPrefix = true;
        int index = 0;  //index为当前比较的  某元素的第 几 个位置，一列一列比较
        /**
         *   abcd
         *   ab
         *   abddc
         */
        String minString = strs[0]; //当前数组里理论上存在的最大公共串，即最小串
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].length() < minString.length()) {
                minString = strs[i];
            }
        }
        //先把所有元素的第一个字母拿出来比较
        while (isCommonPrefix) {
            // 所有元素，竖着 每列每列比
            for (int i = 0; i < strs.length; i++) {
                if (strs[i].charAt(index) == minString.charAt(index)) {
                    //如果相等，判断下一个元素的该位置元素
                    continue;
                } else {
                    isCommonPrefix = false;
                    break;
                }
            }
            //如果当前位置相等，并且当前位置索引没到 minString的最后一位
            if (isCommonPrefix && index < minString.length() - 1) {
                //比较的指针向后移一位
                index++;
            } else {
                //如果第一个位置就不相等
                if (index == 0 && !isCommonPrefix) {
                    return "";
                }

                //如果当前位置相等，并且当前指针已经到最后一位了，就不用继续比较了，因为已经到达理论上的最大值了
                if (isCommonPrefix) {
                    //返回 misString
                    return minString;
                }
                break;
            }
        }
        //如果当前位置不相等了,说明之前所有位置都相等
        return minString.substring(0, index);
    }
}
