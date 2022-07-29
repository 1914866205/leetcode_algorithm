package com.programmercarl.dynamic;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @ClassName MinStickers
 * @Descriotion TODO
 * @Author nitaotao
 * @Date 2022/7/29 21:38
 * @Version 1.0
 * https://leetcode.cn/problems/stickers-to-spell-word/
 * 691. 贴纸拼词
 **/
public class MinStickers {
    public int minStickers(String[] stickers, String target) {
        int result = minSticker(stickers, target);
        return (result == Integer.MAX_VALUE) ? -1 : result;
    }


    /**
     * @param stickers 字符数组
     * @param target   目标值
     * @return
     */
    public int minSticker(String[] stickers, String target) {
        if (target.length() == 0) {
            return 0;
        }
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < stickers.length; i++) {
            //新的目标串
            String minus = minus(target, stickers[i]);
            //如果 对 原串 有改变，即新串变短了
            if (minus.length() != target.length()) {
                min = Math.min(min, minSticker(stickers, minus));
            }
        }
        return min + (min == Integer.MAX_VALUE ? 0 : 1);
    }

    /**
     * 返回 s1 - s2
     *
     * @param s1 大串 需要保留的
     * @param s2 小串
     * @return
     */
    public String minus(String s1, String s2) {
        char[] charS1 = s1.toCharArray();
        char[] charS2 = s2.toCharArray();
        //哈希法
        int[] result = new int[26];
        for (int i = 0; i < charS1.length; i++) {
            result[charS1[i] - 'a']++;
        }
        for (int i = 0; i < charS2.length; i++) {
            result[charS2[i] - 'a']--;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < result.length; i++) {
            if (result[i] > 0) {
                for (int j = 0; j < result[i]; j++) {
                    sb.append((char) (i + 'a'));
                }
            }
        }
        return String.valueOf(sb);
    }
    public int minStickers2(String[] stickers, String target) {
        int[][] str = new int[stickers.length][26];
        // 贴纸词频统计
        for (int i = 0; i < stickers.length; i++) {
            for (int j = 0; j < stickers[i].length(); j++) {
                str[i][stickers[i].charAt(j) - 'a']++;
            }
        }
        int result = minSticker2(str, target);
        return (result == Integer.MAX_VALUE) ? -1 : result;
    }

    /**
     * @param stickers 字符数组
     * @param target   目标值
     * @return
     */
    public int minSticker2(int[][] stickers, String target) {
        if (target.length() == 0) {
            return 0;
        }
        //目标串词频统计
        int[] targetArr = new int[26];
        // 贴纸词频统计  不一定开头为 a
        for (int i = 0; i < target.length(); i++) {
            targetArr[target.charAt(i) - 'a']++;
        }

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < stickers.length; i++) {
            int[] sticker = stickers[i];
            //如果这个目标串的首元素
            if (sticker[target.charAt(0) - 'a'] > 0) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < 26; j++) {
                    //在目标串中找元素，不过匹配串位置有没有，先减了再说
                    if (targetArr[j] > 0) {
                        int nums = targetArr[j] - sticker[j];
                        for (int k = 0; k < nums; k++) {
                            //重新生成新的目标串  每个字母相减后剩余的目标串的元素
                            sb.append((char) (j + 'a'));
                        }
                    }
                }
                min = Math.min(min, minSticker2(stickers, String.valueOf(sb)));
            }
        }
        return min + (min == Integer.MAX_VALUE ? 0 : 1);
    }
    public int minStickers3(String[] stickers, String target) {
        int[][] str = new int[stickers.length][26];
        // 贴纸词频统计
        for (int i = 0; i < stickers.length; i++) {
            for (int j = 0; j < stickers[i].length(); j++) {
                str[i][stickers[i].charAt(j) - 'a']++;
            }
        }
        HashMap<String, Integer> dp = new HashMap<String, Integer>();
        int result = minSticker3(str, target,dp);
        return (result == Integer.MAX_VALUE) ? -1 : result;
    }

    /**
     * @param stickers 字符数组
     * @param target   目标值
     * @return
     */
    public int minSticker3(int[][] stickers, String target, HashMap<String, Integer> dp) {
        if (target.length() == 0) {
            return 0;
        }
        if (dp.containsKey(target)) {
            return dp.get(target);
        }
        //目标串词频统计
        int[] targetArr = new int[26];
        // 贴纸词频统计  不一定开头为 a
        for (int i = 0; i < target.length(); i++) {
            targetArr[target.charAt(i) - 'a']++;
        }

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < stickers.length; i++) {
            int[] sticker = stickers[i];
            //如果这个目标串的首元素
            if (sticker[target.charAt(0) - 'a'] > 0) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < 26; j++) {
                    //在目标串中找元素，不过匹配串位置有没有，先减了再说
                    if (targetArr[j] > 0) {
                        int nums = targetArr[j] - sticker[j];
                        for (int k = 0; k < nums; k++) {
                            //重新生成新的目标串  每个字母相减后剩余的目标串的元素
                            sb.append((char) (j + 'a'));
                        }
                    }
                }
                min = Math.min(min, minSticker3(stickers, String.valueOf(sb),dp));
            }
        }
        dp.put(target, min + (min == Integer.MAX_VALUE ? 0 : 1));
        return min + (min == Integer.MAX_VALUE ? 0 : 1);
    }
    public static void main(String[] args) {
        System.out.println(new MinStickers().minStickers(new String[]{"these", "guess", "about", "garden", "him"}, "atomher"));
        System.out.println(new MinStickers().minStickers2(new String[]{"these", "guess", "about", "garden", "him"}, "atomher"));
        System.out.println(new MinStickers().minStickers3(new String[]{"these", "guess", "about", "garden", "him"}, "atomher"));
    }
}
