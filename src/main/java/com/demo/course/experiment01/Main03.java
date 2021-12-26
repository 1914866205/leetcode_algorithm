package com.demo.course.experiment01;


import java.util.Scanner;

/**
 * author: nitaotao
 * date: 2021/12/26 23:59
 * version: 1.0
 * description: http://acm.zzuli.edu.cn/problem.php?id=1092
 */
public class Main03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        Main03 main03 = new Main03();
        for (int i = m; i <= n; i++) {
            if (main03.isprime(i) == 1) {
                System.out.print(i + " ");
            }
        }
    }

    /**
     * 判断是否是素数
     * @param n
     * @return
     */
    public int isprime(int n) {
        if (n <= 3) {
            return n > 1 ? 1 : 0;
        }

        //如果目标数不在6的前后则一定不是素数
        if (n % 6 != 1 && n % 6 != 5) {
            return 0;
        }
        //增长每次判断的步数，增加效率，判断到目标数的平方根
        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) {//如果目标数可以被6前后的数整除，便不是素数
                return 0;
            }
        }
        return 1;
    }

}
