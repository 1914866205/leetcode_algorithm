package com.study.algorithm;

import java.util.Arrays;

/**
 * @author 倪涛涛
 * @version 1.0.0
 * @ClassName Day02_BubbleSort.java
 * @Description 冒泡排序
 * @createTime 2021年08月14日 17:42:00
 */
public class Day02_BubbleSort {
    public static void bubbleSort(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }
        //第一次需要的冒泡的次数最多，但随着冒泡的流程走完几遍后，再交换的次数越来越少
        //  i是为了控制一次冒泡流程中冒泡的次数
        for (int i = array.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
//                    int temp = array[j];
//                    array[j] = array[i];
//                    array[i] = temp;
                    array[j] = array[j] ^ array[j + 1];
                    array[j + 1] = array[j] ^ array[j + 1];
                    array[j] = array[j] ^ array[j + 1];
                }
            }
        }

    }

    public static void main(String[] args) {
//        int[] arr = new int[]{1, 6, 9, 8, 5, 2, 7};
//        bubbleSort(arr);
//        Arrays.stream(arr).forEach(System.out::print);

        int m = 2;
        int n = 3;
        int temp = m;
        m = n;
        n = temp;
        System.out.println("m:" + m + "-------" + "n:" + n);

        int a = 2;
        int b = 3;
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println("a:" + a + "-------" + "b:" + b);
/**
 * 此处说一下异或操作的性质
 * 1.  1-1
 *               0^N=N
 *     1-2
 *               N^N=0
 * 2.  满足交换律和结合律
 *   即  a^b=b^a          a^b^c=a^(b^c)
 *
 * 则此处  a=a^b
 *        b=a^b       此处a=a^b
 *        则可以看成   b=a^b^b
 *        根据结合律   b=a^(b^b)
 *        由性质1-2得  b=a^0
 *        由性质1-1得  b=a
 *
 *        同理
 *        a=a^b自己算去
 */



        int c = 2;
        int d = 3;
        d = c + d - (c = d);
        System.out.println("c:" + c + "-------" + "d:" + d);

        int e = 2;
        int f = 3;
        e = e + f;
        f = e - f;
        e = e - f;
        System.out.println("e:" + e + "-------" + "f:" + f);
    }
}
