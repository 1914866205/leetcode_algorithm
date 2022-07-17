package com.programmercarl.string;

/**
 * @ClassName Demo
 * @Descriotion TODO
 * @Author nitaotao
 * @Date 2022/7/17 10:19
 * @Version 1.0
 * "Q46：给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 """"
 * 注意：
 * 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
 * 如果 s 中存在这样的子串，我们保证它是唯一的答案。
 * 示例 1：
 * 输入：s = ""ADOBECODEBANC"", t = ""ABC""
 * 输出：""BANC""
 * 示例 2：
 * 输入：s = ""a"", t = ""a""
 * 输出：""a""
 * 示例 3:
 * 输入: s = ""a"", t = ""aa""
 * 输出: """"
 * 解释: t 中两个字符 'a' 均应包含在 s 的子串中，
 * 因此没有符合条件的子字符串，返回空字符串。
 * 你能设计一个在 o(n) 时间内解决此问题的算法吗？"
 **/
public class Demo {
//    public String getStr(String s, String t) {
//        //排除特殊情况
//        if (t == null || t.length() == 0) {
//            return "";
//        }
//        if (s.length() < t.length()) {
//            return "";
//        }
//        final char[] chars = s.toCharArray();
//        char[][] str = new char[chars.length][2];
//        for (int i = 0; i < chars.length; i++) {
//            str[i][0] = chars[i];
//            str[i][1] =0;
//        }
//        for (int i = 0; i < s.length(); i++) {
//            for (int j = 0; j < t.length(); j++) {
//                if (s.charAt(i) == t.charAt(j)) {
//                    str[i][0] = (char) (Integer.parseInt(String.valueOf(str[i][0])) + 1);
//                }
//            }
//        }
//        //到此处已经标记完所有s中t的元素的位置
//        //接下来要用双指针法标记s中一段t的首位，t判断是否是完整的，需要单独做一个t内各元素是否被计入双指针范围内的数组维护
//        //感觉好麻烦
//    }
}
