package com.demo.course.help;

import java.util.Scanner;

/**
 * author: nitaotao
 * date: 2021/12/25 19:34
 * version: 1.0
 * description: todo
 */
public class Solution01 {

    /* 以下为main方法 */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int str1 = input.nextInt();
        int str2 = input.nextInt();
        int s1, s2, count1 = 0, count2 = 0;
        int l1 = 0, l2 = 0;  //两个数组的长度

        Solution01 main = new Solution01();  //main负责调用方法
        //计算出str1,str2数组的长度
        s1 = str1;
        while (s1 != 0) {
            l1++;
            s1 /= 10;
        }
        s2 = str2;
        while (s2 != 0) {
            l2++;
            s2 /= 10;
        }
        int[] c1 = new int[l1];
        int[] c2 = new int[l2];
        while ((str1 != 0)) {
            c1[count1] = str1 % 10;
            str1 /= 10;
            count1++;
        }
        while ((str2 != 0)) {
            c2[count2] = str2 % 10;
            str2 /= 10;
            count2++;
        }
        main.add(l1, l2, c1, c2);
    }

    public void add(int l1, int l2, int[] c1, int[] c2) {
        int max = Math.max(l1, l2);
        int[] sum = new int[max + 1];

        //对应位相加
        int i, k = 0;  // k表示进位
        for (i = 0; i < max; i++) {
            sum[i] = (c1[i] + c2[i] + k) % 10;  //和≥10时，保留个位
            k = (c1[i] + c2[i] + k) / 10;  //取出十位上的数，用k表示进位
        }
        sum[i] = k;  //把进位k存入最后一位
        boolean isZero = true;
        for (i = max; i >= 0; i--) {
            if (sum[i] == 0 && isZero) {
                continue;
            } else {
                isZero = false;
                System.out.print(sum[i]);
            }

            //    if(i==max-1&&sum[max-1]==0)   continue;  //有前导0则跳过
        }
//           return 1;
    }
}
