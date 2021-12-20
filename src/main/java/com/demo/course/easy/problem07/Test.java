package com.demo.course.easy.problem07;


/**
 * author: nitaotao
 * date: 2021/12/20 22:37
 * version: 1.0
 * description: todo
 */
import java.util.Arrays;
import java.util.Scanner;
public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int[] arr = new int[num];
        for (int i = 0; i < num; i++) {
            arr[i] = scanner.nextInt();
        }
        Test test = new Test();
        Arrays.stream(test.arrayInfo(arr)).forEach(item -> System.out.print(item + " "));
    }

    /**
     * arrayInfo方法
     * 从键盘输入一个int型数组的长度，以及这个数组的所有元素。设计arrayInfo方法，完成以下任务：
     * ① 得到数组中奇数元素的个数；
     * ② 得到数组中偶数元素的个数；
     * ③ 得到数组中的最大值；
     * ④ 得到数组中的最小值；
     * ⑤ 得到数组中非负元素的个数。
     * @param arr 输入的数组
     * @return
     */
    public int[] arrayInfo(int[] arr) {
        int[] arrayInfo = new int[5];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 != 0) { //得到数组中奇数的个数
                arrayInfo[0]++;
            } else { //得到数组中偶数的个1数
                arrayInfo[1]++;
            }
            if (arr[i] >= 0) { //负数个数
                arrayInfo[4]++;
            }
        }
        //最大值  设置初始值
        arrayInfo[2] = arr[0];
        //最小值  设置初始值
        arrayInfo[3] = arr[0];
        for (int i = 0; i < arr.length - 1; i++) {
            if (arrayInfo[2] < arr[i + 1]) {
                //最大值
                arrayInfo[2] = arr[i + 1];
            }
            if (arrayInfo[3] > arr[i + 1]) {
                //最小值
                arrayInfo[3] = arr[i + 1];
            }

        }
        return arrayInfo;
    }
}
