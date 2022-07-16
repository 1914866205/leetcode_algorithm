package com.programmercarl.greed;

import java.util.*;

/**
 * @ClassName ReconstructQueue
 * @Descriotion TODO
 * @Author nitaotao
 * @Date 2022/7/16 15:01
 * @Version 1.0
 * https://leetcode.cn/problems/queue-reconstruction-by-height/
 * 406. 根据身高重建队列
 **/
public class ReconstructQueue {
    public int[][] reconstructQueue(int[][] people) {
        System.out.println(people);


//         [[7,0],[4,4],[7,1],[5,0],[6,1],[5,2]]
        //按第一个元素降序，第二个元素升序
        //即按身高降序，按位置升序
        Arrays.sort(people, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            } else {
                return o2[0] - o1[0];
            }
        });
        System.out.println(people);

//         [[7,0],[7,1],[6,1],[5,0],[5,2],[4,4]]
        LinkedList<int[]> que = new LinkedList<int[]>();
        for (int[] p : people) {
            //在p1位置插入元素p
            que.add(p[1], p);
        }
        return que.toArray(new int[people.length][]);
    }

    public static void main(String[] args) {
        int[][] arr = new int[6][];
        arr[0] = new int[]{7, 0};
        arr[1] = new int[]{4, 4};
        arr[2] = new int[]{7, 1};
        arr[3] = new int[]{5, 0};
        arr[4] = new int[]{6, 1};
        arr[5] = new int[]{5, 2};
        System.out.println(new ReconstructQueue().reconstructQueue(arr));
    }
}
