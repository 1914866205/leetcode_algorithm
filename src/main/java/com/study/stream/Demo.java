package com.study.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 倪涛涛
 * @version 1.0.0
 * @ClassName Demo.java
 * @Description TODO
 * @createTime 2021年08月08日 17:45:00
 */
public class Demo {
    public static void main(String[] args) {
        float a = 100;
        List<Integer> list = getNum(a);
        float sum=0;
        for (int i = 0; i <list.size() ; i++) {
            sum =sum+ list.get(i);
        }
        System.out.println(list);
        System.out.println(sum);
        System.out.println(sum/a);
    }

   public static   List getNum(float a) {
        ArrayList list = new ArrayList();
        for (int i = 1; i <=a; i++) {
            if (a % i == 0) {
                list.add(i);
            }
        }
        return list;
    }

}
