package com.programmercarl.string;

/**
 * @ClassName RepeatedSubstringPattern
 * @Descriotion TODO
 * @Author nitaotao
 * @Date 2022/6/27 16:45
 * @Version 1.0
 * https://leetcode.cn/problems/repeated-substring-pattern/
 * 重复的子字符串
 **/
public class RepeatedSubstringPattern {
    /**
     * 给定一个非空的字符串 s ，检查是否可以通过由它的一个子串重复多次构成
     *
     * @param s
     * @return
     */
    public boolean repeatedSubstringPattern1(String s) {
        if (s.equals("")) {
            return false;
        }
        int len = s.length();
        //原串加个空格（哨兵），使下标从1开始，这样j从0开始，也不用初始化了
        s = " " + s;
        char[] chars = s.toCharArray();
        int[] next = new int[len + 1];
        //构造next数组,j从0开始（空格），i从2开始
        for (int i = 2, j = 0; i <= len; i++) {
            //匹配不成功，j 回到前一位置，next数组对应的值
            while (j > 0 && chars[i] != chars[j + 1]) {
                j=next[j];
            }
            if (chars[i] == chars[j + 1]) {
                j++;
            }
            //更新next数组的值
            next[i] = j;
        }

        if (next[len] > 0 && len % (len - next[len]) == 0) {
            return true;
        }
        return false;
    }
    public boolean repeatedSubstringPattern2(String s) {
        return (s + s).substring(1, s.length() * 2 - 1).indexOf(s) != -1;
    }

    public boolean repeatedSubstringPattern3(String s) {
        //字符串长度
        int len = s.length();
        //子串，不包含自身
        if (len < 2) {
            return false;
        }
        //列举所有可能
        for (int i = 0; i <= len / 2; i++) {
            //如果不能整除，必定不是重复字符串组成
            if (len % i != 0) {
                continue;
            }
            String temp = s.substring(0, i);
            String ans = "";
            for (int j = 0; j < len / i; j++) {
                //  len/i 个 temp 字符串拼接在一起和原字符串比较
                ans += temp;
            }
            if (s.equals(ans)) {
                return true;
            }
        }
        return false;
    }
}
