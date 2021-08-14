package com.study;

import java.util.ArrayList;

/**
 * @author 倪涛涛
 * @version 1.0.0
 * @ClassName Demo1.java
 * @Description TODO
 * @createTime 2021年06月28日 15:10:00
 */
//JVM参数使用笔记
//https://blog.csdn.net/tianhong2015/article/details/109032202
//-Xms1m -Xmx8m -XX:+PrintGCDetails
//-Xms1m -Xmx8m -XX:+HeapDumpOnOutOfMemoryError
public class Demo1 {
    byte[] array = new byte[1024 * 1024];
    public static void main(String[] args) {
        ArrayList<Demo1> list = new ArrayList<>();
        int count = 0;
        try {
            while (true) {
                list.add(new Demo1());
                count++;
            }
        } catch (Error e) {
            System.out.println("count:" + count);
            e.printStackTrace();
        }
    }
}
