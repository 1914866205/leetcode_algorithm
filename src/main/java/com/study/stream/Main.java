package com.study.stream;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @author 倪涛涛
 * @version 1.0.0
 * @ClassName Main.java
 * JavaStream流的使用
 * @Description https://blog.csdn.net/mu_wind/article/details/109516995
 * @createTime 2021年07月03日 21:39:00
 */

public class Main {
    static class Person {
        private String name;  // 姓名
        private int salary; // 薪资
        private int age; // 年龄
        private String sex; //性别
        private String area;  // 地区

        // 构造方法
        public Person(String name, int salary, int age, String sex, String area) {
            this.name = name;
            this.salary = salary;
            this.age = age;
            this.sex = sex;
            this.area = area;
        }

        public Person(String name, int salary, String sex, String area) {
            this.name = name;
            this.salary = salary;
            this.sex = sex;
            this.area = area;
        }
    }

    public static void main(String[] args) {
        List<Person> personList = new ArrayList<Person>();
        personList.add(new Person("Tom", 8900, "male", "New York"));
        personList.add(new Person("Jack", 7000, "male", "Washington"));
        personList.add(new Person("Lily", 7800, "female", "Washington"));
        personList.add(new Person("Anni", 8200, "female", "New York"));
        personList.add(new Person("Owen", 9500, "male", "New York"));
        
        
        personList.add(new Person("Alisa", 7900, "female", "New York"));

        List<Integer> list = Arrays.asList(7, 6, 9, 3, 8, 2, 1);
        //遍历输出符合条件的元素  x>6
        list.stream().filter(x -> x > 6).forEach(System.out::println);


        //匹配第一个元素
        Optional<Integer> first = list.stream().filter(x -> x > 6).findFirst();
        //匹配任意（适用于并行流）
        Optional<Integer> any = list.parallelStream().filter(x -> x > 6).findAny();
        //是否包含符合特定
    }
}
