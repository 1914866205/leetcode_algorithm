package com.demo.day09.array;

import java.util.Arrays;
import java.util.List;

/**
 * author: nitaotao
 * date: 2021/12/2 17:11
 * version: 1.0
 * description: todo
 */
public class ListUtil {

    /**
     * add each element of the double-typed array nums to list
     *
     * @param list 集合
     * @param nums 需要添加的数组
     */
    public void assign(List<Double> list, double[] nums) {
        Arrays.stream(nums).forEach(item -> list.add(item));
    }

    // output each element of list by the Iterator
    public void printList(List<Double> list) {
        list.stream().forEach(System.out::println);
    }

    // check whether the target occurs in list
    public boolean isExisted(List<Double> list, double target) {
        for (Double item : list) {
            if (item == target) {
                return true;
            }
        }
        return false;
    }

    // insert value into the specific location of list
    public void insert(List<Double> list, double value, int location) {
        list.add(location, value);
    }

    // remove each object of list which content is equal to value
    public void remove(List<Double> list, double value) {
        list.remove(value);
    }

    // update the content of the element located at location to value
    public void update(List<Double> list, double value, int location) {
        list.remove(location);
        list.add(location,value);
    }
}
