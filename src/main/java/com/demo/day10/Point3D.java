package com.demo.day10;

import com.demo.day09.point.Point2D;

/**
 * author: nitaotao
 * date: 2021/12/8 23:14
 * version: 1.0
 * description: todo
 */
public class Point3D extends Point2D {
    private double xValue;
    private double yValue;
    private double zValue;  // z轴坐标

    public Point3D() {
        xValue = 0;
        yValue = 0;
        zValue = 0;
    }

    public Point3D(double xValue, double yValue, double zValue) {
        this.xValue = xValue;
        this.yValue = yValue;
        this.zValue = zValue;
    }

    // output x, y and z
    @Override
    public void printLocation() {
        System.out.println("x:"+xValue + " y:" + yValue + " z:" + zValue);
    }

    // return the distance between the current point and the origin
    @Override
    public double distance() {
        return Math.sqrt(xValue * xValue + yValue * xValue + zValue * zValue);
    }

    // return the distance between the current point and the specified one
    public double distance(Point3D point) {
        return Math.sqrt((point.getxValue() - this.xValue) * (point.getxValue() - this.xValue)
                + (point.getyValue() - this.yValue) * (point.getyValue() - this.yValue)
                + (point.getzValue() - this.zValue) * (point.getzValue() - this.zValue));
    }

    // move the current point to the specific location
    public void moveTo(Point3D location) {
        this.xValue = location.getxValue();
        this.yValue = location.getyValue();
        this.zValue = location.getzValue();
    }

    // mirror the current point according to the origin
    @Override
    public void mirror() {
        this.xValue = -this.xValue;
        this.yValue = -this.yValue;
        this.zValue = -this.zValue;
    }

    @Override
    public double getxValue() {
        return xValue;
    }

    @Override
    public void setxValue(double xValue) {
        this.xValue = xValue;
    }

    @Override
    public double getyValue() {
        return yValue;
    }

    @Override
    public void setyValue(double yValue) {
        this.yValue = yValue;
    }

    public double getzValue() {
        return zValue;
    }

    public void setzValue(double zValue) {
        this.zValue = zValue;
    }
}
