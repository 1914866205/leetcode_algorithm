package com.study;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

/**
 * @author 倪涛涛
 * @version 1.0.0
 * @ClassName Main.java
 * @Description Stream流的使用
 * @createTime 2021年07月01日 15:54:00
 *
 * 影响性能的五个要素：数据大小、源数据结构、值是否装箱、可用CPU的数量、处理每个元素所花的时间
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Person {
    private String name;
    private String sex;
    private int age;

    public static void main(String[] args) {
        List<Person> list = new ArrayList<>();
        list.add(new Person("测试", "男", 18));
        list.add(new Person("开发", "男", 20));
        list.add(new Person("运维", "女", 19));
        list.add(new Person("DBA", "女", 22));
        list.add(new Person("运营", "男", 24));
        list.add(new Person("产品", "女", 21));
        list.add(new Person("经理", "女", 25));
        list.add(new Person("产品", "女", 21));

        //求性别为男的人集合
        List<Person> sexLists = list.stream().filter(person -> person.sex.equals("男")).collect(Collectors.toList());
        System.out.println("此处复习一下集合");
        System.out.println("----------list集合遍历的四种方式-----------");
        System.out.println("第一种，普通for循环");
        for (int i = 0; i < sexLists.size(); i++) {
            System.out.println(sexLists.get(i));
        }
        System.out.println("---------------------");
        System.out.println("第二种，增强for(foreach)");
        for (Person person : sexLists) {
            System.out.println(person);
        }
        System.out.println("---------------------");
        System.out.println("第三种，迭代器");
        Iterator<Person> personIterator = sexLists.iterator();
        while (personIterator.hasNext()) {
            System.out.println(personIterator.next());
        }
        System.out.println("---------------------");
        System.out.println("第四种，lambda表达式");
        sexLists.forEach(person -> System.out.println(person.toString()));
        System.out.println("---------------------");

        //按性别进行分组统计人数
        Map<String, Integer> map = list.stream().collect(Collectors.groupingBy(Person::getSex, Collectors.summingInt(p -> 1)));
        System.out.println("----------map集合遍历的四种方式-----------");
        System.out.println("第一种，通过map.keySet()遍历key和value");
        for (String i : map.keySet()) {
            Integer integer = map.get(i);
            System.out.println(i + "  " + integer);
        }
        System.out.println("---------------------");

        System.out.println("第二种，通过map.entrySet使用iterator遍历key和value");
        Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> entry = iterator.next();
            System.out.println("键:" + entry.getKey() + "       值:" + entry.getValue());
        }
        System.out.println("---------------------");

        System.out.println("第三种，推荐，尤其容量比较大时");
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println("键:" + entry.getKey() + "       值:" + entry.getValue());
        }
        System.out.println("---------------------");

        System.out.println("第四种，通过Map.value遍历所有的value，但不能遍历key");
        for (Integer value : map.values()) {
            System.out.println("value=" + value);
        }
        System.out.println("---------------------");

        System.out.println("ok复习完毕");
        //map的key值true为男，false为女的集合
        Map<Boolean, List<Person>> map1 = list.stream().collect(partitioningBy(person -> person.getSex().equals("男")));
        for (Map.Entry<Boolean, List<Person>> entrySet : map1.entrySet()) {
            System.out.println(entrySet.getKey() + "-------" + entrySet.getValue());
        }

        //求性别为男的人总岁数
        int sum = list.stream().filter(person -> person.sex.equals("男")).mapToInt(Person::getAge).sum();
        System.out.println("总岁数为：" + sum);

        //判断是否有年龄大于25的人
        boolean b = list.stream().anyMatch(person -> person.getAge() > 25);
        System.out.print(b ? "有" : "没有");
        System.out.println("年龄大于25的人");

        //获取所有人的姓名集合
        List<String> collect = list.stream().map(Person::getName).collect(Collectors.toList());
        collect.forEach(name -> System.out.print(name + " "));

        //求所有人的平均年龄
        Double aveage = list.stream().collect(averagingInt(Person::getAge));
        System.out.println("平均年龄：" + aveage);

        //求年龄最大的人
        Person maxAgePerson = list.stream().reduce((person1, person2) -> person1.getAge() > person2.age ? person1 : person2).get();
        System.out.println("年齡最大的人：" + maxAgePerson);

//        Person maxAgePerson2 = list.stream().collect(maxBy(Comparator.comparing(Person::getAge))).get();
//        System.out.println("年齡最大的人：" + maxAgePerson2);

//        按照年齡从小到大排序
//        List<Student> l3 = list.stream().sorted((s1, s2) -> s1.getAge().compareTo(s2.getAge())).collect(toList());
//
        //求年龄最小的两个人
//        List<Student> collect1 = l3.stream().limit(2).collect(toList());

        //获取所有名字，组成一条语句
//        String collect2 = list.stream().map(Person::getName).collect(joining(",", "[", "]"));
//        System.out.println("获取所有名字，组成一条语句:" + collect2);

        //获取年龄的最大值、最小值、平均值、求和等等
        IntSummaryStatistics intSummaryStatistics = list.stream().mapToInt(Person::getAge).summaryStatistics();
        System.out.println(intSummaryStatistics.getMax());
        System.out.println(intSummaryStatistics.getMin());
        System.out.println(intSummaryStatistics.getAverage());
        System.out.println(intSummaryStatistics.getSum());

    }
}
