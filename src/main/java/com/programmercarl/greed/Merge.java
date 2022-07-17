package com.programmercarl.greed;

import com.programmercarl.util.GenerateArray;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName Merge
 * @Descriotion TODO
 * @Author nitaotao
 * @Date 2022/7/17 12:30
 * @Version 1.0
 * https://leetcode.cn/problems/merge-intervals/
 * 56. 合并区间
 **/
public class Merge {
    public int[][] merge(int[][] intervals) {
        HashMap<Integer, Integer> map = new HashMap<>();
        //排序，根据起始位置升序，按末尾位置降序
        Arrays.sort(intervals, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return Integer.compare(o2[1], o1[1]);
            } else {
                return Integer.compare(o1[0], o2[0]);
            }
        });
        int start = intervals[0][0];
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] > end) {
                //如果起始位置>end
                map.put(start, end);
                start = intervals[i][0];
                end = intervals[i][1];
            } else {
                //否则就取两者中右边界的最大值
                end = Math.max(end, intervals[i][1]);
            }
        }
        //最后一个单独设置为一组
        map.put(start, end);
        int[][] result = new int[map.size()][2];
        int n = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            result[n][0] = entry.getKey();
            result[n][1] = entry.getValue();
            n++;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Merge().merge((int[][]) GenerateArray.generateArrays("[[1,3],[2,6],[8,10],[15,18]]", "int")));
    }
}
