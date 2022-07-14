package com.programmercarl.greed;

import java.util.Arrays;

/**
 * @ClassName FindContentChildren
 * @Descriotion TODO
 * @Author nitaotao
 * @Date 2022/7/14 12:42
 * @Version 1.0
 * https://leetcode.cn/problems/assign-cookies/
 * 455. 分发饼干
 **/
public class FindContentChildren {
    /**
     * @param g 孩子胃口数组
     * @param s 饼干大小数组
     * @return
     */
    public int findContentChildren(int[] g, int[] s) {
        int result = 0;
        /**
         * 两个都升序，遍历饼干数组，如果当前饼干大小>=孩子数量，则结果+1，饼干后移
         */
        Arrays.sort(g);
        Arrays.sort(s);
        //遍历饼干数组
        int boyIndex = 0;
        for (int i = 0; i < s.length; i++) {
            //遍历孩子数组
            for (int j = boyIndex; j < g.length; j++) {
                if (s[i] < g[j]) {
                    //当前饼干小于最小的孩子的胃口，本饼干无用，
                    //因为每个孩子最多只能分一个饼干
                    break;
                }else{
                    //如果当前饼干够当前最小的孩子吃了
                    // 结果++
                    result++;
                    //当前孩子跳过
                    boyIndex++;
                    //当前饼干已被分配，跳过
                    break;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new FindContentChildren().findContentChildren(new int[]{10,9,8,7}, new int[]{5,6,7,8}));
    }
}
