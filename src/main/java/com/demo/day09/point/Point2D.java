package com.demo.day09.point;

/**
 * author: nitaotao
 * date: 2021/12/1 12:20
 * version: 1.0
 * description: todo
 */
public class Point2D {
    private double xValue;
    private double yValue;

    public Point2D() {
        this.xValue = 0;
        this.yValue = 0;
    }

    public Point2D(double xValue, double yValue) {
        this.xValue = xValue;
        this.yValue = yValue;
    }

    public double getxValue() {
        return xValue;
    }

    public void setxValue(double xValue) {
        this.xValue = xValue;
    }

    public double getyValue() {
        return yValue;
    }

    public void setyValue(double yValue) {
        this.yValue = yValue;
    }


    public void printLocation() {
        System.out.println(xValue+"  "+yValue);
    }


    /**
     * 到原点的位置
     *
     * @return
     */
    public double distance() {
        return Math.sqrt(xValue * xValue + yValue * yValue);
    }
    /**
     * 返回两个点的距离
     *
     * @param point
     * @return
     */
    public double distance(Point2D point) {
        return Math.sqrt((point.getxValue() - xValue) * (point.getxValue() - xValue) + (point.getyValue() - yValue) * (point.getyValue() - yValue));
    }

    /**
     * 移动当前点到指定点
     *
     * @param location
     */
    public void moveTo(Point2D location) {
        this.xValue = location.getxValue();
        this.yValue = location.getyValue();
    }

    /**
     * 返回原点镜像
     */
    public void mirror() {
        this.xValue = -this.xValue;
        this.yValue = -this.yValue;
    }

    @Override
    public String toString() {
        return "Point2D{" +
                "xValue=" + xValue +
                ", yValue=" + yValue +
                '}';
    }
}
