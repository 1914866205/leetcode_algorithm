package com.demo.day09.point;

/**
 * author: nitaotao
 * date: 2021/12/1 12:38
 * version: 1.0
 * description: todo
 */
public class Test {
    public static void main(String[] args) {
        Point2D point1 = new Point2D();
        Point2D point2 = new Point2D(3, 4);
        point2.printLocation();
        System.out.println("点2距离原点的距离:"+point2.distance());
        System.out.println("点2距离原的1距离:" + point2.distance(point1));
        point1.moveTo(point2);
        point1.mirror();
        point1.printLocation();
    }
}
