package com.study;

/**
 * @author 倪涛涛
 * @version 1.0.0
 * @ClassName String.java
 * @Description TODO
 * @createTime 2021年06月19日 20:09:00
 */
public class Student {
    @Override
    public String toString(){
        return "hello";
    }

    public static void main(String[] args) {
        Student s = new Student();
        System.out.println(s);
        System.out.println(s.getClass().getClassLoader());
    }
}
