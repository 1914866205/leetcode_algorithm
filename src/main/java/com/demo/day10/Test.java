package com.demo.day10;

import com.demo.day09.point.Point2D;

/**
 * author: nitaotao
 * date: 2021/12/8 23:30
 * version: 1.0
 * description: todo
 */
public class Test {
    public static void main(String[] args) {
        Point3D a = new Point3D(1,2,4);
        Point3D b = new Point3D();
        System.out.println("b的构造方法位置");
        b.printLocation();
        b.setxValue(0);
        b.setyValue(0);
        b.setzValue(1);
        System.out.println("b的初始化位置");
        b.printLocation();
        System.out.println("a的位置");
        b.printLocation();
        System.out.println("a到b的距离");
        System.out.println(a.distance(b));
        System.out.println("b到原点的位置");
        System.out.println(b.distance());
        System.out.println("a移动到b后，a的位置");
        a.moveTo(b);
        a.printLocation();
        System.out.println("a镜像变换");
        a.mirror();
        System.out.println("a的位置");
        a.printLocation();
    }
}
