package com.programmercarl.hashtable;

import java.util.HashMap;

/**
 * @ClassName CanConstruct
 * @Descriotion TODO
 * @Author nitaotao
 * @Date 2022/6/21 14:15
 * @Version 1.0
 * https://leetcode.cn/problems/ransom-note/
 * 赎金信
 **/
public class CanConstruct {
    public static void main(String[] args) {
        canConstruct("aa", "aab");
    }

    /**
     * 给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。
     * 如果可以，返回 true ；否则返回 false 。
     * magazine 中的每个字符只能在 ransomNote 中使用一次。
     * <p>
     * 这个题不就是问两个是不是字母异位词嘛。
     *
     * @param ransomNote
     * @param magazine
     * @return
     */
    public static boolean canConstruct(String ransomNote, String magazine) {
        final byte[] magazineBytes = magazine.getBytes();
        int[] result = new int[26];
        for (byte i : magazineBytes) {
            result[i - 'a'] += 1;
        }
        final byte[] ransomNoteBytes = ransomNote.getBytes();
        for (byte i : ransomNoteBytes) {
            if (result[i - 'a'] <= 0) {
                return false;
            }else {
                result[i - 'a'] -= 1;
            }
        }
        return true;
    }

    /**
     * 给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。
     * 如果可以，返回 true ；否则返回 false 。
     * magazine 中的每个字符只能在 ransomNote 中使用一次。
     * <p>
     * 这个题不就是问两个是不是字母异位词嘛。
     *
     * @param ransomNote
     * @param magazine
     * @return
     */
    public static boolean canConstruct2(String ransomNote, String magazine) {
        final byte[] magazineBytes = magazine.getBytes();
        HashMap<Byte, Integer> map = new HashMap<>();
        for (byte i : magazineBytes) {
            //如果不包含，添加，包含则数量+1
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }
        final byte[] ransomNoteBytes = ransomNote.getBytes();
        int value;
        for (byte i : ransomNoteBytes) {
            //如果不包含，则false
            if (!map.containsKey(i)) {
                return false;
            } else {
                //如果这个字母只剩最后一次使用机会了，则删除这个键
                value = map.get(i);
                if (value == 1) {
                    map.remove(i);
                } else {
                    map.put(i, value - 1);
                }
                if (map.size() == 0) {
                    return true;
                }
            }
        }
        return true;
    }
}
