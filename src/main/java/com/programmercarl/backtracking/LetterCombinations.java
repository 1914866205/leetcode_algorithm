package com.programmercarl.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName LetterCombinations
 * @Descriotion TODO
 * @Author nitaotao
 * @Date 2022/7/8 17:03
 * @Version 1.0
 * https://leetcode.cn/problems/letter-combinations-of-a-phone-number/
 * 17. 电话号码的字母组合
 **/
public class LetterCombinations {
    List<String> result = new ArrayList<String>();

    //字符结果集
    String[] str = new String[26];

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return result;
        }
        for (int i = 0; i < 26; i++) {
            str[i] = String.valueOf(Character.toChars(i + 97));
        }
        final char[] chars = digits.toCharArray();
        // 每个按钮对应三个，最后一个对应四个，1不对应
        // 输入字符串nums 是 2-9
        // 2 - 6 8    3 * ( num - 2 )  <= str[i] <= 3 * ( num - 1 )
        // 7 9        3 * ( num - 2 )  <= str[i]<= 4 * ( num - 1 )
        backtracking(chars, new StringBuilder(""), 0);
        return result;
    }

    public void backtracking(char[] chars, StringBuilder s, int t) {
        //结束条件：长度为digits.length()
        if (chars.length == s.length()) {
            result.add(String.valueOf(s));
            return;
        }
        for (int i = t; i < chars.length; i++) {
            //下次递归不再从头开始，从t开始
            t++;
            //每次取出一个数字
            if (chars[i] == '7') {
                for (int j = (chars[i] - '0' - 2) * 3; j < (chars[i] - '0' - 2) * 3 + 4; j++) {
                    //递归
                    s.append(str[j]);
                    backtracking(chars, s, t);
                    //回溯
                    s.deleteCharAt(s.length() - 1);
                }
            } else if (chars[i] == '8') {
                //                          8 - 1 = 7
                for (int j = (chars[i] - '0' - 2 - 1) * 3 + 4; j < (chars[i] - '0' - 2 - 1) * 3 + 7; j++) {
                    //递归
                    s.append(str[j]);
                    backtracking(chars, s, t);
                    //回溯
                    s.deleteCharAt(s.length() - 1);
                }
            } else if (chars[i] == '9') {
                //                          9 - 2 = 7
                for (int j = (chars[i] - '0' - 2 - 2) * 3 + 7; j < (chars[i] - '0' - 2 - 2) * 3 + 11; j++) {
                    //递归
                    s.append(str[j]);
                    backtracking(chars, s, t);
                    //回溯
                    s.deleteCharAt(s.length() - 1);
                }
            } else {
                //2 - 6
                for (int j = (chars[i] - '0' - 2) * 3; j < (chars[i] - '0' - 2) * 3 + 3; j++) {
                    //递归
                    s.append(str[j]);
                    backtracking(chars, s, t);
                    //回溯
                    s.deleteCharAt(s.length() - 1);
                }
            }
        }
    }

    public static void main(String[] args) {
//        new LetterCombinations().letterCombinations("8");
        new LetterCombinations().letterCombinations("9");
    }
}
