package com.demo.day08;

import java.util.Scanner;

/**
 * author: nitaotao
 * date: 2021/11/18 9:47
 * version: 1.0
 * description:  http://noi.openjudge.cn/ch0110/01/
 */
public class Main01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); //学生人数
        int k = scanner.nextInt(); //第k名学生
        int[] students = new int[n]; //学生学号数组
        Double[] scores = new Double[n]; //学生成绩数组
        for (int i = 0; i < students.length; i++) {
            students[i] = scanner.nextInt();
            scores[i] = scanner.nextDouble();
        }
//        int k = 3;
//        int[] students = {1, 2, 3, 90788004, 5}; //学生学号数组
//        Double[] scores = {67.8, 90.3, 61.0, 68.4, 73.9}; //学生成绩数组
        //对成绩进行排序，冒泡排序
        for (int i = 0; i < scores.length; i++) {
            for (int j = i; j < scores.length; j++) {
                //如果后一个比前一个大，交换位置
                if (scores[i] < scores[j]) {
                    Double temp = scores[i];
                    scores[i] = scores[j];
                    scores[j] = temp;

                    //学号数组对应也要做交换
                    int stu = students[i];
                    students[i] = students[j];
                    students[j] = stu;
                }
            }
        }
//        for (int i = 0; i < scores.length; i++) {
//            System.out.println(scores[i]+" "+students[i]);
//        }
        System.out.print(students[k - 1] + " ");
        System.out.printf("%.1f", scores[k - 1]);
    }
}
