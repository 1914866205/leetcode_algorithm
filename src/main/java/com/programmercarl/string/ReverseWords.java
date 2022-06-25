package com.programmercarl.string;

/**
 * @ClassName ReverseWords
 * @Descriotion TODO
 * @Author nitaotao
 * @Date 2022/6/25 14:30
 * @Version 1.0
 * https://leetcode.cn/problems/reverse-words-in-a-string/
 * 151. 颠倒字符串中的单词
 **/
public class ReverseWords {
    public static void main(String[] args) {
        System.out.println(reverseWords("the sky is blue"));
    }

    public static String reverseWords2(String s) {
        StringBuilder result = new StringBuilder("");
        s = s.trim();
        String[] strs = s.split(" ");
        for (int i = strs.length - 1; i > 0; i--) {
            //防止连续的空格
            if (!"".equals(strs[i])) {
                result.append(strs[i]).append(" ");
            }
        }
        //最后一位不加空格
        result.append(strs[0]);
        return String.valueOf(result);
    }

    /**
     * 不使用java内置的方法
     * 1 去除多于空格
     * 2 反转字符串
     * 3 反转单词
     *
     * @param s
     * @return
     */
    public static String reverseWords(String s) {
        StringBuilder result;
        //去除多余空格
        result = removeSpace(s);
        //反转整个字符串
        result = reverseStr(result, 0, result.length());
        //反转每个单词
        int start = 0;
        int end = 0;
        for (int i = 0; i < result.length(); i++) {
            if (result.charAt(end) == ' ') {
                result = reverseStr(result, start, end);
                end++;
                start = end;
            } else {
                end++;
            }
        }
        //反转最后一个单词
        result = reverseStr(result, start, result.length());
        return String.valueOf(result);
    }

    /**
     * 去除多余空格
     *
     * @param s
     * @return
     */
    public static StringBuilder removeSpace(String s) {
        StringBuilder result = new StringBuilder("");
        char[] strs = s.toCharArray();
        for (int i = 0; i < strs.length; i++) {
            //判断是否是首部的空格
            if (strs[0] == ' ' && i == 0) {
                continue;
            }
            //判断是否是中间多于的空格
            if (strs[i] == ' ' && strs[i - 1] == ' ') {
                continue;
            }
            result.append(strs[i]);
        }
        //判断最后一位是否是空格
        if (result.charAt(result.length() - 1) == ' ') {
            result.deleteCharAt(result.length() - 1);
        }
        return result;
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
            s.replace(start, start + 1, String.valueOf(s.charAt(end - 1)));
            s.replace(end - 1, end, String.valueOf(temp));
//            s.setCharAt(start, s.charAt(end - 1));
//            s.setCharAt(end-1, temp);
            start++;
            end--;
        }
        return s;
    }
}
