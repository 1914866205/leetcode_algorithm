package com.demo.endterm;

/**
 * author: nitaotao
 * date: 2022/1/5 15:38
 * version: 1.0
 * description: todo
 */
public class Solution02 {
    /**
     * myPow1 方法：非递归方法返回 x 的 n 次幂
     *
     * @param x 基数
     * @param n 指数
     * @return x 的 n 次幂
     */
    public double myPow1(double x, int n) {
        int N = n; // 将 n 的值暂存在 N 中
        double ans = 1.0; // 存储最终结果，初始为 1
        while (N != 0) {  //N为指数，指数不为0时 ， 迭代计算x的n次幂
            ans = (N % 2 != 0 ? ans * x : ans);  //如果是奇数次幂，就乘以一个当前x,否则不变
            N = N / 2; // 当前指数下降为上次指数的一半    因为整数除以二是向下取整
            x = x * x; // 当前基数应该提升为上次基数的平方
        }
        // 根据原指数的符号返回最终结果
        return (n < 0 ? 1 / ans : ans);
    }

    /**
     * myPow2 方法：递归方法返回 x 的 n 次幂
     * @param x 基数
     * @param n 指数
     * @return x 的 n 次幂
     */
    /* 这里将 n 从 int 改为 long 是预防 n=-2^31 时，-n 超界 */
    public double myPow(double x, long n) {
        if (n == 0) { // 0 次方返回 1
            return 1;
        } else if (n > 0 && n % 2 == 0) { // 正数偶次方返回基数平方的一半指数
            return myPow(x * x, n / 2);
        } else if (n > 0) { // 正数奇次方返回基数乘以基数的降一阶指数
            return myPow(x, n - 1) * x;
        } else { // 负数次方
            return 1 / myPow(x, -n);
        }
    }
}
