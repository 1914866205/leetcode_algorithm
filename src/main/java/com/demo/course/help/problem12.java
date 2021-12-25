package com.demo.course.help;

import java.util.Arrays;
import java.util.Scanner;

public class problem12 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();  //选手数
        int m = input.nextInt();  //录取数
        int[] id = new int[n];   //输入报名号
        int[] score = new int[n];  //输入成绩
        for (int i = 0; i < n; i++) {
            id[i] = input.nextInt();//输入报名号
            score[i] = input.nextInt();//输入成绩
        }
        //成绩降序排序
        for (int i = 1; i <= n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (score[j] < score[j + 1]) { //若第j个成绩小于第j+1个成绩，则替换第j+1个成绩
                    int t = score[j];
                    score[j] = score[j + 1];
                    score[j + 1] = t;
                    int z = id[j];
                    id[j] = id[j + 1];
                    id[j + 1] = z;  //排列报名号
                } else if (score[j] == score[j + 1]) {//如果成绩相同，则按报名号由小到大的顺序输出
                    if (id[j] > id[j + 1]) {   //对报名号进行比较，升序排列
                        int idtemp = id[j];
                        id[j] = id[j + 1];
                        id[j + 1] = idtemp; //报名号顺序排列
                    }
                }
            }
        }
        Arrays.stream(score).forEach(System.out::print);
        Arrays.stream(id).forEach(System.out::print);
        int newm = (int) Math.floor(m * 1.5);//第m*150%（向下取整）名,如录取三名，则面试人数为3*1.5=4.5，向下取整为4
        int scorenew = score[newm - 1]; //定义成绩数组下标
        int count = 0;//计数
        for (int i = 0; i < score.length; i++) {
            if (score[i] >= scorenew) { //若成绩大于等于录取分数线
                count++;
            }
        }
        System.out.println(scorenew + " " + count);//输出录取分数线 录取人数
        for (int i = 0; i < score.length; i++) {
            if (score[i] >= scorenew) {
                System.out.print(id[i] + " ");
                System.out.println(score[i]);
            }
        }
    }
}