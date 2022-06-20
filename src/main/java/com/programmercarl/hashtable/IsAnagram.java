package com.programmercarl.hashtable;

/**
 * @ClassName IsAnagram
 * @Descriotion 242. 有效的字母异位词
 * @Author nitaotao
 * @Date 2022/6/20 13:21
 * @Version 1.0
 * https://leetcode.cn/problems/valid-anagram/
 **/
public class IsAnagram {
    public static void main(String[] args) {
        System.out.println(isAnagram("anagram", "nagaram"));
    }

    /**
     * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
     * 注意：若s 和 t中每个字符出现的次数都相同，则称s 和 t互为字母异位词。
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/valid-anagram
     * 1 <= s.length, t.length <= 5 * 10^4
     * s 和 t 仅包含小写字母
     *
     * @param s
     * @param t
     * @return
     */
    public static boolean isAnagram(String s, String t) {
        //如果长度不一样，则肯定不相等
        if (s.length() != t.length()) {
            return false;
        }
        //创建位数匹配的字母表
        char[] arrS = s.toCharArray();
        char[] arrT = t.toCharArray();
        int[] numS = new int[26];
        int[] numT = new int[26];
        for (int i = 0; i < arrS.length; i++) {
            numS[arrS[i] % 26] += 1;
            numT[arrT[i] % 26] += 1;
        }
        for (int i = 0; i < 26; i++) {
            if(numS[i]!=numT[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
     * 注意：若s 和 t中每个字符出现的次数都相同，则称s 和 t互为字母异位词。
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/valid-anagram
     * 1 <= s.length, t.length <= 5 * 10^4
     * s 和 t 仅包含小写字母
     *
     * @param s
     * @param t
     * @return
     */
    public static boolean isAnagram2(String s, String t) {
        //如果长度不一样，则肯定不相等
        if (s.length() != t.length()) {
            return false;
        }
        //两个字符串都分割为字符数组，然后排序，再逐位比较
        char[] arrS = s.toCharArray();
        char[] arrT = t.toCharArray();
        for (int i = 0; i < arrS.length - 1; i++) {
            for (int j = i + 1; j < arrS.length; j++) {
                if (arrS[i] > arrS[j]) {
                    char temp = arrS[i];
                    arrS[i] = arrS[j];
                    arrS[j] = temp;
                }
                if (arrT[i] > arrT[j]) {
                    char temp = arrT[i];
                    arrT[i] = arrT[j];
                    arrT[j] = temp;
                }
            }
        }
        for (int i = 0; i <arrS.length ; i++) {
            if(arrS[i]!=arrT[i]) {
                return false;
            }
        }
        return true;
    }
}
