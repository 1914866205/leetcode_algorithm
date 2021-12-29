package com.demo.course.mid.problem02;


/**
 * author: nitaotao
 * date: 2021/12/21 10:25
 * version: 1.0
 * description: http://noi.openjudge.cn/ch0110/05/
 *  分数线划定
 * 【解题思路】：使用两个数组分别存放成绩和选手号，先进行排序，再计算出分数线，筛选符合成绩的选
 * 手的信息输出
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); //报名参加笔试的选手总数
        int m = scanner.nextInt(); //计划录取的志愿者人数
        int[] id = new int[n]; //选手号
        int[] scale = new int[n]; //成绩
        //赋值
        for (int i = 0; i < n; i++) {
            id[i] = scanner.nextInt();
            scale[i] = scanner.nextInt();
        }
        Main main = new Main();
        main.getScale(id, scale, m);
    }

    /**
     * getScale方法：按照笔试成绩从高到低输出，如果成绩相同，则按报名号由小到大的顺序输出。
     *
     * @param id    选手号
     * @param scale 成绩
     * @param plan  计划人数
     */
    public void getScale(int[] id, int[] scale, int plan) {
        int idTemp = 0;
        int scaleTemp = 0;
        for (int i = 0; i < id.length; i++) {
            for (int j = 0; j < id.length; j++) {
                //以成绩为主，降序
                if (scale[j] < scale[i]) {
                    scaleTemp = scale[j];
                    scale[j] = scale[i];
                    scale[i] = scaleTemp;
                    //成绩排序的同时，选手号也排序
                    idTemp = id[j];
                    id[j] = id[i];
                    id[i] = idTemp;

                } else if (scale[j] == scale[i]) {
                    //如果成绩相同，则按报名号由小到大的顺序输出
                    if (id[j] > id[i]) {
                        idTemp = id[j];
                        id[j] = id[i];
                        id[i] = idTemp;

                        scaleTemp = scale[j];
                        scale[j] = scale[i];
                        scale[i] = scaleTemp;

                    }
                }
            }
        }
//        Arrays.stream(scale).forEach(System.out::print);
//        Arrays.stream(id).forEach(System.out::print);
        //面试分数线  为  排名第m*150%（向下取整）名的选手 的分数
        int line = (int) Math.floor(plan * 1.5);
        //输出分数线和录取人数，此处应减一。因为第三名对应数组位置是2
        int scaleLine = scale[line - 1];//数组当前位置成绩为分数线
        int count = 0;
        for (int i = 0; i < scale.length; i++) {
            if (scale[i] >= scaleLine) {
                count++;
            }
        }
        System.out.println(scaleLine + " " + count);
        for (int i = 0; i < scale.length; i++) {
            if (scale[i] >= scaleLine) {
                System.out.print(id[i] + " ");
                System.out.println(scale[i]);
            }
        }
    }
}

