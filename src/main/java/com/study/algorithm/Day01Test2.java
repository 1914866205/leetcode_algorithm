package com.study.algorithm;

import java.util.Arrays;

/**
 * @author 倪涛涛
 * @version 1.0.0
 * @ClassName Day01Test2.java
 * @Description TODO
 * @createTime 2021年08月14日 18:42:00
 */
public class Day01Test2 {
    /**
     * 一个int类型的数组，其中一个数出现奇数次，其余所有数出现偶数次，则如何找出这个数，要求时间复杂度 O(N),空间复杂度O(1)
     */
    public static void printOddTimesNum1(int[] arr) {
        int eor = 0;
        for (int cur : arr) {
            eor ^= cur;
        }
        //比如  [1,1,6,5,7,6,5,5,5]
        //运算  eor=0^1^1^6^6^7^5^5^5^5
        //     eor=0^0^0^7^0
        //     eor=7
        System.out.println(eor);
    }

    /**
     * 一个int类型的数组，其中两个数出现奇数次，其余所有数出现偶数次，则如何找出这个数，要求时间复杂度 O(N),空间复杂度O(1)
     */
    public static void printOddTimesNum2(int[] arr) {
        int eor = 0;
        for (int cur : arr) {
            eor ^= cur;
        }
        //比如  [1,1,6,5,7,9,6,5,5,5]
        //运算  eor=0^1^1^6^6^7^5^5^5^5^9
        //     eor=0^0^0^7^0^9
        //     eor=7^9
        //  因为两个数不相同 假设两个数为a b
        //  则 eor=a^b  !=0
        // 因为eor！=0，所以eor的二进制必不全为0，所以eor的二进制至少有1一位为1
        int rightOne = eor & (~eor + 1); //提取最右的1      ~eor+1  取反+1
        int onlyOne = 0;
        for (int cur : arr) {
            if ((cur & rightOne) == 0) {
                onlyOne ^= cur;   //rightOne可以把a和b分开，把那一位为0的分成1组，a,b其中之一在那里，其余的在那一位为1的里
                //之后把这一组进行全部异或，相同的消去，最后剩下的是a或b其中之一
            }
        }
        System.out.println(onlyOne + " " + (eor ^ onlyOne)); //eor^onlyOne后得到的是  a^b^b=a 或 a^b^a=b
    }
}
