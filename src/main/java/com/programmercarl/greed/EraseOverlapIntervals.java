package com.programmercarl.greed;

import com.programmercarl.util.GenerateArray;

import java.util.Arrays;

/**
 * @ClassName EraseOverlapIntervals
 * @Descriotion TODO
 * @Author nitaotao
 * @Date 2022/7/17 6:47
 * @Version 1.0
 * https://leetcode.cn/problems/non-overlapping-intervals/
 * 435. 无重叠区间
 **/
public class EraseOverlapIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,(o1,o2)->{
            //以第二列升序，第一列降序
            if (o1[1] == o2[1]) {
                return Integer.compare(o2[0], o1[0]);
            } else {
                return Integer.compare(o1[1], o2[1]);
            }
        });
        int end = intervals[0][1];
        int result = 0;
        for (int i = 1; i < intervals.length; i++) {
            //如果当前起点>end,说明上个end已结束
            if (intervals[i][0] >= end) {
                end = intervals[i][1];
            } else {
                //否则上个end没结束，就不能开始，这个就得删除
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] arr = (int[][]) GenerateArray.generateArrays("[[-52,31],[-73,-26],[82,97],[-65,-11],[-62,-49],[95,99],[58,95],[-31,49],[66,98],[-63,2],[30,47],[-40,-26]]", "int");

        System.out.println(new EraseOverlapIntervals().eraseOverlapIntervals(arr));
    }
}
