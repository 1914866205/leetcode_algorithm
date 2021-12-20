package com.demo.course.easy.problem04;


/**
 * author: nitaotao
 * date: 2021/12/20 16:09
 * version: 1.0
 * description: http://noi.openjudge.cn/ch0104/21/
 */
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); //n个苹果
        int x = scanner.nextInt(); //虫子每x小时能吃掉一个苹果
        int y = scanner.nextInt(); //经过y小时你还有多少个完整的苹果
        System.out.print(main.remainByCeil(n, x, y));
        System.out.print(main.remainByFloor(n, x, y));
    }

    /**
     * remainByCeil：使用向上取整肌酸苹果与虫子问题
     * @param n n个苹果
     * @param x 虫子每x小时能吃掉一个苹果
     * @param y 经过y小时你还有多少个完整的苹果
     * @return int类型
     */
    public int remainByCeil(int n, int x, int y) {
        /*ceil 向上取整  此处注意事项：如果 y/x 不乘以1.0改为浮点型，就自动是int整数除法的默认向下取整*/
        return n - Math.ceil(y * 1.0 / x) >= 0 ? (int) (n - Math.ceil(y * 1.0 / x)) : 0;
    }

    /**
     * remainByFloor：使用向下取整肌酸苹果与虫子问题
     * @param n n个苹果
     * @param x 虫子每x小时能吃掉一个苹果
     * @param y 经过y小时你还有多少个完整的苹果
     * @return int 类型
     */
    public int remainByFloor(int n, int x, int y) {
        /*floor 向下取整 */
        int remain = (int) (Math.floor(y * 1.0 / x) == y*1.0 / x ? n - Math.floor(y * 1.0 / x) : n - Math.floor(y * 1.0 / x) - 1);
        return remain >= 0 ? remain : 0;
    }

}
