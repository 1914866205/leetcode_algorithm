package com.demo.course.experiment01;


import java.util.*;

/**
 * author: nitaotao
 * date: 2021/12/27 2:26
 * version: 1.0
 * description: http://noi.openjudge.cn/ch0106/13/
 */
public class Main08 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String c = sc.next();
        Main08 main = new Main08();
        main.factor(c);
    }

    /**
     * 顺序输出因子
     *
     * @param c
     */
    public void factor(String c) {
        TreeSet<Integer> set = new TreeSet();
        //最大位数
        int[] num = new int[30];
        String[] str = c.split("");
        //每一位转成数字
        for (int i = 0; i < str.length; i++) {
            num[num.length - i - 1] = Integer.parseInt(str[str.length - 1 - i]);
        }
        int remainder; //余数
        int tag = 0;  //记录有符合的大整数因子
        for (int i = 2; i <= 9; i++) {
            remainder = 0;
            for (int j = 0; j <= num.length-1; j++) {
                //模拟除法操作  除法操作从第一位开始进行，和大整数加法相反
                //对余数进行运算
                remainder = remainder * 10 + num[j];
                remainder = remainder % i;   //余数

            }
            if (remainder == 0) {  //当余数为0，说明可以整除
                set.add(i);
                tag = 1;
            }
        }
        if (tag == 0) {
            System.out.println("none");
        } else {
            Iterator<Integer> iterator = set.iterator();
            while (iterator.hasNext()) {
                System.out.print(iterator.next()+" ");
            }
        }
    }
}
