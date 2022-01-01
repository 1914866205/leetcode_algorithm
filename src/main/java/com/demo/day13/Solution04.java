package com.demo.day13;

import java.util.ArrayList;
import java.util.List;

/**
 * author: nitaotao
 * date: 2022/1/2 0:07
 * version: 1.0
 * description: todo
 */
public class Solution04 {
    public static void main(String[] args) {
        Solution04 solution04 = new Solution04();
        solution04.selfDividingNumbers(0, 22);
    }

    public List<Integer> selfDividingNumbers(int left, int right) {
        List list = new ArrayList();
        for (int i = left; i < right + 1; i++) {
            boolean flag = true;
            int temp = i;
            int tempNum = 0;
            while (temp / 10 != 0) {
                tempNum = temp % 10;  //取出的余数
                temp = temp / 10;
                if (tempNum == 0) {
                    flag = false;
                    break;
                }
                if (i % tempNum != 0) {
                    flag = false;
                }
            }
            if (temp != 0) {
                if (i % temp != 0) {
                    flag = false;
                }
            }
            if (flag) {
                list.add(i);
            }
        }
        return list;

    }
}
