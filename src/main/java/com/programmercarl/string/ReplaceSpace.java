package com.programmercarl.string;

/**
 * @ClassName ReplaceSpace
 * @Descriotion TODO
 * @Author nitaotao
 * @Date 2022/6/23 19:49
 * @Version 1.0
 * https://leetcode.cn/problems/ti-huan-kong-ge-lcof/
 * 剑指 Offer 05. 替换空格
 **/
public class ReplaceSpace {
    public static void main(String[] args) {
//        char space = ' ';
        //32
//        System.out.println(space - 0);
        System.out.println(replaceSpace("We are happy."));
    }

    public static String replaceSpace(String s) {
        char[] chars = s.toCharArray();
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 32) {
                result.append("%20");
            } else {
                result.append(chars[i]);
            }
        }
        return String.valueOf(result);
    }
}
