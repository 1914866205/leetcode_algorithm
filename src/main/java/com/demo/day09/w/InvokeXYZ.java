package com.demo.day09.w;


/**
 * author: nitaotao
 * date: 2021/12/1 12:15
 * version: 1.0
 * description: todo
 */
public class InvokeXYZ {
    public static void main(String[] args) {
        com.demo.day09.x.Test testx = new com.demo.day09.x.Test();
        System.out.println(testx.add(1,2,3));
        com.demo.day09.y.Test testy = new com.demo.day09.y.Test();
        System.out.println(testy.add(1,2));
        com.demo.day09.z.Test testz = new com.demo.day09.z.Test();
        System.out.println(testz.add());
    }
}
