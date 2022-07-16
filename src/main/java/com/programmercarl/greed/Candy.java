package com.programmercarl.greed;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @ClassName Candy
 * @Descriotion TODO
 * @Author nitaotao
 * @Date 2022/7/16 10:26
 * @Version 1.0
 * https://leetcode.cn/problems/candy/
 * 135. 分发糖果
 **/
public class Candy {
    public int candy(int[] ratings) {
        //至少每人一个
        int sum = 0;
        //标记数组，表示已经额外过给了
        int[] candys = new int[ratings.length];
        //每人至少一个
        Arrays.fill(candys, 1);
        for (int i = 0; i < ratings.length - 1; i++) {
            if (ratings[i] == ratings[i + 1]) {
                //一样大就跳过
                continue;
            } else if (ratings[i] > ratings[i + 1]) {
                //如果当前人比后一个评分高
                if (candys[i] > candys[i + 1]) {
                    continue;
                }
                candys[i] = candys[i + 1] + 1;
                //回退
                for (int j = i + 1; j > 0; j--) {
                    if (ratings[j] >= ratings[j - 1]) {
                        //如果当前人比前一个评分高
                        break;
                    } else {
                        //如果当前人比前一个评分低

                        if (candys[j - 1] > candys[j]) {
                            continue;
                        }
                        candys[j - 1] = candys[j] + 1;
                    }
                }
            } else {
                //如果当前人比后一个评分低
                candys[i + 1] = candys[i] + 1;
            }
        }
        for (int i = 0; i < candys.length; i++) {
            sum += candys[i];
        }
        return sum;
    }

}
