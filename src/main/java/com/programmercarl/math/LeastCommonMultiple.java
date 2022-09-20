package com.programmercarl.math;

/**
 * @ClassName Min
 * @Descriotion 辗转相除法
 * 复盘 Boss直聘笔试第一题
 * @Author nitaotao
 * @Date 2022/9/17 12:55
 * @Version 1.0
 *
 * 由欧几里得辗转相除法得知
 * 最小公倍数 = a*b/最大公因数
 **/
public class LeastCommonMultiple {
    public static void main(String[] args) {
        int a = 7;
        int b = 5;
        if (a < b) {
            int temp = b;
            b = a;
            a = temp;
        }

        System.out.println(a * b / getMaxCommonFactory(a, b));
    }

    /**
     * 求最大公因数
     *
     * @param a
     * @param b 已知 a>=b
     * @return
     */
    public static int getMaxCommonFactory(int a, int b) {
        if (a % b == 0) {
            return b;
        } else {
            return getMaxCommonFactory(b, a % b);
        }
    }
}
