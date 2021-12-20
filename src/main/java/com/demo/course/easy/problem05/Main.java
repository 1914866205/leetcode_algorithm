package com.demo.course.easy.problem05;


/**
 * author: nitaotao
 * date: 2021/12/20 20:42
 * version: 1.0
 * description: http://noi.openjudge.cn/ch0105/41/。
 */
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        Scanner scanner = new Scanner(System.in);
        int start = scanner.nextInt();
        int end = scanner.nextInt();
        System.out.print(main.count(start, end));
    }

    /**
     * count方法：查询2出现的次数
     * @param start 起始范围
     * @param end 结束范围
     * @return
     */
    public int count(int start, int end) {
        int count = 0;
        for (; start <= end; start++) {
            //此处使用递归查询2出现的次数
            int i = start;
            while (i != 0) {
                if (i % 10 == 2) {
                    count++;
                }
                i /= 10;
            }
        }
        return count;
    }
}
