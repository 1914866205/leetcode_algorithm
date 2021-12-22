package com.demo.course.mid.problem06;

/**
 * author: nitaotao
 * date: 2021/12/22 10:52
 * version: 1.0
 * description: https://leetcode-cn.com/problems/longest-common-prefix/
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] str2 = {"ab", "aa"};
        System.out.println(solution.longestCommonPrefix(str2));
    }

    /**
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].equals("")) {
                return "";
            }
        }
        if (strs.length == 1) {
            return strs[0];
        }

        boolean isCommonPrefix = true;
        int index = 0;
        String minString = strs[0]; //当前数组里最大公共串，即最小串
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].length() < minString.length()) {
                minString = strs[i];
            }
        }
        //先把所有元素的第一个字母拿出来比较
        while (isCommonPrefix) {
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

                //如果当前位置相等，并且当前指针已经到最后一位了
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
