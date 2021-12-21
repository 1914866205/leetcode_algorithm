package com.demo.course.mid.problem04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * author: nitaotao
 * date: 2021/12/21 22:13
 * version: 1.0
 * description: todo
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Main main = new Main();

        main.findSuShuDui(n);

    }

    /**
     * findSuShuDui方法： 发现素数对
     *
     * @param n
     */
    public void findSuShuDui(int n) {
        ArrayList list = new ArrayList();
        for (int i = 0; i <= n; i++) {
            if (isSuShu(i)) {
                list.add(i);
            }
        }
        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = (int) list.get(i);
        }
        Arrays.sort(arr);
        boolean flag = true;
        for (int i = 1; i < arr.length-1; i++) {
            if ((arr[i + 1] - arr[i]) == 2){
                flag = false;
                System.out.println(arr[i] + " " + arr[i + 1]);
            }
        }
        if (flag) {
            System.out.print("empty");
        }


    }

    /**
     * isSuShu方法：判断是否是素数
     *
     * @param num
     * @return
     */
    public boolean isSuShu(int num) {
        if (num < 2) {
            return false;
        }
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
