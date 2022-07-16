package com.programmercarl.greed;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @ClassName FindMinArrowShots
 * @Descriotion TODO
 * @Author nitaotao
 * @Date 2022/7/16 17:20
 * @Version 1.0
 * 452. 用最少数量的箭引爆气球
 * https://leetcode.cn/problems/minimum-number-of-arrows-to-burst-balloons/
 **/
public class FindMinArrowShots {
    public int findMinArrowShots(int[][] points) {
//        先对数组进行排序
//        以x start 升序
//        如果 x start 相同，以 x end 升序
        Arrays.sort(points, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            } else {
                return o1[0] - o2[0];
            }
        });
        //之前的排序面对 [[-2147483646,-2147483645],[2147483646,2147483647]] 会溢出
        //按左边界排序，升序   也不行，需要对第二个字段也升序
//        Arrays.sort(points, Comparator.comparingInt(a -> a[0]));


        Arrays.sort(points, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                // 升序  o1[1]-o2[1]   <0
                // 即  o1[1]<o2[1]
                // Integer.compare(o1[1], o2[1])
                // 如果 o1[1]<o2[1]
                // Integer.compare(o1[1], o2[1]) 返回 -1 也<0
                return Integer.compare(o1[1], o2[1]);
            } else {
                return Integer.compare(o1[0], o2[0]);
            }
        });


        int result = points.length;
        for (int i = 0; i < points.length - 1; ) {
            int index = i + 1;
            int temp = 1;
            int minRight = Integer.MAX_VALUE;
            //如果两个气球有重合的地方，箭 - 1
            //左边的气球的右侧在右边气球的右侧，打两个气球中间
            for (int j = index; j < points.length; j++) {
                if (points[j][0] > minRight) {
                    //如果超出最小右边界
                    break;
                }
                if (points[i][1] >= points[j][0]) {
                    if (points[j][1] < minRight) {
                        minRight = points[j][1];
                    }
                    //需要记录最小右边界
                    result--;
                    //新的i的位置
                    //i+=temp
                    temp++;

                } else {
                    break;
                }
            }
            i += temp;
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] arr = new int[8][];
        arr[0] = new int[]{9, 12};
        arr[1] = new int[]{1, 10};
        arr[2] = new int[]{4, 11};
        arr[3] = new int[]{8, 12};
        arr[4] = new int[]{3, 9};
        arr[5] = new int[]{6, 9};
        arr[6] = new int[]{6, 7};
        arr[7] = new int[]{1, 5};

        System.out.println(new FindMinArrowShots().findMinArrowShots(arr));
    }
}
